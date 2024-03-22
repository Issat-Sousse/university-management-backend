package com.IssatSo.AppWeb.Service;

import com.IssatSo.AppWeb.Dto.RequestEnseignant;
import com.IssatSo.AppWeb.Dto.RequestEnseignantUpdate;
import com.IssatSo.AppWeb.Dto.ResponseEnseignant;
import com.IssatSo.AppWeb.Entities.Enseignant;

import java.util.List;

public interface EnseignantService {
    List<ResponseEnseignant> getAllEnseignant();
    void CreateEnseignant(RequestEnseignant enseignantRequest);
    boolean deleteEnseignant(Long id);
    Enseignant updateEnseignant(Long id, RequestEnseignantUpdate enseignantRequest);

    ResponseEnseignant getEnseignantById(Long id);
}
