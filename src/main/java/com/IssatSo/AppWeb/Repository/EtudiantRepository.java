package com.IssatSo.AppWeb.Repository;

import com.IssatSo.AppWeb.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
