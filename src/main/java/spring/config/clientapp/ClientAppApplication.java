package spring.config.clientapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}	

}

@RefreshScope
@RestController
class MessageRestController {
	
	//gitUri = https://github.com/solivaf/config-properties-bar
	@Value("${foo.bar:Unable to connect to config server}")
	private String message2;

	@RequestMapping("/app-bar/message")
	String getAppFooMsg() {
		return this.message2+":foo.bar";
	}
}

