package pe.com.synopsis.imgrabber.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RepositoriesConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean(name="AGVJdbcTemplate")
	public JdbcTemplate AGVJdbcTemplate()
	{
		return new JdbcTemplate(dataSource);
	}
}
