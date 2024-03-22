package com.IssatSo.AppWeb.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RequestEnseignant {
    Long id;
    @NotBlank(message = "nom est obligatoire")
    String nom;
    @NotBlank(message = "prenom est obligatoire")
    String prenom;
    @NotBlank(message = "CIN est obligatoire")
    String cin;
    Date date_nais;
    String lieu_nais;
    @Max(value = 99999999, message = "numero telepohone invalid")
    @Min(value = 10000000, message = "numero telepohone invalid")
    int num_tel;
    String genre;
    String nationalite;
    @NotBlank(message = "email est obligatoire")
    @Email
    String email;
    @NotBlank(message = "password est obligatoire")
    String password;
    String specialite;
    String grade;
}
