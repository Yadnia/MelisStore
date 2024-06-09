package windows;

import org.Yaed.App;
import org.Yaed.entity.Administrador;
import org.Yaed.entity.User;
import org.Yaed.services.GenericServiceImpl;
import org.Yaed.services.IGenericService;
import org.Yaed.util.HibernateUtil;
import org.checkerframework.checker.units.qual.A;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

    JFrame frame1 = new JFrame();

    public Login() {
        //crear el usuario
        List<User> usuarios = getUsers();
        usuarios.forEach(System.out::println);
        List<Administrador> admins = getAdmins();
        if (admins.isEmpty()) {
            Administrador user2 = new Administrador("root@gmail.com","12345678","Yadnia","Baltodano","1234567");
             saveUser(user2);
        }
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
              String password = new String(passTxtF.getPassword());
              if (ValidUser(email, password)){
                  if (existentUser(email,password)){
                      frame1.dispose();
                      new mainPage().setVisible(true);
                  } else{
                      JOptionPane.showMessageDialog(null,"Usuario no registrado");
                  }

              } else {
                  JOptionPane.showMessageDialog(null, "Correo o contraseña inválidos",
                    "Error",JOptionPane.ERROR_MESSAGE);
              }

          }});
        passTxtF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    smtBt.doClick();
                }
            }
        });

        frame1.add(smtBt);

        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private static void saveUser (User user){
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userService.save(user);
    }
    private static List <User> getUsers(){
        List<User> users = new ArrayList<>();
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        users = userService.getAll();
        return users;
    }
    private static boolean ValidUser (String email, String password){
        String emPtrn =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern ptrn = Pattern.compile(emPtrn);
        Matcher mtch = ptrn.matcher(email);
        String passPtrn =
                "^.{8,}$";
        Pattern pttn = Pattern.compile(passPtrn);
        Matcher match = pttn.matcher(password);
        if (mtch.matches() && match.matches()){
            return true;
        }
        return false;
    }
    private static boolean existentUser(String email, String password){
        List<User> usuarios = getUsers();
        for (User user: usuarios){
            if (user.getUserEmail().equalsIgnoreCase(email)&& user.getUserPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    private static List<Administrador> getAdmins() {
        List<Administrador> admins = new ArrayList<>();
        IGenericService<Administrador> adminService = new GenericServiceImpl<>(Administrador.class, HibernateUtil.getSessionFactory());
        admins = adminService.getAll();
        return admins;
    }
}
