package polybius;

import javax.naming.ConfigurationException;

public interface Encryptor {
    public String encrypt(String text) throws ConfigurationException;
}
