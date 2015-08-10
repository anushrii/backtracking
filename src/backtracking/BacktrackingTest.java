package backtracking;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class BacktrackingTest {

	@Test
	public void testSolve() {
		int[] puzzle = new int[]{3,6,4,1,3,4,2,5,3,0};
		
		Stack<Character> actual = new Stack<Character>();
		Stack<Character> stack1 = new Stack<Character>();
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		stack1.push('R');
		stack1.push('R');
	
		Stack<Character> stack2 = new Stack<Character>();
	
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		stack2.push('R');
		
		
		Stack<Character> stack3 = new Stack<Character>();
		
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		
		
		actual = Backtracking.solve(puzzle);
	//	System.out.println(actu9al);
		boolean b1 = actual.equals(stack1);
		boolean b2 = actual.equals(stack2);
		boolean b3 = actual.equals(stack3);
		assertTrue(b1||b2||b3);
		
	}
	@Test
	public void testSearchAllSolution() {
		int[] puzzle = new int[]{3,6,4,1,3,4,2,5,3,0};
		Set<Stack<Character>> actual = new HashSet<Stack<Character>>();
		Set<Stack<Character>> expected = new HashSet<Stack<Character>>();
		Stack<Character> stack = new Stack<Character>();
		stack.push('R');
		stack.push('L');
		stack.push('R');
		stack.push('R');
		stack.push('L');
		stack.push('R');
		stack.push('R');
		stack.push('R');
		expected.add(stack);
		
		stack = new Stack<Character>();
		stack.push('R');
		stack.push('L');
		stack.push('R');
		stack.push('R');
		stack.push('L');
		stack.push('R');
		stack.push('L');
		stack.push('R');
		stack.push('R');
		expected.add(stack);
		
		stack = new Stack<Character>();
		stack.push('R');
		stack.push('L');
		stack.push('R');
		stack.push('R');
		stack.push('L');
		stack.push('R');
		expected.add(stack);
		
		
		
		actual = Backtracking.findAllSolutions(puzzle);
		System.out.println(actual);
		System.out.println(expected);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSolveNull() {
		Stack<Character> actual = new Stack<Character>();
		int[] puzzle = new int[]{3,0,0,3,1,3};
		
		actual = Backtracking.solve(puzzle);
		assertNull( actual);
	}
	
	@Test
	public void testSolveOneElement() {
		Stack<Character> actual = new Stack<Character>();
		Stack<Character> expected = new Stack<Character>();
		int[] puzzle = new int[]{3};
		
		actual = Backtracking.solve(puzzle);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSearchAllSolutionEmpty() {
		int[] puzzle = new int[]{3,0,0,3,1};
		Set<Stack<Character>> actual = new HashSet<Stack<Character>>();
		Set<Stack<Character>> expected = new HashSet<Stack<Character>>();
		actual = Backtracking.findAllSolutions(puzzle);
		assertEquals(expected, actual);
		
		
	}
	@Test
	public void testSearchAllSolutionOneElement() {
		int[] puzzle = new int[]{0};
		Set<Stack<Character>> actual = new HashSet<Stack<Character>>();
		Set<Stack<Character>> expected = new HashSet<Stack<Character>>();
		Stack<Character> empty = new Stack<Character>();
		expected.add(empty);
		actual = Backtracking.findAllSolutions(puzzle);
		assertEquals(expected, actual);
		
		
	}
}
