package com.example.usercenter.service;

import com.example.usercenter.model.domain.Club;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.usercenter.model.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author DELL
* @description 针对表【club(社团)】的数据库操作Service
* @createDate 2024-03-05 15:30:30
*/
public interface ClubService extends IService<Club> {
    /**
     * 查询社团
     * @param request
     * @return
     */
    List<Club> search(HttpServletRequest request);

    /**
     * 更新社团
     * @param updateClub
     * @return
     */
    Boolean editClub(Club updateClub);

    /**
     * 新增社团
     * @param updateClub
     * @return
     */
    Boolean addClub(Club updateClub);
}
