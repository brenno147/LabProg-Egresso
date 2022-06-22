package com.labprog.egresso.service;

import com.labprog.egresso.model.entities.Depoimento;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.repositories.DepoimentoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepoimentoService {
    @Autowired
    private DepoimentoRepository depoimentoRepository;
    @Autowired
    private EgressoService egressoService;

    public Depoimento salvar(Depoimento depoimento){
        Egresso egresso = egressoService.findById(depoimento.getEgresso().getIdEgresso());

        depoimento.setEgresso(egresso);

        return depoimentoRepository.save(depoimento);
    }

    public void remover(Long depoimentoId){
        depoimentoRepository.deleteById(depoimentoId);
    }

    public List<Depoimento> buscarDepoimentosRecentes(){
        return depoimentoRepository.findByOrderByDataDesc();
    }

    public List<Depoimento> buscarDepoimentoEgresso(Long idEgresso){
        Egresso egresso = egressoService.findById(idEgresso);
        return depoimentoRepository.findByEgresso(egresso);
    }

    public Depoimento findById(Long id){
        return depoimentoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Depoimento não encontrado"));
    }
}
