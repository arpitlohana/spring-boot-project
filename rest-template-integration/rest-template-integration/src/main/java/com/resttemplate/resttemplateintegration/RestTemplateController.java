package com.resttemplate.resttemplateintegration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/userscountry/{country}")
	public List<User> getUserCountry(@PathVariable String country){
			List<User> user=new ArrayList<>();
			String url="http://localhost:8080/jpa/users";
			User[] user1=restTemplate.getForObject(url, User[].class);
			
			for (User user2 : user1) {
				if(user2.getCountry().equalsIgnoreCase(country)) {
					user.add(user2);
			}
		}
			return user;
	}

}
