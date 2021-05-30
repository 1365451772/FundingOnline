package com.peng.crowd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVO {
    private Integer id;

    private String projectName;

    private Long money;

    private Integer day;

    private String createdate;

    private Integer memberid;

    private String launchName;
    //SELECT DISTINCT p.id,project_name projectName, money,`day`,createdate,m.description_simple launchName,m.memberid memberid from t_project p LEFT JOIN t_member_launch_info m ON p.memberid = m.memberid

}