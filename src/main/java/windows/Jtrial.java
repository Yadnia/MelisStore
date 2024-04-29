package windows;

import javax.swing.*;
import java.awt.*;

public class Jtrial extends JFrame{
//        static Forms.Admin myAdmin;

        public Jtrial(){
            //super("Administradores",true,true,true);
            Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
            Color yell = new Color(255,179,2);
            Color dk = new Color(46, 21, 59);
           // myAdmin = this;

            JLabel addAdm = new JLabel("Añadir");
            addAdm.setFont(font14);
            addAdm.setForeground(dk);
            add(addAdm);
            setSize(600,600);
            setVisible(true);
        }

    }


