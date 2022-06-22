package com.labprog.egresso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labprog.egresso.model.dto.SalarioNumEgresso;
import com.labprog.egresso.service.FaixaSalarioService;

@RestController
@RequestMapping("/api/faixasalario")
public class FaixaSalarioController {

    @Autowired
    private FaixaSalarioService fsService;


    @GetMapping
    public List<SalarioNumEgresso> listarSalarioEgressos(){
        return fsService.quantEgressoPorCurso();
    }
}
