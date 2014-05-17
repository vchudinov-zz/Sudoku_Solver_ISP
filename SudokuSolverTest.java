import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class SudokuSolverTest {

	@Test
	public void testSetValue() {
		SudokuSolver s = new SudokuSolver();
		s.setup(5);
		int value = 4;
		s.setValue(1, 1, value);
		assertEquals(s.getPuzzle()[1][1], value);
	}

	@Test
	public void testSetup() {
		SudokuSolver s = new SudokuSolver();
		s.setup(3);
		assertNotNull(s.D);
		assertNotNull(s.puzzle);
		
		int[] expecteds = {1,2,3,4,5,6,7,8,9};
		
		ArrayList<ArrayList<Integer>> testdomain = s.D;
		
		for(int i =0; i < testdomain.size(); i++){
			int[] actuals = new int[9];
			for(int j =0; j <9; j++){
				actuals[j] = testdomain.get(i).get(j);
			}
			assertArrayEquals(expecteds,actuals);
		}
	}
		@Test
	public void testGetAssignment() {
			SudokuSolver s = new SudokuSolver();
			s.setup(3);
			ArrayList<Integer> expected = new ArrayList<Integer>();
			for(int i = 0; i < 81; i++){
				expected.add(i, 0);
			}
			
			ArrayList<Integer> asn = s.GetAssignment(s.puzzle);
			assertNotNull(asn);
		
			for (int i = 0; i < expected.size(); i++){
				{assertEquals(expected.get(i), asn.get(i));
				}
			}
		}
	
	@Test
	public void testAC_FC() {
		SudokuSolver s = new SudokuSolver();
		s.setup(3);
		s.setValue(0, 0, 1);
		boolean b = s.AC_FC(1, 9);
		int expected =  9;
		
		int actual = s.D.get(1).get(0);
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void testINITIAL_FC() {
		SudokuSolver s = new SudokuSolver();
		s.setup(3);
		
		ArrayList<Integer> asn = s.GetAssignment(s.puzzle);
		ArrayList<Integer> asnCopy = (ArrayList<Integer>) asn.clone();
		boolean initial = s.INITIAL_FC(asn);
		for(int i =0; i < asnCopy.size(); i++){
			if (asn.get(i) != asnCopy.get(i)) System.out.println(" Passed ");
		}
		System.out.println(initial);
	}
	
	

	@Test
	public void testSolve() {
		SudokuSolver s = new SudokuSolver();
		
		s.setup(3);
		
		s.puzzle = puzzle;
		boolean asn = s.solve();
		assertTrue(asn);
		
		//You'll have to verify by hand
		if (asn = true){
			int checker = 1;
			for(int i = 0; i <9; i++){
				for (int j: s.puzzle[i]){
					System.out.print(" | " + j + " | ");
				}
				System.out.println("\n -------------------------------------------------------------");
			}
		}
		
	}
//
//	@Test
//	public void testReadInPuzzle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFC() {
//		fail("Not yet implemented");
//	}
//
	
//
//	@Test
//	public void testREVISE() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCONSISTENT() {
//		fail("Not yet implemented");
//	}
//

//
//	@Test
//	public void testGetRelevantVariables() {
//		fail("Not yet implemented");
//	}
//

//
//	@Test
//	public void testGetPuzzle() {
//		fail("Not yet implemented");
//	}

}
