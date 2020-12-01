package pl.leonardo.simpleChat.model;

import pl.leonardo.simpleChat.repository.MessageRepository;

import java.util.List;

public class Chat {
    private Long id;
    private User firstUser;
    private User secondUser;
    private MessageRepository messages;
    private String urlAddress;

    public Chat(Long id, User firstUser, String urlAddress) {
        this.id = id;
        this.firstUser = firstUser;
        this.urlAddress = urlAddress;
    }

    public Long getId() {
        return id;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public MessageRepository getMessages() {
        return messages;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }
}
