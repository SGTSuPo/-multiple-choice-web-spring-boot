package com.example.multiplechoiceweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "host")
public class Host {
    @EmbeddedId
    private HostId id;

    @MapsId("classID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classID", nullable = false)
    private classEntity classEntityID;

    @MapsId("hostID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hostID", nullable = false)
    private User hostID;

}