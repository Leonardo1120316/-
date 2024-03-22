package com.example.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.usercenter.common.BaseResponse;
import com.example.usercenter.common.ErrorCode;
import com.example.usercenter.common.ResultUtils;
import com.example.usercenter.exception.BusinessException;
import com.example.usercenter.model.domain.User;
import com.example.usercenter.model.domain.request.user.UserDeleteRequest;
import com.example.usercenter.model.domain.request.user.UserLoginRequest;
import com.example.usercenter.model.domain.request.user.UserRegisterRequest;
import com.example.usercenter.model.domain.request.user.UserUpdateRequest;
import com.example.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.usercenter.constant.UserConstant.ADMIN_ROLE;
import static com.example.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
 *
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if(userRegisterRequest == null){
//            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数错误");
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if(StringUtils.isAnyBlank(userAccount,userPassword,checkPassword)){
//            return ResultUtils.error(ErrorCode.NULL_ERROR);
            throw new BusinessException(ErrorCode.NULL_ERROR,"参数错误");
        }
        Long result = userService.userRegister(userAccount,userPassword,checkPassword);
        return ResultUtils.success(result);
    }

    @PostMapping("/login")
    public BaseResponse<String> userLogin(@RequestBody UserLoginRequest userRegisterRequest, HttpServletRequest request){
        if(userRegisterRequest == null){
//            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数错误");
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        if(StringUtils.isAnyBlank(userAccount,userPassword)){
//            return ResultUtils.error(ErrorCode.NULL_ERROR);
            throw new BusinessException(ErrorCode.NULL_ERROR,"参数错误");
        }
        String result = userService.userLogin(userAccount,userPassword,request);
        return ResultUtils.success(result);
    }

    @PostMapping("/logout")
    public BaseResponse<Integer> userLogout(HttpServletRequest request){
        if(request == null){
//            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数错误");
        }
        Integer result = userService.userLogout(request);
        return ResultUtils.success(result);
    }

    @GetMapping("/search")
    public BaseResponse<List<User>> searcherUsers(String username,HttpServletRequest request){
        //管理员可查询
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if(user == null || user.getUserRole() != ADMIN_ROLE){
        //     return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH,"用户未登录或者无权限");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("username",username);
        }
        List<User> userList = userService.list(queryWrapper);
        List<User> result = userList.stream().map(safeUser -> userService.getSafeUser(safeUser)).collect(Collectors.toList());
        return ResultUtils.success(result);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteUser(@RequestBody UserDeleteRequest userDeleteRequest, HttpServletRequest request){
        //管理员可查询
        long id = userDeleteRequest.getId();
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if(user == null || user.getUserRole() != ADMIN_ROLE){
//            return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH,"用户未登录或者无权限");
        }
        if(id<=0){
//            return ResultUtils.error(ErrorCode.NO_RESULT);
            throw new BusinessException(ErrorCode.NO_RESULT,"无查询用户");
        }
        Boolean result = userService.removeById(id);
        return ResultUtils.success(result);
    }

    @GetMapping("/current")
    public BaseResponse<User> getCurrentUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User)userObj;
        if(currentUser == null){
//            return ResultUtils.error(ErrorCode.NOT_LOGIN);
            throw new BusinessException(ErrorCode.NOT_LOGIN,"无用户登录");
        }
        long userId = currentUser.getId();
        // TODO 校验用户是否合法
        User user = userService.getById(userId);
        User result = userService.getSafeUser(user);
        return ResultUtils.success(result);
    }

    @PostMapping("/update")
    public BaseResponse<Boolean> updateUser(HttpServletRequest request, @RequestBody UserUpdateRequest updateRequest){
        //管理员可查询
        User updateUser = updateRequest.getUser();
        long id = updateUser.getId();
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if(user == null || user.getUserRole() != ADMIN_ROLE){
//            return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH,"用户未登录或者无权限");
        }
        if(id<=0){
//            return ResultUtils.error(ErrorCode.NO_RESULT);
            throw new BusinessException(ErrorCode.NO_RESULT,"无查询用户");
        }
        Boolean result = userService.editUser(updateUser);
        return ResultUtils.success(result);
    }

    @PostMapping("/add")
    public BaseResponse<Boolean> addUser(HttpServletRequest request, @RequestBody UserUpdateRequest updateRequest){
        //管理员可查询
        User updateUser = updateRequest.getUser();
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if(user == null || user.getUserRole() != ADMIN_ROLE){
//            return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH,"用户未登录或者无权限");
        }
        Boolean result = userService.addUser(updateUser);
        return ResultUtils.success(result);
    }
}
