package com.peng.crowd.handler;

import com.peng.crowd.entity.vo.AddressVO;
import com.peng.crowd.entity.vo.OrderProjectVO;
import com.peng.crowd.entity.vo.OrderVO;
import com.peng.crowd.service.api.OrderService;
import com.peng.crowd.util.ResultEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.SoundbankResource;


@RestController
public class OrderProviderHandler {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/save/order/remote")
	ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO,@RequestParam("projectId") Integer projectId,@RequestParam("supportmoney") Long supportMoney) {
		
		try {
			orderService.saveOrder(orderVO);
			orderService.updateProject(projectId,supportMoney);
			
			return ResultEntity.successWithoutData();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
		
	}
	
	@RequestMapping("/save/address/remote")
	public ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO) {
		
		try {
			orderService.saveAddress(addressVO);
			
			return ResultEntity.successWithoutData();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
		
	}
	
	@RequestMapping("/get/address/vo/remote")
	ResultEntity<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId) {
		
		try {
			List<AddressVO> addressVOList = orderService.getAddressVOList(memberId);
			
			return ResultEntity.successWithData(addressVOList);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
		
	}
	
	@RequestMapping("/get/order/project/vo/remote")
	ResultEntity<OrderProjectVO> getOrderProjectVORemote(
			@RequestParam("projectId") Integer projectId, 
			@RequestParam("returnId") Integer returnId) {
		
		try {
			OrderProjectVO orderProjectVO = orderService.getOrderProjectVO(projectId, returnId);
			System.out.println(projectId);
			System.out.println(orderProjectVO);
			System.out.println(1);
			System.out.println(1);
			return ResultEntity.successWithData(orderProjectVO);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultEntity.failed(e.getMessage());
		}
		
	}

}
