package com.wiinvent.consumer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

public class Helper {

  public static long getNowMillisAtUtc() {
    return System.currentTimeMillis();
  }

  public static Map<String, Object> objectToMap(Object object) {
    ObjectMapper oMapper = new ObjectMapper();
    return oMapper.convertValue(object, Map.class);
  }

  public static LocalDate getTodayDateHCMZone() {
    return getTodayDateTimeHCMZone().toLocalDate();
  }

  public static java.time.LocalDateTime getTodayDateTimeHCMZone() {
    return java.time.LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
  }

  public static java.time.LocalDateTime getTodayDateTimeUTCZone() {
    return java.time.LocalDateTime.now(ZoneId.of("UTC"));
  }

  public static java.time.LocalDateTime convertFromHCMToUTC(java.time.LocalDateTime dateTimeHCM) {
    return dateTimeHCM
            .atZone(ZoneId.of("Asia/Ho_Chi_Minh"))
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toLocalDateTime();
  }

  public static java.time.LocalDateTime convertToHCMDateTime(String dateTimeStr) {
    java.time.format.DateTimeFormatter formatter =
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeStr, formatter);
    ZoneId hcmZone = ZoneId.of("Asia/Ho_Chi_Minh");
    ZonedDateTime hcmZoned = zonedDateTime.withZoneSameInstant(hcmZone);
    return hcmZoned.toLocalDateTime();
  }

  public static String replaceWhiteSpace(String text) {
    if(text != null) {
      return text.replaceAll("\\s", "");
    }
    return null;
  }
}
