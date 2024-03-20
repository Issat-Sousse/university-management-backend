package com.IssatSo.AppWeb.ServiceImpl;

import com.IssatSo.AppWeb.Dto.RequestEtudiant;
import com.IssatSo.AppWeb.Dto.RequestEtudiantUpdate;
import com.IssatSo.AppWeb.Dto.ResponseEtudiant;
import com.IssatSo.AppWeb.Entities.Etudiant;
import com.IssatSo.AppWeb.Repository.EtudiantRepository;
import com.IssatSo.AppWeb.Service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
@Autowired
private EtudiantRepository etudiantRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void CreateEtudiant(RequestEtudiant EtudiantRequest) {
Etudiant etudiant = Etudiant.builder()
        .nom(EtudiantRequest.getNom())
        .prenom(EtudiantRequest.getPrenom())
        .cin(EtudiantRequest.getCin())
        .date_nais(EtudiantRequest.getDate_nais())
        .lieu_nais(EtudiantRequest.getLieu_nais())
        .num_tel(EtudiantRequest.getNum_tel())
        .genre(EtudiantRequest.getGenre())
        .nationalite(EtudiantRequest.getNationalite())
        .email(EtudiantRequest.getEmail())
        .specialite(EtudiantRequest.getSpecialite())
        .diplome(EtudiantRequest.getDiplome())
        .situation(EtudiantRequest.getSituation())
        .password(passwordEncoder.encode(EtudiantRequest.getPassword()))
        .build();
etudiantRepository.save(etudiant);
    }

    @Override
    public boolean deleteEtudiant(Long id) {
        if (!etudiantRepository.existsById(id)) {
            return false;
        }
        etudiantRepository.deleteById(id);
        return false;
    }

    @Override
    public Etudiant updateEtudiant(Long id, RequestEtudiantUpdate EtudiantRequest) {
        Etudiant etudaint = etudiantRepository.findById(id).orElseThrow();
        if(EtudiantRequest.getNom() !=null){
            etudaint.setNom(EtudiantRequest.getNom());
        }
        if(EtudiantRequest.getPrenom() !=null){
            etudaint.setPrenom(EtudiantRequest.getPrenom());
        }
        if(EtudiantRequest.getEmail() !=null){
            etudaint.setEmail(EtudiantRequest.getEmail());
        }

        if(EtudiantRequest.getNum_tel() !=0){
            etudaint.setNum_tel(EtudiantRequest.getNum_tel());
        }


        return etudiantRepository.save(etudaint);
    }

    @Override
    public List<ResponseEtudiant> getAllEtudiant() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<ResponseEtudiant> etudiantFormated = new ArrayList<>();
        for(Etudiant etudiant: etudiants){
            ResponseEtudiant member = ResponseEtudiant.makeEtudiant(etudiant);
            etudiantFormated.add(member);
        }
        return etudiantFormated;
    }

    @Override
    public ResponseEtudiant getEtudiantById(Long id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return ResponseEtudiant.makeEtudiant(etudiant.get());
    }
}
