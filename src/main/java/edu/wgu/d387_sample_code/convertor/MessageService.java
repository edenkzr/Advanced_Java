package edu.wgu.d387_sample_code.convertor;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MessageService {

    public static Map<String, String> messages = new HashMap<>();

    public Properties getMessages(String fileName) {
        Properties props = new Properties();

        try {
            InputStream stream = new ClassPathResource(fileName).getInputStream();
            props.load(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return props;
    }

    /*public MessageService() {
        Properties props = new Properties();

        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translations_en_US.properties").getInputStream();
                props.load(stream);
                messages.put("en_US", props.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("translations_fr_CA.properties").getInputStream();
                props.load(stream);
                messages.put("fr_CA", props.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.shutdown();
        try {

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
        }
    }
    public static String englishMessage;
    static String frenchMessage;
    static ExecutorService messageExecutor=newFixedThreadPool(5);
    */

}
