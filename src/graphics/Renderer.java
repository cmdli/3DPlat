//3dplat

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Renderer {
    
    public Renderer() throws Exception {
	try {
	    Display.setDisplayMode(new DisplayMode(800,600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	}
 
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0, 800, 0, 800, 0, -50);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	glEnable(GL_DEPTH_TEST);
	glDepthFunc(GL_LEQUAL);
    }

    public void blit(game g) {
    	
    	System.out.print("Blitting!");

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glLoadIdentity();
	glColor3f(0.5f,0.5f,1.0f);
	glTranslatef(-400f,-400f,-25);

	world w = g.cur;

	for(Block b : w.blocks) {
	    drawBlock(b);
	}

	Display.update();
	
    }

    public void drawBlock(Block b) {
	glBegin(GL_POLYGON);

	glVertex3f(b.loc.x,b.loc.y,b.loc.z);
	glVertex3f(b.loc.x+b.size.x,b.loc.y,b.loc.z);
	glVertex3f(b.loc.x,b.loc.y,b.loc.z+b.size.z);
	glVertex3f(b.loc.x+b.size.x,b.loc.y,b.loc.z+b.size.z);

	glVertex3f(b.loc.x,b.loc.y+b.size.y,b.loc.z);
	glVertex3f(b.loc.x+b.size.x,b.loc.y+b.size.y,b.loc.z);
	glVertex3f(b.loc.x,b.loc.y+b.size.y,b.loc.z+b.size.z);
	glVertex3f(b.loc.x+b.size.x,b.loc.y+b.size.y,b.loc.z+b.size.z);

	glEnd();
    }

    public void close() {
	Display.destroy();
    }

}