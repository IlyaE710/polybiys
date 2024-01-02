# Полибийский шифр

Программа, демонстрирующая шифрование и дешифрование текста с использованием полибийского шифра.

## Использование

Программа предоставляет консольное приложение для шифрования и дешифрования текста с помощью полибийского шифра.

### Пример использования кода

```java
package polybius;

public class App {
    public static void main(String[] args) {
        // Чтение данных из файла и инициализация матрицы
        var polybiusSquare = MatrixHelper.initializePolybiusSquare(5, 5);
        MatrixHelper.writePolybiusSquareToFile(polybiusSquare, "polybius_square.txt");
        
        var cipher = new PolybiusCipher(polybiusSquare);
        var plaintext = FileHelper.readFileToString("plaintext.txt");
        
        // Шифрование текста
        String encryptedMessage = cipher.encrypt(plaintext.replaceAll("\\s", ""));
        FileHelper.writeStringToFile(encryptedMessage, "encrypted.txt");
        
        // Дешифрование зашифрованного текста
        var encryptedMessageFromFile = FileHelper.readFileToString("encrypted.txt");
        var decryptedMessage = cipher.decrypt(encryptedMessageFromFile);
        FileHelper.writeStringToFile(decryptedMessage, "decrypted.txt");
    }
}
