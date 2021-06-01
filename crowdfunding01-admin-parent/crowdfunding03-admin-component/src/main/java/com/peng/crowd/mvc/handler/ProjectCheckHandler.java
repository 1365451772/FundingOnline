package com.peng.crowd.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.peng.crowd.entity.ProjectVO;
import com.peng.crowd.entity.Role;
import com.peng.crowd.service.api.ProjectService;
import com.peng.crowd.service.api.RoleService;
import com.peng.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectCheckHandler {

  @Autowired
  private ProjectService projectService;

  @PreAuthorize("hasAuthority('project:uncheck')")
  @RequestMapping("/project/remove/by/role/id/array.json")
  public ResultEntity<String> removeByRoleIdAarry(@RequestBody List<Integer> roleIdList) {
    projectService.unCheck(roleIdList);
    return ResultEntity.successWithoutData();
  }

  @PreAuthorize("hasAuthority('project:check')")
  @RequestMapping("project/check/by/role/id/array.json")
  public ResultEntity<String> checkByProjectIdAarry(@RequestBody List<Integer> projectIdList){
    projectService.check(projectIdList);
    return ResultEntity.successWithoutData();
  }



  @PreAuthorize("hasAuthority('project:get')")
  @RequestMapping("/project/get/page/info.json")
  public ResultEntity<PageInfo<ProjectVO>> getPageInfo(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
      @RequestParam(value = "keyword", defaultValue = "") String keyword
  ) {

    // 调用Service方法获取分页数据
    PageInfo<ProjectVO> pageInfo = projectService.getPageInfo(pageNum, pageSize, keyword);

    // 封装到ResultEntity对象中返回（如果上面的操作抛出异常，交给异常映射机制处理）
    return ResultEntity.successWithData(pageInfo);
  }

}
