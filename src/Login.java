import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class Login extends JFrame {
    public Login(Map<String, String> usrpw, ArrayList<String> postlist){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JTextField userfield = new JTextField(10);
        panel.add(userfield);
        JPasswordField pwfield = new JPasswordField(10);
        panel.add(pwfield);
        JButton logbutton = new JButton("Login");
        logbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userfield.getText();
                String password = pwfield.getText();

                for (Map.Entry<String, String> loop : usrpw.entrySet()) {
                    //System.out.println(loop.getKey() + " " + loop.getValue());
                    if (username.equals(loop.getKey()) && !password.equals(loop.getValue())) {
                        JOptionPane.showMessageDialog(logbutton,"Contraseña incorrecta");
                    } else if (username.equals(loop.getKey()) && password.equals(loop.getValue())) {
                        new Inicio(loop.getKey(), usrpw, postlist);
                        setVisible(false);
                    }
                }

            }
        });
        panel.add(logbutton);
        JButton registerbutton = new JButton("Registrarse");
        registerbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userfield.getText();
                String password = pwfield.getText();
                for (Map.Entry<String, String> loop : usrpw.entrySet()) {
                    if (username.equals(loop.getKey())) {
                        JOptionPane.showMessageDialog(registerbutton,"Usuario ya registrado");
                        return;
                    }
                }
                usrpw.put(username, password);
                JOptionPane.showMessageDialog(logbutton,"Usuario registrado");
            }
        });
        panel.add(registerbutton);
        add(panel);
        setTitle("Login");
        setSize(400,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
