package com.IssatSo.AppWeb.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enseignant")
@Builder
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nom;
    String prenom;
    String cin;
    Date date_nais;
    String lieu_nais;
    int num_tel;
    String genre;
    String nationalite;
    String email;
    String password;
    String specialite;
    String grade;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private  Instant updatedAt;
}
