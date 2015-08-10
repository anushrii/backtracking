package backtracking;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * This is a Depth first implementation for finding solution/solutions
 * to a puzzle. Where the puzzle is solved by starting from the first element in the array
 * and traversing a path to reach the last element(goal) of the array.
 */
public class Backtracking {
	private static Stack<Character> stack = new Stack<Character>();
	private static Set<Stack<Character>> pathSet = new HashSet<Stack<Character>>();
	
	/**
     * Searches for the solution to a puzzle. Tries to 
     * find a path from the first location in the array
     * to the last location.
     * 
     * @param puzzle An array containing the puzzle.
     * @return A stack containing the moves L or R.
     */
	public static Stack<Character> solve(int[] puzzle){
		boolean[] visited = new boolean[puzzle.length];
		
		
		
		for (int i = 0;i<visited.length;i++){
			visited[i] = false;
		}
		
		int first = 0;
		int goal = puzzle.length-1;
		Stack<Character> output = new Stack<Character>(); 
		
		if(puzzle.length==1){
			return output;
		}
		
		// to go from first to goal
		boolean b = searchOneSolution(first,goal,puzzle,visited);
		if(b==false){
			return null;
		}
	    output = stack;
		
		return output;
	}
	
	private static boolean searchOneSolution(int first,int goal, int[] puzzle, boolean[] visited){

		 if(first == goal){
			 return true ; 
		 }
		 // To check for visited nodes
		 visited[first]=true;
		 
		 // Creating children for first
		int children[] = new int[2];
		
		if (puzzle[first]+first >= (puzzle.length))
			children[0] = -1;
		else
			children[0] = puzzle[first]+first;
		
		if (first -puzzle[first]<= 0)
			children[1] = -1;
		else
			children[1] = first - puzzle[first];
		
		for(int c=0;c<=1;c++){
			if(children[c]>=0){
				if(visited[children[c]]==false ){
					if(searchOneSolution(children[c],goal,puzzle,visited)==true){
						if(c==0)
							stack.push('R');
						else
							stack.push('L');
						return true;
					
					}
				}
			}
		}
		visited[first]=false;
		return false;
	}
	
	/**
     * Searches for all possible solutions to a puzzle. Tries to 
     * find all possible paths from the first location in the array
     * to the last location.
     * 
     * @param puzzle An array containing the puzzle.
     * @return A set containing the stacks(of moves L or R) corresponding to every path.
     */
	public static Set<Stack<Character>> findAllSolutions(int[] puzzle){
		
		boolean[] visited = new boolean[puzzle.length];
		int first = 0;
		int goal = puzzle.length-1;
		Stack<Character> temp = new Stack<Character>();
		stack.clear();
		pathSet.clear();
		
		if(puzzle.length==1){
			pathSet.add(stack);
			return pathSet;
		}
		boolean b = searchAllSolution(first,goal,puzzle,visited,temp);
		
		return pathSet;	
	}
		
	private static boolean searchAllSolution(int first,int goal, int[] puzzle, boolean[] visited, Stack<Character> tempStack){


		 if(first == goal){
			 Stack<Character> tempStacknew =  new Stack<Character>();
			 while(!tempStack.empty()){
				 tempStacknew.push(tempStack.pop());
			 }
			 pathSet.add(tempStacknew);
        	 tempStack =  new Stack<Character>();
			 return true; 
		 }
		 // To check for visited nodes
		 visited[first]=true;
		 
		 // Creating children for first
		int children[] = new int[2];
		
		if (puzzle[first]+first >= (puzzle.length))
			children[0] = -1;
		else
			children[0] = puzzle[first]+first;
		
		if (first -puzzle[first]<= 0)
			children[1] = -1;
		else
			children[1] = first - puzzle[first];
		
		if(children[0] == -1 && children[1] == -1)
			return false;
		
		for(int c=0;c<=1;c++){
			if(children[c]>=0){
				if(visited[children[c]]==false ){
		
					Stack<Character> temp =  new Stack<Character>();
					temp.addAll(tempStack);
					if(c==0)
						temp.push('R');
					else
						temp.push('L');
					if(searchAllSolution(children[c],goal,puzzle,visited,temp)==true){				
					}
				}
			}
		}
		visited[first]=false;
		return true;
	}
	
//	public static void main(String arg[]){
//		int[] puzzle = new int[]{3,1,2,3,0,4};//{3,6,4,1,3,4,2,5,3,1,2,9,2};//{3,6,4,1,3,4,2,5,3,0};//{3,1,2,3,0};
//		Set<Stack<Character>> output;
//		output = Backtracking.findAllSolutions(puzzle);
//		System.out.println(output);
//	}
}
