//3dplat

public class world {

    Block[] blocks;

    public world() {
	blocks = null;
    }

    public void loadFromFile(String name) {

	try {

	    BufferedReader in = new BufferedReader(new FileReader(name));

	    //Using a List here so file is only read once;
	    //tmp will be transferred into blocks
	    List<Block> tmp = new ArrayList<Block>();

	    String line = "";
	    while((line = in.readLine()) != null) {
		tmp.add(loadBlock(line));
	    }

	    blocks = (Block[])tmp.toArray();
	    
	    //Old image-based code
	    /**BufferedImage in = ImageIO.read(new File(name));

	    int[] src = ((DataBufferInt) in.getRaster().getDataBuffer()).getData();

	    blocks = new Block[in.getWidth()][/*MAGIC NUMBER10/*MAGIC NUMBER*//*][in.getHeight()];

	    for(int x = 0; x < in.getWidth(); x++) {
		for(int z = 0; z < in.getHeight(); z++) {
		    blocks[x][0][z] = loadBlock(src[x+y*in.getWidth()]);
		    for(int y = 0; y < /*MAGIC NUMBER10/*MAGIC NUMBER*//*; y++) {
			blocks[x][y][z] = new EmptyBlock();
		    }
		}
		}*/
	} catch(Exception e) {
	    System.out.println("Cannot load from file");
	}
    }

    private Block loadBlock(String input) {

	String[] vals = input.split(" ");
	
	Block b = new Block();

	if(vals.length() < 6) 
	    return b;

	b.loc.x = Integer.parseInt(vals[0]);
	b.loc.y = Integer.parseInt(vals[1]);
	b.loc.z = Integer.parseInt(vals[2]);
	b.size.x = Integer.parseInt(vals[3]);
	b.size.y = Integer.parseInt(vals[4]);
	b.size.z = Integer.parseInt(vals[5]);
	return b;

	//Old Image-based code
	/*
	switch(col) {
	case 0x000000:
	    return new SolidBlock();
	}
	return new EmptyBlock();*/
    }

    public Block getBlock(int x, int y, int z) {
	if(blocks == null)
	    return null;
	return blocks[x][y][z];
    }

}