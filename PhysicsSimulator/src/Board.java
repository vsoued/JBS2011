import java.util.ArrayList;


public class Board {
	
	//Lists of squares jewels and disks
	ArrayList<Square> squares;
	ArrayList<Jewel> jewels;
	ArrayList<Disk> disks;
	
	public Board(){
		
		squares = new ArrayList<Square>();
		jewels = new ArrayList<Jewel>();
		disks = new ArrayList<Disk>();
	}
	
	public void add(Object o){
		
		//add object o to its corresponding list
		
		if (o instanceof Jewel){
			
			jewels.add((Jewel)o);
			//System.out.println("jewel");
		
		} else if (o instanceof Square){
				
			squares.add((Square)o);
			//System.out.println("square");
		
		} else if (o instanceof Disk){
			
			if (disks.size()<3){
				
				disks.add((Disk)o);
			
			} else {
				
				System.out.println("No more disks allowed");
			}
			//System.out.println("disk");
		}
	}
}
