//3dplat

package world;

import org.lwjgl.LWJGLException;
import world.player;
import world.world;
import graphics.Renderer;

public class game {

    public world cur;
    public double oldTick;
    public player pl;
    Input in;
 
    Renderer scr;

    public game() throws LWJGLException {
	cur = new world();
	//cur.loadFromFile("world.txt");
	pl = new player();
	try {
		scr = new Renderer(this);
	} catch (Exception e) {
		e.printStackTrace();
	}
        in = new Input();
	
    }

    public void tick() {
	double time = getTime(0);
	if(time - oldTick < /*MAGIC NUMBER*/0.05/*MAGIC NUMBER*/)
	    return;
	oldTick = getTime(0);

        in.update();

        pl.tick(this, time, in);
	

	scr.blit(this);
	
    }

    public void close() {
	scr.close();
        in.close();
    }

    public static double getTime(int hi) {
	return System.nanoTime()/1000000000.0;
    }
    
}