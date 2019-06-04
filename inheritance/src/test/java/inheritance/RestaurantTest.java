package inheritance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantTest {
    @Test
    public void testRestaurantValid(){
        List<Review> reviews = new ArrayList<>();
        Restaurant test = new Restaurant("myRestaurant", 2);
        assertEquals("Restaurant name should be the same.", "myRestaurant", test.getName());
        assertEquals("Restaurant star rating should be the same.", 0, test.getStarRating());
        assertEquals("Restaurant price category should be the same.", 2, test.getPriceCategory());
        assertEquals("Restaurant review should be the same.", reviews, test.getReviews());
    }

    //Test minimum boundaries of price category and rating
    @Test
    public void testRestaurantValidMinBoundaries(){
        List<Review> reviews = new ArrayList<>();
        Review rev = new Review("myName", "this is a sample description", 0);

        Restaurant test = new Restaurant("myRestaurant", 1);
        test.addReview(rev);
        assertEquals("Restaurant price category should be the same.", 1, test.getPriceCategory());
        assertEquals("Restaurant star rating should be the same.", 0, test.getStarRating());
    }

    //Test maximum boundaries of price category and rating
    @Test
    public void testRestaurantValidMaxBoundaries(){
        List<Review> reviews = new ArrayList<>();
        Review rev = new Review("myName", "this is a sample description", 5);

        Restaurant test = new Restaurant("myRestaurant", 4);
        test.addReview(rev);
        assertEquals("Restaurant price category should be the same.", 4, test.getPriceCategory());
        assertEquals("Restaurant star rating should be the same.", 5, test.getStarRating());

    }


    //Test invalid name
    @Test (expected=IllegalArgumentException.class)
    public void testRestaurantInvalidNullName(){
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("myName", "this is a sample description", 3));
        Restaurant test = new Restaurant(null, 4);
    }

    //Test invalid rating greater than the range
    @Test (expected=IllegalArgumentException.class)
    public void testRestaurantInvalidRatingNameGreater(){
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("myName", "this is a sample description", 3));
        Restaurant test = new Restaurant("myRestaurant", 8);
    }

    //Test invalid rating less than the range
    @Test (expected=IllegalArgumentException.class)
    public void testRestaurantInvalidRatingNameLess(){
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("myName", "this is a sample description", 3));
        Restaurant test = new Restaurant("myRestaurant", -2);
    }

    //Test invalid price category greater than 4
    @Test (expected=IllegalArgumentException.class)
    public void testRestaurantInvalidPrice(){
        Restaurant test = new Restaurant("myRestaurant", 5);
    }

    //Test invalid price category less than 1
    @Test (expected=IllegalArgumentException.class)
    public void testRestaurantInvalidPriceLess(){

        Restaurant test = new Restaurant("myRestaurant", 0);
    }

    //Test add review
    @Test
    public void testAddReviewOne(){
        List<Review> reviews = new ArrayList<>();
        Review rev = new Review("myName", "this is a sample description", 3);
        reviews.add(rev);
        Restaurant test = new Restaurant("myRestaurant", 4);
        test.addReview(rev);

        assertEquals("Restaurant rating should be the same.", 3, test.getStarRating());
        assertEquals("Restaurant name should be the same.", reviews, test.getReviews());
    }

    //Test add review
    @Test
    public void testAddReviewValues(){
        List<Review> reviews = new ArrayList<>();
        Review rev1 = new Review("myName", "this is a sample description", 3);
        Review rev2 = new Review("Jim", "this is another review", 1);
        reviews.add(rev1);
        reviews.add(rev2);

        Restaurant test = new Restaurant("myRestaurant", 4);
        test.addReview(rev1);
        test.addReview(rev2);

        assertEquals("Restaurant rating should be the same.", 2, test.getStarRating());
        assertEquals("Restaurant name should be the same.", reviews, test.getReviews());
    }


    //Test add empty review
    @Test
    public void testAddReviewEmpty(){
        List<Review> reviews = new ArrayList<>();

        Restaurant test = new Restaurant("myRestaurant", 4);
        test.addReview(null);

        assertEquals("Restaurant rating should be the same.", 0, test.getStarRating());
        assertEquals("Restaurant name should be the same.", reviews, test.getReviews());
    }

    //Test toString
    @Test
    public void testToString(){
        List<Review> reviews = new ArrayList<>();
        Review rev = new Review("myName", "this is a sample description", 3);
        reviews.add(rev);
        Restaurant test = new Restaurant("myRestaurant", 4);
        test.addReview(rev);
        String expected = "Restaurant{name='myRestaurant', starNumber=3, priceCategory=4," +
                " reviews=[{Review: description= this is a sample description, author= myName, rating= 3}]}";
        assertEquals("Restaurant name should be the same.", expected, test.toString());

    }

    //Test toString with 2 reviews
    @Test
    public void testToStringTwoReviews(){
        List<Review> reviews = new ArrayList<>();
        Review rev1 = new Review("myName", "this is a sample description", 3);
        Review rev2 = new Review("Jim", "this is another review", 1);

        Restaurant test = new Restaurant("myRestaurant", 4);
        test.addReview(rev1);
        test.addReview(rev2);

        String expected = "Restaurant{name='myRestaurant', starNumber=2, priceCategory=4," +
                " reviews=[{Review: description= this is a sample description, author= myName, rating= 3}," +
                " {Review: description= this is another review, author= Jim, rating= 1}]}";
        assertEquals("Restaurant name should be the same.", expected, test.toString());

    }
}