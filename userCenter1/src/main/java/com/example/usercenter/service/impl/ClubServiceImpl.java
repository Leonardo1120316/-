package com.example.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.usercenter.common.ErrorCode;
import com.example.usercenter.exception.BusinessException;
import com.example.usercenter.model.domain.Club;
import com.example.usercenter.model.domain.User;
import com.example.usercenter.service.ClubService;
import com.example.usercenter.mapper.ClubMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.example.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author DELL
* @description 针对表【club(社团)】的数据库操作Service实现
* @createDate 2024-03-05 15:30:30
*/
@Service
@Slf4j
public class ClubServiceImpl extends ServiceImpl<ClubMapper, Club>
    implements ClubService{

    @Resource
    ClubMapper clubMapper;

    @Override
    public List<Club> search(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(USER_LOGIN_STATE);
        long id = user.getId();
        if(user==null){
            throw new BusinessException(ErrorCode.NOT_LOGIN,"未登录");
        }
        if(user.getUserRole()==0){
            throw new BusinessException(ErrorCode.NO_AUTH,"用户无权限");
        }
        if(id<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数错误");
        }
        QueryWrapper<Club> queryWrapper = new QueryWrapper<Club>();
//        queryWrapper.eq("manageid",id);
//        List<Club> clubList = clubMapper.selectList(queryWrapper);
        List<Club> clubList = clubMapper.selectList(null);
        return clubList;
    }

    @Override
    public Boolean editClub(Club updateClub) {
        if(updateClub.getId()==0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"id参数为空");
        }
        int result = clubMapper.updateById(updateClub);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean addClub(Club updateClub) {
        String email = updateClub.getEmail();
        Club club = new Club();
        club.setClubname(updateClub.getClubname());
        club.setEmail(updateClub.getEmail());
        club.setClubStatus(0);
        return this.save(club);
    }
}




