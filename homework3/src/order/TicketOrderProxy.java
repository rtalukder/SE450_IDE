package order;

import ticket.ITicket;

import java.util.Random;

public class TicketOrderProxy implements ITicketOrder {
    private ITicketOrder ticketOrder;
    private ITicket ticket;
    private int quantity;
    private String orderNumber;
    private final IApiCaller apiCaller;

    public TicketOrderProxy (ITicket ticket, int quantity, IApiCaller apiCaller){
        ticketOrder = new TicketOrder(ticket, quantity, apiCaller);
        ticketOrder.submitTicketOrder();
        this.apiCaller = apiCaller;
        this.quantity = quantity;
        this.ticket = ticket;
        orderNumber = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
    }

    @Override
    public void submitTicketOrder() {
        apiCaller.callApi("www.ticketinsurance.com/api/addInsurance",
                "{\"orderNumber\": \"" + ticketOrder.getOrderNumber() + "\"}");
        Integer orderNumberInt = new Random().nextInt();
        orderNumber = orderNumberInt.toString();
    }

    @Override
    public String getOrderNumber() {
        System.out.println("order number returned");
        return ticketOrder.getOrderNumber();
    }
}
