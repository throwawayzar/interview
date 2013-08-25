package sudoku;

import java.util.HashMap;

public class Solvedoku {

	public static void main(String[] args){
		int[][] arr = { 
		        {5, 3, 4, 6, 7, 8, 9, 1, 2}, 
		        {6, 7, 2, 1, 9, 5, 3, 4, 8},
		        {1, 9, 8, 3, 4, 2, 5, 6, 7},
		        
		        {8, 5, 9, 7, 6, 1, 4, 2, 3},
		        {4, 2, 6, 8, 5, 3, 7, 9, 1},
		        {7, 1, 3, 9, 2, 4, 8, 5, 6},
		        
		        {9, 6, 1, 5, 3, 7, 2, 8, 4},
		        {2, 8, 7, 4, 1, 9, 6, 3, 5},
		        {3, 4, 5, 2, 8, 6, 1, 7, 9}
		    };

		System.out.println(isSudokuSolved(arr).toString());
	}

	private static Boolean isSudokuSolved(int[][] arr) {
		HashMap<Integer, Boolean> verify = new HashMap<Integer, Boolean>();
		for(int i=1; i<=9; i++)
		{
			verify.put(i, false);
		}
		//check rows
		for(int i=0; i<9; i++){
			HashMap<Integer, Boolean> current = (HashMap<Integer, Boolean>) verify.clone();
			for(int j=0; j<9; j++){
				if(current.containsKey(arr[j][i]) && !current.get(arr[i][j]))
					current.put(arr[i][j], true);
				else
					return false;
			}
		}
		//check columns
		for(int i=0; i<9; i++){
			HashMap<Integer, Boolean> current = (HashMap<Integer, Boolean>) verify.clone();
			for(int j=0; j<9; j++){
				if(current.containsKey(arr[j][i]) && !current.get(arr[j][i]))
					current.put(arr[j][i], true);
				else
					return false;
			}
		}
		
		//check tiny boxes
		for(int x=0; x<3; x++)
		{
			for(int y=0; y<3; y++)
			{
				HashMap<Integer, Boolean> current = (HashMap<Integer, Boolean>) verify.clone();
				for(int i=x*3; i<(x*3+3); i++)
				{
					for(int j=y*3; j<(y*3+3); j++)
					{
						if(current.containsKey(arr[j][i]) && !current.get(arr[j][i]))
							current.put(arr[j][i], true);
						else
							return false;
					}
				}
			}
		}
		return true;
	}
	
	
	
}
