package util;

import java.util.*;
import java.util.stream.IntStream;

public class SudokuGenerator {

//<editor-fold defaultstate="collapsed" desc="Level">
    /**
     * Easy Level: (42 to 51) Cells
     */
    private static final int EASY_LEVEL = 42;
    /**
     * MEDIUM Level: (32 to 41) Cells
     */
    private static final int MEDIUM_LEVEL = 32;
    /**
     * HARD Level: (22 to 31) Cells
     */
    private static final int HARD_LEVEL = 22;
    private static int rSudo[][] = new int[9][9];
    private static String arrTemp[] = new String[81];
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Attributes">
    private final Random randValue = new Random(); // Generate random values.
    private ArrayList<ArrayList<Integer>> sudokuList = new ArrayList<>(); // Sudoku List
    private long startTime; // Time when Function hasUniqueSolution started.
    private int solutionCount = 0; //Count Solutions in hasUniqueSolution Function.
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Public methods">
    /**
     * Generate Sudoku with desired level.
     *
     * @param Level Selected level. SudokuGenerator.EASY SudokuGenerator.MEDIUM
     * SudokuGenerator.HARD
     * @return Unsolved Sudoku with Unique Solution.
     */
    public int[][] createSudoku(int Level) {
        // Create Complete Sudoku :D
        generateCompleteSudoku();
        // Contain ordered numbers (0 to 80) if "HARD" is selected to remove most of the cells.
        // Otherwise, generate unordered numbers (0 to 80).
        ArrayList<Integer> AvailableIndex = new ArrayList<>();
        if (Level == SudokuGenerator.HARD_LEVEL) {//HARD LEVEL
                for (int i = 0; i < 81; i++) {
                    AvailableIndex.add(i);
                }
            } else {// EASY or MEDIUM LEVEL
                AvailableIndex = getRandomValues(0, 80);
            }

        // Return Sudoku with removed cells.
        ArrayList<ArrayList<Integer>> SudokuArray = removeCells(Level, AvailableIndex);
        String rSudoku = "";
        for (ArrayList<Integer> row : SudokuArray) {
            for (Integer cell : row) {
                rSudoku += cell + " ";
            }
        }
        //  System.out.println(rSudoku);
        arrTemp = rSudoku.split("\\s");

       
        int x = -1, y = 0;
        for (int i = 0; i < 81; i++) {
            if (i % 9 == 0) {
                x++;
                y = 0;
            }
            rSudo[x][y] = Integer.parseInt(arrTemp[i]);
            y++;
        }
        return rSudo;
    }

    public int[] getSudoku() {
        int[] arrSudoku = new int[81];
        for (int i = 0; i < 81; i++) {
            arrSudoku[i] = Integer.parseInt(arrTemp[i]);
        }
        return arrSudoku;
    }
    
    
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Private methods">
    /**
     * Remove cells from generated Sudoku According to the Selected Level.
     *
     * @param Level Selected level. SudokuGenerator.EASY SudokuGenerator.MEDIUM
     * SudokuGenerator.HARD
     * @param AvailableIndexes (Randomly/ordered) indexes.
     * @return Sudoku with removed cells.
     */
    private ArrayList<ArrayList<Integer>> removeCells(int Level, ArrayList<Integer> AvailableIndexes) {
        int RowIndex, ColumnIndex;
        int OriginalValue;
        // Remaining cells that should be removed count
        int RemovedCells = 81 - Level - randValue.nextInt(10);
        int Upper = 0, Lower = 0;
        // get cell index from -random/ordered- numbers from 0 to 80
        for (Integer Index : AvailableIndexes) {
            // calculate Cell Location.
            RowIndex = Index / 9;
            ColumnIndex = Index % 9;
            //Store Cell's Value before removing it.
            OriginalValue = sudokuList.get(RowIndex).get(ColumnIndex);
            // Set Cell to zero.
            sudokuList.get(RowIndex).set(ColumnIndex, 0);
            // decrease number of remaining cells.
            RemovedCells--;
            if (Index > 45) {
                Lower++;
            } else {
                Upper++;
            }
            // Check if Sudoku still have a unique Solution.
            if (!hasUniqueSolution(Lower > Upper)) {
                // if not, reset the cell to it's original value.
                sudokuList.get(RowIndex).set(ColumnIndex, OriginalValue);
                // and increase number of remaining cell.
                RemovedCells++;
                if (Index > 45) {
                    Lower--;
                } else {
                    Upper--;
                }
            }
            // return if the selected number of cells is removed.
            if (RemovedCells == 0) {
                return sudokuList;
            }
        }
        return sudokuList;
    }

    /**
     * Generate Complete Sudoku without empty cells.
     *
     * @return Sudoku.
     */
    private ArrayList<ArrayList<Integer>> generateCompleteSudoku() {
        // Empty Sudoku List and fill it with zeros :v
        sudokuList.clear();
        for (int i = 0; i < 9; i++) {
            sudokuList.add(new ArrayList<>());
            for (int j = 0; j < 9; j++) {
                sudokuList.get(i).add(0);
            }
        }
        // start generating Sudoku from cell zero
        generateSudoku(0);
        //return Sudoku
        return sudokuList;
    }

