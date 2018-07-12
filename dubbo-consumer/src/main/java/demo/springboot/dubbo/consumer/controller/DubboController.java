package demo.springboot.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import demo.springboot.dubbo.producer.api.service.DubboProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "接口服务", value = "接口服务文档")
public class DubboController {

	@Reference
	private DubboProducerService producerService;
	
	@ApiOperation(value="测试调用dubbo服务", notes="调用生产者服务")
	@GetMapping({ "/index"})
	public String index() {
		return producerService.sqlHello("carson");
	}
}
