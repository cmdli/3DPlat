//3dplat

public class player extends entity {

    public static final double G = -9.8;

    vector loc;
    vector vel;
    vector acc;


    public player() {
	
    }

    public void tick(game g, double time) {

	Keys k = g.getKeys();

	acc.y = -G;

	vectorAcc(vel,acc,time);

	vectorAcc(loc,vel,time);
	
    }

}