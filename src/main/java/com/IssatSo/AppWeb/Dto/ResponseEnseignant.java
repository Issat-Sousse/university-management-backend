package com.IssatSo.AppWeb.Dto;

import com.IssatSo.AppWeb.Entities.Enseignant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseEnseignant {
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
    private Instant createdAt;
    private Instant updatedAt;
    public static ResponseEnseignant makeEnseignant(Enseignant enseignant){
        return  ResponseEnseignant.builder()
                .id(enseignant.getId())
                .nom(enseignant.getNom())
                .prenom(enseignant.getPrenom())
                .cin(enseignant.getCin())
                .date_nais(enseignant.getDate_nais())
                .lieu_nais(enseignant.getLieu_nais())
                .num_tel(enseignant.getNum_tel())
                .genre(enseignant.getGenre())
                .nationalite(enseignant.getNationalite())
                .email(enseignant.getEmail())
                .password(enseignant.getPassword())
                .specialite(enseignant.getSpecialite())
                .grade(enseignant.getGrade())
                .createdAt(enseignant.getCreatedAt())
                .updatedAt(enseignant.getUpdatedAt())
                .build();
    }
}
