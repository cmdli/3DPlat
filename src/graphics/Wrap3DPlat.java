import javax.swing.*;
import java.awt.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Wrap3DPlat extends JPanel
{
    //declarations
    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static final int BOUNDSIZE = 100;
    private SimpleUniverse su;
    private BranchGroup BG;
    private BoundingSphere bounds;

    public Wrap3DPlat(){
	setLayout( new BoarderLayout() );
	setOpaque( false );
	setPreferredSize( new Dimension(WIDTH,HEIGHT));
	GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
	Canvas3D canvas3D = new Canvas3D(config);
	add("Center",canvas3D);
	canvas3D.setFocusable(true);
	canvas3D.requestFocus(); //allow key input
	su = new SimpleUniverse(canvas3D);
	createSceneGraph();
	su.addBranchGraph( BG );
    }
    public void createSceneGraph(){
	BG = new BranchGroup();
	bounds = new BoundingSphere(new Point3d(0,0,0), BOUNDSIZE);
	//lightScene();
	addBackground();
	//addFloor
	BG.addChild( new Floor().getBG() );

	//addStuffBELOW
	//BG.addChild( Shape3D );
	initUserControls();
	BG.compile();
    }
    //if we want lights 
    // private void lightScene(){
    //}
    private void addBackground(){
    }
    private void initUserCongrols(){
    }
}
