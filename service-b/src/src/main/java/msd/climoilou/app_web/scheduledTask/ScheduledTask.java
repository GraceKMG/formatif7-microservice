package msd.climoilou.app_web.scheduledTask;

import msd.climoilou.app_web.controller.ServiceBController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTask {



    private int i = 0;
    private Logger logger = LoggerFactory.getLogger(ServiceBController.class);



    public void doScheduyledTask()  {
        //TODO


    }


}
