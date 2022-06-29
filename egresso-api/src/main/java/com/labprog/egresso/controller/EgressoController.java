package com.labprog.egresso.controller;

import com.labprog.egresso.controller.dto.ContatoDto;
import com.labprog.egresso.controller.dto.CursoEgressoDto;
import com.labprog.egresso.controller.dto.EgressoDto;
import com.labprog.egresso.controller.dto.ProfEgressoDto;
import com.labprog.egresso.model.entities.*;
import com.labprog.egresso.model.repositories.EgressoRepository;
import com.labprog.egresso.service.CargoService;
import com.labprog.egresso.service.CursoService;
import com.labprog.egresso.service.EgressoService;
import com.labprog.egresso.service.FaixaSalarioService;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/egressos")
public class EgressoController {

    @Autowired
    EgressoService egressoService;

    @Autowired
    EgressoRepository egressoRepository;

    @Autowired
    CursoService cursoService;

    @Autowired
    CargoService cargoService;

    @Autowired
    FaixaSalarioService faixaSalarioService;

    @GetMapping
    public List<Egresso> listarEgressos(){
        return egressoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody EgressoDto dto){
        Egresso egresso = Egresso.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .urlFoto(dto.getUrlFoto())
                .resumo(dto.getResumo())
                .build();

        for (ContatoDto contatoDto : dto.getContatos()) {
            Contato contato = Contato.builder()
                    .nome(contatoDto.getNome())
                    .url_logo(contatoDto.getUrl_logo())
                    .build();

            egresso.getContatos().add(contato);
        }

        for (CursoEgressoDto cursoEgressoDto : dto.getCursos()) {
            Curso curso = cursoService.buscarPorId(cursoEgressoDto.getCursoId());

            CursoEgresso cursoEgresso = CursoEgresso.builder()
                    .curso(curso)
                    .data_inicio(cursoEgressoDto.getDataInicio())
                    .data_conclusao(cursoEgressoDto.getDataConclusao())
                    .build();

            egresso.addCurso(cursoEgresso);
        }

        for (ProfEgressoDto profEgressoDto : dto.getProfissoes()) {
            Cargo cargo = cargoService.buscarPorId(profEgressoDto.getCargoId());
            FaixaSalario faixaSalario = faixaSalarioService.buscarPorId(profEgressoDto.getFaixaSalarioId());

            ProfEgresso profEgresso = ProfEgresso.builder()
                    .cargo(cargo)
                    .faixaSalario(faixaSalario)
                    .empresa(profEgressoDto.getEmpresa())
                    .descricao(profEgressoDto.getDescricao())
                    .dataRegistro(profEgressoDto.getDataRegistro())
                    .build();

            egresso.addProfissao(profEgresso);
        }

        try {
            Egresso salvo = egressoService.salvar(egresso);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        if (!egressoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            egressoService.remover(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{nome}")
    public ResponseEntity consultarNome(@PathVariable String nome){
        try {
            Egresso consultado = egressoService.egressoPorNome(nome);
            return new ResponseEntity(consultado, HttpStatus.OK);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
