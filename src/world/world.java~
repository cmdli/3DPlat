//3dplat

public class world {

    Block[][][] blocks;

    public world() {
	blocks = null;
    }

    public void loadFromFile(String name) {

	try {
	    BufferedImage in = ImageIO.read(new File(name));

	    int[] src = ((DataBufferInt) in.getRaster().getDataBuffer()).getData();

	    blocks = new Block[in.getWidth()][/*MAGIC NUMBER*/10/*MAGIC NUMBER*/][in.getHeight()];

	    for(int x = 0; x < in.getWidth(); x++) {
		for(int z = 0; z < in.getHeight(); z++) {
		    blocks[x][0][z] = loadBlock(src[x+y*in.getWidth()]);
		    for(int y = 0; y < /*MAGIC NUMBER*/10/*MAGIC NUMBER*/; y++) {
			blocks[x][y][z] = new EmptyBlock();
		    }
		}
	    }
	} catch(Exception e) {
	    System.out.println("Cannot load from file");
	}
    }

    private Block loadBlock(int col) {
	switch(col) {
	case 0x000000:
	    return new SolidBlock();
	}
	return new EmptyBlock();
    }

    public Block getBlock(int x, int y, int z) {
	if(blocks == null)
	    return null;
	return blocks[x][y][z];
    }

}