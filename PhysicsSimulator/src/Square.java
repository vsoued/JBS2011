import java.util.ArrayList;
/**Square class, defines the square object, its position, width, and all int coordinates inside it**/

public class Square {
	
	//int centery;
	//int centerx;
	Point position;
	int width;
	ArrayList<Point> points;
	
	
	public Square(int centerx, int centery, int width){
		
		//this.centery = centery;
		//this.centerx = centerx;
		points = new ArrayList<Point>();
		position = new Point(centerx,centery);
		this.width = width;
		
		points.add(new Point(centerx,centery));
		
		for (int i = (centerx-(width/2)); i<= width; i++){
			
			for (int j = (centery-(width/2)); j<= width; j++){
				
				points.add(new Point(i,j));
			}
		}
	}
}
