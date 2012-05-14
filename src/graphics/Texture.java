//3dplat

public class Texture {

    private int target;
    private int id;

    public Texture(int target, int id) {
	this.target = target;
	this.id = id;
    }

    public void bind() {
	glBindTexture(target,id);
    }

}