package windows;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.Yaed.entity.*;
import org.Yaed.services.GenericServiceImpl;
import org.Yaed.services.IGenericService;
import org.Yaed.util.HibernateUtil;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class temporalVentas extends JFrame {

    public temporalVentas(){
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(new Dimension(500,500));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cliente");
        model.addColumn("Vendedor");
        model.addColumn("Id productos");
        model.addColumn("Monto");
        model.addColumn("Fecha");

        JTable tablaVentas = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tablaVentas);
        add(scrollPane, BorderLayout.CENTER);
        JButton refresh = new JButton("Refrescar");
        refresh.setPreferredSize(new Dimension(50, 20));
        refresh.setOpaque(false);
        refresh.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        add(refresh, BorderLayout.SOUTH);
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRows(model);
            }
        });
        setVisible(true);
    }
    private static void addRows(DefaultTableModel model)
    {
        model.setRowCount(0);
        List<Ventas> ventas = getVentas();
        for (Ventas venta : ventas){
            Cliente cliente = venta.getCliente();
            int id_cliente = cliente.getClientId();
            Vendedor vendedor = venta.getVendedor();
//            String id_vendedor = vendedor.getUserEmail();
            String nombre_Vendedor = vendedor.getNames();
            List<Long> producto = venta.getProductos();
            float monto = venta.getMonto();
            LocalDate fecha = venta.getFecha();
            model.addRow(new Object[]{id_cliente,nombre_Vendedor,producto,monto,fecha});
        }
    }
        private static List <Ventas> getVentas(){
        List<Ventas> ventas = new ArrayList<>();
        IGenericService<Ventas> ventasService = new GenericServiceImpl<>(Ventas.class, HibernateUtil.getSessionFactory());
        ventas = ventasService.getAll();
        return ventas;
    }

}
