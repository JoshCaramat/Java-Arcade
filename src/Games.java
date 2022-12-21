import java.util.Scanner;
import java.util.Random;
public class Games{
    public Scanner sc =  new Scanner(System.in);
    public Random rand = new Random();
    public Terminal terminal = new Terminal();
    private int ticket;

    public class Guess{     
        private int trials = 5;
        private int i, guess;
        private final int randomNumber = 1 + rand.nextInt(20);

        public void startGuess(Cards cardNum){        
            cardNum.reduceCredit(5);
            System.out.println("----------Guess Game----------");
            System.out.println("\nEnter a number from 1 - 20: ");
            for(i = 0; i < trials; i++){
                System.out.print("Enter a number: ");
                guess = sc.nextInt();

                if(guess == randomNumber){
                    System.out.println("Great You've Guessed the Number.\n");
                    cardNum.setTicketBalance(winTickets());
                    System.out.println("You've earned " + ticket+ " tickets");
                    break;
                }            
                else if(guess > randomNumber && i != trials-1){
                    System.out.println("Think a number lower than " + guess); 
                }
                else if(guess < randomNumber && i != trials-1){
                    System.out.println("Think a number higher than " + guess); 
                }
            }
            if(i == trials){
                    System.out.println("You Lose! The number was " + randomNumber);
                    System.out.println("You've consumed " + trials + " trials.");
                    cardNum.setTicketBalance(loseTickets());
                    System.out.println("You've earned " + ticket+ " tickets");
            }
        }
    }
    public class ColorGame{
        private int trials = 5;
        private String colors[] = {"Yellow", "Red", "Green", "Blue", "Black"};
        private String randomColor = randomColor();
        private int i;
        private String colorGuess;
        public void startColorGame(Cards cardNum){
            cardNum.reduceCredit( 5);
            System.out.println("----------Guess the Color Game----------");
            System.out.println("["+colors[0]+" "+colors[1]+" "+colors[2]+" "+colors[3]+" "+colors[4]+"]");
            System.out.println(randomColor);
            for(i = 0; i < trials; i++){
                System.out.print("Your guess: ");
                colorGuess = sc.nextLine();

                if (colorGuess.equalsIgnoreCase(randomColor)){
                    System.out.println("Great You've Guessed the Color.\n");
                    cardNum.setTicketBalance(winTickets());
                    System.out.println("You've earned " + ticket+ " tickets");
                    break;
                }                
            }
            if(i == trials){
                System.out.println("You Lose! The color was " + randomColor);
                System.out.println("You've consumed " + trials + " trials.");
                cardNum.setTicketBalance(loseTickets());
                System.out.println("You've earned " + ticket+ " tickets");
            }
        }
        public String randomColor(){
            Random random = new Random();
            String result = colors[random.nextInt(4)];
            return result;
        }
    }
 
    public int loseTickets(){
        ticket = rand.nextInt(4) + 1;
        return ticket;
    }
    public int winTickets(){
        ticket = rand.nextInt((10) + 1);
        if (ticket == 0) {
            ticket += 5;
        } else if (ticket == 1) {
            ticket += 3;
        } else if (ticket == 2) {
            ticket += 1;
        }
        return ticket;
    }
    
}