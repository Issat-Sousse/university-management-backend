package com.IssatSo.AppWeb.Repository;

import com.IssatSo.AppWeb.Entities.Etudiant;
import com.IssatSo.AppWeb.Entities.ListeEtudiantInscrit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListeEtudiantInscritRepository extends JpaRepository<ListeEtudiantInscrit, Long> {
    boolean existsByCin(String cin);
}
