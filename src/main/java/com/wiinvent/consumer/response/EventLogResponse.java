package com.wiinvent.consumer.response;

import com.wiinvent.consumer.requests.EventLogRequest;
import lombok.Data;

import java.util.List;

@Data
public class EventLogResponse {
  private Integer errorCode;
  private String message;
  private List<EventLogRequest.EventLogDto> data;

}
