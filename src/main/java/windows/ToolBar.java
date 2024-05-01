package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class ToolBar extends JToolBar{
    public ToolBar(){
        JToolBar bar = new JToolBar();
        URL redoIconu = mainPage.class.getResource("/redo.png");
        URL undoIconu = mainPage.class.getResource("/undo.png");
        URL scanIconu = mainPage.class.getResource("/scan.png");
        ImageIcon undoIconb = new ImageIcon(undoIconu);
        ImageIcon redoIconb = new ImageIcon(redoIconu);
        ImageIcon scanIconb = new ImageIcon(scanIconu);

        Image im1 = undoIconb.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image im2 = redoIconb.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image im3 = scanIconb.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        ImageIcon undoIcon = new ImageIcon(im1);
        ImageIcon redoIcon = new ImageIcon(im2);
        ImageIcon scanIcon = new ImageIcon(im3);


        ToolBar.ToolbarAction undo = new ToolBar.ToolbarAction("Undo", undoIcon, "Deshacer", 'Z');
        ToolBar.ToolbarAction redo = new ToolBar.ToolbarAction("Redo", redoIcon, "Rehacer", 'x');
        ToolBar.ToolbarAction scan = new ToolBar.ToolbarAction("Escanear", scanIcon, "Escanear producto", 's');

        add(undo);
        add(redo);
        add(scan);
        setPreferredSize(new Dimension(200, 30));
        setBounds(100, 100, 200, 30);
        setOpaque(false);

    }
    class ToolbarAction extends AbstractAction {

        public ToolbarAction(String text, Icon icon, String description, char acelerator) {
            super(text, icon);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(acelerator, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
            putValue(SHORT_DESCRIPTION, description);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                JOptionPane.showMessageDialog(null, "Accion " + getValue(NAME) + "realizada");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
