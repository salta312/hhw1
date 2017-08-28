package net.salta.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.salta.spring.dbo.Message;
import net.salta.spring.mybatis.MessageDBS;
import net.salta.spring.mybatis.MyBatisConnectionFactory;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("I am here");
		MessageDBS msgDbs = new MessageDBS(MyBatisConnectionFactory.getSqlSessionFactory());
		Message msg = msgDbs.selectMessage();
		System.out.println("The message is "+ msg.getMessage());
		model.addAttribute("name", msg.getMessage());

		return "welcome";
	}
}
