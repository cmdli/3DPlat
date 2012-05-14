//3dplat

public class main {

    boolean running;
    game g;

    public main() {
	running = true;
	g = new game();
    }

    public void start() {
	while(running) {
	    g.tick();
	    System.out.print("Hi!");
	}
    }

    public static void main(String[] args) {
	main m = new main();
	m.start();
    }

}