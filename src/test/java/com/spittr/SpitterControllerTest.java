package com.spittr;

import com.spittr.data.SpitterRepository;
import com.spittr.model.Spitter;
import com.spittr.web.SpitterController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {
    @Test
    public void shouldShowRegistration()throws Exception{
        SpitterRepository spitterRepository=mock(SpitterRepository.class);
        SpitterController controller=new SpitterController(spitterRepository);
        MockMvc mockMvc=standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration()throws Exception{
        SpitterRepository mockRepository=mock(SpitterRepository.class);
        Spitter unsaved=new Spitter("jbauer","24hours","Jack","Bauer");
        Spitter saved=new Spitter(24L,"jbauer","24hours","Jack","Bauer");

        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController controller=new SpitterController(mockRepository);
        MockMvc mockMvc=standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName","Jack")
                .param("lastName","24hours")
                .param("userName","jbauer")
                .param("password","Bauer")
        ).andExpect(redirectedUrl("/spitter/jbauer"));
    }
}
