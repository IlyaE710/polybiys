package polybius;

import javax.naming.ConfigurationException;

import static java.lang.System.exit;

public class App {
    public static void main(String[] args) {
        // Чтение данных из файла
        var polybiusSquare = MatrixHelper.initializePolybiusSquare(5, 5);
        // Запись матрицы в файл
        MatrixHelper.writePolybiusSquareToFile(polybiusSquare, "polybius_square.txt");
        var cipher = new PolybiusCipher(polybiusSquare);
        var plaintext = FileHelper.readFileToString("plaintext.txt");
        // Шифрование
        String encryptedMessage = null;
        try {
            encryptedMessage = cipher.encrypt(plaintext.replaceAll("\\s", ""));
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
            exit(-1);
        }
        FileHelper.writeStringToFile(encryptedMessage, "encrypted.txt");
        var encryptedMessageFromFile = FileHelper.readFileToString("encrypted.txt");
        // Дешифрование
        var decryptedMessage = cipher.decrypt(encryptedMessageFromFile);
        FileHelper.writeStringToFile(decryptedMessage, "decrypted.txt");
    }
}
