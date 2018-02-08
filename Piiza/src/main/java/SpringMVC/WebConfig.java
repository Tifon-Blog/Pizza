package SpringMVC;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan({ "springmvc" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
		public NamedParameterJdbcTemplate geTemplate() {
			return new NamedParameterJdbcTemplate(dataSource);
		}
		
		public DataSource geDataSource() {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/prueba2");
			ds.setUsername("root");
			ds.setPassword("2222");
			
			return ds;
		}
		
		@Bean(name="multipartResolver")
		public CommonsMultipartResolver geCommonsMultipartResolver() {
			CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
			commonsMultipartResolver.setMaxUploadSize(20*1024*1024);//20mb de capacidad por archivo
			
			return commonsMultipartResolver;
		}
		
		//public void addResourceHandlers(ResourceHandlerRegistration registration) {
		//	registration.addResourceLocations("/resources/**").addResourceLocations("/resources/");
			
		//}
		
		public InternalResourceViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/jspx/");
			viewResolver.setSuffix(".jspx");
			
			return viewResolver;
		}
		
		@Bean
		public ResourceBundleMessageSource messageSource() {
			ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
			rb.setBasenames(new String[] {"validation"});
			
			return rb;
		}
		//tutorial en curso https://www.youtube.com/watch?v=eQpzrxtD2dA
		//https://www.youtube.com/watch?v=eQpzrxtD2dA
}
