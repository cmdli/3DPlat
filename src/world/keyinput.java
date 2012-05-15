import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

public class keyinput extends Thread {//IDK If we need thread here or nor?

    public keyinput() throws LWJGLException{
	Keyboard.create();
	Keyboard.enableRepeatEvents(true);
    }
    public void run(){
	while(true){
	    Keyboard.poll();
	    while(Keyboard.next()){
		if(Keyboard.getEventKeyState()){
		    if(Keyboard.getEventKey() == Keyboard.KEY_UP ||
		       Keyboard.getEventKey() == Keyboard.KEY_W)
			{/*move forward*/}
		    if(Keyboard.getEventKey() == Keyboard.KEY_DOWN ||
		       Keyboard.getEventKey() == Keyboard.KEY_S)
			{/*move BACK*/}
		    if(Keyboard.getEventKey() == Keyboard.KEY_LEFT ||
		       Keyboard.getEventKey() == Keyboard.KEY_A)
			{/*move LEFT*/}
		    if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT ||
		       Keyboard.getEventKey() == Keyboard.KEY_D)
			{/*Move Right*/}
		    if(Keyboard.getEventKey() == Keyboard.KEY_SEMICOLON)
			{/*EXIT*/}
		    if(Keyboard.getEventKey() == Keyboard.KEY_SPACE)       
			{/*jump?*/}
		}

	    }
	    
	}
    }
    
}