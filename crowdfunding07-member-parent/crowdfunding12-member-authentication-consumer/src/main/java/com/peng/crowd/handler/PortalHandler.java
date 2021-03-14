package com.peng.crowd.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalHandler {
	@Autowired
	private MySQLRemoteService mySQLRemoteService;

	@RequestMapping("/")
	public String showPortalPage(Model model) {

		// 1、调用MySQLRemoteService提供的方法查询首页要显示的数据
		ResultEntity<List<PortalTypeVO>> resultEntity =
				mySQLRemoteService.getPortalTypeProjectDataRemote();

		// 2.检查查询结果
		String result = resultEntity.getResult();
		if(ResultEntity.SUCCESS.equals(result)) {

			// 3.获取查询结果数据
			List<PortalTypeVO> list = resultEntity.getData();

			// 4.存入模型
			model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);

		}

		return "portal";
	}


}
