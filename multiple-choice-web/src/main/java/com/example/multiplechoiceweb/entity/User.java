package com.example.multiplechoiceweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")

public class User {
    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Column(name = "username", nullable = false, length = 10)
    private String username;

    @Column(name = "password", nullable = false, length = 70)
    private String password;

    @Nationalized
    @Column(name = "firstName", nullable = false, length = 10)
    private String firstName;

    @Nationalized
    @Column(name = "lastName", nullable = false, length = 10)
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @Nationalized
    @Column(name = "address", length = 50)
    private String address;

    @Nationalized
    @Column(name = "phone", length = 12)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roleID", nullable = false)
    private Role roleID;

}