package pl.entito.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		String password = "admin";
		String encodedPass = encoder.encode(password);
		System.out.println(
				"saltet hash -> " + encodedPass + " matches pass -> " + encoder.matches(password, encodedPass));

	}
}
