package com.restalone.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "users") // replace with your collection name if different
public class User {

    @Id
    private String id; // corresponds to _id: 'MTS38186'

    private String firstName;
    private String lastName;
    private String gender;
    private String dob;              // Can also use LocalDate if you prefer strict typing
    private String qualification;
    private String guardian;
    private String cqtype;
    private int cqscore;
    private String accesslevel;
}
