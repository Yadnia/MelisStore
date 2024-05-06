package forms;

import javax.swing.*;
import java.awt.*;

public class Factura extends JInternalFrame {

    static Factura myFactura;

    private Factura(){
        super("Factura", true, true, true);
        InicializarFac();
        myFactura = this;

    }

    private void InicializarFac(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(screen.width-800, screen.height-100));
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(new BorderLayout());
        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20= new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255,179,2);
        Color dk = new Color(46, 21, 59);



    }
    public static Factura getInstancia (){
        return null == myFactura ? (new Factura()): myFactura;
    }
}
