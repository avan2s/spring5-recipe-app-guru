package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository toTest;


    @Test(expected = IncorrectResultSizeDataAccessException.class)
    public void findByDescriptionWithMultipleResults() {
        this.toTest.findByDescription("Tablespoon").get();

        //Assert.assertTrue(tablespoon.isPresent());
        //Assert.assertEquals(tablespoon, "Tablespoon");
    }

    @Test
    public void findByDescriptionWithoutResults() {
        Optional<UnitOfMeasure> tablespoon = this.toTest.findByDescription("Tablespoon2");
        assertThat(tablespoon.isPresent(), is(false));
        Assert.assertThat(tablespoon.orElse(null), nullValue());
    }

    @Test
    @Ignore
    public void findAllByDescription() {
        List<UnitOfMeasure> tablespoons = this.toTest.findAllByDescription("Tablespoon");
        Assert.assertThat(tablespoons.size(), is(2));
        Assert.assertEquals(tablespoons.get(0).getDescription(), "Tablespoon");
        Assert.assertEquals(tablespoons.get(1).getDescription(), "Tablespoon");
    }

    @Test
    public void findAllByDescriptionNoResult() {
        List<UnitOfMeasure> tablespoons = this.toTest.findAllByDescription("Tablespoon2");
        Assert.assertThat(tablespoons.size(), is(0));
    }
}