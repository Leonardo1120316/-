package com.example.usercenter.controller;

import com.example.usercenter.common.BaseResponse;
import com.example.usercenter.common.ErrorCode;
import com.example.usercenter.common.ResultUtils;
import com.example.usercenter.exception.BusinessException;
import com.example.usercenter.model.domain.Club;
import com.example.usercenter.model.domain.User;
import com.example.usercenter.model.domain.response.chart.DataChart;
import com.example.usercenter.service.ActivityService;
import com.example.usercenter.service.ClubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.usercenter.constant.UserConstant.ADMIN_ROLE;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chart")
public class ChartController {
    @Resource
    ClubService clubService;
    ActivityService activityService;

    @GetMapping("/dataChart")
    public BaseResponse<DataChart> userData(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("USER_LOGIN_STATE");
        if (user == null || user.getUserRole() != ADMIN_ROLE) {
        //     return ResultUtils.error(ErrorCode.NO_AUTH);
            throw new BusinessException(ErrorCode.NO_AUTH, "用户未登录或者无权限");
        }
        List<Club> clubs = clubService.search(request);
        List<String> clubList = clubs.stream().map(Club::getClubname).collect(Collectors.toList());
        DataChart result = new DataChart();
        result.setClubList(clubList);
        return ResultUtils.success(result);
    }
}
