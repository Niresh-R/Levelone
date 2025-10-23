package utils.jsonUtills;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonUtils  {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static  <T> T readJsonFile(String filePath, Class<T> clazz){
        try{
            System.out.println("Current working dir: " + new File(".").getAbsolutePath());
            return mapper.readValue(Paths.get(filePath).toFile(),clazz);
        }  catch (IOException e) {
        throw new RuntimeException("Failed to read JSON file: " + filePath, e);
    }
    }
}
