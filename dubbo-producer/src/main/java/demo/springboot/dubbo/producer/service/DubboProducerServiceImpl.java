package demo.springboot.dubbo.producer.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import demo.springboot.dubbo.producer.api.service.DubboProducerService;

@Service(interfaceClass=DubboProducerService.class)
@Component
public class DubboProducerServiceImpl implements DubboProducerService {

	@Override
	public String sqlHello(String name) {
		return name+" hello";
	}

}
