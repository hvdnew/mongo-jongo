import data.JongoServiceImpl;
import data.model.MovieDetails;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.junit.Test;

public class JongoQueryTest {

    @Test
    public void testDoWhatYouDoBest() {

        final MongoCollection movieDetailsColl = new JongoServiceImpl("video").getCollection("movieDetails");


        MongoCursor<MovieDetails> movies = movieDetailsColl.find("{year: 2000}")
                .projection("{title: 1, year:1}") // can be used to avoid loading heavy objects
                .as(MovieDetails.class);
        System.out.println("Count:" + movies.count());
        movies.iterator().forEachRemaining(System.out::println);

    }

}
