import MyAggrigation.Actor;
import MyAggrigation.Movie;
public class AggregationDemo {
    public static void main(String[] args) {

        Actor a1 = new Actor("Yash", 38);

        Movie m1 = new Movie("KGF", a1);

        m1.showMovieDetails();
    }
}
