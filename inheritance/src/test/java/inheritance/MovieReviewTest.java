package inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieReviewTest {

    @Test
    public void testMovieReview(){
        MovieReview test = new MovieReview("myName", "my current description", 5,
                "classic movie");
        assertEquals("Author should be the same", "myName", test.getAuthor());
        assertEquals("Description should be the same", "my current description", test.getDescription());
        assertEquals("Rating should be the same", 5,  test.getReviewRating());
        assertEquals("Movie should be the same", "classic movie",  test.getMovie());
    }


    //Test toString
    @Test
    public void tesToString(){
        MovieReview test = new MovieReview("myName", "my current description", 5,
                "classic movie");
        String result = "{Review: description= my current description, author= myName, movie=classic movie, rating= 5}";
        assertEquals("Result should be the same", result, test.toString());

    }

}