package org.idtaleb.tp2_orm.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date birthDate;
    private boolean sick;
    private int score;
}