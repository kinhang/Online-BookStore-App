package com.bookstore.resource;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.User;
import com.bookstore.domain.UserBilling;
import com.bookstore.domain.UserPayment;
import com.bookstore.service.UserPaymentService;
import com.bookstore.service.UserService;

@RestController
@RequestMapping("/payment")
public class PaymentResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPaymentService userPaymentService;
	
	@RequestMapping(value ="/add",method = RequestMethod.POST)
	//RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上
	public ResponseEntity addNewCreditCardPost(
		@RequestBody UserPayment userPayment, Principal principal){
		//RequestBody 用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，
		//然后把相应的数据绑定到要返回的对象上；再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上
		User user = userService.findByUsername(principal.getName());
		
		UserBilling userBilling = userPayment.getUserBilling();
		
		userService.updateUserBilling(userBilling,userPayment,user);
		return new ResponseEntity("Payment Added(Updated) Successfully!",HttpStatus.OK);
		}
	
	@RequestMapping(value="/remove",method =RequestMethod.POST)
	public ResponseEntity removePaymentPost(
			@RequestBody String id, Principal principal ){
//		User user = userService.findByUsername(principal.getName());
		userPaymentService.removeById(Long.valueOf(id));
		return new ResponseEntity("Payment Removed Successfully!",HttpStatus.OK);
	}
	@RequestMapping(value="/setDefault",method =RequestMethod.POST)
	public ResponseEntity setDefaltPaymentPost(
			@RequestBody String id, Principal principal ){
		User user = userService.findByUsername(principal.getName());
		
		userService.setUserDefaultPayment(Long.parseLong(id),user);
		
		return new ResponseEntity("Payment set Successfully!",HttpStatus.OK);
	}
	@RequestMapping(value="/getUserPaymentList")
	public List<UserPayment> getUserPaymentList( Principal principal ){
		User user = userService.findByUsername(principal.getName());
		
		List<UserPayment> userPaymentList = user.getUserPaymentList();
		return userPaymentList;
	}
	}

