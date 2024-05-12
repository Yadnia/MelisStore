package forms;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Factura extends JInternalFrame {

    static Factura myFactura;

    private Factura(){
        super("Factura", true, true, true,true);
        InicializarFac();
        myFactura = this;

    }

    private void InicializarFac(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(750,600));
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(new BorderLayout());
        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20= new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255,179,2);
        Color dk = new Color(46, 21, 59);
        MatteBorder border = new MatteBorder(0,0,1,0,Color.WHITE);


        //PANEL
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(dk);

        //LABELS Y TEXTFIELDS
        JLabel prod = new JLabel("Producto");
        prod.setFont(font14);
        prod.setForeground(yell);
        JLabel sell = new JLabel("Vendedor");
        sell.setFont(font14);
        sell.setForeground(yell);
        JLabel client = new JLabel("Cliente");
        client.setFont(font14);
        client.setForeground(yell);

        JTextField prodTxt = new JTextField();
        prodTxt.setColumns(10);
        prodTxt.setOpaque(false);
        prodTxt.setBorder(border);
        prodTxt.setFont(font12);
        JTextField sellTxt = new JTextField();
        sellTxt.setColumns(10);
        sellTxt.setOpaque(false);
        sellTxt.setBorder(border);
        sellTxt.setFont(font12);
        JTextField clientTxt = new JTextField();
        clientTxt.setColumns(10);
        clientTxt.setOpaque(false);
        clientTxt.setBorder(border);
        clientTxt.setFont(font12);

        //BOTONES
        JButton create = new JButton("Crear");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(prod, gbc);
        gbc.gridx = 1;
        panel1.add(prodTxt,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(sell, gbc);
        gbc.gridx = 1;
        panel1.add(sellTxt,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(client, gbc);
        gbc.gridx = 1;
        panel1.add(clientTxt,gbc);  gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(prod, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(create,gbc);

        add(panel1, BorderLayout.CENTER);

    }
    public static Factura getInstancia (){
        return null == myFactura ? (new Factura()): myFactura;
    }
}
