//3dplat

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class Renderer {
	float xpos = 0f;
	float ypos = 0f;
	float zpos = 0f;
	float xrot = 0f;
	float yrot = 0f;
	float angle = 0.0f;
    private static final int width = 800;
    private static final int height = 600;
    keyinput keyboard;
    public Renderer() throws Exception {
	try {
	    Display.setDisplayMode(new DisplayMode(800,600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	}
//	GL11.glViewport(0, 0, width, height);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0, 800, 0, 600, 1, -1);
	glMatrixMode(GL_MODELVIEW);
	keyboard = new keyinput(this);
	keyboard.start();

	}

    public void blit(game g) {
    	
    	System.out.print("Blitting!");

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glColor3f(0.5f,0.5f,1.0f);

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
    public void camera(){
    	glRotatef(xrot,1.0f,0.0f,0.0f);
    	glRotatef(yrot,0.0f,1.0f,0.0f);
    	glTranslated(-xpos,-ypos,-zpos);
    }

}