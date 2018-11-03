package tickets;

import java.util.Calendar;

public class MovieFlyweight implements IMovieTicket, IMovieTicketFactory {
    private MovieTicket movieTicket;
    private Calendar showTime;

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
