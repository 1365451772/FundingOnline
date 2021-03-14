package com.peng.crowd.api;

import com.peng.crowd.entity.po.MemberPO;
import com.peng.crowd.entity.vo.AddressVO;
import com.peng.crowd.entity.vo.DetailProjectVO;
import com.peng.crowd.entity.vo.OrderProjectVO;
import com.peng.crowd.entity.vo.PortalTypeVO;
import com.peng.crowd.entity.vo.ProjectVO;
import com.peng.crowd.util.ResultEntity;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("peng-crowd-mysql")
public interface MySQLRemoteService {
	
	@RequestMapping("/get/memberpo/by/login/acct/remote")
	ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(
      @RequestParam("loginacct") String loginacct);

	@RequestMapping("/save/member/remote")
	public ResultEntity<String> saveMember(@RequestBody MemberPO memberPO);

	@RequestMapping("/save/project/vo/remote")
	ResultEntity<String> saveProjectVORemote(
      @RequestBody ProjectVO projectVO,
      @RequestParam("memberId") Integer memberId);
	
	@RequestMapping("/get/portal/type/project/data/remote")
	public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();
	
	@RequestMapping("/get/project/detail/remote/{projectId}")
	public ResultEntity<DetailProjectVO> getDetailProjectVORemote(
      @PathVariable("projectId") Integer projectId);

	@RequestMapping("/get/order/project/vo/remote")
	ResultEntity<OrderProjectVO> getOrderProjectVORemote(@RequestParam("projectId") Integer projectId,
      @RequestParam("returnId") Integer returnId);

	@RequestMapping("/get/address/vo/remote")
	ResultEntity<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId);

	@RequestMapping("/save/address/remote")
	ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO);
}
