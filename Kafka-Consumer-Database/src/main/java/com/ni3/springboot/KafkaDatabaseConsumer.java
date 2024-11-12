package com.ni3.springboot;

import com.ni3.springboot.entity.WikimediaData;
import com.ni3.springboot.repository.WikiMediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private WikiMediaRepository wikiMediaRepository;

    public KafkaDatabaseConsumer(WikiMediaRepository wikiMediaRepository) {
        this.wikiMediaRepository = wikiMediaRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){

        LOGGER.info(String.format("Event message received -> %s",eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikiMediaRepository.save(wikimediaData);

     }


}
