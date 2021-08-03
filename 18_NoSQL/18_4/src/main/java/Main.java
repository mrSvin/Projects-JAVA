import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Filters.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

public class Main {

    //commit
    public static void main(String[] args) throws InterruptedException {
        MongoDB mongoDB = new MongoDB();
        mongoDB.scannerOperations();
    }



}
