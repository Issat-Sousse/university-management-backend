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
    public static ResponseEtudiant makeEtudiant(Etudiant etudiant){
        return  ResponseEtudiant.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .cin(etudiant.getCin())
                .date_nais(etudiant.getDate_nais())
                .lieu_nais(etudiant.getLieu_nais())
                .num_tel(etudiant.getNum_tel())
                .genre(etudiant.getGenre())
                .nationalite(etudiant.getNationalite())
                .email(etudiant.getEmail())
                .password(etudiant.getPassword())
                .specialite(etudiant.getSpecialite())
                .diplome(etudiant.getDiplome())
                .situation(etudiant.getSituation())
                .createdAt(etudiant.getCreatedAt())
                .updatedAt(etudiant.getUpdatedAt())
                .build();
    }
}
