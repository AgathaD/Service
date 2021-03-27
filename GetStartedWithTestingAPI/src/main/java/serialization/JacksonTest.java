package serialization;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonTest {
    public static void main(String args[]){
        JacksonTest tester = new JacksonTest();
        try {
            Painter painter = new Painter();
            painter.setGenre("Landscape");
            painter.setName("John Constable");
            tester.writeJSON(painter);

            Painter p1 = tester.readJSON();
            System.out.println(p1);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJSON(Painter painter) throws JsonGenerationException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("data.json"), painter);
    }

    private Painter readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Painter painter = mapper.readValue(new File("data.json"), Painter.class);
        return painter;
    }
}