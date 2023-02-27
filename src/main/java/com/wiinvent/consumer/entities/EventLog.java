package com.wiinvent.consumer.entities;

import lombok.Data;

@Data
public class EventLog {
  private String id;
  private String deviceId;
  private Integer viewerId;
  private Long clientTime;
  private Long serverTime;
  private Long processTime;
  private String ip;
  private String city;
  private String country;
  private String platform;
  private String type;
  private Boolean frequencyEnable;
  private String campaignFrequency;
  private Integer frequencyValue;
  private Long ownerId;
  private Long channelId;
  private Long streamId;
  private Long overlayId;
  private Long campaignId;
  private String campaignType;
  private Long sessionId;
  private Long createdAt;
  private String browser;
  private String os;
  private Integer tenantId;
  private String vastCampaignId;
}
