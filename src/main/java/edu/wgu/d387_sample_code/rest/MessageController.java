package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.convertor.MessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageController {

    MessageService messageService = new MessageService();
    //String en_US = messageService.englishMessage;

    @RequestMapping(path ="/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> showPresentation(){

        return new ArrayList<>(messageService.messages.values());
    }
}
