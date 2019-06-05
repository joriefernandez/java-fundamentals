package inheritance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Restaurant implements Reviewable {
    private String name;
    private int starRating;
    private int priceCategory;
    private List<Review> reviews;

    //Constructor
    public Restaurant(String name, int priceCategory) {
        this.name = validateRestaurantName(name);
        this.priceCategory = validatePriceCategory(priceCategory);
        this.starRating = 0;
        this.reviews = new LinkedList<>();
    }



    //Add review to the restaurant
    public void addReview(Review theReview){
        if(theReview != null){
            reviews.add(theReview);
            updateStarRating();
        }
    }

    // Method to print
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", starNumber=" + starRating +
                ", priceCategory=" + priceCategory +
                ", reviews=" + reviews +
                '}';
    }

    //Getters


    public String getName() {
        return name;
    }

    public int getStarRating() {
        return starRating;
    }

    public int getPriceCategory() {
        return priceCategory;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    /*** HELPERS ***/
    //update star rating
    private void updateStarRating(){
        int sum = 0;
        for(Review current : reviews){
            sum += current.getReviewRating();
        }
        starRating =  sum/reviews.size();
    }


    //validate price category. Must be 1 to 4
    private int validatePriceCategory(int category){
        if(category >= 1 && category <= 4){
            return category;
        } else{
            throw new IllegalArgumentException("Rating should be between 1 to 4.");
        }
    }

    //validate restaurant name
    private String validateRestaurantName(String name){
        if(name == null || name.length() <= 0){
            throw new IllegalArgumentException("Restaurant name cannot be null.");
        }

        return name;
    }


}
