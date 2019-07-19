package controller;

import br.com.control.revenda.controller.RevendaController;
import br.com.control.revenda.entity.Revenda;
import br.com.control.revenda.entity.dtos.RevendaDTO;
import br.com.control.revenda.service.RevendaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RevendaController.class)
@SpringBootTest(classes=RevendaController.class)
public class RevendaControllerTest {

    @MockBean
    RevendaService revendaService;

    @Autowired
    MockMvc mockMvc;


    private RevendaDTO revendaDTO;
    private Revenda revenda;
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        revendaDTO = new RevendaDTO(145, "teste 1");
        revenda = new Revenda(1456, "teste 2");

    }


    @Test
    public void quando_salvar_revenda_tem_que_devolver_a_revenda() throws Exception{
        given(revendaService.save(any(Revenda.class))).willReturn(revenda);
        mockMvc.perform(post("/revenda/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(revendaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(revendaDTO.getName()));
    }


}
