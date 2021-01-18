package com.carrental.model;

import com.carrental.enums.IdDocumentEnum;
import com.carrental.enums.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"reservations"})
@Entity
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private IdDocumentEnum idDocumentEnum;

    @Column
    private String documentNum;

    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations;

    public Customer(String login, String firstName, String lastName, String email, String password, Address address, Long id, IdDocumentEnum idDocumentEnum, String documentNum, Set<Reservation> reservations) {
        super(login, firstName, lastName, email, UserType.CUSTOMER, password, address);
        this.id = id;
        this.idDocumentEnum = idDocumentEnum;
        this.documentNum = documentNum;
        this.reservations = new HashSet<>();
    }
}
