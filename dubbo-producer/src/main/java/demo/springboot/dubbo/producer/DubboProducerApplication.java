package demo.springboot.dubbo.producer;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication(scanBasePackages = { "demo.springboot.dubbo.producer"})
@EnableDubboConfiguration
public class DubboProducerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DubboProducerApplication.class);
	
	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext  content = SpringApplication.run(DubboProducerApplication.class, args);
		ConfigurableEnvironment env = content.getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}\n\t" +
                "External: \t{}://{}:{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));
	}
}
