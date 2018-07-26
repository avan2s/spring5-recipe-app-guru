package guru.springframework;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
@JsonTest
public class Spring5RecipeAppApplicationTests {
    private JacksonTester<Recipe> json = null;

    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void testSerialize() throws IOException {
        Recipe details = new Recipe();
        // Assert against a `.json` file in the same package as the test
        assertThat(this.json.write(details)).isEqualToJson("/expected-jsons/expected.json");
        // Or use JSON path based assertions
//        assertThat(this.json.write(details)).hasJsonPathStringValue("@.make");
//        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.make").isEqualTo("Honda");
    }

}
