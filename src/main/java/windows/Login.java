package windows;

import org.Yaed.App;
import org.Yaed.entity.User;
import org.Yaed.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

    JFrame frame1 = new JFrame();

    public Login() {
        //crear el usuario
        User user = new User("yadnia@gmail.com","P@ssw0rd!", "admin");
        guardarUsuario(user);
        List<User> usuarios = getUsers();
        usuarios.forEach(System.out::println);

        URL rutaimg = App.class.getResource("/IconLogin.png");
        ImageIcon iconImg = new ImageIcon(rutaimg);
        frame1.setIconImage(iconImg.getImage());

        frame1.setLayout(null);

        frame1.setSize(400, 450);
        frame1.getContentPane().setBackground(new Color(46, 21, 59));
        frame1.setResizable(false);
        frame1.setLocation(550, 200);

        JLabel label1 = new JLabel();
        label1.setText("Usuario:");
        label1.setBounds(50, 100, 100, 30);
        label1.setFont(new Font("Outfit SemiBold", Font.BOLD, 16));
        label1.setForeground(new Color(255, 179, 2));
        frame1.add(label1);

        JTextField emailTextF = new JTextField();
        emailTextF.setText("Ingrese su nombre de usuario");
        emailTextF.setBounds(130, 100, 200, 30);
        emailTextF.setFont(new Font("Outfit", Font.ITALIC, 12));
        emailTextF.setOpaque(false);
        emailTextF.setBorder(new MatteBorder(0,0,1,0,Color.white));
        emailTextF.setForeground(new Color(255,179,2));
        frame1.add(emailTextF);

        // modificar para agregar placeholder

        emailTextF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailTextF.getText().equals("Ingrese su nombre de usuario")) {
                    emailTextF.setText("");
                    emailTextF.setForeground(new Color(255,179,2));
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailTextF.getText().isEmpty()) {
                    emailTextF.setText("Ingrese su nombre de usuario");
                    emailTextF.setForeground(Color.LIGHT_GRAY);
                }

            }
        });

        JLabel label2 = new JLabel();
        label2.setText("Contraseña:");
        label2.setBounds(30, 160, 200, 30);
        label2.setFont(new Font("Outfit SemiBold", Font.BOLD, 16));
        label2.setForeground(new Color(255, 179, 2));
        frame1.add(label2);

        JPasswordField passTxtF = new JPasswordField();
        passTxtF.setText("Contraseña");
        passTxtF.setBounds(130, 160, 200, 30);
        passTxtF.setFont(new Font("Outfit", Font.ITALIC, 12));
        passTxtF.setOpaque(false);
        passTxtF.setForeground(new Color(255,179,2));
        passTxtF.setBorder(new MatteBorder(0,0,1,0,Color.white));
        passTxtF.setEchoChar('*');
        frame1.add(passTxtF);

        // placeholder

        passTxtF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passTxtF.getText().equals("Contraseña")) {
                    passTxtF.setText("");
                    passTxtF.setForeground(new Color(255,179,2));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passTxtF.getText().isEmpty()) {
                    passTxtF.setText("Contraseña");
                    passTxtF.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        JLabel label3 = new JLabel();
        label3.setText("Iniciar sesión");
        label3.setBounds(100, 30, 200, 50);
        label3.setFont(new Font("Outfit SemiBold ", Font.BOLD, 30));
        label3.setForeground(new Color(237, 204, 255));
        frame1.add(label3);

        JButton smtBt = new JButton();

        smtBt.setText("Enviar");
        smtBt.setBounds(143, 250, 100, 30);
        smtBt.setBackground(new Color(255, 179, 2));
        smtBt.setFont(new Font("Outfit SemiBold", Font.BOLD, 15));

          smtBt.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
          String email = emailTextF.getText();
          String emPtrn =
          "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
          Pattern ptrn = Pattern.compile(emPtrn);
          Matcher mtch = ptrn.matcher(email);

          String password = new String(passTxtF.getPassword());
          String passPtrn =
          "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$";
          Pattern pttn = Pattern.compile(passPtrn);
          Matcher match = pttn.matcher(password);
//          JOptionPane.showMessageDialog(null,mtch.matches());
//          JOptionPane.showMessageDialog(null, match.matches());
              boolean validUser = false;
              for (User user: usuarios){
                  if (user.getUserEmail().equalsIgnoreCase(email)&& user.getUserPassword().equals(password)){
                      validUser = true;
                  }
              }

          if (mtch.matches() && match.matches()){
              if (validUser){
                  frame1.dispose();
                  new mainPage().setVisible(true);
              }
              else {
                  JOptionPane.showMessageDialog(null,"Usuario no registrado");
              }
          } else {
          JOptionPane.showMessageDialog(null, "Correo o contraseña inválidos",
          "Error",JOptionPane.ERROR_MESSAGE);
          }
          }
          });

        frame1.add(smtBt);

        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private static void guardarUsuario (User user){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();{
                if (transaction != null){
                    transaction.rollback();
                }
            }
        }
    }
    private static List <User> getUsers (){
        Transaction transaction = null;
        List <User> users = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            users = session.createQuery("from User", User.class).list();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return users;
    }

}
