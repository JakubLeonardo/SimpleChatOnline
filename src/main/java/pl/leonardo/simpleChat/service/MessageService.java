package pl.leonardo.simpleChat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leonardo.simpleChat.model.Message;
import pl.leonardo.simpleChat.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void addMessage(Message mess){
        if(messageRepository.findMessageIndexById(mess.getId()) == -1) messageRepository.addMessage(mess);
    }

    public Message getMessageById(long id) {
        return messageRepository.getMessage(id);
    }
    public void updateMessage(long id, Message mess){
        messageRepository.updateMessage(id, mess);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteMessage(id);
    }
}
