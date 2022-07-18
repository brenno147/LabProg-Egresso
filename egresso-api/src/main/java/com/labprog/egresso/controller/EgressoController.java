package com.labprog.egresso.controller;


import com.labprog.egresso.model.dto.ContatoDTO;
import com.labprog.egresso.model.dto.CursoEgressoDTO;
import com.labprog.egresso.model.dto.EgressoDTO;
import com.labprog.egresso.model.dto.ProfEgressoDTO;
import com.labprog.egresso.model.entities.*;
import com.labprog.egresso.model.repositories.EgressoRepository;
import com.labprog.egresso.service.CargoService;
import com.labprog.egresso.service.CursoService;
import com.labprog.egresso.service.EgressoService;
import com.labprog.egresso.service.FaixaSalarioService;
import com.labprog.egresso.service.exceptions.RegraNegocioException;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log4j2
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Egresso> listarEgressos(){
        return egressoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody EgressoDTO dto){
        log.info("\n\n\nDTOEGRESSO:",dto);

        Egresso egresso = Egresso.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .urlFoto(dto.getUrlFoto())
                .resumo(dto.getResumo())
                .senha(passwordEncoder.encode(dto.getSenha()))
                .build();

        log.info("\n\n\nEGRESSO:",egresso);
        for (ContatoDTO contatoDto : dto.getContatos()) {
            Contato contato = Contato.builder()
                    .nome(contatoDto.getNome())
                    .url_logo(contatoDto.getUrlLogo())
                    .build();

            egresso.getContatos().add(contato);
        }

        try {
            Egresso salvo = egressoService.salvar(egresso);
            if(salvo != null){
                for (CursoEgressoDTO cursoEgressoDto : dto.getCursos()) {
                    Curso curso = cursoService.buscarPorId(cursoEgressoDto.getCursoId());
        
                    CursoEgressoPK pk = CursoEgressoPK.builder()
                            .egresso_id(salvo.getIdEgresso())
                            .curso_id(cursoEgressoDto.getCursoId())
                            .build();
                    
        
                    CursoEgresso cursoEgresso = CursoEgresso.builder()
                            .id(pk)
                            .curso(curso)
                            .data_inicio(cursoEgressoDto.getDataInicio())
                            .data_conclusao(cursoEgressoDto.getDataConclusao())
                            .build();
        
                    salvo.addCurso(cursoEgresso);
                }
                for (ProfEgressoDTO profEgressoDto : dto.getProfissoes()) {
                    Cargo cargo = cargoService.buscarPorId(profEgressoDto.getCargoId());

                    FaixaSalario faixaSalario = faixaSalarioService.buscarPorId(profEgressoDto.getFaixaSalarioId());
        
                    ProfEgresso profEgresso = ProfEgresso.builder()
                            .egresso(salvo)
                            .cargo(cargo)
                            .faixaSalario(faixaSalario)
                            .empresa(profEgressoDto.getEmpresa())
                            .descricao(profEgressoDto.getDescricao())
                            .dataRegistro(profEgressoDto.getDataRegistro())
                            .build();
        
                    salvo.addProfissao(profEgresso);
                }
            }
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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
