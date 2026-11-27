package a26.web2.service_a.dto;

import a26.web2.service_a.model.Message;

public class MessageDTO {
    private String message;

    public MessageDTO(String message) {
        this.message = message;
    }

    public MessageDTO(Message message) {
        this.message = message.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
