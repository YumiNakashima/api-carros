package com.carros.api;

import com.carros.domain.CarroService;
import com.carros.domain.dto.CarroDTO;
import com.carros.utils.GenerateRandom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CarrosController.class)
public class CarrosControllerTest {

    @InjectMocks
    private CarrosController controller;

    @Mock
    private CarroService carroService;

    @Spy
    private GenerateRandom generateRandom;

    private MockMvc mvc;
    private List<CarroDTO> listaCarros;
    private CarroDTO carro1;
    private CarroDTO carro2;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(controller)
                //.setControllerAdvice(new ControllerExceptionHandler())
                .build();
        listaCarros = new ArrayList<>();
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

    @Test
    public void deveRetornarListaComTodosOsCarrosQuandoChamarGetAllCarros() {
        when(carroService.getCarros()).thenReturn(listaCarros);

        ResponseEntity<List<CarroDTO>> response = controller.getAllCarros();

        assertEquals(listaCarros.size(), response.getBody().size());
    }

    @Test
    public void deveVerificarIdDosCarrosDaListaQuandoChamarGetAllCarros(){
        when(carroService.getCarros()).thenReturn(listaCarros);

        ResponseEntity<List<CarroDTO>> response = controller.getAllCarros();

        assertEquals(listaCarros.get(0).getId(), response.getBody().get(0).getId());
        assertEquals(listaCarros.get(1).getId(), response.getBody().get(1).getId());
    }
    //endregion GetAllCarros

}
