package com.peng.crowd.task;


import com.peng.crowd.entity.po.ProjectPO;
import com.peng.crowd.mapper.ProjectPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sp
 * @create 2021-05-30
 */
@Component
public class ScheduledTasks {

    @Autowired
    ProjectPOMapper projectPOMapper;


    @Scheduled(cron = "59 59 23 * * ?")
    public void check() {
        List<ProjectPO> projectPOS = projectPOMapper.selectByExample();
        Date currentDay = new Date();
        // 把众筹日期解析成Date类型
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (ProjectPO project : projectPOS) {
            try {
                Date deployDay = format.parse(project.getDeploydate());

                // 获取当前当前日期的时间戳
                long currentTimeStamp = currentDay.getTime();

                // 获取众筹日期的时间戳
                long deployTimeStamp = deployDay.getTime();

                // 两个时间戳相减计算当前已经过去的时间
                long pastDays = (currentTimeStamp - deployTimeStamp) / 1000 / 60 / 60 / 24;

                // 获取总的众筹天数
                Integer totalDays = project.getDay();

                // 使用总的众筹天数减去已经过去的天数得到剩余天数
                Integer lastDay = (int) (totalDays - pastDays);
                if (lastDay > 0 && project.getMoney() <= project.getSupportmoney()) {
                    project.setStatus(2);

                }
                if (lastDay <= 0 && project.getMoney() > project.getSupportmoney()) {
                    project.setStatus(3);
                }
                projectPOMapper.updateByPrimaryKeySelective(project);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }
}
