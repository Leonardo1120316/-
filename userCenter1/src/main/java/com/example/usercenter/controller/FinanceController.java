package com.example.usercenter.controller;

import com.example.usercenter.common.BaseResponse;
import com.example.usercenter.common.ErrorCode;
import com.example.usercenter.common.ResultUtils;
import com.example.usercenter.exception.BusinessException;
import com.example.usercenter.model.domain.Finance;
import com.example.usercenter.model.domain.User;
import com.example.usercenter.model.domain.request.finance.FinanceDeleteRequest;
import com.example.usercenter.model.domain.request.finance.FinanceUpdateRequest;
import com.example.usercenter.service.FinanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.usercenter.constant.UserConstant.ADMIN_ROLE;
import static com.example.usercenter.constant.UserConstant.USER_LOGIN_STATE;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/finance")
public class FinanceController {
    @Resource
    FinanceService financeService;

    @GetMapping("/search")
    public BaseResponse<List<Finance>> search(HttpServletRequest request){
        List<Finance> result = financeService.search(request);
        return ResultUtils.success(result);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteUser(@RequestBody FinanceDeleteRequest financeDeleteRequest, HttpServletRequest request){
        //管理员可查询
        long id = financeDeleteRequest.getId();
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if(user == null || user.getUserRole() != ADMIN_ROLE){
//            return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH,"用户未登录或者无权限");
        }
        if(id<=0){
//            return ResultUtils.error(ErrorCode.NO_RESULT);
            throw new BusinessException(ErrorCode.NO_RESULT,"无查询社团");
        }
        Boolean result = financeService.removeById(id);
        return ResultUtils.success(result);
    }

    @PostMapping("/update")
    public BaseResponse<Boolean> updateUser(HttpServletRequest request, @RequestBody FinanceUpdateRequest updateRequest){
        //管理员可查询
        Finance updateFinance = updateRequest.getFinance();
        long id = updateFinance.getId();
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if(user == null || user.getUserRole() != ADMIN_ROLE){
//            return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH,"用户未登录或者无权限");
        }
        if(id<=0){
//            return ResultUtils.error(ErrorCode.NO_RESULT);
            throw new BusinessException(ErrorCode.NO_RESULT,"无查询社团");
        }
        Boolean result = financeService.editFinance(updateFinance);
        return ResultUtils.success(result);
    }

    @PostMapping("/add")
    public BaseResponse<Boolean> addUser(HttpServletRequest request, @RequestBody FinanceUpdateRequest updateRequest){
        //管理员可查询
        Finance updateFinance = updateRequest.getFinance();
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if(user == null || user.getUserRole() != ADMIN_ROLE){
//            return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH,"用户未登录或者无权限");
        }
        Boolean result = financeService.addFinance(updateFinance);
        return ResultUtils.success(result);
    }
}
