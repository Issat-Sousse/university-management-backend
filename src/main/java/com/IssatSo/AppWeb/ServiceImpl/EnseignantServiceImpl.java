package com.IssatSo.AppWeb.ServiceImpl;

import com.IssatSo.AppWeb.Dto.*;
import com.IssatSo.AppWeb.Entities.Enseignant;
import com.IssatSo.AppWeb.Entities.Etudiant;
import com.IssatSo.AppWeb.Repository.EnseignantRepository;
import com.IssatSo.AppWeb.Repository.ListeEnseignantInscritRepository;
import com.IssatSo.AppWeb.Service.EnseignantService;
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
public class EnseignantServiceImpl implements EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    ListeEnseignantInscritRepository listeEnseignantInscritRepository;

    private final PasswordEncoder passwordEncoder;
    private boolean isEnseignantExist(String cin){
        return listeEnseignantInscritRepository.existsByCin(cin);
    }
    @Override
    public List<ResponseEnseignant> getAllEnseignant() {
        List<Enseignant> enseignants = enseignantRepository.findAll();
        List<ResponseEnseignant> enseignantFormated = new ArrayList<>();
        for(Enseignant enseignant: enseignants){
            ResponseEnseignant member = ResponseEnseignant.makeEnseignant(enseignant);
            enseignantFormated.add(member);
        }
        return enseignantFormated;
    }
    @Override
    public void CreateEnseignant(RequestEnseignant enseignantRequest) {
        if (isEnseignantExist(enseignantRequest.getCin())){
            Enseignant enseignant = Enseignant.builder()
                    .nom(enseignantRequest.getNom())
                    .prenom(enseignantRequest.getPrenom())
                    .cin(enseignantRequest.getCin())
                    .date_nais(enseignantRequest.getDate_nais())
                    .lieu_nais(enseignantRequest.getLieu_nais())
                    .num_tel(enseignantRequest.getNum_tel())
                    .genre(enseignantRequest.getGenre())
                    .nationalite(enseignantRequest.getNationalite())
                    .email(enseignantRequest.getEmail())
                    .specialite(enseignantRequest.getSpecialite())
                    .grade(enseignantRequest.getGrade())
                    .password(passwordEncoder.encode(enseignantRequest.getPassword()))
                    .build();
            enseignantRepository.save(enseignant);
       }else {
           throw new IllegalStateException("L'enseignant n'est pas inscrit dans la liste des enseignant inscrits");
        }
    }

    @Override
    public boolean deleteEnseignant(Long id) {
        if (!enseignantRepository.existsById(id)) {
            return false;
        }
        enseignantRepository.deleteById(id);
        return false;
    }

    @Override
    public Enseignant updateEnseignant(Long id, RequestEnseignantUpdate enseignantRequest) {

        Enseignant enseignant = enseignantRepository.findById(id).orElseThrow();
        if(enseignantRequest.getNom() !=null){
            enseignant.setNom(enseignantRequest.getNom());
        }
        if(enseignantRequest.getPrenom() !=null){
            enseignant.setPrenom(enseignantRequest.getPrenom());
        }
        if(enseignantRequest.getEmail() !=null){
            enseignant.setEmail(enseignantRequest.getEmail());
        }

        if(enseignantRequest.getNum_tel() !=0){
            enseignant.setNum_tel(enseignantRequest.getNum_tel());
        }


        return enseignantRepository.save(enseignant);
    }

    @Override
    public ResponseEnseignant getEnseignantById(Long id) {
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        return ResponseEnseignant.makeEnseignant(enseignant.get());
    }
}
