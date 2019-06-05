package inheritance;

public class MovieReview extends Review {
    //movie to be reviewed
    private String movie;

    //Constructor
    public MovieReview(String author, String description, int rating, String movie) {
        super(author, description, rating);
        this.movie = movie;
    }

    //Method to get movie
    public String getMovie(){
        return movie;
    }

    //toString method to print values
    public String toString(){
        StringBuilder result = new StringBuilder("{Review: ");
        result.append("description= " + super.getDescription());
        result.append(", author= " + super.getAuthor());
        result.append(", movie=" + this.movie);
        result.append(", rating= " + this.getReviewRating() + "}");

        return result.toString();
    }
}
