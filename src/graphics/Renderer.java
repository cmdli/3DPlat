//3dplat

<<<<<<< HEAD
import static org.lwjgl.opengl.GL11.*;
=======
import static org.lwjgl.opengl.GL11.GL_ALPHA_TEST;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PERSPECTIVE_CORRECTION_HINT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glNewList;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3d;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.util.glu.GLU.gluPerspective;

>>>>>>> 070756cd7ee2a824071d11d1ad7d41c4bca3f587
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector3f;

public class Renderer {
	public static final boolean resizable = false;
	public static Vector3f position = new Vector3f(0, 0, 0);
	public static Vector3f rotation = new Vector3f(0, 0, 0);
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
 
<<<<<<< HEAD
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0, 800, 0, 800, 0, -50);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	glEnable(GL_DEPTH_TEST);
	glDepthFunc(GL_LEQUAL);
=======
        Display.setTitle("3DPlat!");
        Display.create();
    } catch (LWJGLException ex) {
        System.err.println("Display initialization failed.");
        System.exit(1);
>>>>>>> 070756cd7ee2a824071d11d1ad7d41c4bca3f587
    }

	Mouse.setGrabbed(true);
	w = g.cur;
    

<<<<<<< HEAD
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glLoadIdentity();
	glColor3f(0.5f,0.5f,1.0f);
	glTranslatef(-400f,-400f,-25);
=======
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
    floorTexture = glGenTextures();
>>>>>>> 070756cd7ee2a824071d11d1ad7d41c4bca3f587

   	floorDisplayList = glGenLists(1);
   		glNewList(floorDisplayList, GL_COMPILE);
   		glBegin(GL_QUADS);
   			glTexCoord2f(0, 0);
   			glVertex3f(-gridSize, floorHeight, -gridSize);
   			glTexCoord2f(0, gridSize * 10 * tileSize);
   			glVertex3f(-gridSize, floorHeight, gridSize);
   			glTexCoord2f(gridSize * 10 * tileSize, gridSize * 10 * tileSize);
   			glVertex3f(gridSize, floorHeight, gridSize);
   			glTexCoord2f(gridSize * 10 * tileSize, 0);
   			glVertex3f(gridSize, floorHeight, -gridSize);
   		glEnd();
   		glEndList();
    objectDisplayList = glGenLists(1);
    	glNewList(objectDisplayList, GL_COMPILE);
    
    	{
    		double topPoint = 0.75;
    		glBegin(GL_TRIANGLES);
    			glColor4f(1, 1, 0, 1f);
    			glVertex3d(0, topPoint, -5);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(-1, -0.75, -4);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(1, -.75, -4);

    			glColor4f(1, 1, 0, 1f);
    			glVertex3d(0, topPoint, -5);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(1, -0.75, -4);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(1, -0.75, -6);

    			glColor4f(1, 1, 0, 1f);
    			glVertex3d(0, topPoint, -5);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(1, -0.75, -6);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(-1, -.75, -6);
        
    			glColor4f(1, 1, 0, 1f);
    			glVertex3d(0, topPoint, -5);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(-1, -0.75, -6);
    			glColor4f(0, 0, 1, 1f);
    			glVertex3d(-1, -.75, -4);
        
    		glEnd();
    		glColor4f(1, 1, 1, 1); 
    		glColor3f(0.5f,0.5f,1.0f);
    		for(Block b : w.blocks){
    			drawBlock(b);
    		}
    		glColor4f(1, 1, 1, 1); 
    	}

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
        glRotatef(rotation.x, 1, 0, 0);
        glRotatef(rotation.y, 0, 1, 0);
        glRotatef(rotation.z, 0, 0, 1);
        glTranslatef(position.x, position.y, position.z); //end camera
        //mouse actions
        if (Mouse.isGrabbed()) {
            float mouseDX = Mouse.getDX() * mouseSpeed * 0.16f;
            float mouseDY = Mouse.getDY() * mouseSpeed * 0.16f;
            if (rotation.y + mouseDX >= 360) {
                rotation.y = rotation.y + mouseDX - 360;
            } else if (rotation.y + mouseDX < 0) {
                rotation.y = 360 - rotation.y + mouseDX;
            } else {
                rotation.y += mouseDX;
            }
            if (rotation.x - mouseDY >= maxLookDown && rotation.x - mouseDY <= maxLookUp) {
                rotation.x += -mouseDY;
            } else if (rotation.x - mouseDY < maxLookDown) {
                rotation.x = maxLookDown;
            } else if (rotation.x - mouseDY > maxLookUp) {
                rotation.x = maxLookUp;
            }
        }//end mouse
        //keyboard
        boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W);
        boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S);
        boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A);
        boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D);
        boolean flyUp = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
        boolean flyDown = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);




        if (keyUp && keyRight && !keyLeft && !keyDown) {
            float angle = rotation.y + 45;
            Vector3f newPosition = new Vector3f(position);
            float dist = (walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyUp && keyLeft && !keyRight && !keyDown) {
            float angle = rotation.y - 45;
            Vector3f newPosition = new Vector3f(position);
            float dist = (walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyUp && !keyLeft && !keyRight && !keyDown) {
            float angle = rotation.y;
            Vector3f newPosition = new Vector3f(position);
            float dist = (walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyDown && keyLeft && !keyRight && !keyUp) {
            float angle = rotation.y - 135;
            Vector3f newPosition = new Vector3f(position);
            float dist = (walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyDown && keyRight && !keyLeft && !keyUp) {
            float angle = rotation.y + 135;
            Vector3f newPosition = new Vector3f(position);
            float dist = (walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyDown && !keyUp && !keyLeft && !keyRight) {
            float angle = rotation.y;
            Vector3f newPosition = new Vector3f(position);
            float dist = -(walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyLeft && !keyRight && !keyUp && !keyDown) {
            float angle = rotation.y - 90;
            Vector3f newPosition = new Vector3f(position);
            float dist = (walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (keyRight && !keyLeft && !keyUp && !keyDown) {
            float angle = rotation.y + 90;
            Vector3f newPosition = new Vector3f(position);
            float dist = (walkingSpeed * 0.0002f) * delta;
            float a = dist * (float) Math.cos(Math.toRadians(angle));
            float o = (float) (Math.sin(Math.toRadians(angle)) * dist);
            newPosition.z += a;
            newPosition.x -= o;
            position.z = newPosition.z;
            position.x = newPosition.x;
        }
        if (flyUp) {
            double newPositionY = (walkingSpeed * 0.0002) * delta;
            position.y -= newPositionY;
        }
        if (flyDown) {
            double newPositionY = (walkingSpeed * 0.0002) * delta;
            position.y += newPositionY;
        }

        while (Mouse.next()) {
            if (Mouse.isButtonDown(0)) {
                Mouse.setGrabbed(true);
            }
            if (Mouse.isButtonDown(1)) {
                Mouse.setGrabbed(false);
            }

        }
        while (Keyboard.next()) {

           if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            	close();
            }
        }
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
