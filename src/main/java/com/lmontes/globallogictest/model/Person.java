package com.lmontes.globallogictest.model;

//mport jakarta.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import lombok.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column( unique = true )

    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;
    private LocalDateTime created;
    private LocalDateTime lastLogin;
    private boolean isActive = true;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}
