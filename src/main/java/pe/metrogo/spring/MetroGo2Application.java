package pe.metrogo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MetroGo2Application {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MetroGo2Application.class, args);
	}

	public void run(String...args) throws Exception {
		String password = "12345";
		String contra = "pet";
		
		for(int i = 0; i < 2 ; i++) {
			String bCrypPassword1 = passwordEncoder.encode(password);		
			System.out.println(bCrypPassword1);
			}
		
		for(int i = 0; i < 2 ; i++) {
			String bCrypPassword2 = passwordEncoder.encode(contra);		
			System.out.println(bCrypPassword2);
			}
	}
}
