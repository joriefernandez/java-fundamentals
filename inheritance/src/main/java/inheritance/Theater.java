package inheritance;

import java.util.*;

public class Theater{
    //theater name
    private String name;
    //list of movies
    private Set<String> movies;
    //list of reviews
    private Map<String, List<MovieReview>> reviews;


    //Constructor
    public Theater(String name){
        this.name = validateName(name);
        this.movies = new HashSet<>();
        this.reviews = new HashMap<>();
    }

    // Method to add movie
    public void addMovie(String movie){
        movies.add(validateName(movie));

    }

    //Method to remove movie
    public void removeMovie(String movie){
        movies.remove(validateName(movie));
    }

    //Add review with the movie

    public void addReview(MovieReview theReview) {

        String curMovie = theReview.getMovie();
        List<MovieReview> res = new LinkedList<>();

        if(reviews.containsKey(curMovie)){
            res = reviews.get(curMovie);

        }

        res.add(theReview);
        reviews.put(curMovie, res);

    }

    //toString method to print values
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("{Theater: ");
        result.append("name = " + name);
        result.append(", movies = " + movies);
        result.append(", reviews = " + reviews + "}");

        return result.toString();
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public Set<String> getMovies() {
        return movies;
    }

    public Map<String, List<MovieReview>> getReviews() {
        return reviews;
    }

    //validate restaurant name
    private String validateName(String name){
        if(name == null || name.length() <= 0){
            throw new IllegalArgumentException("Restaurant name cannot be null.");
        }

        return name;
    }


}