    /**
     *
     * @param Index Cell index
     * @return false to the previous cell if there is no valid number.
     * Otherwise, return true.
     */
    private boolean generateSudoku(int Index) {
        // Unordered numbers from 1 to 9.
        ArrayList<Integer> Values = getRandomValues(1, 9);
        // calculate Cell Location.
        int x = Index / 9;
        int y = Index % 9;
        // try numbers (1 to 9).
        for (Integer Value : Values) {
            // if it's valid number.
            if (ValidNumber(Value, x, y)) {
                // set value to the cell.
                sudokuList.get(x).set(y, Value);
                // go to next cell.
                int next = Index + 1;
                if (Index == 80 || generateSudoku(next)) {
                    return true;
                }
            }
        }
        // if there is no valid number return false to the previous cell.
        sudokuList.get(x).set(y, 0);
        return false;
    }

    /**
     * Check if Sudoku has unique Solution.
     *
     * @param SearchForword start from first or last cell.
     * @return true if it has one solution.
     */
    private boolean hasUniqueSolution(boolean SearchForword) {
        // save starting time to tirminate function if it exceeded 1 second.
        startTime = System.currentTimeMillis();
        solutionCount = 0; // Number of possible solutions.
        if (SearchForword) {// start search from first or last cell.
            hasUniqueSolution(0, 0, SearchForword);
        } else {
            hasUniqueSolution(8, 8, SearchForword);
        }
        return solutionCount == 1; // return true if there is only one solution.
    }

    /**
     * Check if Sudoku has unique Solution.
     *
     * @param RowIndex cell position
     * @param ColumnIndex cell position
     * @param SearchForword start from first or last cell.
     * @return always false, to undo any changes happened to sudokuList
     */
    private boolean hasUniqueSolution(int RowIndex, int ColumnIndex, boolean SearchForword) {
        int xLimit = 8, yLimit = 8; // last Cell location starting from first cell.
        if (!SearchForword) {
            // last Cell location starting from last cell.
            xLimit = 0;
            yLimit = 0;
        }
        // Check if there is more than one Solution or the function exceeded one second.
        if ((solutionCount > 1) || System.currentTimeMillis() - startTime > 1000) {
            return false;
        }
        // Next cell number
        int nextCellNum = RowIndex * 9 + ColumnIndex + 1;
        if (!SearchForword) {
            nextCellNum -= 2;
        }
        // if the cell is empty
        if (sudokuList.get(RowIndex).get(ColumnIndex) == 0) {
            // try numbers from 1 to 9
            for (int PossibleNumber = 1; PossibleNumber < 10; PossibleNumber++) {
                // if its valid number
                if (ValidNumber(PossibleNumber, RowIndex, ColumnIndex)) {
                    sudokuList.get(RowIndex).set(ColumnIndex, PossibleNumber);
                    // if its the last cell increase Solution counter, Otherwise go to next cell.
                    if ((RowIndex == xLimit && ColumnIndex == yLimit) || hasUniqueSolution(nextCellNum / 9, nextCellNum % 9, SearchForword)) {
                        solutionCount++;
                        // return false to continue searching for solutions.
                        return false;
                    }
                }
            }
            // if no valid number, set cell to zero.
            sudokuList.get(RowIndex).set(ColumnIndex, 0);
            return false;// go to previous cell.
        } else // if its not the last cell, go to next cell.
        if (!(RowIndex == xLimit && ColumnIndex == yLimit)) {
            return hasUniqueSolution(nextCellNum / 9, nextCellNum % 9, SearchForword);
        } else {
            //else incerease Solution conuter.
            solutionCount++;
            return false;
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Helper Functions">

    /**
     * Check if the given number is valid.
     *
     * @param PossibleNumber Number to be checked.
     * @param RowIndex Cell Location.
     * @param ColumnIndex Cell Location.
     * @return true if its a valid number.
     */
    private boolean ValidNumber(int PossibleNumber, int RowIndex, int ColumnIndex) {
        // first cell in the block that contains (RowIndex, ColumnIndex).
        int block_x = (RowIndex / 3) * 3;
        int block_y = (ColumnIndex / 3) * 3;
        // if number exist in row.
        if (sudokuList.get(RowIndex).contains(PossibleNumber)) {
            return false;
        }
        // if number exist in culomn.
        if (sudokuList.stream().anyMatch(row -> row.get(ColumnIndex) == PossibleNumber)) {
            return false;
        }
        // if number exist in block.
        for (int j = 0; j < 3; j++) {
            if (sudokuList.get(block_x + j).subList(block_y, block_y + 3).contains(PossibleNumber)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Generate unordered numbers from minValue to maxValue included.
     *
     * @param minValue from number (minValue < maxValue). 
         * @
     * param maxValue * to number. @return list of numbers.
     */
    private ArrayList<Integer> getRandomValues(int minValue, int maxValue) {
        int count = maxValue - minValue + 1;
        ArrayList<Integer> randomValues = new ArrayList<>(count);
        IntStream.range(minValue, maxValue + 1).forEach(randomValues::add);
        IntStream.range(0, count).forEach(i -> randomValues.add(count - 1, randomValues.remove(randValue.nextInt(count - i))));
        return randomValues;
    }
    
//</editor-fold>

}
