package com.cts.fmsjwt.config;
/**
 * @author 849289
 * */
import java.nio.charset.StandardCharsets;

import io.r2dbc.spi.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory;
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
import com.github.jasync.sql.db.mysql.util.URLParser;

@Configuration
public class MySQLConfiguration extends AbstractR2dbcConfiguration{

	@Override
	@Bean
	public ConnectionFactory connectionFactory() {
		// TODO Auto-generated method stub
		String url="mysql://root:root123@localhost:3306/fms";
		return new JasyncConnectionFactory(new MySQLConnectionFactory(URLParser.INSTANCE.parseOrDie(url,StandardCharsets.UTF_8)));
	}

}
