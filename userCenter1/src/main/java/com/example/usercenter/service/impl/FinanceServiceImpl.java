package com.example.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.usercenter.common.ErrorCode;
import com.example.usercenter.exception.BusinessException;
import com.example.usercenter.mapper.FinanceMapper;
import com.example.usercenter.model.domain.Finance;
import com.example.usercenter.model.domain.User;
import com.example.usercenter.service.FinanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author DELL
* @description 针对表【finance(活动)】的数据库操作Service实现
* @createDate 2024-03-06 12:34:23
*/
@Service
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance>
    implements FinanceService{
    @Resource
    FinanceMapper financeMapper;

    @Override
    public List<Finance> search(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(USER_LOGIN_STATE);
        if(user==null){
            throw new BusinessException(ErrorCode.NOT_LOGIN,"未登录");
        }
        if(user.getUserRole()==0){
            throw new BusinessException(ErrorCode.NO_AUTH,"用户无权限");
        }
        QueryWrapper<Finance> queryWrapper = new QueryWrapper<Finance>();
        queryWrapper.eq("isDelete",0);
        List<Finance> financeList = financeMapper.selectList(queryWrapper);
        return financeList;
    }

    @Override
    public Boolean editFinance(Finance updateFinance) {
        if(updateFinance.getId()==0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"id参数为空");
        }
        int result = financeMapper.updateById(updateFinance);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean addFinance(Finance updateFinance) {
        Finance finance = new Finance();
        finance.setFinancename(updateFinance.getFinancename());
        finance.setEmail(updateFinance.getEmail());
        finance.setFinanceStatus(0);
        return this.save(finance);
    }
}




