package com.walk.start;

@SpringBootApplication
@ConfigurationProperties
@EnableAutoConfiguration
@Component
public class Application implements CommandLineRunner{
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	public void run(String... args) throws Exception {
		// nothing to do...
	}
}
