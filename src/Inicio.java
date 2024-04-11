import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Inicio extends JFrame {
    public Inicio(String usuario, Map<String, String> usrpw, ArrayList<String> postlist) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton postbtn = new JButton("Post");
        panel.add(postbtn);
        JButton backbtn = new JButton("Back");
        panel.add(backbtn);
        JTextField postComment = new JTextField(30);
        panel.add(postComment);
        JTextArea publicPosts = new JTextArea(10, 40);
        publicPosts.setEditable(false);
        publicPosts.setLineWrap(true);
        panel.add(publicPosts);
        postbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!postComment.getText().equals("")) {
                    publicPosts.append(usuario + ": " + postComment.getText()+"\n");
                }
                postComment.setText("");
            }
        });
        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveList(postlist, publicPosts);
                new Login(usrpw, postlist);
                setVisible(false);
            }
        });

        //Cargar datos
        loadList(postlist, publicPosts);


        add(panel);


        setTitle("Inicio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public static void loadList(ArrayList<String> postlist, JTextArea publicPosts) {
        for (String post : postlist) {
            publicPosts.append(post + "\n");
            //System.out.println(post);
        }
    }

    public static void saveList(ArrayList<String> postlist, JTextArea publicPosts) {
        postlist.clear();
        String linea[] = publicPosts.getText().split("\\n");
        for (String line : linea) {
            postlist.add(line);
        }
    }
}
