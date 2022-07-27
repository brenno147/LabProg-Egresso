package com.labprog.egresso.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labprog.egresso.model.dto.ContatoDTO;
import com.labprog.egresso.model.dto.CursoEgressoDTO;
import com.labprog.egresso.model.dto.DepoimentoDTO;
import com.labprog.egresso.model.dto.EgressoDTO;
import com.labprog.egresso.model.dto.EgressoEditeDTO;
import com.labprog.egresso.model.dto.ProfEgressoDTO;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Contato;
import com.labprog.egresso.model.entities.Curso;
import com.labprog.egresso.model.entities.CursoEgresso;
import com.labprog.egresso.model.entities.CursoEgressoPK;
import com.labprog.egresso.model.entities.Depoimento;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.entities.FaixaSalario;
import com.labprog.egresso.model.entities.ProfEgresso;
import com.labprog.egresso.model.repositories.CursoEgressoRepository;
import com.labprog.egresso.model.repositories.EgressoRepository;
import com.labprog.egresso.model.repositories.ProfEgressoRepository;
import com.labprog.egresso.service.CargoService;
import com.labprog.egresso.service.CursoService;
import com.labprog.egresso.service.DepoimentoService;
import com.labprog.egresso.service.EgressoService;
import com.labprog.egresso.service.FaixaSalarioService;
import com.labprog.egresso.service.exceptions.RegraNegocioException;

import lombok.extern.log4j.Log4j2;
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
    DepoimentoService depService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfEgressoRepository profEgressoRepository;


    @GetMapping
    public List<Egresso> listarEgressos(){
        return egressoRepository.findAll();
    }


    @PostMapping
    public ResponseEntity salvar(@RequestBody EgressoDTO dto){

        Egresso egresso = Egresso.builder()
            .nome(dto.getNome())
            .email(dto.getEmail())
            .cpf(dto.getCpf())
            .urlFoto(dto.getUrlFoto())
            .resumo(dto.getResumo())
            .senha(passwordEncoder.encode(dto.getSenha()))
            .build();

        for (ContatoDTO contatoDto : dto.getContatos()) {
            Contato contato = Contato.builder()
                .nome(contatoDto.getNome())
                .url_logo(contatoDto.getUrlLogo())
                .build();

            egresso.getContatos().add(contato);
        }

        for (ProfEgressoDTO profEgressoDto : dto.getProfissoes()) {

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

        for (CursoEgressoDTO cursoEgressoDto : dto.getCursos()) {

            Curso curso = cursoService.buscarPorId(cursoEgressoDto.getCursoId());

            CursoEgressoPK pk = CursoEgressoPK.builder()
                    .egresso_id(egresso.getIdEgresso())
                    .curso_id(cursoEgressoDto.getCursoId())
                    .build();
            

            CursoEgresso cursoEgresso = CursoEgresso.builder()
                    .id(pk)
                    .curso(curso)
                    .data_inicio(cursoEgressoDto.getDataInicio())
                    .data_conclusao(cursoEgressoDto.getDataConclusao())
                    .build();

            egresso.addCurso(cursoEgresso);
        }

        try {
            Egresso salvo = egressoService.salvar(egresso);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // editar um usuário
    @PutMapping("/editar/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody EgressoEditeDTO dto){
        Egresso egresso = Egresso.builder()
            .idEgresso(id)
            .nome(dto.getNome())
            .email(dto.getEmail())
            .cpf(dto.getCpf())
            .urlFoto(dto.getUrlFoto())
            .resumo(dto.getResumo())
            .senha(passwordEncoder.encode(dto.getSenha()))
            .build();
        // for (ProfEgressoDTO profEgressoDto : dto.getProfissoes()) {

        //     Cargo cargo = cargoService.buscarPorId(profEgressoDto.getCargoId());

        //     FaixaSalario faixaSalario = faixaSalarioService.buscarPorId(profEgressoDto.getFaixaSalarioId());

        //     ProfEgresso profEgresso = ProfEgresso.builder()
        //         .cargo(cargo)
        //         .faixaSalario(faixaSalario)
        //         .empresa(profEgressoDto.getEmpresa())
        //         .descricao(profEgressoDto.getDescricao())
        //         .dataRegistro(profEgressoDto.getDataRegistro())
        //         .build();

        //     egresso.addProfissao(profEgresso);
        // }
        

        // for (CursoEgressoDTO cursoEgressoDto : dto.getCursos()) {

        //     Curso curso = cursoService.buscarPorId(cursoEgressoDto.getCursoId());

        //     CursoEgressoPK pk = CursoEgressoPK.builder()
        //             .egresso_id(egresso.getIdEgresso())
        //             .curso_id(cursoEgressoDto.getCursoId())
        //             .build();
            

        //     CursoEgresso cursoEgresso = CursoEgresso.builder()
        //             .id(pk)
        //             .curso(curso)
        //             .data_inicio(cursoEgressoDto.getDataInicio())
        //             .data_conclusao(cursoEgressoDto.getDataConclusao())
        //             .build();

        //     egresso.addCurso(cursoEgresso);
        // }
        
        // if(dto.getDepoimentos() != null){
        //     LocalDate data = LocalDate.now();
        //     for (DepoimentoDTO depoimentoDto : dto.getDepoimentos()) {
        //         Depoimento depoimento = Depoimento.builder()
        //             .id_depoimento(depoimentoDto.getIdEgresso())
        //             .egresso(egresso)
        //             .texto(depoimentoDto.getTexto())
        //             .data(data)
        //             .build();
        //         egresso.addDepoimento(depoimento);
        //     }
        // }

        try {
            Egresso salvar = egressoService.salvar(egresso);
            return new ResponseEntity(salvar, HttpStatus.OK);
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

    @GetMapping("/email/{email}")
    public ResponseEntity consultarEmail(@PathVariable String email){
        try {
            Optional <Egresso> consultado = egressoService.egressoPorEmail(email);
            return new ResponseEntity(consultado, HttpStatus.OK);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/editar/profEgresso/{idProfEgresso}")
    public void deletarProfEgresso(@PathVariable Long idProfEgresso){
        ProfEgresso profEgresso = ProfEgresso.builder()
            .idProfEgresso(idProfEgresso)
            .build();
        profEgressoRepository.delete(profEgresso);
    }

}
