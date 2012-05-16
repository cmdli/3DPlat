import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

public class keyinput extends Thread {//IDK If we need thread here or nor?
	Renderer r;
    public keyinput(Renderer a) throws LWJGLException{
	Keyboard.create();
	Keyboard.enableRepeatEvents(true);
	r= a;
    }
    public void run(){
	while(true){
	    Keyboard.poll();
	    while(Keyboard.next()){
		//if(Keyboard.getEventKeyState()){
		    if(Keyboard.getEventKey() == Keyboard.KEY_UP ||
		       Keyboard.getEventKey() == Keyboard.KEY_W)
//			if(Keyboard.isKeyDown(Keyboard.KEY_UP)||Keyboard.isKeyDown(Keyboard.KEY_W));
			{   
		    	float xrotrad, yrotrad;
		    	yrotrad = (r.yrot / 180 * (float)Math.PI);
		    	xrotrad = (r.xrot / 180 * (float)Math.PI); 
		    	r.xpos += (float)(Math.sin(yrotrad)) ;
		    	r.zpos -= (float)(Math.cos(yrotrad)) ;
		    	r.ypos -= (float)(Math.sin(xrotrad)) ;}
		    if(Keyboard.getEventKey() == Keyboard.KEY_DOWN ||
		       Keyboard.getEventKey() == Keyboard.KEY_S)
//		    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)||Keyboard.isKeyDown(Keyboard.KEY_S));
			{    
		    	float xrotrad, yrotrad;
		    	yrotrad = (r.yrot / 180 * (float) Math.PI);
		    	xrotrad = (r.xrot / 180 * (float) Math.PI); 
		    	r.xpos -= (float)(Math.sin(yrotrad));
		    	r.zpos += (float)(Math.cos(yrotrad)) ;
		    	r.ypos += (float)(Math.sin(xrotrad));}
		    if(Keyboard.getEventKey() == Keyboard.KEY_LEFT ||
		       Keyboard.getEventKey() == Keyboard.KEY_A)
//			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)||Keyboard.isKeyDown(Keyboard.KEY_A));
			{   r.yrot += 1;
				if (r.yrot >360) r.yrot -= 360;
				}
		    if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT ||
		       Keyboard.getEventKey() == Keyboard.KEY_D)
//		    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)||Keyboard.isKeyDown(Keyboard.KEY_D));
			{  	 r.yrot -= 1;
		    	if (r.yrot < -360) r.yrot += 360;}
		    if(Keyboard.getEventKey() == Keyboard.KEY_SEMICOLON)
			{/*EXIT*/}
		    if(Keyboard.getEventKey() == Keyboard.KEY_SPACE)       
			{/*jump?*/}
	//	}

	    }
	    
	}
    }
    
}