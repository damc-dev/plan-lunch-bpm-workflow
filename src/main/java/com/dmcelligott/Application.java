package com.dmcelligott;


import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
/*
	@Bean
    SpringProcessEngineConfiguration springProcessEngineConfiguration() {
        SpringProcessEngineConfiguration engine = new SpringProcessEngineConfiguration();
        engine.setMailServerHost("smtp.gmail.com");
        engine.setMailServerPort(587);
        engine.setMailServerUseTLS(true);
        engine.setMailServerUsername("damc.dev@gmail.com");
        engine.setMailServerPassword("PointD3xter");
        engine.setMailServerDefaultFrom("damc.dev@gmail.com");
        return engine;
    }
*/
	@Bean
	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

		return new InitializingBean() {
			public void afterPropertiesSet() throws Exception {

				Group group = identityService.newGroup("user");
				group.setName("users");
				group.setType("security-role");
				identityService.saveGroup(group);

				User admin = identityService.newUser("admin");
				admin.setPassword("admin");
				identityService.saveUser(admin);

			}
		};
	}
}
