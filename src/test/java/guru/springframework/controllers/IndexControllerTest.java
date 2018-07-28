package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(IndexController.class)
@RunWith(SpringRunner.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    public void getIndexPage() throws Exception {
        when(recipeService.getRecipes()).thenReturn(new HashSet<>());
        List<String> requestMappings = Arrays.asList("/","","/index");

        for(final String requestMapping : requestMappings) {
            this.mockMvc.perform(get(requestMapping))
                    .andExpect(status().isOk())
                    .andExpect(view().name("index"));
        }
    }

    @Test
    public void getIndexPage2() throws Exception {
        this.getIndexPage();
    }

    @Test
    public void getIndexPage3() throws Exception {
        this.getIndexPage();
    }
}