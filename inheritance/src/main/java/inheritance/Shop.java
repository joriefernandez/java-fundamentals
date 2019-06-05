package inheritance;

import java.util.LinkedList;
import java.util.List;

public class Shop implements Reviewable {
    //shop name
    private String name;
    //description
    private String description;
    //price category
    private int priceCategory;
    //list of reviews
    private List<Review> reviews;


    //Constructor
    public Shop(String name, String description, int priceCategory){
        this.name = validateInput(name);
        this.description = validateInput(description);
        this.priceCategory = validatePriceCategory(priceCategory);
        this.reviews = new LinkedList<>();
    }
    //toString method to print values
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("{Shop: ");
        result.append("name = " + name);
        result.append(", description = " + description);
        result.append(", priceCategory = " + priceCategory);
        result.append(", reviews = " + reviews + "}");

        return result.toString();
    }

    // Add review about the shop
    @Override
    public void addReview(Review theReview) {
        if(theReview != null){
            reviews.add(theReview);
        }
    }

    //Getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriceCategory() {
        return priceCategory;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    //validate string input
    private String validateInput(String name){
        if(name == null || name.length() <= 0){
            throw new IllegalArgumentException("Value cannot be null.");
        }

        return name;
    }

    //validate price category. Must be 1 to 4
    private int validatePriceCategory(int category){
        if(category >= 1 && category <= 4){
            return category;
        } else{
            throw new IllegalArgumentException("Rating should be between 1 to 4.");
        }
    }
}
