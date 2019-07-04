package com.bone;

import com.bone.core.EnableJpaSoftDeleteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaSoftDeleteRepositories
public class BoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoneApplication.class, args);
	}

}
