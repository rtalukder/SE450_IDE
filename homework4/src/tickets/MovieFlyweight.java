package tickets;

import java.util.Calendar;
import java.util.List;

public class MovieFlyweight implements IMovieTicket, IMovieTicketFactory {
    private MovieTicket movieTicket;
    private Calendar showTime = null;

    public MovieFlyweight(MovieTicket movieTicket) {
        this.movieTicket = movieTicket;
    }

    @Override
    public IMovieTicket createTicket(Calendar showtime) {
        this.showTime = showtime;
        return this;
    }

    @Override
    public String getMovieName() {
        return movieTicket.getMovieName();
    }

    @Override
    public String getMovieStudio() {
        return movieTicket.getMovieStudio();
    }

    @Override
    public String getDirector() {
        return movieTicket.getDirector();
    }

    @Override
    public Calendar getShowtime() {
        return showTime;
    }
}
