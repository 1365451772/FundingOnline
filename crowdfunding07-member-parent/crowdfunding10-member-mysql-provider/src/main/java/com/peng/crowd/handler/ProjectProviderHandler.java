package com.peng.crowd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.peng.crowd.entity.vo.ProjectVO;
import com.peng.crowd.service.api.ProjectService;
import com.peng.crowd.util.ResultEntity;


@RestController
public class ProjectProviderHandler {

	@Autowired
	private ProjectService projectService;

	@RequestMapping("/save/project/vo/remote")
	public ResultEntity<String> saveProjectVORemote(
			@RequestBody ProjectVO projectVO,
			@RequestParam("memberId") Integer memberId) {

		try {
			// 调用“本地”Service执行保存
			projectService.saveProject(projectVO, memberId);

			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();

			return ResultEntity.failed(e.getMessage());
		}

	}

}