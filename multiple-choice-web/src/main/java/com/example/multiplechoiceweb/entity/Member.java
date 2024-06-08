package com.example.multiplechoiceweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @EmbeddedId
    private MemberId id;

    @MapsId("classID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classID", nullable = false)
    private classEntity classEntityID;

    @MapsId("userID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    private User userID;

}