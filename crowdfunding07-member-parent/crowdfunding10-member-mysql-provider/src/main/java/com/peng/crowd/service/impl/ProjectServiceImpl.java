package com.peng.crowd.service.impl;

import com.peng.crowd.service.api.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional(readOnly = true)
@Service
public class ProjectServiceImpl implements ProjectService {

}
