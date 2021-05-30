package com.peng.crowd.service.impl;


import com.peng.crowd.entity.po.*;
import com.peng.crowd.entity.vo.AddressVO;
import com.peng.crowd.entity.vo.OrderProjectVO;
import com.peng.crowd.entity.vo.OrderVO;
import com.peng.crowd.mapper.AddressPOMapper;
import com.peng.crowd.mapper.OrderPOMapper;
import com.peng.crowd.mapper.OrderProjectPOMapper;
import com.peng.crowd.mapper.ProjectPOMapper;
import com.peng.crowd.service.api.OrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderProjectPOMapper orderProjectPOMapper;
	
	@Autowired
	private OrderPOMapper orderPOMapper;
	
	@Autowired
	private AddressPOMapper addressPOMapper;

	@Autowired
	private ProjectPOMapper projectPOMapper;

	@Override
	public OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId) {
		
		return orderProjectPOMapper.selectOrderProjectVO(returnId);
	}

	@Override
	public List<AddressVO> getAddressVOList(Integer memberId) {
		
		AddressPOExample example = new AddressPOExample();
		
		example.createCriteria().andMemberIdEqualTo(memberId);
		
		List<AddressPO> addressPOList = addressPOMapper.selectByExample(example);
		
		List<AddressVO> addressVOList = new ArrayList<AddressVO>();
		
		for (AddressPO addressPO : addressPOList) {
			AddressVO addressVO = new AddressVO();
			BeanUtils.copyProperties(addressPO, addressVO);
			
			addressVOList.add(addressVO);
		}
		
		return addressVOList;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void saveAddress(AddressVO addressVO) {
		
		AddressPO addressPO = new AddressPO();
		
		BeanUtils.copyProperties(addressVO, addressPO);
		
		addressPOMapper.insert(addressPO);
		
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void saveOrder(OrderVO orderVO) {
		
		OrderPO orderPO = new OrderPO();
		
		BeanUtils.copyProperties(orderVO, orderPO);
		
		OrderProjectPO orderProjectPO = new OrderProjectPO();
		
		BeanUtils.copyProperties(orderVO.getOrderProjectVO(), orderProjectPO);
		
		// 保存orderPO自动生成的主键是orderProjectPO需要用到的外键
		orderPOMapper.insert(orderPO);
		
		// 从orderPO中获取orderId
		Integer id = orderPO.getId();
		
		// 将orderId设置到orderProjectPO
		orderProjectPO.setOrderId(id);
		
		orderProjectPOMapper.insert(orderProjectPO);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void updateProject(Integer projectId, Long supportMoney) {
		ProjectPO project = projectPOMapper.selectByPrimaryKey(projectId);
	    supportMoney = project.getSupportmoney()==null?supportMoney:project.getSupportmoney()+supportMoney;
		Integer supporter = project.getSupporter() == null ? 1 : project.getSupporter() + 1;
		Long completion =  project.getCompletion()==null?supportMoney/project.getMoney()*100:supportMoney/project.getMoney()*100;
		project.setSupportmoney(supportMoney);
		project.setSupporter(supporter);
		project.setCompletion(completion.intValue());
		if (supportMoney>=project.getMoney()){
			project.setStatus(2);
		}
		projectPOMapper.insertSelective(project);
	}

}
