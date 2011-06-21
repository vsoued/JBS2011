import java.util.ArrayList;

/**Disk class, defines the disk object, its position, radius, velocities, whether it has played,
 * and a track list**/

public class Disk {
	
	boolean played;
	double counter;
	double y;
	double x;
	ArrayList<Point> track;
	//Point position;
	int radius;
	double velocityx;
	double velocityy;
	
	public Disk(int radius, int x, int y){
		
		this.y = x;
		this.x = y;
		track = new ArrayList<Point>();
		this.counter = 0;
		//this.position = new Point(0,0);
		this.radius = radius;
		this.radius = radius;	
	}
	
	public Disk(int radius){
		this(radius,0,0);
	}
	
	public void flick(double x, double y, double xvelocity, double yvelocity, Board board){
		
		//set current velocities
		this.velocityx=xvelocity;
		this.velocityy=yvelocity;
		
		//set disk to position given
		this.x=x;
		this.y=y;
		
		//restart counter
		counter = 0;
		
		//restart yvelocity
		double ynow = 0;
		
		//till it touches the ground
		while (y>=0){
			
			//add position to list
			Point p = new Point(x,y);
			track.add(p);
			
			//check if that position falls inside any square
			for (int i = 0; i<board.squares.size(); i++){
				
				if (board.squares.get(i).points.contains(p)){
					//break
					y = -10;
					//System.out.println("FREEZE!");
				}
			}
			
			//check if that position falls into a jewel
			for (int i = 0; i<board.jewels.size(); i++){
				
				if (board.jewels.get(i).points.contains(p)){
					//break
					y = -10;
					//System.out.println("SCORE!");
					
					//remove that jewel
					board.jewels.remove(i);
				}
			}
			
			//check if it falls into a frozen disk
			for (int i = 0; i<board.disks.size(); i++){
				
				if (p.equals(new Point(board.disks.get(i).x,board.disks.get(i).y)) && board.disks.get(i).played){
					
					//break
					y = -10;
					//System.out.println("FREEZE!");
				}
			}
			
			if (y != -10){
				
				//increase time unit
				counter+= 1;
				//System.out.println(counter);
				
				//set y velocity now
				ynow = yvelocity-(9.81*counter);
				
				//System.out.println(ynow);
				
				//get y displacement
				y += (ynow*counter);
				//y += ((yvelocity*counter)-(((9.81)*(counter*counter))/2));
				//System.out.println((yvelocity*counter)-(((-9.8)*(counter*counter))/2));
				
				//get x displacement
				x += (xvelocity*counter);
			}
		}
		
		//System.out.println(track);
		
		//set as played
		played = true;
		
		//restart velocity
		this.velocityx=0;
		this.velocityy=0;

		//if no more jewels win, if no more disks, lose
		if (board.jewels.isEmpty()){
			
			System.out.println("WIN!");
		
		} else if (board.disks.get(0).played&&board.disks.get(1).played&&board.disks.get(2).played){
			
			System.out.println("GAME OVER");
		}
	}

	//gets position of disk at given time from the track list
	public Point getPosition(int time){	
		
		return track.get(time);
	}
	
	//gets position for a double time
	public Point getPosition(double time){	
		
		return new Point((x+(velocityx*time)),(y+(velocityy*counter)-(((9.81)*(counter*counter))/2)));
	}

	
}
