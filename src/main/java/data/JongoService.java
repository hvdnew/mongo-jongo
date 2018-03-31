package data;

import org.jongo.MongoCollection;

public interface JongoService {

    MongoCollection getCollection(String collection);

}
