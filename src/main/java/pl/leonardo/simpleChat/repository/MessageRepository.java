package pl.leonardo.simpleChat.repository;

import org.springframework.stereotype.Repository;
import pl.leonardo.simpleChat.model.Message;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    List<Message> messages = new ArrayList<>();

    public List<Message> findAll() {
        return messages;
    }
    public void addMessage(Message message){
        messages.add(message);
    }
    public Message getMessage(long id) {
        if(findMessageIndexById(id) != -1) return messages.get(findMessageIndexById(id));
        else return null;
    }
    public void updateMessage(long id, Message message){
        int ID = findMessageIndexById(id);
        if(ID != -1){
            messages.get(ID).setId(message.getId());
            messages.get(ID).setSend_to(message.getSend_to());
            messages.get(ID).setSent_by(message.getSent_by());
            messages.get(ID).setContent(message.getContent());
        }
    }

    public void deleteMessage(Long id) {
        if(findMessageIndexById(id) != -1){
            messages.remove(findMessageIndexById(id));
        }
    }

    public int findMessageIndexById(long id){
        int index=-1;
        for(Message mess : messages) {
            if(mess.getId() == id) {
                index =  mess.getId().intValue();
            }
        }
        return index;
    }
}
