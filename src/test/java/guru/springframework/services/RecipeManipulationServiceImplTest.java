package guru.springframework.services;

import guru.springframework.domain.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;


public class RecipeManipulationServiceImplTest {

    RecipeManipulationServiceImpl recipeManipulationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.recipeManipulationService = new RecipeManipulationServiceImpl();
    }

    @Test
    public void changeDescriptionTo() {
        ArgumentCaptor<Recipe> recipeArgumentCaptor = ArgumentCaptor.forClass(Recipe.class);
        Recipe recipe = new Recipe();
        recipe.setDescription("abc");
        this.recipeManipulationService.changeDescriptionTo(recipe, "someDescription");
        Assert.assertThat(recipe.getDescription(), is("someDescriptionsomeDescription"));
    }

    @Test
    public void testArgumentCapture() {
        Recipe recipe =  mock(Recipe.class);
        ArgumentCaptor<String> recipeDescriptionCaptor = ArgumentCaptor.forClass(String.class);
        this.recipeManipulationService.changeDescriptionTo(recipe,"a");
        verify(recipe, times(2)).setDescription(recipeDescriptionCaptor.capture());

        List expected = Arrays.asList("a","aa");
        Assert.assertEquals(expected, recipeDescriptionCaptor.getAllValues());
    }
}