package com.example.codeblue;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class CodeblueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeblueApplication.class, args);
	}
	 
//	@Bean
//    public ViewResolver viewResolver() {
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setTemplateMode("XHTML");
//        templateResolver.setPrefix("templates/");
//        templateResolver.setSuffix(".html");
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver);
// 
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(engine);
//        return viewResolver;        
//    } 
	
	 @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	        javaMailSender.setHost("smtp.gmail.com");
	        javaMailSender.setPort(587);
	        javaMailSender.setUsername("ddukgyen@gmail.com");
	        javaMailSender.setPassword("dmzdshurwgdmcfsu");
	        
	        Properties properties = new Properties();
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.starttls.enable", "true");
	        javaMailSender.setJavaMailProperties(properties);
	        
	        return javaMailSender;
	        
	 }
}
