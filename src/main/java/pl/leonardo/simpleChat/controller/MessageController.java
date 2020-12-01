package pl.leonardo.simpleChat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.leonardo.simpleChat.model.Message;
import pl.leonardo.simpleChat.service.MessageService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    private static AtomicLong idCounter = new AtomicLong();

    @GetMapping("/messages")
    public List<Message> getMessages(){
        return messageService.getMessages();
    }
    @GetMapping("/messages/{id}")
    public Message getSingleMessage(@PathVariable long id){
        return messageService.getMessageById(id);
    }

    @PostMapping("/messages")
    public void createMessage(@RequestBody Message message){
        messageService.addMessage(new Message(idCounter.getAndIncrement(),message.getSent_by(),
                message.getSend_to(), message.getContent()));
    }
    @PostMapping("/messages/{id}")
    public void addSingleMessage(@PathVariable Long id, @RequestBody Message message){
        messageService.addMessage(new Message(id,message.getSent_by(),
                message.getSend_to(), message.getContent()));
    }

    @PutMapping("/messages/{id}")
    public void updateMessage(@PathVariable Long id, @RequestBody Message message){
        messageService.updateMessage(id, message);
    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable Long id){
        messageService.deleteMessage(id);
    }
}
