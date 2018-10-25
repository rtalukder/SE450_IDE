package order;

import ticket.ITicket;

public class TicketOrderFactory {

    private IApiCaller apiCaller;

    public TicketOrderFactory(IApiCaller apiCaller){
        this.apiCaller = apiCaller;
    }

    public ITicketOrder createTicketOrder(ITicket ticket, int quantity, boolean purchasedInsurance) {
        if(purchasedInsurance)
            throw new Error("Create a TicketOrderProxy class and return a new instance of it here");
        else
            return new TicketOrder(ticket, quantity, apiCaller);
    }
}
