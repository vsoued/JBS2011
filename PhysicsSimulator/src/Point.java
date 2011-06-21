/**Point class to make my life easier**/
public class Point {
	int x;
	int y;
	
	public Point(double x, double y){
		this.x = (int)x;
		this.y = (int)y;
	}

	public String toString(){
		return "\n("+x+","+y+")";
	}
}
