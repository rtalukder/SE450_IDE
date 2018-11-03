package tickets;

import java.util.Calendar;

public class main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 8,1, 10, 30);
        IMovieTicketFactory movieTicketFactory = MovieTicketFactoryManager.getMissionImpossibleMovieTicketFactory();
        IMovieTicket ticket = movieTicketFactory.createTicket(calendar);

        System.out.println(ticket.getMovieName());
    }
}
