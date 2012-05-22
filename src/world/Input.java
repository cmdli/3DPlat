//3dplat
package world;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {
    public boolean[] keys = new boolean[65536];
    public double mx = 0.0;
    public double my = 0.0;
    
    
    public Input() throws LWJGLException {
        Keyboard.create();
        Mouse.create();
    }
    
    public void close() {
        Keyboard.destroy();
        Mouse.destroy();
    }
    
    public void update() {
        
        mx = Mouse.getX();
        my = Mouse.getY();
        
        while(Keyboard.next()) {
            keys[Keyboard.getEventKey()] = Keyboard.getEventKeyState();
        }
    }
}
