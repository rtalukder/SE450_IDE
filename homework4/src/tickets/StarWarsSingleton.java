package tickets;

import java.util.Calendar;

public class StarWarsSingleton implements IMovieTicketFactory {
    private static StarWarsSingleton instance;
    private IMovieTicketFactory ticket;

    private StarWarsSingleton(IMovieTicketFactory ticket){
        this.ticket = ticket;
    }

    @Override
    public IMovieTicket createTicket(Calendar showtime) {
        return ticket.createTicket(showtime);
    }


    public static StarWarsSingleton getInstance(IMovieTicketFactory ticket) {
        if (instance == null){
            instance = new StarWarsSingleton(ticket);
        }
        return instance;
    }

}

