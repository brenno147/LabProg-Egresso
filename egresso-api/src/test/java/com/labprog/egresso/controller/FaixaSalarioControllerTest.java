package com.labprog.egresso.controller;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.labprog.egresso.model.dto.SalarioNumEgresso;
import com.labprog.egresso.service.FaixaSalarioService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FaixaSalarioController.class)
@AutoConfigureMockMvc
public class FaixaSalarioControllerTest {
    
   static final String API = "/api/faixasalario";

   @Autowired
   MockMvc mvc;

   @MockBean
   FaixaSalarioService service;

   @Test
   public void deveObterUmaListaComAquantidadeDeEgressosPorFaixaSalarial() throws Exception{
        List<SalarioNumEgresso> salEgr = new ArrayList<SalarioNumEgresso>();
        salEgr.add(new SalarioNumEgresso(3L, 1L));

        Mockito.when(
            service.quantEgressoPorSalario()
        ).thenReturn(salEgr);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(API).accept(MediaType.APPLICATION_JSON);

        mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
   }



}
