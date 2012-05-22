//3dplat

package world;

public class entity {

    public vector loc = new vector();
    public vector size = new vector();

    /*DATA STRUCTURE
     *move is a boolean array
     *which stores whether or
     *not the entity can move
     *in a certain direction.
     *-Index--Value-
     *-0--Forward-
     *-1--Backward-
     *-2--Left-
     *-3--Right-
     *-4--Up-
     *-5--Down-
     */
    public boolean[] move;
    public vector vel;

    public entity() {

    }

    public void tick(game g, double time) {
	
    }

    public void vectorAcc(vector v1, vector v2, double t) {
	v1.x += v2.x*t;
	v1.y += v2.y*t;
	v1.z += v2.z*t;
    }
    
    public void rotate(vector v1, vector rot) {
        v1.x *= Math.cos(rot.x);
        v1.y *= Math.cos(rot.y);
        v1.z *= Math.cos(rot.z);
    }

    public void collide(entity e, Block[] b, double rest) {

	
	for(int i = 0; i < b.length; i++) {

	    if(e.loc.z-b[i].loc.z < b[i].size.z || e.loc.z+e.size.z - b[i].loc.z < b[i].size.z) {
		e.vel.z *= -rest;
	    }
	    if(e.loc.x-b[i].loc.x < b[i].size.x || e.loc.x+e.size.x - b[i].loc.x < b[i].size.x) {
		e.vel.x *= -rest;
	    }
	    if(e.loc.y-b[i].loc.y < b[i].size.y || e.loc.y+e.size.y - b[i].loc.y < b[i].size.y) {
		e.vel.y *= -rest;
	    }
	}
    }

}