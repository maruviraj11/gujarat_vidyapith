package MyAggrigation;
import MyAggrigation.Actor;

public class Movie {
    private String movieName;
    private Actor actor;

    public Movie(String movieName, Actor actor) {
        this.movieName = movieName;
        this.actor = actor;
    }

    public void showMovieDetails() {
        System.out.println("Movie Name: " + movieName);
        actor.showActor();
    }
}