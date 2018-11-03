package tickets;

import java.util.Calendar;

public class SpidermanSingleton implements IMovieTicketFactory {
    private static SpidermanSingleton instance;
    private IMovieTicketFactory ticket;

    private SpidermanSingleton(IMovieTicketFactory ticket){
        this.ticket = ticket;
    }

    @Override
    public IMovieTicket createTicket(Calendar showtime) {
        return ticket.createTicket(showtime);
    }


    public static SpidermanSingleton getInstance(IMovieTicketFactory ticket) {
        if (instance == null){
            instance = new SpidermanSingleton(ticket);
        }
        return instance;
    }

}
