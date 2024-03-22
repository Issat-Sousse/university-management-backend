package com.IssatSo.AppWeb.Controller;

import com.IssatSo.AppWeb.Dto.*;
import com.IssatSo.AppWeb.ServiceImpl.EnseignantServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/enseignant")
@RequiredArgsConstructor
public class EnseignantController {
    @Autowired
    private EnseignantServiceImpl enseignantService;
    @GetMapping("")
    public ResponseEntity<List<ResponseEnseignant>> getAllEnseignant(){
        List<ResponseEnseignant> enseignants= enseignantService.getAllEnseignant();
        return ResponseEntity.ok(enseignants);
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseEnseignant> getEnseignantById(@PathVariable Long id){
        return ResponseEntity.ok(enseignantService.getEnseignantById(id));
    }
    @PostMapping("")
    public ResponseEntity<Object> addEnseignant(@RequestBody @Valid RequestEnseignant request){
        enseignantService.CreateEnseignant(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success !")
        );
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateEnseigant(
            @PathVariable(name="id") Long id,
            @RequestBody @Valid RequestEnseignantUpdate request ){
        enseignantService.updateEnseignant(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public  ResponseEntity<Object> deleteEnseignant (@PathVariable Long id){
        boolean deleteEnseignant= enseignantService.deleteEnseignant(id);
        if (deleteEnseignant){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "deleted success !!")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "etudiant not exist ")
        );

    }
}
