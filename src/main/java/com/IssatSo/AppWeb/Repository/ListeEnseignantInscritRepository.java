package com.IssatSo.AppWeb.Repository;

import com.IssatSo.AppWeb.Entities.ListeEnseignantInscit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListeEnseignantInscritRepository extends JpaRepository<ListeEnseignantInscit, Long> {
    boolean existsByCin(String cin);
}
