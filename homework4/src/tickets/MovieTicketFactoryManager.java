package tickets;

public class MovieTicketFactoryManager {
    private static final IMovieTicketFactory spiderManTicketInstance = null;

    public static IMovieTicketFactory getMissionImpossibleMovieTicketFactory() {
        MovieTicket ticket = new MovieTicket("Mission Impossible", "JJ Abrams", "DreamWorks");

        return new MovieFlyweight(ticket);
    }

    public static IMovieTicketFactory getStarWarsMovieTicketFactory() {
        throw new Error("Implement the StarWarsMovieTicketFactory as a Singleton");
        //TODO
    }

    public static IMovieTicketFactory getSpidermanMovieTicketFactory() {
        throw new Error("Implement the SpidermanMovieTicketFactory as a Singleton");
        //TODO
    }

}
