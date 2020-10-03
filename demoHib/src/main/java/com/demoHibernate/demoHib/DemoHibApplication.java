package com.demoHibernate.demoHib;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan(basePackages = "com.demoHibernate")
@EnableJpaRepositories(basePackages = "com.demoHibernate")
@EntityScan( basePackages = {"com.demoHibernate"} )
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
public class DemoHibApplication {

	public static void main(String[] args) {
		if(args == null || args.length == 0) {
		  System.out.println("No Args passed for runner");
		  System.exit(-1);
		}
		SpringApplication.run(DemoHibApplication.class, args);
	}

	
	@Autowired
	private Map<String,ExampleRunner> runners;
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println(runners.size());
			ExampleRunner runner = runners.get(args[0]);
			runner.run(ctx);
			System.out.println("Hello ");
			SpringApplication.exit(ctx, () -> 0);
		};
	}

}
