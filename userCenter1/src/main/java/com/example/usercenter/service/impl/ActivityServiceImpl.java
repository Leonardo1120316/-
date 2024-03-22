package com.example.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.usercenter.common.ErrorCode;
import com.example.usercenter.exception.BusinessException;
import com.example.usercenter.mapper.ActivityMapper;
import com.example.usercenter.model.domain.Activity;
import com.example.usercenter.model.domain.User;
import com.example.usercenter.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author DELL
* @description 针对表【activity(活动)】的数据库操作Service实现
* @createDate 2024-03-06 12:22:51
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{
    @Resource
    ActivityMapper activityMapper;

    @Override
    public List<Activity> search(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user==null){
            throw new BusinessException(ErrorCode.NOT_LOGIN,"未登录");
        }
        if(user.getUserRole()==0){
            throw new BusinessException(ErrorCode.NO_AUTH,"用户无权限");
        }
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<Activity>();
        queryWrapper.eq("isDelete",0);
        List<Activity> activityList = activityMapper.selectList(queryWrapper);
        return activityList;
    }

    @Override
    public Boolean editActivity(Activity updateActivity) {
        if(updateActivity.getId()==0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"id参数为空");
        }
        int result = activityMapper.updateById(updateActivity);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean addActivity(Activity updateActivity) {
        Activity activity = new Activity();
        activity.setActivityname(updateActivity.getActivityname());
        activity.setEmail(updateActivity.getEmail());
        activity.setActivityStatus(0);
        return this.save(activity);
    }

}




