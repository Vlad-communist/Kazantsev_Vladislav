package message_enricher;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

    private ConcurrentHashMap<String, User> usersByMsisdn = new ConcurrentHashMap<>();
    private final String characters = "qwertyuiopasdfghjklzxcvbnm";
    private final Random rng = new Random();

    // функция для тестирования
    private String generateString() {

        int length = 10;
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    private void setFirstNameIfNotExist(String msisdn) {
        User user = findByMsisdn(msisdn);
        if (user.firstName.isEmpty()) {
            user.firstName = generateString();
        }
    }

    private void setLastNameIfNotExist(String msisdn) {
        User user = findByMsisdn(msisdn);
        if (user.lastName.isEmpty()) {
            user.lastName = generateString();
        }
    }

    public String getLastName(String msisdn) {
        setLastNameIfNotExist(msisdn);
        return findByMsisdn(msisdn).lastName;
    }

    public String getFirstName(String msisdn) {
        setFirstNameIfNotExist(msisdn);
        return findByMsisdn(msisdn).firstName;
    }

    User findByMsisdn(String msisdn) {
        if (!usersByMsisdn.containsKey(msisdn)) {
            usersByMsisdn.put(msisdn, new User());
        }
        return usersByMsisdn.get(msisdn);
    }

    void updateUserByMsisdn(String msisdn, User user) {
        usersByMsisdn.put(msisdn, user);
    }
}
