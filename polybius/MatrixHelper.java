package polybius;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatrixHelper {
    public static char[][] initializePolybiusSquare(int columnSize, int rowSize) {
        List<Character> alphabetList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        Collections.shuffle(alphabetList);

        var polybiusSquare = new char[columnSize][rowSize];

        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                polybiusSquare[i][j] = alphabetList.get(index++);
            }
        }

        return polybiusSquare;
    }

    public static void writePolybiusSquareToFile(char[][] polybiusSquare, String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    fileWriter.write(polybiusSquare[i][j] + " ");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
