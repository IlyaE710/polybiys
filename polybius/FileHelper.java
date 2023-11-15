package polybius;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
    public static String readFileToString(String filename) {
        StringBuilder content = new StringBuilder();
        try (FileReader fileReader = new FileReader(filename)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                content.append((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeStringToFile(String content, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
