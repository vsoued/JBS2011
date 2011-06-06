
public class Main {

	public static void main(String[] args) {
		
		Maze mac = new Maze(4,4);
		mac.display();
		mac.display101();
		mac.load("111111111100010001111010101100010101101110101100000101111011101100000101111111111");
		mac.display101();
		//if (mac.solve(1,1,2,2)){
		//	System.out.println("has a solution");
		//}
		//mac.trace(1,1,2,2);
	}

}
