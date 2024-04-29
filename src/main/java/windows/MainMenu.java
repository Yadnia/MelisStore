package windows;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar{

    public static JDesktopPane desktopPane;
    public MainMenu(){

        UIManager.put("MenuItem.selectionBackground", new Color(137, 109, 150));
//        JMenuBar barOne = new JMenuBar();
        JMenu mainMenu = new JMenu("Inicio");
        JMenu secMenu = new JMenu("Herramientas");
        JMenu searchMenu = new JMenu("Buscar");

        ActionListener ctFca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Crear Factura");
            }
        };
        ActionListener outa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Salir");
            }
        };
        ActionListener logOa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Cerrar sesion");
            }
        };
        ActionListener admina = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        ActionListener sella = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        ActionListener clienta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        ActionListener prova = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        ActionListener cliSr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Buscar Cliente");
            }
        };
        ActionListener prvSr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Buscar Proveedor");
            }
        };
        ActionListener pdSr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Buscar producto");
            }
        };

        JMenuItem createFac = new JMenuItem("Crear Factura");
        createFac.setAccelerator(KeyStroke.getKeyStroke('F', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(),false));
        createFac.setBackground(new Color(46, 21, 59));
        createFac.setForeground(Color.white);
        createFac.addActionListener(ctFca);
        JMenuItem out = new JMenuItem("Salir");
        out.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(),false));
        out.setBackground(new Color(46, 21, 59));
        out.setForeground(Color.white);
        out.addActionListener(outa);
        JMenuItem logO = new JMenuItem("Cerrar sesion");
        logO.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(),false));
        logO.setBackground(new Color(46, 21, 59));
        logO.setForeground(Color.white);;
        logO.addActionListener(logOa);

        mainMenu.add(createFac);
        mainMenu.add(out);
        mainMenu.add(logO);
        mainMenu.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        mainMenu.setOpaque(false);
        mainMenu.setPreferredSize(new Dimension(100,30));

        JMenuItem admin = new JMenuItem("Administradores");
        admin.setBackground(new Color(46, 21, 59));
        admin.setForeground(Color.white);
        admin.addActionListener(admina);
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin1 = new Admin();
                desktopPane.add(admin1);
                admin1.pack();
                admin1.setSize(400,400);
                admin1.setVisible(true);

            }
//            private void AgregarAVentana(JInternalFrame ventanaInterna){
//                desktopPane.add(ventanaInterna);
//                Dimension dskSize = desktopPane.getSize();
//                Dimension frmSize = ventanaInterna.getSize();
//                ventanaInterna.setLocation(0,0);
//                ventanaInterna.setVisible(true);
//            }
        });
        JMenuItem sell = new JMenuItem("Vendedores");
        sell.setBackground(new Color(46, 21, 59));
        sell.setForeground(Color.white);
        sell.addActionListener(sella);
        JMenuItem client = new JMenuItem("Clientes");
        client.setBackground(new Color(46, 21, 59));
        client.setForeground(Color.white);
        client.addActionListener(clienta);
        JMenuItem prov = new JMenuItem("Proveedores");
        prov.setBackground(new Color(46, 21, 59));
        prov.setForeground(Color.white);
        prov.addActionListener(prova);

        secMenu.add(admin);
        secMenu.add(sell);
        secMenu.add(client);
        secMenu.add(prov);
        secMenu.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        secMenu.setOpaque(false);
        secMenu.setPreferredSize(new Dimension(200,30));

        JMenu search = new JMenu("Buscar...");

//     search.setForeground(Color.white);

        JMenuItem cSrc = new JMenuItem("Cliente");
        cSrc.setForeground(Color.white);
        cSrc.addActionListener(cliSr);
        cSrc.setBackground(new Color(46, 21, 59));
        JMenuItem pSrc = new JMenuItem("Proveedor");
        pSrc.setBackground(new Color(46, 21, 59));
        pSrc.setForeground(Color.white);
        pSrc.addActionListener(prvSr);
        JMenuItem pdRrc = new JMenuItem("Producto");
        pdRrc.setBackground(new Color(46, 21, 59));
        pdRrc.setForeground(Color.white);
        pdRrc.addActionListener(pdSr);

        search.add(cSrc);
        search.add(pSrc);
        search.add(pdRrc);
        search.setPreferredSize(new Dimension(250,30));

        searchMenu.add(search);
        searchMenu.setPreferredSize(new Dimension(300,30));


        add(mainMenu);
        add(secMenu);
        add(searchMenu);
        setOpaque(false);
        setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        setForeground(Color.white);
        setPreferredSize(new Dimension(600,30));


    }
}
