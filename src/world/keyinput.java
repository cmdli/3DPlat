//3dplat

public class keyinput implements KeyListener {

    boolean[] keys = new boolean[65536];

    public keyinput() {
	
    }

    public void keyPressed(KeyEvent e) {
	keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
	keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {

    }

    public boolean getKeys() {
	KeyEvent e = new KeyEvent();
	e.setKeyChar(c);
	return keys[e.getKeyCode()];
    }

}