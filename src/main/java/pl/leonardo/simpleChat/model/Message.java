package pl.leonardo.simpleChat.model;

public class Message {
    private Long id;
    private Long sent_by;
    private Long send_to;
    private String content;

    public Message(Long id, Long sent_by, Long send_to, String content) {
        this.id = id;
        this.sent_by = sent_by;
        this.send_to = send_to;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Long getSent_by() {
        return sent_by;
    }

    public Long getSend_to() {
        return send_to;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSent_by(Long sent_by) {
        this.sent_by = sent_by;
    }

    public void setSend_to(Long send_to) {
        this.send_to = send_to;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
