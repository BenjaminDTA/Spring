package fr.dta;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.service.MainService;

@Configuration
@ComponentScan(basePackages = "fr.dta")
//@ImportResource("application.properties")
public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		MainService mainService = (MainService) context.getBean("mainService");
		mainService.start();
		context.close();
	}

}
