package com.sertec.JSB.entityR.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_auth")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    Long id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
}
