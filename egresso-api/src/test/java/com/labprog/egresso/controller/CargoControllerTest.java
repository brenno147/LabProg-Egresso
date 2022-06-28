// package com.labprog.egresso.controller;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
// import com.labprog.egresso.controller.dto.CargoDto;
// import com.labprog.egresso.model.entities.Cargo;
// import com.labprog.egresso.service.CargoService;

// @ExtendWith(SpringExtension.class)
// @ActiveProfiles("test")
// @WebMvcTest(controllers = CargoController.class)
// @AutoConfigureMockMvc
// public class CargoControllerTest {

//   static final String API = "/api/cargos";

//   @Autowired
//   MockMvc mvc;

//   @MockBean
//   CargoService service;

//   @Test
//   public void deveSalvarUmCargo() throws Exception {

//     CargoDto dto = CargoDto
//         .builder()
//         .nome("Devops")
//         .descricao("Profissional que atua no desenvolvimento e infraestrutura de sistemas")
//         .build();

//     Cargo cargo = Cargo
//         .builder()
//         .nome(dto.getNome())
//         .descricao(dto.getDescricao())
//         .build();

//     Mockito.when(
//         service.salvar(
//             Mockito.any(Cargo.class)))
//         .thenReturn(cargo);

//     String json = new ObjectMapper()
//         .writeValueAsString(dto);

//     MockHttpServletRequestBuilder request = MockMvcRequestBuilders
//         .post(API + "/salvar")
//         .accept(MediaType.APPLICATION_JSON)
//         .contentType(MediaType.APPLICATION_JSON)
//         .content(json);

//     mvc.perform(request)
//         .andExpect(MockMvcResultMatchers.status().isCreated());

//   }

//   @Test
//   public void deveEditarUmCargo() throws Exception {

//     // Mockito.when(
//     // service.editar(Mockito.any(Cargo.class)))
//     // .thenReturn();
//   }

// }
