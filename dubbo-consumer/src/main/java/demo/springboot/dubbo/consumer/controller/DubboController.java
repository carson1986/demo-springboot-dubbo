package demo.springboot.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import demo.springboot.dubbo.producer.api.service.DubboProducerService;

@RestController
public class DubboController {

	@Reference
	private DubboProducerService producerService;
	
	@GetMapping({ "/index"})
	public String index() {
		return producerService.sqlHello("carson");
	}
}
