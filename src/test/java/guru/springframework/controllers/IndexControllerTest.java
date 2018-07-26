package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

import static org.junit.Assert.*;

@WebMvcTest(IndexController.class)
@RunWith(SpringRunner.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    public void getIndexPage() {
        Assert.assertNotNull(mockMvc);

    }
}