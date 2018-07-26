package guru.springframework.services;

import guru.springframework.domain.Recipe;

public interface RecipeManipulationService {
    void changeDescriptionTo(Recipe recipe, String description);
}
