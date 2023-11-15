package polybius;

import javax.naming.ConfigurationException;

public class PolybiusCipher implements Encryptor, Decryptor {
    private char[][] polybiusSquare;

    public PolybiusCipher(char[][] polybiusSquare) {
        this.polybiusSquare = polybiusSquare;
    }

    public String encrypt(String text) throws ConfigurationException {
        StringBuilder ciphertext = new StringBuilder();

        for (char ch : text.toCharArray()) {
            ciphertext.append(charToPolybiusCoordinates(ch));
        }

        return ciphertext.toString();
    }

    public String decrypt(String text) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            String coords = text.substring(i, i + 2);
            plaintext.append(polybiusCoordinatesToChar(coords));
        }

        return plaintext.toString();
    }

    private String charToPolybiusCoordinates(char ch) throws ConfigurationException {
        ch = Character.toUpperCase(ch);

        if (ch == 'J') {
            ch = 'I'; // Полибийский квадрат не содержит 'J', поэтому заменяем его на 'I'.
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (polybiusSquare[i][j] == ch) {
                    return "" + (i + 1) + (j + 1);
                }
            }
        }

        throw new ConfigurationException("Not correct char " + ch);
    }

    private char polybiusCoordinatesToChar(String coords) {
        int row = Character.getNumericValue(coords.charAt(0)) - 1;
        int col = Character.getNumericValue(coords.charAt(1)) - 1;

        return polybiusSquare[row][col];
    }
}
