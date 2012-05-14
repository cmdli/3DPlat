//3dplat

public class game {

    world cur;
    double oldTick;
    player pl;
    keyinput keyin;

    public game() {
	cur = new world();
	pl = new player();
    }

    public void tick() {
	
	double time = getTime();
	if(time - oldTick < /*MAGIC NUMBER*/0.05/*MAGIC NUMBER*/)
	    return;
	oldTick = getTime();

	

    }

    public double getTime() {
	return System.nanoTime()/1000000000.0;
    }

    public boolean getKey(char c) {
	return keyin.getKey(c);
    }

}