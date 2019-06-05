package inheritance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ShopTest {
    //Test constructor given valid inputs
    @Test
    public void testShopValid(){
        List<Review> reviews = new LinkedList<>();
        Shop test = new Shop("myShop", "this is the description",  2);
        assertEquals("Shop name should be the same.", "myShop", test.getName());
        assertEquals("Shop description should be the same.", "this is the description",
                test.getDescription());
        assertEquals("Shop price category should be the same.", 2, test.getPriceCategory());
        assertEquals("Shop review should be the same.", reviews, test.getReviews());
    }

    //Test constructor given valid inputs with a review
    @Test
    public void testShopValidOneReview(){
        List<Review> reviews = new LinkedList<>();
        Review rev = new Review("myName", "this is a sample description", 0);
        reviews.add(rev);
        Shop test = new Shop("myShop", "this is the description",  2);
        test.addReview(rev);
        assertEquals("Shop name should be the same.", "myShop", test.getName());
        assertEquals("Shop description should be the same.", "this is the description",
                test.getDescription());
        assertEquals("Shop price category should be the same.", 2, test.getPriceCategory());
        assertEquals("Shop review should be the same.", reviews, test.getReviews());
    }

    //Test constructor given invalid name
    @Test (expected = IllegalArgumentException.class)
    public void testShopInvalidName(){
        Shop test = new Shop("", "this is the description",  2);

    }

    //Test constructor given invalid description
    @Test (expected = IllegalArgumentException.class)
    public void testShopInvalidDesc(){
        Shop test = new Shop("myName", "",  2);

    }

    //Test constructor given invalid price category
    @Test (expected = IllegalArgumentException.class)
    public void testShopInvalidPrice(){
        Shop test = new Shop("myName", "description",  -2);

    }


    // TEST ADDREVIEW METHOD
    //Test add review
    @Test
    public void testAddReviewOne(){
        List<Review> reviews = new LinkedList<>();
        Review rev = new Review("myName", "this is a sample description", 3);
        reviews.add(rev);
        Shop test = new Shop("myShop", "this is the description",  2);
        test.addReview(rev);

        assertEquals("Shop reviews should be the same.", reviews, test.getReviews());
    }

    //Test add review
    @Test
    public void testAddReviews(){
        List<Review> reviews = new LinkedList<>();
        Review rev1 = new Review("myName", "this is a sample description", 3);
        Review rev2 = new Review("Jim", "this is another review", 1);
        reviews.add(rev1);
        reviews.add(rev2);

        Shop test = new Shop("myShop", "this is the description",  2);
        test.addReview(rev1);
        test.addReview(rev2);

        assertEquals("Shop reviews should be the same.", reviews, test.getReviews());
    }

    //Test add null review
    @Test
    public void testAddNullReview(){
        List<Review> reviews = new LinkedList<>();

        Shop test = new Shop("myShop", "this is the description",  2);
        test.addReview(null);

        assertEquals("Shop reviews should be the same.", reviews, test.getReviews());
    }

    //TEST TOSTRING METHOD
    @Test
    public void testToStringEmptyReview(){
        String expected = "{Shop: name = myShop, description = this description, priceCategory = 2, reviews = []}";
        assertEquals("Shop values should be the same.", expected, new Shop("myShop",
                "this description", 2).toString());
    }

    //Test with one review
    @Test
    public void testToStringOneReview(){
        List<Review> reviews = new LinkedList<>();
        Review rev = new Review("myName", "this is a sample description", 0);
        reviews.add(rev);
        Shop test = new Shop("myShop", "this is the description",  2);
        test.addReview(rev);

        String expected = "{Shop: name = myShop, description = this is the description, priceCategory = 2, " +
                "reviews = [{Review: description= this is a sample description, author= myName, rating= 0}]}";
        assertEquals("Shop values should be the same.", expected, test.toString());
    }

}
