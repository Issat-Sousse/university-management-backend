package com.IssatSo.AppWeb.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ListeEtudiantInscrit")
@Builder
public class ListeEtudiantInscrit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nom;
    String prenom;
    String cin;
    Date date_nais;
    String lieu_nais;
    String diplome;
}
