import java.util.Scanner;
public class Prize {
    public Scanner sc =  new Scanner(System.in);
    private static Terminal terminal = new Terminal();
    private int price[] = {10, 50, 100};
    private String prizes[] = {"Candy / Chocolate treats", "Chips / Biscuits", "Drinks "};
    public void displayPrizes(){
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("+                   Select Prize to Redeem                        +");
        System.out.println("+ 1. " +prizes[0]+ "   ======      "+price[0]+" tickets            +");
        System.out.println("+ 2. " +prizes[1]+ "           ======      "+price[1]+" tickets            +");
        System.out.println("+ 3. " +prizes[2]+ "                    ======      "+price[2]+" tickets           +");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.print("\nEnter Prize number: ");
        int chosenPrize = sc.nextInt();
        navigatePrize(chosenPrize);
    }
    public void navigatePrize(int chosenPrize){
        switch(chosenPrize){
            case 1 -> {firstPrize();}
            case 2 -> {secondPrize();}
            case 3 -> {thirdPrize();}            
        }
    }
    public void firstPrize(){
        System.out.println("Select Card: Enter 1 for Card 1 || Enter 2 for Card 2");
        int chosenCard = sc.nextInt();
        switch(chosenCard){
            case 1 ->{
                if(Terminal.card1.getTicketBalance() > 0){
                    Terminal.card1.reduceTicket(price[0]);
                    System.out.println("You've redeemed your "+ prizes[0] +"!");
                    Terminal.card1.displayCardDetails();
                    terminal.chooseAction();
                } else{System.out.println("\nNot Enough Tickets");terminal.chooseAction();}
            }
            case 2 ->{
                if(Terminal.card2.getTicketBalance() > 0){
                    Terminal.card2.reduceTicket(price[0]);
                    System.out.println("You've redeemed your "+ prizes[0] +"!");
                    Terminal.card2.displayCardDetails();
                    terminal.chooseAction();
                } else{System.out.println("\nNot Enough Tickets");terminal.chooseAction();}
            }
            default -> {System.out.println("\nPlease Enter right number"); terminal.chooseAction();}                
        }
    }
    public void secondPrize(){
        System.out.println("Select Card: Enter 1 for Card 1 || Enter 2 for Card 2");
        int chosenCard = sc.nextInt();
        switch(chosenCard){
            case 1 ->{
                if(Terminal.card1.getTicketBalance() > 0){
                    Terminal.card1.reduceTicket(price[1]);
                    System.out.println("You've redeemed your "+ prizes[1] +"!");
                    Terminal.card1.displayCardDetails();
                    terminal.chooseAction();
                } else{System.out.println("\nNot Enough Tickets");terminal.chooseAction();}
            }
            case 2 ->{
                if(Terminal.card2.getTicketBalance() > 0){
                    Terminal.card2.reduceTicket(price[1]);
                    System.out.println("You've redeemed your "+ prizes[1] +"!");
                    Terminal.card2.displayCardDetails();
                    terminal.chooseAction();
                } else{System.out.println("\nNot Enough Tickets");terminal.chooseAction();}
            }
            default -> {System.out.println("\nPlease Enter right number"); terminal.chooseAction();}                
        }
    }
    public void thirdPrize(){
        System.out.println("Select Card: Enter 1 for Card 1 || Enter 2 for Card 2");
        int chosenCard = sc.nextInt();
        switch(chosenCard){
            case 1 ->{
                if(Terminal.card1.getTicketBalance() > 0){
                    Terminal.card1.reduceTicket(price[2]);
                    System.out.println("You've redeemed your "+ prizes[2] +"!");
                    Terminal.card1.displayCardDetails();
                    terminal.chooseAction();
                } else{System.out.println("\nNot Enough Tickets");terminal.chooseAction();}
            }
            case 2 ->{
                if(Terminal.card2.getTicketBalance() > 0){
                    Terminal.card2.reduceTicket(price[2]);
                    System.out.println("You've redeemed your "+ prizes[2] +"!");
                    Terminal.card2.displayCardDetails();
                    terminal.chooseAction();
                } else{System.out.println("\nNot Enough Tickets");terminal.chooseAction();}
            }
            default -> {System.out.println("\nPlease Enter right number"); terminal.chooseAction();}                
        }
    }

}
