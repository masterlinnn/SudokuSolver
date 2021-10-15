/**
 * @author masterlinnn
 * @project Sudoku Solver
 */
package util;

public class PuzzleHolder {
    
   private static int[][] puzzle = new int[9][9];
    
    public PuzzleHolder(int[][] inPuzzle){
        puzzle = inPuzzle;
    }

    public static int[][] getPuzzle() {
        return puzzle;
    }
    
}
