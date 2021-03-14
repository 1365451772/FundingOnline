package com.atguigu.crowd.service.api;

import com.peng.crowd.entity.vo.ProjectVO;

public interface ProjectService {

  void saveProject(ProjectVO projectVO, Integer memberId);

  List<PortalTypeVO> getPortalTypeVO();

  DetailProjectVO getDetailProjectVO(Integer projectId);

}
