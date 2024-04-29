package windows;

import Forms.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class mainPage extends JFrame {

    JFrame mainFrame = new JFrame();
    public static JDesktopPane desktopPane;

    public mainPage(){


        //pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Melis Store");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(screen.width-800, screen.height-100));
       setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(null);

        //titulo
        JLabel label1 = new JLabel();
        label1.setText("Bienvenido a Melis Store");
        //label1.setSize(800,250);
        label1.setFont(new Font("Outfit ExtraBold",Font.BOLD,40));
        label1.setForeground(new Color(255, 179, 2));
        label1.setBounds(125,30,800,50);
        add(label1);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(65,100,600,200);
        mainPanel.setBackground(new Color(137, 109, 150));

        UIManager.put("MenuItem.selectionBackground", new Color(137, 109, 150));
       JMenuBar barOne = new JMenuBar();
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
        admin.addActionListener(admina); //-----------------------------------------------------------------------------------
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               desktopPane = new JDesktopPane();
               Admin admin1 = new Admin();
               desktopPane.add(admin1);
               admin1.setVisible(true);
               add(desktopPane);
              // new AdminNormal();
               new Admin();

            }
            private void AgregarAVentana(JInternalFrame ventanaInterna){
                desktopPane.add(ventanaInterna);
                Dimension dskSize = desktopPane.getSize();
                Dimension frmSize = ventanaInterna.getSize();
                ventanaInterna.setLocation(0,0);
                ventanaInterna.setVisible(true);
            }
        });
        JMenuItem sell = new JMenuItem("Vendedores");
        sell.setBackground(new Color(46, 21, 59));
        sell.setForeground(Color.white);
        sell.addActionListener(sella);
        sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SellNormal();
            }
        });
        JMenuItem client = new JMenuItem("Clientes");
        client.setBackground(new Color(46, 21, 59));
        client.setForeground(Color.white);
        client.addActionListener(clienta);
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientNormal();
            }
        });
        JMenuItem prov = new JMenuItem("Productos");
        prov.setBackground(new Color(46, 21, 59));
        prov.setForeground(Color.white);
        prov.addActionListener(prova);
        prov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductNormal();
            }
        });

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
        JMenuItem pdRrc = new JMenuItem("Producto");
        pdRrc.setBackground(new Color(46, 21, 59));
        pdRrc.setForeground(Color.white);
        pdRrc.addActionListener(pdSr);

        search.add(cSrc);
        search.add(pdRrc);
        search.setPreferredSize(new Dimension(250,30));

        searchMenu.add(search);
        searchMenu.setPreferredSize(new Dimension(300,30));


        barOne.add(mainMenu);
        barOne.add(secMenu);
        barOne.add(searchMenu);
        barOne.setOpaque(false);
        barOne.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        setForeground(Color.white);
        setPreferredSize(new Dimension(600,30));

//        JTextField txt1 = new JTextField();
//        txt1.setBackground(Color.cyan);
//       txt1.setPreferredSize(new Dimension(200,30));
//       txt1.setBorder(new MatteBorder(0,0,2,0, Color.white));
//       txt1.setOpaque(false);
//
//        mainPanel.add(txt1);

        JToolBar bar = new JToolBar();
        URL redoIconu =mainPage.class.getResource("/redo.png");
        URL undoIconu = mainPage.class.getResource("/undo.png");
        URL scanIconu = mainPage.class.getResource("/scan.png");
        ImageIcon undoIconb = new ImageIcon(undoIconu);
        ImageIcon redoIconb = new ImageIcon(redoIconu);
        ImageIcon scanIconb = new ImageIcon(scanIconu);

        Image im1 = undoIconb.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        Image im2 = redoIconb.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        Image im3 = scanIconb.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);

        ImageIcon undoIcon = new ImageIcon(im1);
        ImageIcon redoIcon = new ImageIcon(im2);
        ImageIcon scanIcon = new ImageIcon(im3);

        ToolbarAction undo = new ToolbarAction("Undo", undoIcon, "Deshacer", 'Z');
        ToolbarAction redo = new ToolbarAction("Redo", redoIcon, "Rehacer", 'x');
        ToolbarAction scan = new ToolbarAction("Escanear", scanIcon, "Escanear producto", 's');

        bar.add(undo);
        bar.add(redo);
        bar.add(scan);
        bar.setPreferredSize(new Dimension(200,30));
        bar.setBounds(100,100,200,30);
        bar.setOpaque(false);

        add(mainPanel);
        TablePanel tablePanel= new TablePanel();
        add(tablePanel);

        //MainMenu menu = new MainMenu();
        mainPanel.add(barOne);
        mainPanel.add(bar);


        setVisible(true);

    }
    class ToolbarAction extends AbstractAction{

        public ToolbarAction(String text, Icon icon, String description, char acelerator){
            super(text, icon);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(acelerator, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
            putValue(SHORT_DESCRIPTION, description);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
               JOptionPane.showMessageDialog(null,"Accion "+getValue(NAME)+"realizada") ;
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }

//        @Override
//        public boolean accept(Object sender) {
//            return super.accept(sender);
//
//        }

    }
}
