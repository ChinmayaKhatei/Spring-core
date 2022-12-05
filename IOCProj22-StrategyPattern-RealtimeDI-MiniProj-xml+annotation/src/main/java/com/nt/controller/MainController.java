package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerMgmtService;
import com.nt.vo.CustomerVO;

@Controller("controller")
public final class MainController {
	//HAS-A property
	@Autowired
	private ICustomerMgmtService service;
	
	public String proccsorCustomer(CustomerVO vo)throws Exception{
		CustomerDTO custDTO=new CustomerDTO();
		custDTO.setCname(vo.getCname());
		custDTO.setCadd(vo.getCadd());
		custDTO.setPamt(Double.parseDouble(vo.getPamt()));
		custDTO.setTime(Double.parseDouble(vo.getTime()));
		custDTO.setRate(Double.parseDouble(vo.getRate()));
		
		String resultMsg=service.registerCustomer(custDTO);
		return resultMsg;
	}

	public String processCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Main controller processcustomer");
		return null;
	}
}
