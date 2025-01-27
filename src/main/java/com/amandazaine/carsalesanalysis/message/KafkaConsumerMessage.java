package com.amandazaine.carsalesanalysis.message;

import com.amandazaine.carsalesanalysis.dto.CarPostDTO;
import com.amandazaine.carsalesanalysis.service.CarPostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostAnalyticsService carPostAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "car_sales_analytics")
    public void listening(@Payload CarPostDTO carPostDTO) {
        LOG.info("Received CarPost information: {}", carPostDTO);
        carPostAnalyticsService.saveDataAnalytics(carPostDTO);
    }

}
