package com.wiinvent.consumer.requests;

import com.wiinvent.consumer.requests.Type.Action;
import com.wiinvent.consumer.requests.Type.DeviceType;
import lombok.Data;

import java.util.List;

@Data
public class EventLogRequest {
  private Integer total;
  private List<EventLogDto> data;

  @Data
  public static class EventLogDto {
    private Integer accountId;
    private String channelId;
    private String streamId;
    private DeviceType deviceType;
    private String thirdPartyToken;
    private String vastCampaignId;
    private String logId;
    private String contentId;
    private String contentTypeVOD;
    private String displayDuration;
    private String duration;
    private Action action;
  }
}
