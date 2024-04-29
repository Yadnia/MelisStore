package windows;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel {

    public TablePanel(){
        setBounds(50, 350,630,350);
        setBackground(new Color(113, 66, 190));
        Font fuente12 = new Font("Outfit SemiBold", Font.BOLD,12);
        Font fuente14 = new Font("Outfit SemiBold", Font.BOLD,14);

        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Admins");
        model1.addColumn("Vendedores");
        model1.addColumn("Proveedores");
        model1.addColumn("Productos");


        model1.addRow(new Object[]{"Hola"});
        JTable table1 = new JTable(model1);
        table1.setBackground(new Color(184, 172, 217));
        table1.setSelectionBackground(new Color(113,66,190,30));
        table1.getTableHeader().setBackground(new Color(46, 21, 59));
        table1.getTableHeader().setForeground(Color.white);
        table1.getTableHeader().setFont(fuente14);
        table1.setFont(fuente12);


        JScrollPane scrollPane = new JScrollPane(table1);

        scrollPane.setPreferredSize(new Dimension(600,300));;
        add(scrollPane);

    }
}
