package com.IssatSo.AppWeb.Dto;

import com.IssatSo.AppWeb.Entities.Etudiant;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
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
    String diplome;
    String situation;
    private Instant createdAt;
    private Instant updatedAt;
    public static ResponseEtudiant makeEtudiant(Etudiant Etudiant){
        return  ResponseEtudiant.builder()
                .id(Etudiant.getId())
                .nom(Etudiant.getNom())
                .prenom(Etudiant.getPrenom())
                .cin(Etudiant.getCin())
                .date_nais(Etudiant.getDate_nais())
                .lieu_nais(Etudiant.getLieu_nais())
                .num_tel(Etudiant.getNum_tel())
                .genre(Etudiant.getGenre())
                .nationalite(Etudiant.getNationalite())
                .email(Etudiant.getEmail())
                .password(Etudiant.getPassword())
                .specialite(Etudiant.getSpecialite())
                .diplome(Etudiant.getDiplome())
                .situation(Etudiant.getSituation())
                .createdAt(Etudiant.getCreatedAt())
                .updatedAt(Etudiant.getUpdatedAt())
                .build();
    }
}
