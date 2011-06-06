
public class Maze {
	private Cell[][] maz;
	private int m;
	private int n;
	
	public Maze(int n, int m){
		maz= new Cell[m][n];
		this.n=n;
		this.m=m;
		
		//initialize cells
		for (int i = 0; i<n; i++){
			for (int j = 0; j<m; j++){
				maz[i][j]= new Cell();
			}
		}
	}
	
	public void display101(){
	//same as display but with zeroes and ones 
		int y = 0;
		
		for (int i = 0; i<(n*2)+1; i++){
			
			if (i%2!=0 && i>1){
				y++;
			}
			
			int x = 0;
			
			for (int j = 0; j<(m*2)+1; j++){
				
				if (j%2!=0 && j>1){
					x++;
				}
				
				if (i%2 == 0){
					
					if (j%2== 0){
						
						System.out.print("1");
					
					} else {
						
						if (i==0 || i==(n*2)){
							
							System.out.print("1");
							
						} else if (!maz[x][y].bottom() || !maz[x][y+1].top()){
							
							System.out.print("1");
						
						} else {
						
							System.out.print("0");
						}
					}
				
				} else {
					
					if (j==0 || j==(m*2)){
						
						System.out.print("1");
					
					} else if (j%2== 0){
						
						if (!maz[x][y].right() || !maz[x+1][y].left()){
							
							System.out.print("1");
						
						} else {
							
							System.out.print("1");
						}
						
					} else {
						System.out.print("0");
					}
				}
				
			}
		System.out.println();
		}
	}
	
	public void display(){
		
		//y
		int y = 0;
		
		//vertical
		for (int i = 0; i<(n*2)+1; i++){
			
			//increase y when i is odd and more than one
			if (i%2!=0 && i>1){
				y++;
			}
			
			//x
			int x = 0;
			
			//horizontal
			for (int j = 0; j<(m*2)+1; j++){
				
				//increase x when its odd and more than one
				if (j%2!=0 && j>1){
					x++;
				}
				
				//i is even
				if (i%2 == 0){
					
					//j is even
					if (j%2== 0){
						
						System.out.print(" ");
					
						//i is odd
					} else {
						
						//top and bottom
						if (i==0 || i==(n*2)){
							
							System.out.print("--");
						
						//whether or not to print wall if its false for either cell
						} else if (!maz[x][y].bottom() || !maz[x][y+1].top()){
							
							System.out.print("--");
						
						} else {
						
							System.out.print("  ");
						}
					}
				
				} else {
					
					//sides
					if (j==0 || j==(m*2)){
						
						System.out.print("|");
					
					// even j
					} else if (j%2== 0){
						
						//whether print or not if wall is false for either
						if (!maz[x][y].right() || !maz[x+1][y].left()){
							
							System.out.print("|");
						
						} else {
							
							System.out.print(" ");
						}
						
					} else {
						System.out.print("  ");
					}
				}
				
			}
		System.out.println();
		}
	}
	
	public void load(String input){
		
		//coordinates
		int y = 0;
		int x = 0;
		int count=0;
			
		//goes through string
		for (int c = 1; x<n && y<m; c++){
			
			if(x==0&&y==0&&c%2==0){
				count++;
			}
			if (count<3){
			
				System.out.println(x+","+y);
				if(c%2==0){
					
					//for 0 sets walls to true
					if (input.charAt(c)=='0'){	
							
							//top and bottom for even c
							if (c%2==0){
								maz[y][x].setBottom(true);
								maz[y+1][x].setTop(true);
							
							//left right for odd c
							} else {
								maz[y][x].setRight(true);
								maz[y][x+1].setLeft(true);
							}
					}
					if (x<n-1){
						x++;
					} else {
						x=0;
					}
				}
			}
			if(c%((2*n+1)*2)==0){
				y++;
			}
			
			//x and y pointers that dont work
			//if (pointy>(2*((2*n)+1))){
			//	y++;
			//	pointy=0;
			//}
			
			//increase y every two 
			//if ((c-1)%(2*((2*n)+1))==0 && (c-1)>0){
			//	y++;
			//	x=0;
			//}else 
			
		}
	}

	public boolean solve(int begx, int begy, int endx, int endy){
		//Do until beg equals end
		while (begx != endx && begy != endy || begx != n || begy != m){
			//checks cells for true and advances
			if (begy-1>=0){
				if (maz[begx][begy].top() && maz[begx][begy-1].bottom()){
					begy--;
				}
			} else if (begy+1<m){
				if (maz[begx][begy].bottom() && maz[begx][begy+1].top()){
					begy++;
				}
			} else if (begx+1<n){
				if (maz[begx][begy].right() && maz[begx+1][begy].left()){
					begx++;
				}
			} else if (begx-1>=0){
				if (maz[begx][begy].left() && maz[begx-1][begy].right()){
					begx--;
				}
			}
			//returns true when beg equals end
			if (begx == endx && begy == endy){
				return true;
			}
		}
		return false;
		
	}
	
	public void trace(int begx, int begy, int endx, int endy){
		
		//while it can still move
		while (begx != endx && begy != endy || begx != n || begy != m){
			
			//prints current coordinate
			System.out.println("("+begx+","+begy+")");
			
			//check for true in cells and advance if possible and change coordinates
				if (maz[begx][begy].left() && maz[begx-1][begy].right()){
					begx--;
				}else if (maz[begx][begy].top() && maz[begx][begy-1].bottom()){
					begy--;
				} else if (maz[begx][begy].right() && maz[begx+1][begy].left()){
					begx++;
				} else if (maz[begx][begy].bottom() && maz[begx][begy+1].top()){
					begy++;
				}
			//if found
			if (begx == endx && begy == endy){
				System.out.println("("+begx+","+begy+")");
				System.out.println("solved");
				//break
				begx=n;
			}
			
		}
		System.out.println("Maze has no solution");
	}
	
}
