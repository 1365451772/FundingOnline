package com.peng.crowd.service.api;

import com.peng.crowd.entity.vo.DetailProjectVO;
import com.peng.crowd.entity.vo.PortalTypeVO;
import com.peng.crowd.entity.vo.ProjectVO;

import java.util.List;

public interface ProjectService {

  void saveProject(ProjectVO projectVO, Integer memberId);

  List<PortalTypeVO> getPortalTypeVO();

  DetailProjectVO getDetailProjectVO(Integer projectId);

}
