package data;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class JongoServiceImpl implements JongoService {

    private final Jongo jongo;

    public JongoServiceImpl(String dbName) {

        MongoClient client = new MongoClient();
        DB db = client.getDB(dbName);

        jongo = new Jongo(db);

    }

    @Override
    public MongoCollection getCollection(String name) {
        return jongo.getCollection(name);
    }
}
