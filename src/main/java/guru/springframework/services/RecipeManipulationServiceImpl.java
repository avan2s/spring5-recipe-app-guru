package guru.springframework.services;

import guru.springframework.domain.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeManipulationServiceImpl implements RecipeManipulationService {

    @Override
    public void changeDescriptionTo(Recipe recipe, String description) {
        recipe.setDescription(description);
        recipe.setDescription(description + description);
    }
}
