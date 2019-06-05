package inheritance;

import org.junit.Test;

import java.util.*;

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
    public void testAddReviewValidSameMovie(){
        MovieReview theReview = new MovieReview("myName", "my current description", 5,
                "classic movie");
        Theater test = new Theater("CenturyMovie");
        test.addReview(theReview);
        //expected result
        Map<String, List<MovieReview>> expected = new HashMap<>();
        List<MovieReview> list = new LinkedList<>();
        list.add(theReview);
        expected.put("classic movie", list);

        assertEquals("Reviews should be the same", expected, test.getReviews());

        //add another review
        MovieReview another = new MovieReview("myName", "my another description", 1,
                "classic movie");
        //add to expected
        list.add(another);

        expected.put("classic movie", list);

        //add to theater
        test.addReview(another);

        assertEquals("Reviews should be the same", expected, test.getReviews());

    }

    //Test addReview with another movie review
    @Test
    public void testAddReviewValidAnotherMovie(){
        MovieReview theReview = new MovieReview("myName", "my current description", 5,
                "classic movie");
        Theater test = new Theater("CenturyMovie");
        test.addReview(theReview);
        //expected result
        Map<String, List<MovieReview>> expected = new HashMap<>();
        List<MovieReview> list = new LinkedList<>();
        list.add(theReview);
        expected.put("classic movie", list);

        assertEquals("Reviews should be the same", expected, test.getReviews());

        //add another review
        MovieReview another = new MovieReview("myOtherName", "my another description", 1,
                "super bad movie");
        List<MovieReview> anotherReview = new LinkedList<>();
        anotherReview.add(another);
        expected.put("super bad movie", anotherReview);

        //add to theater
        test.addReview(another);

        assertEquals("Reviews should be the same", expected, test.getReviews());

    }

    //Test addReview with empty movie
    @Test
    public void testAddReviewValidEmptyMovie(){
        MovieReview theReview = new MovieReview("myName", "my current description", 5,
                null);
        Theater test = new Theater("CenturyMovie");
        test.addReview(theReview);
        //expected result
        Map<String, List<MovieReview>> expected = new HashMap<>();
        List<MovieReview> list = new LinkedList<>();
        list.add(theReview);
        expected.put(null, list);

        assertEquals("Reviews should be the same", expected, test.getReviews());

    }

    //Test with one review
    @Test
    public void testToStringOneReview(){
        MovieReview theReview = new MovieReview("myName", "my current description", 5,
                "classic movie");
        Theater test = new Theater("CenturyMovie");
        test.addReview(theReview);
        //expected result

        String expected = "{Theater: name = CenturyMovie, movies = [], " +
        "reviews = {classic movie=[{Review: description= my current description, " +
                "author= myName, movie=classic movie, rating= 5}]}}";
        assertEquals("Shop values should be the same.", expected, test.toString());
    }

    //Test with one review
    @Test
    public void testToString(){

        Theater test = new Theater("CenturyMovie");

        //expected result

        String expected = "{Theater: name = CenturyMovie, movies = [], reviews = {}}";
        assertEquals("Shop values should be the same.", expected, test.toString());
    }




}