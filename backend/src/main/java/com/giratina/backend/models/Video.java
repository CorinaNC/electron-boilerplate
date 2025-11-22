package com.giratina.backend.models;

import com.giratina.backend.records.BodyPart;
import com.giratina.backend.records.Muscle;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(setterPrefix = "set")
@Document(collection = "videos")
public class Video {
    @Id
    private ObjectId id;

    @CreatedDate
    private LocalDateTime createdTS;

    @LastModifiedDate
    private LocalDateTime updatedTS;

    @Field("name")
    String name;

    @Field("url")
    String url;

    @DocumentReference(lazy = true)
    private List<Muscle> muscles;

    @DocumentReference(lazy = true)
    private List<BodyPart> bodyParts;
}
