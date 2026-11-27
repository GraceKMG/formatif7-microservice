package a26.web2.service_a.dto;

import a26.web2.service_a.model.Message;

public class MessageDTOMapper {
    public MessageDTO versDTO(Message message){
        return new MessageDTO(message);
    }

    public Message versMessage(MessageDTO messageDTO){
        return new Message(messageDTO.getMessage());
    }
}

