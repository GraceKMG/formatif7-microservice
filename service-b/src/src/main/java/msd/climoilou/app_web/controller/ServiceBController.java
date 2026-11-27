package msd.climoilou.app_web.controller;

import msd.climoilou.app_web.dto.MessageDTO;
import msd.climoilou.app_web.modele.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ServiceBController {
    public static final String SERVICE_A = "service-a";
    private Logger logger = LoggerFactory.getLogger(ServiceBController.class);
    private RestClient restClient;

    public ServiceBController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/serviceb/sansdb")
    public String getServiceB() throws URISyntaxException {

        logger.info("requete vers getService B");

//        String serviceAResponse = "pas encore fait";
       URI serviceInstanceUri = new URI("http://service-a/8080");
        String serviceAResponse = restClient.get()
                .uri(serviceInstanceUri + "/message/sansdb")
                .retrieve()
                .body(String.class);
        return serviceAResponse + " reçu du service B";
    }

    @GetMapping("/serviceb/avecdb")
    public String getServiceBAvecMessage() throws URISyntaxException {
        logger.info("requete vers getService B avec message");


        MessageDTO message = new MessageDTO("Pas encore fait");
        return message.getMessage() + " --- reçu du service B ";
    }



}
