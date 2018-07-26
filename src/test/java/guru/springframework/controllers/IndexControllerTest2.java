package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest2 {

    private MockMvc mockMvc;

    private IndexController toTest;

    @Mock
    private RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.toTest = new IndexController(this.recipeService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.toTest).build();
    }

    @Test
    public void getIndexPage() throws Exception {

        when(recipeService.getRecipes()).thenReturn(new HashSet<>());
        List<String> requestMappings = Arrays.asList("/");

        for(final String requestMapping : requestMappings) {
            this.mockMvc.perform(get(requestMapping))
                    .andExpect(status().isOk())
                    .andExpect(view().name("index"));
        }


    }
}