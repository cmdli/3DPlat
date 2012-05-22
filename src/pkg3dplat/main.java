package pkg3dplat;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import world.game;

//3dplat

public class main {

    boolean running;
    game g;

    public main() throws LWJGLException {
	running = true;
	g = new game();
    }

    public void start() {
	while(!Display.isCloseRequested()) {
	    g.tick();
	}
	g.close();
    }

    public static void main(String[] args) throws LWJGLException {
	main m = new main();
	m.start();
    }

}