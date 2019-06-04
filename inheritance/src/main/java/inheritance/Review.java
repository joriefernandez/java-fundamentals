package inheritance;

public class Review {

    private String description;
    private String author;
    private int rating;

    //Constructor
    public  Review(String author, String description, int rating){
        this.description = description;
        this.author = author;
        this.rating = validateRating(rating);
    }

    //GETTERS
    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getReviewRating(){
        return rating;
    }


    public String toString(){
        StringBuilder result = new StringBuilder("{Review: ");
        result.append("description= " + description);
        result.append(", author= " + author);
        result.append(", rating= " + rating + "}");

        return result.toString();
    }


    //validate star Rating. Must be 0 to 5
    private int validateRating(int rate){
        if(rate >= 0 && rate <= 5){
            return rate;
        } else{
            throw new IllegalArgumentException("Rating should be between 0 to 5.");
        }
    }
}
