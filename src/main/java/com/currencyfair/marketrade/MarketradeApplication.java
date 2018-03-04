package com.currencyfair.marketrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class },
scanBasePackages={"com.currencyfair.marketrade"})
public class MarketradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketradeApplication.class, args);
	}
}
