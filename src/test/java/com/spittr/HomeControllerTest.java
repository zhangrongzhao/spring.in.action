package com.spittr;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import com.spittr.web.HomeController;
import com.spittr.web.SpittleController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void testHomePage0()throws Exception{
        //POJO 视角测试
        HomeController controller = new HomeController();
        assertEquals("home",controller.home());
    }

    @Test
    public void testHomePage1()throws Exception{
        //Spring MVC 视角测试。
        HomeController controller=new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void testHomePage2()throws Exception{
        HomeController controller=new HomeController();
        MockMvc mockMvc=standaloneSetup(controller).build();
        mockMvc.perform(get("/index")).andExpect(view().name("home"));
    }

    @Test
    public void testHomePage3()throws Exception{
        HomeController controller=new HomeController();
        MockMvc mockMvc=standaloneSetup(controller).build();
        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles()throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE,20)).thenReturn(expectedSpittles);

        SpittleController controller=new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB_INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles/index"))
               .andExpect(view().name("spittles"))
               .andExpect(model().attributeExists("spittleList"))
               .andExpect(model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldShowPagedSpittles()throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900,50)).thenReturn(expectedSpittles);

        SpittleController controller=new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB_INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldShowSpecifiedSpittle()throws Exception{
        Spittle spittle = new Spittle("1",new Date());
        SpittleRepository mockRepository=mock(SpittleRepository.class);
        when(mockRepository.findOne(1)).thenReturn(spittle);

        SpittleController controller=new SpittleController(mockRepository);
        MockMvc mockMvc=standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB_INF/views/spittle.jsp")).build();

        mockMvc.perform(get("/spittles/show?spittle_id=1"))
               .andExpect(view().name("spittle"))
               .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle",spittle));
    }

    @Test
    public void testSpittleResource()throws Exception{
        Spittle spittle = new Spittle("Hello",new Date());
        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findOne(12345)).thenReturn(spittle);

        SpittleController controller=new SpittleController(spittleRepository);
        MockMvc mockMvc=standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB_INF/views/spittle.jsp")).build();

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle",spittle));
    }


    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles=new ArrayList<Spittle>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle("Spittle"+i,new Date()));
        }
        return spittles;
    }
}
