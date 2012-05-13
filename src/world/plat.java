import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class plat extends JFrame
{
    public plat()
    {
	super("3DPlAT");
	Container c = getContentPane();
	c.setLayout(new BoarderLayout());
	Wrap3DPlat w3d = new Wrap3DPlat();
	c.add(w3d,BoarderLayout.CENTER);

	setDefaultCloseOperation(JFrame.Exit_ON_CLOSE );
	pack();
	setResisable(false);
	setVisible(true);
    }
    public static void main(String[] args)
    { new plat();}
}
