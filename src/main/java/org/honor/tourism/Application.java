package org.honor.tourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class Application {
//测试冲突啥地方啥地方
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
