package com.example.securesaving;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.securesaving.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecureSavingApplicationTests {

	@Autowired
	private DemoController demoController;

	@Test
	void contextLoads() {
		assertThat(demoController).isNotNull();
	}

}
