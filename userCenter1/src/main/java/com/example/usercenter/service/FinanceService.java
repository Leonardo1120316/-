package com.example.usercenter.service;

import com.example.usercenter.model.domain.Finance;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author DELL
* @description 针对表【finance(活动)】的数据库操作Service
* @createDate 2024-03-06 12:34:23
*/
public interface FinanceService extends IService<Finance> {
    /**
     * 查询社团
     * @param request
     * @return
     */
    List<Finance> search(HttpServletRequest request);

    /**
     * 更新社团
     * @param updateFinance
     * @return
     */
    Boolean editFinance(Finance updateFinance);

    /**
     * 新增社团
     * @param updateFinance
     * @return
     */
    Boolean addFinance(Finance updateFinance);
}
