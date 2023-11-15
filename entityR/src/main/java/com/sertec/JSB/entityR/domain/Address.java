package com.sertec.JSB.entityR.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1,
            initialValue = 8100
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_sequence")
    Long id;
    @Column(name = "street")
    String street;
    @Column(name = "number")
    String number;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "client_id")
    Client client;

}
