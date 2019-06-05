# Java Fundamentals
## 401 Java Lab Exercises
Contains programming exercises using Java.

### [Lab 1: Java Primitives and Control Flow](https://github.com/joriefernandez/java-fundamentals/tree/master/basics)
Main.java contains the following methods:
1. pluralize
2. flipNHeads
3. clock

### [Lab 2: Arrays,for loops, imports, ArrayList](https://github.com/joriefernandez/java-fundamentals/tree/master/basiclibrary)
Src folder contains [Library class](https://github.com/joriefernandez/java-fundamentals/blob/master/basiclibrary/src/main/java/basiclibrary/Library.java) and [LibraryTest class](https://github.com/joriefernandez/java-fundamentals/blob/master/basiclibrary/src/test/java/basiclibrary/LibraryTest.java) for methods:
1. Roll Dice - roll
2. Contains Duplicates - containsDuplicates
3. Calculating Averages - calculateAverage
4. Array of arrays - calculateArraysAverage

### [Lab 3: Maps](https://github.com/joriefernandez/java-fundamentals/tree/master/basiclibrary) , [ File I/O](https://github.com/joriefernandez/java-fundamentals/tree/master/linter)
basiclibrary src folder contains [Library class](https://github.com/joriefernandez/java-fundamentals/blob/master/basiclibrary/src/main/java/basiclibrary/Library.java) and [LibraryTest class](https://github.com/joriefernandez/java-fundamentals/blob/master/basiclibrary/src/test/java/basiclibrary/LibraryTest.java) for methods:
1. analyzeWeather
2. tally

linter src folder contains [Linter class](https://github.com/joriefernandez/java-fundamentals/blob/master/linter/src/main/java/linter/Linter.java) and [LinterTest class](https://github.com/joriefernandez/java-fundamentals/blob/master/linter/src/test/java/linter/LinterTest.java) with created test files under resources directory for method:
1. linterJS

### [Lab 4-5: Inheritance](https://github.com/joriefernandez/java-fundamentals/tree/master/inheritance)

To run the [Restaurant test](https://github.com/joriefernandez/java-fundamentals/blob/master/inheritance/src/test/java/inheritance/RestaurantTest.java) and [Review test](https://github.com/joriefernandez/java-fundamentals/blob/master/inheritance/src/test/java/inheritance/ReviewTest.java), clone the repo and go the directory then run: `./gradlew test`
#### [Restaurant](https://github.com/joriefernandez/java-fundamentals/blob/master/inheritance/src/main/java/inheritance/Restaurant.java) and [Review](https://github.com/joriefernandez/java-fundamentals/blob/master/inheritance/src/main/java/inheritance/Review.java) classes are found under src folder.
#### Restaurant Methods
* Initialization: `Restaurant [variable] = new Restaurant(["name"], [number category])`
1. getters - to get the fields
2. toString - to print the restaurant properties
3. addReview - to add review. Adding updates the star rating of the restaurant
#### Review Methods
* Initialization: `Review [variable] = new Review(["author"], ["description"], [number rating])`
1. toString - to print the review
2. getters -  to get each fields
#### Shop Methods
* Initialization: `Shop [variable] = new Shop(["name"], ["description"], [number rating])`
1. toString - to print the review
2. getters -  to get each fields
3. addReview - to add review
#### Theater Methods
* Initialization: `Theater [variable] = new Theater(["name"])`
1. toString - to print the review
2. getters -  to get each fields
3. addReview - to add review
4. addMovie - add movie to the theater
5. removeMovie - remove movie from the theater
#### MovieReview Methods
* Initialization: `MovieReview [variable] = new MovieReview(["author"], ["description"], [number rating], [movie])`
1. toString - to print the review
2. getters -  to get each fields
#### Reviewable Interface
* Implemented by other classes
1. addReview






