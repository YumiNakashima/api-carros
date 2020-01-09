package com.carros.api;

import com.carros.domain.Carro;
import com.carros.domain.CarroService;
import com.carros.domain.dto.CarroDTO;
import com.carros.utils.GenerateRandom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarrosController.class)
public class CarrosControllerTest {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private CarrosController controller;

    @MockBean
    private CarroService service;

    @Spy
    private GenerateRandom generateRandom;

    private static List<CarroDTO> listaCarros = new ArrayList<CarroDTO>();
    private static CarroDTO carro1;
    private static CarroDTO carro2;

    @Before
    public void setup() {
        carro1 = generateRandom.buildRandomCarroDTO();
        carro2 = generateRandom.buildRandomCarroDTO();
        listaCarros.add(carro1);
        listaCarros.add(carro2);

    }

    //region GetAllCarros
    @Test
    public void deveRetornarStatus200QuandoChamarGetAllCarros() throws Exception {
        mvc.perform(get("/api/v1/carros")
                    .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(OK.value()));
    }

//    @Test
//    public void deveRetornarListaComTodosOsCarrosQuandoChamarGetAllCarros(){
//        when(service.getCarros()).thenReturn(listaCarros);
//
//        ResponseEntity<List<CarroDTO>> response = controller.getAllCarros();
//
//        assertEquals(listaCarros.size(), response.getBody().size());
//    }
//
//    @Test
//    public void deveVerificarIdDosCarrosDaListaQuandoChamarGetAllCarros(){
//        when(service.getCarros()).thenReturn(listaCarros);
//
//        ResponseEntity<List<CarroDTO>> response = controller.getAllCarros();
//
//        assertEquals(listaCarros.get(0).getId(), carro1.getId());
//        assertEquals(listaCarros.get(1).getId(), carro2.getId());
//    }
    //endregion GetAllCarros

}
