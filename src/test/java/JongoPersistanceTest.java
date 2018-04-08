import data.JongoService;
import data.JongoServiceImpl;
import data.model.*;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JongoPersistanceTest {

    private Logger log = Logger.getLogger(JongoPersistanceTest.class.getName());
    private static final String DB_NAME = "jongo-example";
    private JongoService jongoService;


    @Before
    public void before() {

        log.info("#################################################");
        jongoService = new JongoServiceImpl(DB_NAME);
    }

    @Test
    public void testSaveData() {

        Person harsh = new Person("Harshvardhan", "Dadhich");

        State rajasthan = new State("Rajasthan");
        rajasthan.getAttractions().add("Jaipur");
        rajasthan.getAttractions().add("Jodhpur");

        Address address = new Address("addLine1", "addLine2", "122004");
        address.setState(rajasthan);

        harsh.setAddress(address);

        List<Blog> blogs = new ArrayList<>(0);
        Blog blog = new Blog("Let us brew Java with MongoDB", "45 mins content");
        blog.setAuthor(harsh);


        Person attendee1 = new Person("Mr", "Bean");
        Person attendee2 = new Person("Tony", "Stark");

        List<Comment> comments = new ArrayList<>(0);

        comments.add(new Comment("What is OGM?", attendee1));
        comments.add(new Comment("Let's wait till end, he will take questions", attendee2));

        blog.setComments(comments);
        blogs.add(blog);
        //harsh.setBlogs(blogs);


        MongoCollection personCollection = jongoService.getCollection(Person.class.getName());

        MongoCollection stateCollection = jongoService.getCollection(State.class.getName());
        MongoCollection addressCollection = jongoService.getCollection(Address.class.getName());

        MongoCollection blogCollection = jongoService.getCollection(Blog.class.getName());

        MongoCollection commentCollection = jongoService.getCollection(Comment.class.getName());


        personCollection.insert(harsh, attendee1, attendee2);
        stateCollection.insert(rajasthan);
        addressCollection.insert(address);
        blogCollection.insert(blog);
        commentCollection.insert(comments.get(0), comments.get(1));


    }


    @Test
    public void updateTest() {

        final MongoCollection movieDetailsColl = new JongoServiceImpl("video").getCollection("movieDetails");

        movieDetailsColl.update("{actors: 'Henry Fonda'}").multi() // multiple updates
                .with("{$set: {totallyNewField: 'blah'}}");

    }


}
