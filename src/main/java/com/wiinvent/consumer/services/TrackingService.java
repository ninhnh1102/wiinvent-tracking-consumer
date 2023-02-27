package com.wiinvent.consumer.services;

import com.wiinvent.consumer.requests.EventLogRequest;
import com.wiinvent.consumer.entities.EventLog;
import com.wiinvent.consumer.response.EventLogResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class TrackingService {
  private static RestTemplate restTemplate = new RestTemplate();
  @Value("${tv360.domain}")
  private String tv360Domain;

  public void sendEventLogHttp(List<EventLog> eventLogs) {
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    String url = tv360Domain + "/public/v1/tracking/event-adv";
    EventLogRequest eventLogRequest = new EventLogRequest();
    List<EventLogRequest.EventLogDto> data = new ArrayList<>();

    for (EventLog eventLog: eventLogs) {
      EventLogRequest.EventLogDto eventLogDto = new EventLogRequest.EventLogDto();
      eventLogDto.setLogId(eventLog.getId());
      eventLogDto.setAccountId(eventLog.getTenantId());
      data.add(eventLogDto);
    }
    eventLogRequest.setTotal(eventLogs.size());
    eventLogRequest.setData(data);

    HttpEntity<EventLogRequest> httpEntity = new HttpEntity<>(eventLogRequest, requestHeaders);
    ResponseEntity<EventLogResponse> eventLogResponseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, EventLogResponse.class);
    log.info("======responseSendTracking: " + eventLogResponseEntity);
  }
}
