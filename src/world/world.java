import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//3dplat

public class world {

    Block[] blocks;

    public world() {}

    public void loadFromFile(String name) {

	try {

	    BufferedReader in = new BufferedReader(new FileReader("world/world.txt"));
	    //Using a List here so file is only read once;
	   //tmp will be transferred into blocks
	    List<Block> tmp = new ArrayList<Block>();

	    String line = "";
	    while((line = in.readLine()) != null) {
	    tmp.add(loadBlock(line));
	    }
	    blocks = new Block[tmp.size()];
	    for(int i = 0; i<tmp.size();i++){
	    	blocks[i] = tmp.get(i);
	    }
	    
	    

	    

	} catch(Exception e) {
	    System.out.println("Cannot load from file");
	    e.printStackTrace();
	}

    }

    private Block loadBlock(String input) {

	String[] vals = input.split(" ");
	
	Block b = new Block();

	if(vals.length < 6) 
	    return b;

	b.loc.x = Integer.parseInt(vals[0]);
	b.loc.y = Integer.parseInt(vals[1]);
	b.loc.z = Integer.parseInt(vals[2]);
	b.size.x = Integer.parseInt(vals[3]);
	b.size.y = Integer.parseInt(vals[4]);
	b.size.z = Integer.parseInt(vals[5]);
	return b;
    }


}