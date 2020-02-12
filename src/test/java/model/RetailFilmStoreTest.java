package model;


import org.junit.Before;
import org.junit.Test;

import java.util.List;


import static org.hamcrest.CoreMatchers.is;


import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;


 public class RetailFilmStoreTest {


    private final Film kingKong = new Film("King Kong", "Jackson", 2000);
    private final Film starshipTroopers = new Film("Starship Troopers", "Verhoeven", 2004);
    private final Film starGate = new Film("Star Gate", "Verhoeven", 1994);
    private final Film bladeRunner = new Film("Blade Runner", "Doe", 2002);
    private final Film fifthElement = new Film("Fifth Element", "Verhoeven", 1997);
    private final RetailFilmStore retailFilmStore = new RetailFilmStore();


    @Before
    public void setUp() throws Exception {
    	retailFilmStore.add(kingKong);
    	retailFilmStore.add(starshipTroopers);
    	retailFilmStore.add(starGate);
    	retailFilmStore.add(bladeRunner);
    	retailFilmStore.add(fifthElement);
    }

    @Test
     public void noResultReturningsIfNoTitelesPartiallyMatchSearch() throws Exception{

        List<Film> results= retailFilmStore.findByPartialTitle("abc");
        assertThat(results.size(), is(0));
     }


    @Test
    public void filmFindingIfTitleIsPartiallyMatchedCaseInsensitive() throws Exception{

        List<Film> results= retailFilmStore.findByPartialTitle("Star");
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starGate, starshipTroopers));
    }

    @Test
    public void filmFindingIfDirectorExactlyMatches() throws Exception{

        List<Film> results= retailFilmStore.findByDirector("Verhoeven");
        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(starGate, starshipTroopers, fifthElement));
    }
    @Test
    public void filmFindingIfReleaseYearIsBetweenTwoValues() throws Exception{

        List<Film> results= retailFilmStore.findByReleaseYear(2000, 2005);
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starshipTroopers,bladeRunner));
    }
}