import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConvertToJson {

    public void ConvertJson() {
        ObjectMapper mapper = new ObjectMapper();

        Parser parser = new Parser();
        parser.ParserHtml();

        try {

            // Java objects to JSON file
            mapper.writeValue(new File("C:\\Users\\Home\\Desktop\\test\\outJSON.json"), parser);

            // Java objects to JSON string - compact-print
            //String jsonString = mapper.writeValueAsString(parser);
            //System.out.println(jsonString);

            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(parser);


            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
