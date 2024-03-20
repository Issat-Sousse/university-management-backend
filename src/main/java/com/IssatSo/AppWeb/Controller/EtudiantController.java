package com.IssatSo.AppWeb.Controller;

import com.IssatSo.AppWeb.Dto.RequestEtudiant;
import com.IssatSo.AppWeb.Dto.RequestEtudiantUpdate;
import com.IssatSo.AppWeb.Dto.ResponseEtudiant;
import com.IssatSo.AppWeb.Service.EtudiantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("")
    public ResponseEntity<List<ResponseEtudiant>> getAllEtudiant(){
        List<ResponseEtudiant> etudiants= etudiantService.getAllEtudiant();
        return ResponseEntity.ok(etudiants);
    }
    @PostMapping("")
    public ResponseEntity<Object> addEtudiant(@RequestBody @Valid RequestEtudiant request){
        etudiantService.CreateEtudiant(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success !")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseEtudiant> getEtudiantById(@PathVariable Long id){
        return ResponseEntity.ok(etudiantService.getEtudiantById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateEtudiant(
            @PathVariable(name="id") Long id,
            @RequestBody @Valid RequestEtudiantUpdate request ){
        etudiantService.updateEtudiant(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public  ResponseEntity<Object> deleteEtudiant (@PathVariable Long id){
        boolean deleteEtudiant= etudiantService.deleteEtudiant(id);
        if (deleteEtudiant){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "deleted success !!")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "etudiant not exist ")
        );

    }
}
