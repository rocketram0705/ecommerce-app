package com.excercise.demoform;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.excercise.demoform.model.UserData;
import com.excercise.demoform.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
@AutoConfigureMockMvc
@SpringBootTest
class DemoformApplicationTests {
	    
    
	@Autowired
	private UserRepository userRepository;
	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testIndexController() {
	    UserData userData = new UserData();
		userData.setAddress("chennai");
		userData.setName("ram");
		userData.setFatherName("Devendran");
		userData.setPassword("root");
        userRepository.save(userData);
		UserData found = userRepository.findById(userData.getsNo()).get();
		assertEquals(userData.getsNo(),found.getsNo());

	}

}
