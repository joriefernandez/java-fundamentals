package inheritance;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TheaterTest {

    //Test constructor

    @Test
    public void testTheater(){
        Theater test = new Theater("Sample Theater");
        assertEquals("Theater name should be the same", "Sample Theater", test.getName());
        assertEquals("Theater  movies should be the same", new HashSet<>(), test.getMovies());
        assertEquals("Theater  reviews should be the same", new HashMap<>(), test.getReviews());
    }

    //Test invalid name
    @Test (expected=IllegalArgumentException.class)
    public void testTheaterInvalid(){
        Theater test = new Theater("");
    }

    //Test addMovie

    @Test
    public void testAddMovie(){
        String curMovie = "John Wick";
        //expected results
        Set<String> expected = new HashSet<>();
        expected.add(curMovie);
        //Theater
        Theater test = new Theater("Sample Theater");
        test.addMovie(curMovie);
        assertEquals("Movie should be added.", expected, test.getMovies());

        //Add more values to theater
        String[] testValues = new String[]{"The Fave Movie", "Scary Movie", "Funny Movie", "John Wick"};
        for(String val: testValues){
            test.addMovie(val);
            expected.add(val);
        }

        assertEquals("Movie should be added.", expected, test.getMovies());

    }

    //Test invalid movie
    @Test (expected=IllegalArgumentException.class)
    public void testAddMovieInvalid(){
        Theater test = new Theater("Sample");
        test.addMovie(null);
    }

    //Test removeMovie
    @Test
    public void testRemoveMovie(){

        //expected results
        Set<String> expected = new HashSet<>();
        //Theater
        Theater test = new Theater("Sample Theater");

        //Add more values to theater
        String[] testValues = new String[]{"The Fave Movie", "Scary Movie", "Funny Movie", "John Wick"};
        for(String val: testValues){
            test.addMovie(val);
            expected.add(val);
        }

        String cur = "The Fave Movie";
        expected.remove(cur);
        test.removeMovie(cur);

        assertEquals("Should remove the movie.", expected, test.getMovies() );
    }

    //Test remove null
    @Test (expected=IllegalArgumentException.class)
    public void testRemoveMovieInvalid(){
        Theater test = new Theater("Sample");
        test.removeMovie(null);
    }


    //Test removeMovie with not in the list
    @Test
    public void testRemoveMovieNotInList(){

        //expected results
        Set<String> expected = new HashSet<>();
        //Theater
        Theater test = new Theater("Sample Theater");

        //Add more values to theater
        String[] testValues = new String[]{"The Fave Movie", "Scary Movie", "Funny Movie", "John Wick"};
        for(String val: testValues){
            test.addMovie(val);
            expected.add(val);
        }

        test.removeMovie("Random Movie");
        assertEquals("Should remove the movie.", expected, test.getMovies() );
    }

    //Test addReview
    @Test
    public void testAddReviewValid(){
        
    }



}