package com.cloudcode.activemq.mvc;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudcode.activemq.model.Mq;
import com.cloudcode.activemq.spring.ProducerService;
import com.cloudcode.framework.controller.CrudController;

@Controller
@RequestMapping("/activemq")
public class MqController extends CrudController<Mq> {
	
	@Autowired
	private ProducerService producerService;
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;
	
	@RequestMapping(value = "activemqList")
	public ModelAndView futuresTypeList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("classpath:com/cloudcode/activemq/ftl/list.ftl");
		return modelAndView;
	}

	@RequestMapping(value = "create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("classpath:com/cloudcode/activemq/ftl/detail.ftl");
		return modelAndView;
	}

	@RequestMapping(value = "/sendMessage", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody void sendMessage(@ModelAttribute  @Valid Mq mq, HttpServletRequest request) {
		for (int i=0; i<2; i++) {
			producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));
		}
	}
	
}
