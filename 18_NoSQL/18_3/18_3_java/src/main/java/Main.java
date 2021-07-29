import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

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
        mongodbOperations();
    }
    private static void mongodbCreate() {
        MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("skillbox");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("TestSkillDemo");

        // Удалим из нее все документы
        collection.drop();

        // Создадим первый документ
        Document firstDocument = new Document()
                .append("Type", 1)
                .append("Description", "Это наш первый документ в MongoDB")
                .append("Author", "Я")
                .append("Time", new SimpleDateFormat().format(new Date()));

        // Вложенный объект
        Document nestedObject = new Document()
                .append("Course", "NoSQL Базы Данных")
                .append("Author", "Mike Ovchinnikov");

        firstDocument.append("Skillbox", nestedObject);


        // Вставляем документ в коллекцию
        collection.insertOne(firstDocument);

        collection.find().forEach((Consumer<Document>) document -> {
            System.out.println("Наш первый документ:\n" + document);
        });

        // Используем JSON-синтаксис для создания объекта
        Document secondDocument = Document.parse(
                "{Type: 2, Description:\"Мы создали и нашли этот документ с помощью JSON-синтаксиса\"}"
        );
        collection.insertOne(secondDocument);

        // Используем JSON-синтаксис для написания запроса (выбираем документы с Type=2)
        BsonDocument query = BsonDocument.parse("{Type: {$eq: 2}}");
        collection.find(query).forEach((Consumer<Document>) document -> {
            System.out.println("Наш второй документ:\n" + document);
        });

    }

    private static void mongodb2() {
        String file = "E:\\java\\java_basics\\18_NoSQL\\18_3\\mongo.csv";

        List<Document> documents = new ArrayList<Document>();
        try {
            // connection mongo Service
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //Connect to the database
            MongoDatabase mongoDatabase = mongoClient.getDatabase("skillbox");


            System.out.println("connect to database successfully");

            // Create Collection
            mongoDatabase.createCollection("students");
            System.out.println ( "Creating a collection of success");
            // select a collection
            MongoCollection<Document> collection = mongoDatabase.getCollection("students");
            System.out.println ( "set students selects successfully");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine (); // read each row of data represents
            String line = null;
            while((line = reader.readLine())!=null) {
                int lineTest = line.indexOf("\"");
                String line2 = line.substring(0,lineTest);
                String line3 = line.substring(lineTest,line.length());
                line3=line3.replaceAll("\"", "");
                //line3=line3.replaceAll(",",";");
                //String result = line2 + line3;
                String [] item = line2.split ( ","); // csv file is "" separated
                //System.out.println(line2 + line3);
                String name = item [0]; // get the value in the csv assign keywords
                String age = item[1];
                String courses = line3;
                Document document = new Document (); // create a document
                document.put ( "name", name); // data into the database
                document.put("age", age);
                document.put("courses", courses);
                documents.add(document);
            }
            collection.insertMany (documents); // set the document into the database

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private static void mongodbOperations() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //Connect to the database
        MongoDatabase mongoDatabase = mongoClient.getDatabase("skillbox");
        MongoCollection<Document> collection = mongoDatabase.getCollection("students");

        long count = collection.count()+1;
        System.out.println("Колчество студентов " + count);



    }

}
