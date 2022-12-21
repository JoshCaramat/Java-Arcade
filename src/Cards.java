public class Cards{
    private String Name;
    private int creditBalance, ticketBalance;

    public Cards(){
        this.Name ="";
        this.creditBalance = 0;
        this.ticketBalance = 0;
    }
    public void setName(String name){
        this.Name = name;
    }
    public String getName(){
        return this.Name;
    }
    public void setCreditBalance(int setCreditBalance){
        this.creditBalance += setCreditBalance;
    }
    public int getCreditBalance(){
        return this.creditBalance;
    }
    public void setTicketBalance(int setTicketBalance){
        this.ticketBalance += setTicketBalance;
    }
    public int getTicketBalance(){
        return this.ticketBalance;
    }
    public void displayCardDetails(){
        System.out.println("Name: " + getName());
        System.out.println("Credits: " + getCreditBalance());
        System.out.println("Tickets: " + getTicketBalance());
    }
    public void reduceCredit(int amount) {
        this.creditBalance -= amount;
    }
    public void reduceTicket(int amount) {
        this.ticketBalance -= amount;
    }
    public void transferCredit(int amount, Cards cardsReceiving) {
        if (this.creditBalance < amount) {
           System.out.println("Credit Transfer Failed");
        } else {
           this.creditBalance -= amount;
           cardsReceiving.creditBalance += amount;
        }
     }  
     public void transferTickets(int amount, Cards cardsReceiving) {
        if (this.ticketBalance < amount) {
           System.out.println("Credit Transfer Failed");
        } else {
           this.ticketBalance -= amount;
           cardsReceiving.ticketBalance += amount;
        }
     }
}