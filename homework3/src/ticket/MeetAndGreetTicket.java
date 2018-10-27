package ticket;

public class MeetAndGreetTicket implements ITicketDecorator {
    private ITicket ticket;
    private final int meetAndGreetPrice = 100;
    private final String meetAndGreetSummary = " + Meet and Greet";

    public MeetAndGreetTicket(ITicket ticket){
        this.ticket = ticket;
    }

    @Override
    public int getPrice() {
        return ticket.getPrice() + meetAndGreetPrice;
    }

    @Override
    public String getSummary() {
        return ticket.getSummary() + meetAndGreetSummary;
    }
}
