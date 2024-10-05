package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.convertor.MessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageController {

    MessageService messageService = new MessageService();
    static ExecutorService messageExecutor=newFixedThreadPool(5);

    @RequestMapping(path ="/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showPresentation(){
        CountDownLatch latch = new CountDownLatch(2);
        Map<String, String> messages = new HashMap<>();

        messageExecutor.execute(()->{
            try {
                Properties props = new Properties();
                props = messageService.getMessages("translations_en_US.properties");
                messages.put("en_US", props.getProperty("welcome"));
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });
        messageExecutor.execute(()->{
            try {
                Properties prop = new Properties();
                prop = messageService.getMessages("translations_fr_CA.properties");
                messages.put("fr_CA", prop.getProperty("welcome"));
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        String[] messagesArray = messages.values().toArray(new String[0]);

        return messagesArray;
    }
}
