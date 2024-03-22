package com.example.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.usercenter.model.domain.Activity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author DELL
* @description 针对表【activity(活动)】的数据库操作Service
* @createDate 2024-03-06 12:22:51
*/
public interface ActivityService extends IService<Activity> {
    /**
     * 查询社团
     * @param request
     * @return
     */
    List<Activity> search(HttpServletRequest request);

    /**
     * 更新社团
     * @param updateActivity
     * @return
     */
    Boolean editActivity(Activity updateActivity);

    /**
     * 新增社团
     * @param updateActivity
     * @return
     */
    Boolean addActivity(Activity updateActivity);
}
