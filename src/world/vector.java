//3dplat

package world;

public class vector {

    public float x = 0f;
    public float y = 0f;
    public float z = 0f;
    
    public vector(float xa, float ya, float za){
    	x = xa;
    	y = ya;
    	z = za;
    }
    public vector(){}
    
    public void reset() {
        x = 0f;
        y = 0f;
        z = 0f;
    }
}