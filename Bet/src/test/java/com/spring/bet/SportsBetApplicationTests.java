package com.spring.bet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories("com.spring.bet.repo")
@EntityScan(basePackages={"com.spring.bet.entity"})
public class SportsBetApplicationTests {

	@Test
	public void contextLoads() {
	}

}
