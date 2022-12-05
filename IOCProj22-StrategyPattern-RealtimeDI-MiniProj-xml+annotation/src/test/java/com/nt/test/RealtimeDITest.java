package com.nt.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

@Component("test")
public class RealtimeDITest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=null,addrs=null,pamt=null,rate=null,time=null;
		if(sc!=null) {
			System.out.println("Enter customer name:");
			name=sc.next();
			System.out.println("Enter customer Address:");
			addrs=sc.next();
			System.out.println("Enter customer principle");
			pamt=sc.next();
			System.out.println("enter rate:");
			rate=sc.next();
			System.out.println("Enter time in months:");
			time=sc.next();
		}
		//prepare VO class obj having inputs
		CustomerVO vo=new CustomerVO();
		vo.setCname(name);vo.setCadd(addrs);vo.setPamt(pamt);vo.setRate(rate);;vo.setTime(time);
		
		
		//IOC container creation
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationcontext.xml");
		
		//get Controller class obj
		MainController controller=ctx.getBean("controller",MainController.class);
		try {
			String resultMsg=controller.processCustomer(vo);
			System.out.println(resultMsg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
