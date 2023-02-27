package com.wiinvent.consumer.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "gift_history")
public class User {
    @Id
    private String id;
    private String name;
    private String phoneNumber;

}
