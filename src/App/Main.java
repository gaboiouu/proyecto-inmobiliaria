
package App;

import Vista.Login;

      
public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

                // Crear una instancia de la ventana de login y hacerla visible
                Login login = new Login();
                login.setVisible(true);  // Hacer visible la ventana de login
            
        });
    }
}
