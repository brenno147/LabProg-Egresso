package com.labprog.egresso.controller;

import com.labprog.egresso.controller.dto.DepoimentoDto;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Depoimento;
import com.labprog.egresso.model.repositories.DepoimentoRepository;
import com.labprog.egresso.service.DepoimentoService;
import com.labprog.egresso.service.EgressoService;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/depoimentos")
public class DepoimentoController {
    @Autowired
    private DepoimentoService depoimentoService;

    @Autowired
    private EgressoService egressoService;

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @GetMapping
    public List<Depoimento> listarDepoimentos(){
        return depoimentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody DepoimentoDto dto) {

        Depoimento depoimento = Depoimento.builder()
                .texto(dto.getTexto())
                .egresso(egressoService.findById(dto.getIdEgresso()))
                .texto(dto.getTexto())
                .data(dto.getData())
                .build();


        try {
            Depoimento salvo = depoimentoService.salvar(depoimento);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Depoimento> editar(@PathVariable Long id, @RequestBody DepoimentoDto dto) {
        if (!depoimentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Depoimento depoimento = Depoimento.builder()
                .id_depoimento(id)
                .texto(dto.getTexto())
                .egresso(egressoService.findById(dto.getIdEgresso()))
                .texto(dto.getTexto())
                .data(dto.getData())
                .build();

        try {
            Depoimento salvo = depoimentoService.salvar(depoimento);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!depoimentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            depoimentoService.remover(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/depoimentos-recentes")
    public List<Depoimento> buscarDepoimentosRecentes(){
        return depoimentoService.buscarDepoimentosRecentes();
    }

    @GetMapping("/depoimentos-por-egresso/{id}")
    public List<Depoimento> buscarDepoimentosPorEgresso(@PathVariable Long id){
        return depoimentoService.buscarDepoimentoEgresso(id);
    }
}
