package com.peng.crowd.service.api;

import com.peng.crowd.entity.vo.AddressVO;
import com.peng.crowd.entity.vo.OrderProjectVO;
import java.util.List;

public interface OrderService {

	OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);

	List<AddressVO> getAddressVOList(Integer memberId);

	void saveAddress(AddressVO addressVO);

}
