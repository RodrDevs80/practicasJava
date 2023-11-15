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
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(targetEntity = Coach.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_coach")
    private Coach coach;

    @OneToMany(targetEntity = Player.class,fetch = FetchType.LAZY,mappedBy = "club")
    private List<Player> players;
    @ManyToOne(targetEntity = FootballAssociation.class)
    private FootballAssociation footballAssociation;
    @ManyToMany(targetEntity = FootballCompetition.class,fetch = FetchType.LAZY)
    @JoinTable(name = "club_competition"
            ,joinColumns = @JoinColumn(name = "club"),
            inverseJoinColumns = @JoinColumn(name = "competition"))
    private List<FootballCompetition> competitions;
}
