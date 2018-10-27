package ticket;

public class BonusPackageTicket implements ITicketDecorator {
    private ITicket ticket;
    private final int bonusPackagePrice = 50;
    private final String bonusPackageSummary = " + Bonus Package";

    public BonusPackageTicket(ITicket ticket){
        this.ticket = ticket;
    }

    @Override
    public int getPrice() {
        return ticket.getPrice() + bonusPackagePrice;
    }

    @Override
    public String getSummary() {
        return ticket.getSummary() + bonusPackageSummary;
    }
}
