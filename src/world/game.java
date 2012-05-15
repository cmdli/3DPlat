import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

//3dplat

public class game {

    world cur;
    double oldTick;
    player pl;
    keyinput keyin;
    Renderer scr;

    public game() throws LWJGLException {
	cur = new world();
	cur.loadFromFile("world.txt");
	pl = new player();
	try {
		scr = new Renderer();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    }

    public void tick() {
	
	double time = getTime();
	if(time - oldTick < /*MAGIC NUMBER*/0.05/*MAGIC NUMBER*/)
	    return;
	oldTick = getTime();

	
	

	scr.blit(this);

    }

    public void close() {
	scr.close();
    }

    public double getTime() {
	return System.nanoTime()/1000000000.0;
    }

    /*public boolean getKey(char c) {
	return getKey(c);
    }*/

}