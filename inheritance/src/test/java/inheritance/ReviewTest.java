package inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {
    //Test constructor
    @Test
    public void testReviewValid(){
        Review test = new Review("Abc", "the description", 3);
        assertEquals("Author should be the same", "Abc", test.getAuthor());
        assertEquals("Description should be the same", "the description", test.getDescription());
        assertEquals("Rating should be the same", 3,  test.getReviewRating());
    }

    // Test if rating is less than the range
    @Test (expected = IllegalArgumentException.class)
    public void testReviewInvalidNegative(){
        Review test = new Review("Abc", "the description", -1);

    }

    // Test if rating is greater than the range
    @Test (expected = IllegalArgumentException.class)
    public void testReviewInvalidGreater(){
        Review test = new Review("Abc", "the description", 6);

    }

    //Test toString
    @Test
    public void tesToString(){
        Review test = new Review("Abc", "the description", 3);
        String result = "{Review: description= the description, author= Abc, rating= 3}";
        assertEquals("Result should be the same", result, test.toString());

    }


}