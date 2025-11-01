package hng.backend.task3.fashionAiAgent;

import com.google.adk.web.AdkWebServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FashionAiAgentApplication {
	public static void main (String[]args) {
//		AdkWebServer.start();
		SpringApplication.run(FashionAiAgentApplication.class, args);
	}
}