import java.util.Scanner;
public class Terminal {
    public Scanner sc = new Scanner(System.in);
    static Cards card1 = new Cards();
    static Cards card2 = new Cards();
    private Prize prize = new Prize();
    private static Games game = new Games();
    private static Games.Guess guess = game.new Guess();
    private static Games.ColorGame color = game.new ColorGame();
    // private static int chosenCard, transferAmount, creditAmount;
    public void startArcade(){ 
        chooseAction();
    }
    public void chooseAction(){     
        System.out.println("\nSelect Transaction:");
        System.out.println("1. Play Guess Game");
        System.out.println("2. Play Color Game");
        System.out.println("3. Top up Credit"); 
        System.out.println("4. Transfer Credits");
        System.out.println("5. Display Details");
        System.out.println("6. Transfer Ticket");
        System.out.println("7. Redeem Prizes");
        System.out.println("8. Exit");
        
        System.out.print("\nEnter number: ");
        int choice = sc.nextInt();
        
        switch(choice){
            case 1 -> {firstGame();}
            case 2 -> {secondGame();}
            case 3 -> {topUp();}
            case 4 -> {transferCredit();}
            case 5 -> {displayDetails();}
            case 6 -> {transferTicket();}
            case 7 -> {prize.displayPrizes();}
            case 8 -> {System.exit(0);}
        }
    }
    public void firstGame(){
        System.out.println("Select Card: Enter 1 for Card 1 || Enter 2 for Card 2");
        int chosenCard = sc.nextInt();
        
        if(chosenCard == 1 && card1.getCreditBalance() > 0){            
            guess.startGuess(card1);
            card1.displayCardDetails();
            chooseAction();
        }
        else if(chosenCard == 2 && card2.getCreditBalance() > 0){             
            guess.startGuess(card2);
            card2.displayCardDetails();
            chooseAction();
        }
        else{ System.out.println("\nTop up First to Play Games"); chooseAction(); }
    }
    public void secondGame(){
        System.out.println("Select Card: Enter 1 for Card 1 || Enter 2 for Card 2");
        int chosenCard = sc.nextInt();
        
        if(chosenCard == 1 && card1.getCreditBalance() > 0){                        
            color.startColorGame(card1);
            card1.displayCardDetails();
            chooseAction();
        }
        else if(chosenCard == 2 && card2.getCreditBalance() > 0){                         
            color.startColorGame(card2);
            card2.displayCardDetails();
            chooseAction();
        }
        else{ System.out.println("\nTop up First to Play Games"); chooseAction(); }       
    }
    public void topUp(){
        System.out.println("Select Card: Enter 1 for Card 1 || Enter 2 for Card 2");
        int chosenCard = sc.nextInt();

        switch(chosenCard){
            case 1 -> {
                System.out.print("Enter amount: ");
                int creditAmount = sc.nextInt();
                card1.setCreditBalance((creditAmount * 2));
                card1.displayCardDetails();
                chooseAction();
            }
            case 2 -> {
                System.out.print("Enter amount: ");
                int creditAmount = sc.nextInt();
                card2.setCreditBalance((creditAmount * 2));
                card2.displayCardDetails();
                chooseAction();
            }
        }
    }
    public void transferCredit(){
        System.out.println("-----------------|Transfer Credits|------------------");
        System.out.println("Select Card: \nEnter 1 for Card 1 -> Card 2 \nEnter 2 for Card 2 -> Card 1");
        int chosenCard =  sc.nextInt();
        switch(chosenCard){
            case 1 ->{
                if(card1.getCreditBalance() > 0){
                    System.out.print("Enter amount: ");
                    int transferAmount = sc.nextInt();
                    card1.transferCredit(transferAmount, card2);
                    System.out.println("Current Balance: ");
                    card1.displayCardDetails();
                    chooseAction();
                } else{System.out.println("\nNot Enough Credits");chooseAction();}
            }
            case 2 ->{
                if(card1.getCreditBalance() > 0){
                    System.out.print("Enter amount: ");
                    int transferAmount = sc.nextInt();
                    card2.transferCredit(transferAmount, card1);
                    System.out.println("Current Balance: ");
                    card2.displayCardDetails();
                    chooseAction();
                } else{System.out.println("\nNot Enough Credits");chooseAction();}
            }
            default -> {System.out.println("\nPlease Enter right number"); chooseAction();}
        }
    }
    public void displayDetails(){
        System.out.println("Select Card: Enter 1 for Card 1 || Enter 2 for Card 2");
        int chosenCard = sc.nextInt();
        switch(chosenCard){
            case 1 ->{card1.displayCardDetails(); chooseAction();}
            case 2 ->{card2.displayCardDetails(); chooseAction();}
        }
    }
    public void transferTicket(){
        System.out.println("-----------------|Transfer Tickets|------------------");
        System.out.println("Select Card: \nEnter 1 for Card 1 -> Card 2 \nEnter 2 for Card 2 -> Card 1");
        int chosenCard =  sc.nextInt();
        switch(chosenCard){
            case 1 ->{
                if(card1.getTicketBalance() > 0){
                    System.out.print("Enter amount: ");
                    int transferAmount = sc.nextInt();
                    card1.transferTickets(transferAmount, card2);
                    System.out.println("Current Balance: ");
                    card1.displayCardDetails();
                    chooseAction();
                } else{System.out.println("\nNot Enough Tickets");chooseAction();}
            }
            case 2 ->{
                if(card2.getTicketBalance() > 0){
                    System.out.print("Enter amount: ");
                    int transferAmount = sc.nextInt();
                    card2.transferTickets(transferAmount, card1);
                    System.out.println("Current Balance: ");
                    card2.displayCardDetails();
                    chooseAction();
                } else{System.out.println("\nNot Enough Tickets");chooseAction();}
            }
            default -> {System.out.println("\nPlease Enter right number"); chooseAction();}                
        }
    }
}
