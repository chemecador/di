package inicio;

import javax.swing.*;
import java.util.ArrayList;

public class Usuarios {
    private ArrayList<String> users;
    private ArrayList<String> passwords;

    Usuarios() {
        users = new ArrayList<>();
        passwords = new ArrayList<>();
        users.add("");
        passwords.add("");
        users.add("root");
        passwords.add("root");
        users.add("admin");
        passwords.add("admin");
    }

    public void registro(String user, String pass) {
        users.add(user);
        passwords.add(pass);
        System.out.println("Ahora los usuarios son : ");
        int indice = 0;
        for (String i : users){
            System.out.println("Usuario: " + i + " contraseña: " + passwords.get(indice));
            indice++;
        }
    }

    public boolean iniciarSesion(String user, String pass) {
        System.out.println("la clave es " + pass);
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
