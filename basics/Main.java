import java.util.Random;
import java.util.Calendar;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing pluralize...");
        String curWord = "sample";
        int num = 2;
        System.out.println(pluralize(curWord, num));
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        //Test flipNHeads
        System.out.println("Testing flipNHead function...");
        System.out.println("Flip 4 heads");
        flipNHeads(4);
        System.out.println("Flip 2 heads");
        flipNHeads(2);
        System.out.println("Flip 1 head");
        flipNHeads(1);
        System.out.println("Flip 0 head");
        flipNHeads(0);

        System.out.println("Testing clock...");
        clock();
    }


    /**
     * Function to make the word plural.
     * @param word - the word to be pluralized
     * @param number - the quantity
     * @return pluralized word (with ending character 's') if the number is zero or greater than 1.
     */
   public static String  pluralize(String word, int number){
        //Check if the number is zero or greater than one. If so, add 's'
       //If not, return the original word.
       if ((word.charAt(word.length() -1) == 's') || (number == 1)) {
           return word;
       } else{
           return word + 's';
       }
   }

    /**
     * Method to flip heads N consecutively.
     * @param headFlip number of consecutive head flips.
     */
   public static void flipNHeads(int headFlip){
       //total number of flip and current head count.
       int totalFlip = 0, headCount = 0;
       // flag to indicate that we had flipped head.
       boolean head =  false;

       //Loop while we haven't reached the target consecutive head flip
       while(headCount < headFlip){
           //Generate random number between 0 and 1
           // 0 : tails and 1: heads
           if(generateRandom() == 0){
               head = false;
               System.out.println("tails");
           } else{
               if(head){
                   headCount += 1;
               } else{
                   headCount = 1;
               }
               head = true;
               System.out.println("heads");
           }

           //Increase the number of flips
           totalFlip += 1;
       }

        //Print the number of heads and flips
       System.out.println("It took " + totalFlip + " " + pluralize("flip", totalFlip) + " to flip "
               + headFlip + " " + pluralize("head", headCount) + " in a row." );


   }

    /**
     * Function to print time for every second change.
     */
   public static void clock(){
       // previous time
       LocalDateTime prev = LocalDateTime.now();

       //Loop until the user terminates
       while(true){
           //Current time
           LocalDateTime now = LocalDateTime.now();

           //Check if current second is not the same as the previous
           if(now.getSecond() != prev.getSecond()){
               //assign previous with the current time
               prev = now;
               //print the time
               System.out.println(now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
           }
       }
   }

   // Helper function to generate random number between 0 and 1
   private static int generateRandom(){
       return new Random().nextInt(2);
   }

}
