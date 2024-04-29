package Forms;

import windows.Jtrial;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultTextUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductNormal extends JFrame {

    public ProductNormal(){
        setTitle("Productos Melis");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(screen.width-800, screen.height-100));
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(null);


        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20= new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255,179,2);
        Color dk = new Color(46, 21, 59);

        JLabel title = new JLabel("Productos en almacen");
        title.setForeground(yell);
        title.setFont(font20);
        title.setBounds(30,20,400,40);

        JLabel nameA = new JLabel("Descripcion:");
        nameA.setForeground(yell);
        nameA.setFont(font12);
        nameA.setBounds(30,90,100,30);

        JLabel apeA = new JLabel("Color:");
        apeA.setForeground(yell);
        apeA.setFont(font12);
        apeA.setBounds(30,150,100,30);

        JLabel cedA = new JLabel("Codigo:");
        cedA.setForeground(yell);
        cedA.setFont(font12);
        cedA.setBounds(30,200,100,30);

        JLabel catA = new JLabel("Categoria:");
        catA.setForeground(yell);
        catA.setFont(font12);
        catA.setBounds(30,200,100,30);

        JLabel sizeA = new JLabel("Talla:");
        sizeA.setForeground(yell);
        sizeA.setFont(font12);
        sizeA.setBounds(30,200,100,30);

        JTextField namTxt = new JTextField();
        namTxt.setOpaque(false);
        namTxt.setBorder(new MatteBorder(0,0,1,0,yell));
        namTxt.setBounds(100,90, 200,30);
        namTxt.setForeground(yell);
        namTxt.setFont(font12);

        JTextField apetxt = new JTextField();
        apetxt.setOpaque(false);
        apetxt.setBorder(new MatteBorder(0,0,1,0,yell));
        apetxt.setBounds(100,150, 200,30);
        apetxt.setForeground(yell);
        apetxt.setFont(font12);

        JTextField cedtxt = new JTextField();
        cedtxt.setOpaque(false);
        cedtxt.setBorder(new MatteBorder(0,0,1,0,yell));
        cedtxt.setBounds(100,200, 200,30);
        cedtxt.setForeground(yell);
        cedtxt.setFont(font12);

        JButton addBtt = new JButton("Agregar");
        addBtt.setText("Agregar Producto");
        addBtt.setOpaque(false);
        addBtt.setFont(font14);
        addBtt.setForeground(yell);
        addBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
//        addBtt.setPreferredSize(new Dimension(300,40));
        addBtt.setBounds(300,100,200,40);
        JButton delBtt = new JButton("Eliminar");
        delBtt.setText("Restar Producto");
        delBtt.setOpaque(false);
        delBtt.setFont(font14);
        delBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
//        addBtt.setPreferredSize(new Dimension(300,40));
        delBtt.setBounds(300,170,200,40);

        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Descripcion");
        model1.addColumn("Color");
        model1.addColumn("Codigo");
        model1.addColumn("Talla");
        JTable table1 = new JTable(model1);
        table1.getTableHeader().setBackground(dk);
        table1.getTableHeader().setForeground(yell);
        table1.getTableHeader().setFont(font14);
        table1.setBackground(yell);
        table1.setForeground(dk);
        table1.setFont(font12);
        table1.setSelectionBackground(new Color(141, 98, 220));

        JScrollPane scrollPane = new JScrollPane(table1);
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(30,300,500,700);
        tablePanel.setBackground(yell);
        tablePanel.add(scrollPane);

        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namTxt.getText();
                String lastN = apetxt.getText();
                String cd = cedtxt.getText();

                model1.addRow(new Object[]{name,lastN,cd});
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = table1.getSelectedRow();
                model1.removeRow(num);
            }
        });

        add(tablePanel);
        add(title);
        add(nameA);
        add(namTxt);
        add(apeA);
        add(apetxt);
        add(cedA);
        add(cedtxt);
        add(addBtt);
        add(delBtt);
        setVisible(true);

    }


}
