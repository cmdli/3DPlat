//3dplat

public class main {

    boolean running;

    public main() {
	running = true;
    }

    public void start() {
	while(!Display.isCloseRequested()) {
	    g.tick();
	}
	g.close();
    }

    public static void main(String[] args) {
	main m = new main();
	m.start();
    }

}