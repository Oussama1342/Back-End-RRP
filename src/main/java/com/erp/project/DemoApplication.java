package com.erp.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;



@SpringBootApplication

@CrossOrigin(origins = "*")
public class DemoApplication implements CommandLineRunner {
    

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
	//	Users u = new Users("amari", "amari", "mednine");
		
		//userRepository.save(u);
		//roleInterface.saveRole(new Role("clt", u));
	}

}
