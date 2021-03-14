package com.peng.crowd.api;

import com.peng.crowd.entity.po.MemberPO;
import com.peng.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("peng-crowd-mysql")
public interface MySQLRemoteService {
	
	@RequestMapping("/get/memberpo/by/login/acct/remote")
	ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

	@RequestMapping("/save/member/remote")
	ResultEntity<String> saveMember(@RequestBody MemberPO memberPO);

	@RequestMapping("/save/project/vo/remote")
	ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);


	@RequestMapping("/get/portal/type/project/data/remote")
  ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();

	@RequestMapping("/get/project/detail/remote/{projectId}")
	ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);
}
