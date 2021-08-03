import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Filters.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //mongodb();
        //mongodbCreate();

        MongoDB mongoDB = new MongoDB();
        mongoDB.mongodbOperations();
    }



}
