package a26.web2.service_a.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import a26.web2.service_a.dto.MessageDTO;
import a26.web2.service_a.model.Message;
import a26.web2.service_a.repository.MessageRepository;

import java.util.Iterator;

@RestController
public class ServiceAController implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(ServiceAController.class);

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/message/sansdb")
    public String getServiceA() {
        logger.info("service-a message sans db");
        return "service-a message sans db";
    }

    @GetMapping("/message/avecdb")
    public MessageDTO getServiceAMessage() {
        logger.info("requete vers message avec db");
        Iterator<Message> messageIterator = messageRepository.findAll().iterator();
        Message message = messageIterator.next(); //On retourne le premier message disponible.
        if (message != null) {
            return new MessageDTO(message);
        } else {
            return new MessageDTO("No message in DB"); // Sinon on en inventeun
        }
    }


    @Override
    public void run(String... args) throws Exception {
        // on s'assure que le message est présent à l'ouverture
        Message message = messageRepository.findFirstByMessageIs("DB message");
        if (message == null) {
            message = new Message("service-a message avec db");
            messageRepository.save(message);
        }
    }
}
