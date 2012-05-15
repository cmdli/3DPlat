import org.lwjgl.input.Keyboard;

public class keyinput extends Thread {

    public keyinput(){
	create();
	enableRepeatEvents(true);
    }
    public void run(){
	while(true){
	    poll();
	    if(isKeyDown(KEY_UP)    || isKeyDown(KEY_W)){/* move forward*/}
	    if(isKeyDown(KEY_DOWN)   || isKeyDown(KEY_S)){/*move backwards*/}
	    if(isKeyDown(Key_LEFT)  || isKeyDown(KEY_A)){/*turn left*/}
	    if(isKeyDown(Key_RIGHT) || isKeyDown(KEY_F)){/*turn right*/}
            if(isKeyDown(Key_SEMICOLON))                
		{/*CLOSE GAME*/
		destroy();
		break;
		}

	}
    }

}