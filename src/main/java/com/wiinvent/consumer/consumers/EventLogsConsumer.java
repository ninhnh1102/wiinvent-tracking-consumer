package com.wiinvent.consumer.consumers;

import com.wiinvent.consumer.configs.TopicConfig;
import com.wiinvent.consumer.entities.EventLog;
import com.wiinvent.consumer.services.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class EventLogsConsumer {
  @Autowired
  private TrackingService trackingService;

  @KafkaListener(topics = TopicConfig.EVENT_LOGS_TOPIC)
  public void processorEventLog(
      List<String> messages, Acknowledgment acknowledgment) {
    List<EventLog> eventLogs = new ArrayList<>();
    messages.forEach(message -> {
      try {
        EventLog eventLog = new ObjectMapper().readValue(message, EventLog.class);
        eventLogs.add(eventLog);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    });

    trackingService.sendEventLogHttp(eventLogs);
    acknowledgment.acknowledge();
  }

}
