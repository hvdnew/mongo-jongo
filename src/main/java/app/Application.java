package app;

import data.JongoService;
import data.JongoServiceImpl;
import data.model.Address;
import data.model.MovieDetails;
import data.model.State;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

public class Application {

    private static final String DB_NAME = "jongo-example";
    private static final String ADDR_COLL_NAME = "address";
    private static final String STATE_COLL_NAME = "state";

    private final MongoCollection addressColl;
    private final MongoCollection stateColl;
    private final MongoCollection movieDetailsColl;

    public Application() {

        JongoService service = new JongoServiceImpl(DB_NAME);
        addressColl = service.getCollection(ADDR_COLL_NAME);
        stateColl = service.getCollection(STATE_COLL_NAME);


        movieDetailsColl = new JongoServiceImpl("video").getCollection("movieDetails");
    }

    public void insertData() {

        State rajasthan = new State("Rajasthan");
        rajasthan.getAttractions().add("Jaipur");
        rajasthan.getAttractions().add("Jodhpur");


        for (int i = 0; i < 100; i++) {
            Address address1 = new Address("firstLine", "secondLine", "122004");
            address1.setState(rajasthan);
            addressColl.insert(address1);
        }

        stateColl.insert(rajasthan);

    }

    public void readMovieDetails() {

        MongoCursor<MovieDetails> movies = movieDetailsColl.find("{year: 2000}")
                .projection("{title: 1, year:1}") // can be used to avoid loading heavy objects
                .as(MovieDetails.class);
        System.out.println("Count:" + movies.count());
        movies.iterator().forEachRemaining(System.out::println);

    }

    public void update() {

        movieDetailsColl.update("{actors: 'Henry Fonda'}").multi()
                .with("{$set: {totallyNewField: 'blah'}}");
    }
}
