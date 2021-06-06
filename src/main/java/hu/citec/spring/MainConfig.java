package hu.citec.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("hu.citec,spring")
@PropertySource({"classpath:application.properties", "classpath:/application-${spring.profiles.active}.properties"})
public class MainConfig {
		
	@Bean
	public JdbcTemplate jdbcTemplate(@Value("${database_url}") String url, 
			@Value("${user}") String username, @Value("${password}") String password) {
		return new JdbcTemplate(dataSource(url, username, password));
	}
	
	private DataSource dataSource(String url, String username, String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
}