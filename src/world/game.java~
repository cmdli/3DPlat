//3dplat

public class game {

    world cur;
    double oldTick;
    player pl;
    keyinput keyin;
    Renderer scr;

    public game() {
	cur = new world();
	pl = new player();
	scr = new Renderer();
<<<<<<< HEAD
=======
	cur.loadFromFile("world.txt");
>>>>>>> de219aef0f8d0f65c18022ba057f8d3f1c89c5dc
    }

    public void tick() {
	
	double time = getTime();
	if(time - oldTick < /*MAGIC NUMBER*/0.05/*MAGIC NUMBER*/)
	    return;
	oldTick = getTime();

	scr.blit(this);

    }

    public double getTime() {
	return System.nanoTime()/1000000000.0;
    }

    public boolean getKey(char c) {
	return keyin.getKey(c);
    }

}