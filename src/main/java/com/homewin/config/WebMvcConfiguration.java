package com.homewin.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.homewin.config.intercepors.LoginInterceptor;
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
	// classpath:/META-INF/resources/,
	// classpath:/resources/,classpath:/static/,classpath:/public/
//	可以在这里或者在配置文件中设置访问外部文件
//   @Override
//public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	   registry.addResourceHandler("/**").addResourceLocations("file:D:/")
//	   
//	   ;
//	WebMvcConfigurer.super.addResourceHandlers(registry);
//   }
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/welcome","/sendVerCode/**", "/register", "/login", "/add", "/js/**", "/css/**", "/images/**", "/bootstrap/**","/layer/**", "/img/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}