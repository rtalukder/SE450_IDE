package tickets;

import java.util.Calendar;

public class MovieTicketFactoryManager {
    private static MovieTicket spidermanTicket = new MovieTicket("Spiderman", "MGM", "Steven Spielberg");
    private static MovieTicket missionImpossibleTicket = new MovieTicket("Mission Impossible", "DreamWorks", "JJ Abrams");
    private static MovieTicket starWarsTicket = new MovieTicket("Star Wars", "LucasFilm", "George Lucas");

    public static IMovieTicketFactory getMissionImpossibleMovieTicketFactory() {
        return MissionImpossibleSingleton.getInstance(new MovieFlyweight(missionImpossibleTicket));
    }

    public static IMovieTicketFactory getStarWarsMovieTicketFactory() {
        return StarWarsSingleton.getInstance(new MovieFlyweight(starWarsTicket));
    }

    public static IMovieTicketFactory getSpidermanMovieTicketFactory() {
        return SpidermanSingleton.getInstance(new MovieFlyweight(spidermanTicket));
    }

}
