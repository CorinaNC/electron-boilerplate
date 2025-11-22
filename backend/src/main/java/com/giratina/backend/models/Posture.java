package com.giratina.backend.models;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Data
@Builder(setterPrefix = "set")
@Document(collection = "postures")
public class Posture {
    @Id
    private ObjectId id;

    @CreatedDate
    private LocalDateTime createdTS;

    @LastModifiedDate
    private LocalDateTime updatedTS;

    @DocumentReference(lazy = true)
    private User user;

    // TODO: Add vectors or something?? How do we define this posture
}
