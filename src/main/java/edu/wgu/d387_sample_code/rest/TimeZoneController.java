package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.convertor.TimeZoneService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;


import static java.util.concurrent.Executors.newFixedThreadPool;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TimeZoneController {

    static ExecutorService messageExecutor=newFixedThreadPool(5);
    TimeZoneService timeZone =new TimeZoneService();
    CountDownLatch latch = new CountDownLatch(3);

    @RequestMapping(path ="/timezone", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> showTimeZone(){

        List<String> timeZones = new CopyOnWriteArrayList<>();

        messageExecutor.execute(() -> {
            try {
                String eastern = timeZone.parseTimeZone(1);
                if ( !timeZones.contains(eastern)) {
                    timeZones.add(eastern);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }

        });
        messageExecutor.execute(() -> {
            try {
                String pacific = timeZone.parseTimeZone(2);
                if ( !timeZones.contains(pacific)) {
                    timeZones.add(pacific);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });
        messageExecutor.execute(() -> {
            try {
                String UTC = timeZone.parseTimeZone(3);
                if ( !timeZones.contains(UTC) ) {
                    timeZones.add(UTC);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }

        });

        try {
            latch.await();  // Wait for all 3 tasks to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupted status
            e.printStackTrace();
        }
        return timeZones;
    }
}

