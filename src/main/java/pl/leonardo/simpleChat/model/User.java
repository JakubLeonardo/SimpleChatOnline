package pl.leonardo.simpleChat.model;

public class User {
    private Long id;
    private String nick;

    public User(Long id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    public Long getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
