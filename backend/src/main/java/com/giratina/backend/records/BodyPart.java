package com.giratina.backend.records;

import lombok.Getter;

@Getter
public enum BodyPart {
    HEAD(0, "Head"),
    HAND(1, "Hand")
    ;
    // TODO: Add more please

    private final int value;
    private final String description;

    BodyPart(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static BodyPart fromValue(int value) throws IllegalArgumentException {
        for (BodyPart bodyPart : BodyPart.values()) {
            if (bodyPart.value == value) {
                return bodyPart;
            }
        }
        throw new IllegalArgumentException("BodyPart with value " + value + " does not exist.");
    }
}
