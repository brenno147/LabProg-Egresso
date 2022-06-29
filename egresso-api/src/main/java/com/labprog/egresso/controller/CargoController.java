package com.labprog.egresso.controller;

import com.labprog.egresso.controller.dto.CargoDto;
import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.repositories.CargoRepository;
import com.labprog.egresso.service.CargoService;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public List<Cargo> listarCargos(){
        return cargoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody CargoDto dto) {
        Cargo cargo = Cargo.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .build();

        try {
            Cargo salvo = cargoService.salvar(cargo);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody CargoDto dto) {
        if (!cargoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Cargo cargo = Cargo.builder()
                .id(id)
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .build();

        try {
            Cargo salvo = cargoService.salvar(cargo);
            return new ResponseEntity(salvo, HttpStatus.OK);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!cargoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            cargoService.deletar(cargoRepository.findById(id).get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/lista-cargos-por-egresso/{id}")
    public List<Cargo> listaCargosPorEgresso(@PathVariable Long id) {
        return cargoService.consultarCargoPorEgresso(id);
    }

    @GetMapping("/quant-egresso-por-cargo")
    public List<CargoNumEgresso> quantEgressoPorCargo() {
        return cargoService.quantEgressoPorCargo();
    }


}
