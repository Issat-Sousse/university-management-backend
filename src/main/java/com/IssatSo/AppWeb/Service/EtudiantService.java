package com.IssatSo.AppWeb.Service;

import com.IssatSo.AppWeb.Dto.RequestEtudiant;
import com.IssatSo.AppWeb.Dto.RequestEtudiantUpdate;
import com.IssatSo.AppWeb.Dto.ResponseEtudiant;
import com.IssatSo.AppWeb.Entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<ResponseEtudiant> getAllEtudiant();
    void CreateEtudiant(RequestEtudiant EtudiantRequest);
    boolean deleteEtudiant(Long id);
    Etudiant updateEtudiant(Long id, RequestEtudiantUpdate EtudiantRequest);

    ResponseEtudiant getEtudiantById(Long id);
}
