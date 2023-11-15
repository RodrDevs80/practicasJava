package com.sertec.JSB.entityR.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "client")
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1,
            initialValue = 999
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "client_sequence")
    Long id;
    @Column(name = "name")
    String name;
    @OneToOne
    User user;
    @OneToMany(fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    Set<Address> addressList=new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_product",
            joinColumns = {@JoinColumn(name = "fk_client")},
            inverseJoinColumns = {@JoinColumn(name = "fk_product")}
    )
    Set<Product> products=new HashSet<>();

}
