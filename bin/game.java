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
	cur.loadFromFile("world.txt");
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

    public Keys getKeys() {
	return keyin.getKeys();
    }

}