package com.IssatSo.AppWeb.ServiceImpl;

import com.IssatSo.AppWeb.Dto.RequestEtudiant;
import com.IssatSo.AppWeb.Dto.RequestEtudiantUpdate;
import com.IssatSo.AppWeb.Dto.ResponseEtudiant;
import com.IssatSo.AppWeb.Entities.Etudiant;
import com.IssatSo.AppWeb.Repository.EtudiantRepository;
import com.IssatSo.AppWeb.Repository.ListeEtudiantInscritRepository;
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
@Autowired
private ListeEtudiantInscritRepository listeEtudiantInscritRepository;
    private final PasswordEncoder passwordEncoder;
    private boolean isEtudiantExist(String cin){
        return listeEtudiantInscritRepository.existsByCin(cin);
    }
    @Override
    public void CreateEtudiant(RequestEtudiant etudiantRequest) {
        if (isEtudiantExist(etudiantRequest.getCin())){
Etudiant etudiant = Etudiant.builder()
        .nom(etudiantRequest.getNom())
        .prenom(etudiantRequest.getPrenom())
        .cin(etudiantRequest.getCin())
        .date_nais(etudiantRequest.getDate_nais())
        .lieu_nais(etudiantRequest.getLieu_nais())
        .num_tel(etudiantRequest.getNum_tel())
        .genre(etudiantRequest.getGenre())
        .nationalite(etudiantRequest.getNationalite())
        .email(etudiantRequest.getEmail())
        .specialite(etudiantRequest.getSpecialite())
        .diplome(etudiantRequest.getDiplome())
        .situation(etudiantRequest.getSituation())
        .password(passwordEncoder.encode(etudiantRequest.getPassword()))
        .build();
etudiantRepository.save(etudiant);
    }else {
            throw new IllegalStateException("L'étudiant n'est pas inscrit dans la liste des étudiants inscrits");
        }}

    @Override
    public boolean deleteEtudiant(Long id) {
        if (!etudiantRepository.existsById(id)) {
            return false;
        }
        etudiantRepository.deleteById(id);
        return false;
    }

    @Override
    public Etudiant updateEtudiant(Long id, RequestEtudiantUpdate etudiantRequest) {
        Etudiant etudaint = etudiantRepository.findById(id).orElseThrow();
        if(etudiantRequest.getNom() !=null){
            etudaint.setNom(etudiantRequest.getNom());
        }
        if(etudiantRequest.getPrenom() !=null){
            etudaint.setPrenom(etudiantRequest.getPrenom());
        }
        if(etudiantRequest.getEmail() !=null){
            etudaint.setEmail(etudiantRequest.getEmail());
        }

        if(etudiantRequest.getNum_tel() !=0){
            etudaint.setNum_tel(etudiantRequest.getNum_tel());
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
