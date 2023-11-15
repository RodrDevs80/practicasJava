package com.sertec.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class FootballAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String president;
    @OneToMany(targetEntity = Club.class,fetch = FetchType.LAZY,mappedBy = "footballAssociation")
    private List<Club> clubs;
}
