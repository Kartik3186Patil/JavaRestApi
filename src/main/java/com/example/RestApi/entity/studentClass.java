package com.example.RestApi.entity;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
public class studentClass {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String dept;
    private LocalDateTime date;

}
