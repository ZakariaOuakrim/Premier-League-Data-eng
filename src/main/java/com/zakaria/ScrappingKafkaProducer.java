package com.zakaria;

import com.zakaria.scraper.LeagueTableScraper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ScrappingKafkaProducer {
    private static final String BOOTSTRAP_SERVERS = "localhost:29092";
    private static final String TOPIC = "Premier-League-Table";

    public static void main(String[] args) {
        //configuration Kafka Producer
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //kafka producer
        KafkaProducer<String,String> producer=new KafkaProducer<>(properties);
        //scrapping from website
        try{
            System.out.println("Scrapping from BBC");
            LeagueTableScraper leagueTableScraper =new LeagueTableScraper();
            leagueTableScraper.scrapDataFromBBC();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
