package com.labprog.egresso.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labprog.egresso.model.entities.Contato;
import com.labprog.egresso.model.entities.CursoEgresso;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.entities.ProfEgresso;
import com.labprog.egresso.model.repositories.ContatoRepository;
import com.labprog.egresso.model.repositories.CursoEgressoRepository;
import com.labprog.egresso.model.repositories.EgressoRepository;
import com.labprog.egresso.model.repositories.ProfEgressoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;

@Service
public class EgressoService implements UserDetailsService{
    @Autowired
    EgressoRepository egressoRepository;

    @Autowired
    ProfEgressoRepository profEgressoRepository;

    @Autowired
    CursoEgressoRepository cursoEgressoRepository;

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    EgressoRepository repository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Transactional
    public Egresso salvar(Egresso egresso) {
        verificarEgresso(egresso);

        for (Contato contato : egresso.getContatos()){
            contatoRepository.save(contato);
        }

        Egresso egressoSalvo = egressoRepository.save(egresso);

        for (ProfEgresso profissoes : egresso.getProfissao()) {
            profEgressoRepository.save(profissoes);
        }

        for (CursoEgresso cursos : egresso.getDatasCursos()) {
            cursoEgressoRepository.save(cursos);
        }

        return egressoSalvo;
    }

    @Transactional
    public void remover(Long egressoId) {
        Egresso egresso = egressoRepository.findById(egressoId)
                .orElseThrow(() -> new RegraNegocioException("Egresso não encontrado"));

        for (ProfEgresso profissoes : egresso.getProfissao()) {
            profEgressoRepository.delete(profissoes);
        }

        for (CursoEgresso cursos : egresso.getDatasCursos()) {
            cursoEgressoRepository.delete(cursos);
        }

        egressoRepository.delete(egresso);
    }

    public Egresso findById(Long id) {
        return egressoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Egresso não encontrado"));
    }

    public Egresso egressoPorNome(String nome) {
        return egressoRepository.findByNome(nome);
    }

    private void verificarEgresso(Egresso egresso) {
        if (egresso == null) {
            throw new RegraNegocioException("Egresso inválido");
        }

        if ((egresso.getNome() == null) || egresso.getNome().equals(' ')) {
            throw new RegraNegocioException("O nome do egresso não está preenchido corretamente");
        }

        if ((egresso.getEmail() == null) || egresso.getEmail().equals(' ')) {
            throw new RegraNegocioException("O email do egresso não está preenchido corretamente");
        }

        if ((egresso.getCpf() == null) || egresso.getCpf().equals(' ')) {
            throw new RegraNegocioException("O cpf do egresso não está preenchido corretamente");
        }

        if ((egresso.getResumo() == null) || egresso.getResumo().equals(' ')) {
            throw new RegraNegocioException("O resumo do egresso não está preenchido corretamente");
        }

        if ((egresso.getUrlFoto() == null) || egresso.getUrlFoto().equals(' ')) {
            throw new RegraNegocioException("A url da foto do egresso não está preenchido corretamente");
        }
    }


    // public boolean efetuarLogin(String email, String senha) {
    //     Optional <Egresso> egresso = repository.findByEmail(email);
    //     if (!egresso.isPresent())
    //         throw new RegraNegocioException("Erro de autenticação. Email informado não encontrado");    
    //     if (!egresso.get().getSenha().equals(senha))
    //         throw new RegraNegocioException("Erro de autenticação. Senha inválida");    
    //     return true;
    // }

    // public Egresso efetuarLogin(String email, String senha) {
        
    //     Optional <Egresso> egresso = repository.findByEmail(email);
    //     if (!egresso.isPresent())
    //         throw new RegraNegocioException("Erro de autenticação. Email informado não encontrado");    
    //     if (!passwordEncoder.matches(senha, egresso.get().getSenha()))
    //         throw new RegraNegocioException("Erro de autenticação. Senha inválida");    
    //     return egresso.get();
    // }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Egresso> usr = repository.findByEmail(email);
        if (!usr.isPresent())            
            throw new UsernameNotFoundException(email);
        Egresso a = usr.get();
        return new User(a.getEmail(), a.getSenha(), emptyList());
    }

    private Collection<? extends GrantedAuthority> emptyList() {
        return null;
    }

    
}
