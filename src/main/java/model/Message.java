package model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "text")
    private String text;
    @Column(name = "senderId")
    private String senderId;
    @Column(name = "receiverId")
    private String receiverId;
    @Column(name = "senderName")
    private String senderName;
    @Column(name = "receiverName")
    private String receiverName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {return receiverName;}

    public void setReceiverName(String receiverName) {this.receiverName = receiverName;}

    public String getSenderName() {return senderName;}

    public void setSenderName(String senderName) {this.senderName = senderName;}
}
