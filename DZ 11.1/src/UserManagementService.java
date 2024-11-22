import java.util.HashMap;
import java.util.Map;

interface UserManagementService {
    boolean registerUser(String username, String password);
    boolean loginUser(String username, String password);
}

class UserManagementServiceImpl implements UserManagementService {
    private Map<String, String> users = new HashMap<>();

    @Override
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Пользователь уже существует!");
            return false;
        }
        users.put(username, password);
        System.out.println("Пользователь успешно зарегистрировался!");
        return true;
    }

    @Override
    public boolean loginUser(String username, String password) {
        if (users.getOrDefault(username, "").equals(password)) {
            System.out.println("Вход в систему выполнен успешно!");
            return true;
        }
        System.out.println("Недействительные учетные данные!");
        return false;
    }
}
