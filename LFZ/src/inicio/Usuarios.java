package inicio;

import javax.swing.*;
import java.util.ArrayList;

public class Usuarios {
    private ArrayList<String> users;
    private ArrayList<String> passwords;

    Usuarios() {
        users = new ArrayList<>();
        passwords = new ArrayList<>();
        users.add("root");
        passwords.add("root");
        users.add("admin");
        passwords.add("admin");
    }

    public void registro(String user, String pass) {
        users.add(user);
        passwords.add(pass);
    }

    public boolean iniciarSesion(String user, String pass) {
        if (users.contains(user)) {
            int indice = users.indexOf(user);
            if (passwords.get(indice).equals(pass)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,
                "Usuario o contraseña incorrectos",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
