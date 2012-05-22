//3dplat

package world;

import org.lwjgl.input.Keyboard;
import world.vector;
import world.entity;
        
public class player extends entity {

    public static final float G = -9.8f;
    public static final float WALK_Z = 0.1f;
    public static final float ROT_SPEED = 0.1f;
    
    public vector loc = new vector();
    public vector vel = new vector();
    public vector acc = new vector();
    public vector rot = new vector();


    public player() {
	
    }
    
    public void tick(game g, double time, Input in) {
        
        vel.reset();
        
        if(in.keys[Keyboard.KEY_W]) {
            vel.z = WALK_Z;
            System.out.println('w');
        }
        if(in.keys[Keyboard.KEY_D]) {
            rot.x = rot.z = rot.x + ROT_SPEED;
            System.out.println('d');
        }
        if(in.keys[Keyboard.KEY_S]) {
            vel.z = -WALK_Z;
        }
        
        rotate(vel,rot);
        
        vectorAcc(loc,vel,time);
    }

}