
package Forms;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Admin extends JInternalFrame {

    static Admin myAdmin;


    private Admin(){
        super("Client", true, true,true);
        inicializarCliente ();
        myAdmin = this;
    }

    private void inicializarCliente(){
        setToolTipText("Datos del cliente");
        setOpaque(true);
        setBorder(new LineBorder(new Color(0,0,0)));
        setIconifiable(false);

        JLabel text = new JLabel("Cliente");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        panel.setBorder(BorderFactory.createTitledBorder(null, "Clientes",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                null,Color.black));
        panel.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(text);
        setName("Cliente");
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().setPreferredSize(new Dimension(800,400));
        pack();
    }

    public static Admin getInstancia(){
        return null == myAdmin ? (new Admin()) : myAdmin;
    }
}
