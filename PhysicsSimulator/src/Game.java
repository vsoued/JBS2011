
/**Test to run the game**/

public class Game{
	public static void main (String[]args){
		
		//create a board
		Board board = new Board();
		
		//create disks
		Disk disk1 = new Disk(3);
		Disk disk2 = new Disk(3);
		Disk disk3 = new Disk(3);
		
		//add disks to board
		board.add(disk1);
		board.add(disk2);
		board.add(disk3);
		
		//create and add squares
		board.add(new Square(10,5,10));
		board.add(new Square(20,5,10));
		board.add(new Square(30,5,10));
		board.add(new Square(10,15,10));
		board.add(new Square(20,15,10));
		board.add(new Square(30,15,10));
		board.add(new Square(10,25,10));
		board.add(new Jewel(20,25,8));
		board.add(new Square(30,25,10));
		
		//Flicking disks
		disk1.flick(0, 5, 12.2, 14.6,board);
		disk2.flick(0, 5, 47, 17,board);
		disk3.flick(0, 5, 3.54, 3.54,board);
		
		
		
	}
}
