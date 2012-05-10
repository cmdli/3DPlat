//3dplat

public class BlockMap {

    public BlockMap(String name) {
	try {
	    BufferedReader in = new BufferedReader(new File(name));

	    
	}
	catch(Exception e) {
	    System.out.println("BlockMap constructor failed.");
	    e.printStackTrace();
	}
    }

    public Block getBlock(int col) {
	
    }

}