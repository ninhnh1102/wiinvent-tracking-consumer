package com.wiinvent.consumer.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicConfig {
  public static final String VOTING_RESULT_TOPIC = "wiinvent.voting.results";
  public static final String EVENT_LOGS_TOPIC = "wiinvent.event_logs";
  public static final String STREAM_OVERLAY_LOG_EVENT_TOPIC = "wiinvent.streams.stream_overlay_log";
  public static final String CALCULATOR_POINT_ALL_VOTING_TOPIC =
      "wiinvent_calculator_point_all_voting";
  public static final String CALCULATOR_POINT_PER_VOTE_TOPIC = "wiinvent_calculator_per_vote";

  public static final String SURVEY_RESULT_TOPIC = "wiinvent.survey.results";

  public static final String DONATE_TOPIC = "wiinvent.donate";

  public static final String PREDICT_HISTORY_TOPIC = "wiinvent.predict.history";

  public static final String LOYALTY_ORDER_TOPIC = "wiinvent.loyalty.order";

  public static final String CAMPAIGN_STATISTIC_TOTAL_TOPIC = "wiinvent.campaign.statistical"; //realtime
//  public static final String CAMPAIGN_VIEW_FREQUENCY_TOPIC = "wiinvent.campaign.view.frequency";
  public static final String WIINVENT_BATCH_ITEM_STATISTICS = "wiinvent.batch.item.statistics"; //batch

  public static final String EVENT_TOPIC = "wiinvent.event_log";

  public static final String VOTING_PREDICT_RESULT_TOPIC = "wiinvent.voting.predict2.result";
  public static final String VOTING_PREDICT_RESULT_DLT_TOPIC = "wiinvent.voting.predict2.result.dlt";
  public static final String VOTING_PREDICT_RESULT_COMPLETED_TOPIC = "wiinvent.voting.predict2.result.completed";

  private static final Map<String, String> defaultConfigs = new HashMap<>();

  static {
    defaultConfigs.put("retention.ms", "604800000"); // 7 day
  }

  @Value("${spring.kafka.topic.replication-factor}")
  private short replicationFactor;

  @Value("${spring.kafka.topic.num-partitions}")
  private short numPartitions;

  @Bean
  public NewTopic createResultTopic() {
    NewTopic topic = new NewTopic(VOTING_RESULT_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic createCalculatorPoint() {
    NewTopic topic =
        new NewTopic(CALCULATOR_POINT_ALL_VOTING_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic createCalculatorPointPerVote() {
    NewTopic topic =
        new NewTopic(CALCULATOR_POINT_PER_VOTE_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic surveyResultTopic() {
    NewTopic topic = new NewTopic(SURVEY_RESULT_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic predictHistoryTopic() {
    NewTopic topic = new NewTopic(PREDICT_HISTORY_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic donateTopic() {
    NewTopic topic = new NewTopic(DONATE_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic loyaltyOrderTopic() {
    NewTopic topic = new NewTopic(LOYALTY_ORDER_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic createPredict2ResultDltTopic() {
    NewTopic topic = new NewTopic(VOTING_PREDICT_RESULT_DLT_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }

  @Bean
  public NewTopic createPredict2ResultCompletedTopic() {
    NewTopic topic = new NewTopic(VOTING_PREDICT_RESULT_COMPLETED_TOPIC, numPartitions, replicationFactor);
    topic.configs(defaultConfigs);
    return topic;
  }
}
