package com.peng.crowd.handler;

import com.peng.crowd.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProjectProviderHandler {
	
	@Autowired
	private ProjectService projectService;

}
