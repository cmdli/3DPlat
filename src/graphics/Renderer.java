//3dplat

package graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import world.world;
import world.player;
import world.entity;
import world.game;
import world.vector;
import world.Block;

public class Renderer {
    public static final boolean resizable = false;
    public static float zNear = 0.001f;
    public static float zFar = 20f;
    public static final int gridSize = 10;
    public static final float tileSize = 0.20f;
    public static final boolean fullscreen = false;
    public static int walkingSpeed = 10;
    public static int mouseSpeed = 2;
    public static final int maxLookUp = 85;
    public static final int maxLookDown = -85;
    public static final float ceilingHeight = 10;
    public static final float floorHeight = -1;
    public static int fov = 68;
    private static long lastFrame;
    private int floorTexture;
    private int floorDisplayList;
    private int objectDisplayList;
    private world w;
    
    public Renderer(game g) throws Exception {
            try {
                Display.setResizable(resizable);
                Display.setDisplayMode(new DisplayMode(800, 600));
                Display.setTitle("3DPlat!");
                Display.create();
            } catch (LWJGLException ex) {
                System.err.println("Display initialization failed.");
                System.exit(1);
            }
            
            w = g.cur;

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glLoadIdentity();
            glColor3f(0.5f,0.5f,1.0f);
            glTranslatef(-400f,-400f,-25);
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            gluPerspective(fov, (float) Display.getWidth() / (float) Display.getHeight(), zNear, zFar);
            
            glMatrixMode(GL_MODELVIEW);
            glLoadIdentity();
            glEnable(GL_DEPTH_TEST);
            glEnable(GL_TEXTURE_2D);
            glEnable(GL_BLEND);
            glEnable(GL_ALPHA_TEST);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
            glEnable(GL_CULL_FACE);
            glCullFace(GL_BACK);

            
            objectDisplayList = glGenLists(1);
                
            glNewList(objectDisplayList, GL_COMPILE);
            
                
                glColor4f(0.5f, 0.5f, 0.5f, 1); 
                Block b = new Block();
                b.loc.x = -5f;
                b.loc.y = -5f;
                b.loc.z = 5f;
                b.size.x = 5f;
                b.size.y = 5f;
                b.size.z = 5f;
                drawBlock(b);

            glEndList();

            getDelta();
  
	}
    private static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
    private static int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }

    public void blit(game g) {
    	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        int delta = getDelta();
        glBindTexture(GL_TEXTURE_2D, floorTexture);

        glEnable(GL_CULL_FACE);
        glDisable(GL_DEPTH_TEST);
        glCallList(floorDisplayList);
        glEnable(GL_DEPTH_TEST);
        glDisable(GL_CULL_FACE);
        glBindTexture(GL_TEXTURE_2D, 0);
        glCallList(objectDisplayList);

        glLoadIdentity();
        //camera transformations
        glRotatef(g.pl.rot.x, 1, 0, 0);
        glRotatef(g.pl.rot.z, 0, 0, 1);
        glTranslatef(g.pl.loc.x, g.pl.loc.y, g.pl.loc.z); 
        System.out.print(g.pl.loc.x + " " + g.pl.loc.y + " " + g.pl.loc.z + "\n");
        
        //end keyboard
        Display.update();
    }


    public void drawBlock(Block b) {
	glBegin(GL_QUADS);
		vector center = new vector(b.loc.x,b.loc.y,b.loc.z);
		float frontz = center.z+b.size.z/2;
		float leftx = center.x-b.size.x/2;
		float rightx = center.x+b.size.x/2;
		float topy = center.y+b.size.y;
		float bottomy = center.y;
		float backz = center.z - b.size.z/2;
		//base
			glVertex3f(leftx,bottomy,frontz);
			glVertex3f(leftx,bottomy,backz);
			glVertex3f(rightx,bottomy,backz);
			glVertex3f(rightx,bottomy,frontz);
		//end base
		//front
			glVertex3f(leftx, bottomy,frontz);
			glVertex3f(leftx, topy        ,frontz);
			glVertex3f(rightx,topy  ,frontz);
			glVertex3f(rightx, bottomy  ,frontz);
		//end front
		//back
			glVertex3f(leftx, bottomy,backz);
			glVertex3f(leftx, topy        ,backz);
			glVertex3f(rightx,topy  ,backz);
			glVertex3f(rightx, bottomy  ,backz);
		//back ends
		//left side
			glVertex3f(leftx,bottomy,frontz);
			glVertex3f(leftx,topy,frontz);
			glVertex3f(leftx,topy,backz);
			glVertex3f(leftx,bottomy,backz);
		//left ends
		//right
			glVertex3f(rightx,bottomy,frontz);
			glVertex3f(rightx,topy,frontz);
			glVertex3f(rightx,topy,backz);
			glVertex3f(rightx,bottomy,backz);
		//right ends
		//top
			glVertex3f(leftx,topy,frontz);
			glVertex3f(leftx,topy,backz);
			glVertex3f(rightx,topy,backz);
			glVertex3f(rightx,topy,frontz);
		//bottom ends
	glEnd();
    }

    public void close() {
        Display.destroy();
        System.exit(0);
    }

    
}

  
;
