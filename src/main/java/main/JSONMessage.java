package main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class JSONMessage {
    private String content;
    private String senderId;
    private String receiverId;
    private Date date;

    @JsonCreator
    public JSONMessage() {
        super();
    }

    public JSONMessage(String content, String senderId, String receiverId, Date date) {
        this.content = content;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "JSONMessage{" +
                "content='" + content + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
