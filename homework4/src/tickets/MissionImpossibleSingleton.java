package tickets;

import java.util.Calendar;

public class MissionImpossibleSingleton implements IMovieTicketFactory {
    private static MissionImpossibleSingleton instance;
    private IMovieTicketFactory ticket;

    private MissionImpossibleSingleton(IMovieTicketFactory ticket){
        this.ticket = ticket;
    }

    @Override
    public IMovieTicket createTicket(Calendar showtime) {
        return ticket.createTicket(showtime);
    }


    public static MissionImpossibleSingleton getInstance(IMovieTicketFactory ticket) {
        if (instance == null){
            instance = new MissionImpossibleSingleton(ticket);
        }
        return instance;
    }

}

