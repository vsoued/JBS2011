
public class Cell {
	private boolean top;
	private boolean bottom;
	private boolean left;
	private boolean right;
	
	//set walls methods
	public void setTop(boolean b){
		top=b;
	}
	
	public void setBottom(boolean b){
		bottom=b;
	}

	public void setRight(boolean b){
		right=b;
	}
	
	public void setLeft(boolean b){
		left=b;
	}
	
	//get wall status methods
	public boolean top(){
		return top;
	}
	
	public boolean bottom(){
		return bottom;
	}

	public boolean right(){
		return right;
	}
	
	public boolean left(){
		return left;
	}
}


