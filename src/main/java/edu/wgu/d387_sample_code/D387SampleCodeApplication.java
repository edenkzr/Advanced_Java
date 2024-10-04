package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.convertor.TimeZoneService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {

	/*public static Map<String, String> messages = new HashMap<>();
    public static String englishMessage;
	static String frenchMessage;
	static ExecutorService messageExecutor=newFixedThreadPool(5);*/

	public static void main(String[] args) {

		SpringApplication.run(D387SampleCodeApplication.class, args);

		/*TimeZoneService timeZoneService = new TimeZoneService();
		timeZoneService.getTimeZoneService(timeZoneService.zUTC);
		Properties props = new Properties();

		messageExecutor.execute(()-> {
			try {
				InputStream stream = new ClassPathResource("translations_en_US.properties").getInputStream();
				props.load(stream);
				System.out.println(props.getProperty("welcome"));
				stream = new ClassPathResource("translations_en_US.properties").getInputStream();
				props.load(stream);
				System.out.println(props.getProperty("welcome"));
				stream = new ClassPathResource("translations_en_US.properties").getInputStream();
				props.load(stream);
				System.out.println(props.getProperty("welcome"));
				messages.put("en_US", props.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		messageExecutor.execute(()-> {
			try {
				InputStream stream = new ClassPathResource("translations_fr_CA.properties").getInputStream();
				props.load(stream);
				System.out.println(props.getProperty("welcome"));
				stream = new ClassPathResource("translations_fr_CA.properties").getInputStream();
				props.load(stream);
				System.out.println(props.getProperty("welcome"));
				stream = new ClassPathResource("translations_fr_CA.properties").getInputStream();
				props.load(stream);
				System.out.println(props.getProperty("welcome"));
				messages.put("fr_CA", props.getProperty("welcome"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		messageExecutor.shutdown();
		try {
			// Wait for a maximum of 5 seconds for the tasks to complete
			if (messageExecutor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
				englishMessage = messages.get("en_US"); // Get value for English
				frenchMessage = messages.get("fr_CA"); // Get value for French

// Print the messages
				System.out.println("English: " + englishMessage);
				System.out.println("French: " + frenchMessage);

			} else {
				System.out.println("Tasks did not finish in the allotted time.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

}
