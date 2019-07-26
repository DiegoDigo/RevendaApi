package services;

import br.com.control.revenda.entity.Revenda;
import br.com.control.revenda.entity.enums.EnvironmentEnum;
import br.com.control.revenda.repository.RevendaRepository;
import br.com.control.revenda.service.RevendaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RevendaServiceTest {

    @InjectMocks
    private RevendaService revendaService;

    @MockBean
    private RevendaRepository revendaRepository;

    private List<Revenda> revendas;

    private Page<Revenda> revendasPageable;

    private Revenda revenda;

    private Optional<Revenda> revendaOptional;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        revendas = Arrays.asList(
                new Revenda(1456, "teste 1", EnvironmentEnum.DEVELOP, "00000000"),
                new Revenda(1457, "teste 2", EnvironmentEnum.DEVELOP, "00000000"),
                new Revenda(1458, "teste 3", EnvironmentEnum.DEVELOP, "00000000")
        );

        revenda = new Revenda(1459, "teste 4", EnvironmentEnum.DEVELOP, "00000000");

        revendasPageable = new PageImpl<>(revendas);

        revendaOptional = Optional.of(revenda);

    }


    @Test
    public void quando_chamado_tem_que_devolver_3_resultado() {
        when(revendaRepository.findAll()).thenReturn(revendas);
        List<Revenda> revendas = revendaService.getAll();
        assertThat(revendas.size()).isEqualTo(3);
    }


    @Test
    public void quando_chamado_tem_que_devolver_3_resultado_e_a_ultima_pagina() {
        when(revendaRepository.findAll(any(Pageable.class))).thenReturn(revendasPageable);
        Page<Revenda> allPageable = revendaService.getAll(PageRequest.of(1, 3));
        assertThat(allPageable.getTotalElements()).isEqualTo(3);
        assertThat(allPageable.isLast()).isEqualTo(true);
    }


    @Test
    public void quando_salvar_tem_que_devolver_o_objeto() {
        when(revendaRepository.save(any(Revenda.class))).thenReturn(revenda);
        Revenda objSave = revendaService.save(revenda);
        assertThat(objSave).isEqualTo(revenda);
    }


    @Test
    public void quando_buscar_por_id_deve_retornar_a_revenda() {
        when(revendaRepository.findById(any(String.class))).thenReturn(revendaOptional);
        Revenda objGet = revendaService.get(revenda.getId());
        assertThat(objGet).isEqualTo(revenda);
        assertThat(objGet.getId()).isEqualTo(revenda.getId());
    }

    @Test
    public void quando_fiz_o_update_retornar_a_revenda_atualizada() {
        Revenda revendaUpdate = revenda;
        revendaUpdate.setName("update");
        when(revendaRepository.save(any(Revenda.class))).thenReturn(revendaUpdate);
        when(revendaRepository.existsById(any(String.class))).thenReturn(true);
        Revenda objUpdate = revendaService.update(revendaUpdate);
        assertThat(objUpdate.getId()).isEqualTo(revenda.getId());
        assertThat(objUpdate.getName()).isEqualTo("update");
    }

    @Test
    public void quando_verificar_se_existe_tem_que_devolver_true(){
        when(revendaRepository.existsById(any(String.class))).thenReturn(true);
        Boolean exist = revendaService.exist(revenda.getId());
        assertThat(exist).isTrue();
    }

}
