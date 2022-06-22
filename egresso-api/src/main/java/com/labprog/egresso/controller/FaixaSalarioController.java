package com.labprog.egresso.controller;

import java.util.List;

import com.labprog.egresso.controller.dto.CargoDto;
import com.labprog.egresso.controller.dto.FaixaSalarioDto;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.FaixaSalario;
import com.labprog.egresso.model.repositories.FaixaSalarioRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labprog.egresso.model.dto.SalarioNumEgresso;
import com.labprog.egresso.service.FaixaSalarioService;

@RestController
@RequestMapping("/api/faixasalario")
public class FaixaSalarioController {

    @Autowired
    private FaixaSalarioService fsService;

    @Autowired
    private FaixaSalarioRepository faixaSalarioRepository;

    @GetMapping
    public List<FaixaSalario> listarFaixaSalario(){
        return faixaSalarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody FaixaSalarioDto dto){
        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao(dto.getDescricao())
                .build();

        try {
            FaixaSalario salvo = fsService.salvar(faixaSalario);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/egresso-por-salario")
    public List<SalarioNumEgresso> listarNumEgressoPorSalario(){
        return fsService.quantEgressoPorSalario();
    }
}
