package jh.mooGameRest.mooGameRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class BasicConfig {


//	@Autowired
//	ApplicationContext applicationContext;
//	
//
//	@Bean
//	public ViewResolver thymeleafResolver() {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(templateEngine());
//		viewResolver.setOrder(0);
//		return viewResolver;
//	
//	}
//	
//	@Bean
//	public SpringResourceTemplateResolver templateResolver() {
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setApplicationContext(applicationContext);
//		templateResolver.setSuffix(".html");
//		return templateResolver;
//	}
//	
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver());
//		templateEngine.setEnableSpringELCompiler(true);
//		return templateEngine;
//	}
	
}
