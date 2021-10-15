/**
 * @author masterlinnn
 * @project Sudoku Solver
 */
package pkg2021;

/*====================Imports=====================*/
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import util.DatabaseConnection;
import util.PuzzleHolder;
import util.SudokuGenerator;
import util.SudokuSolver;
/*====================Imports=====================*/

public class Game extends javax.swing.JFrame {//Game Class

    /*====================Objects=====================*/
    private DatabaseConnection dbConnection = new DatabaseConnection();//Database Connection 
    private SudokuGenerator sudokuGenerator = new SudokuGenerator();//Sudoku Generator
    private SudokuSolver sudokuSolver = new SudokuSolver();//Sudoku Solver
    private PuzzleHolder puzzleHolder;//Puzzle Holder(Helper Class)
    /*====================Objects=====================*/

    /*====================Valiables=====================*/
    //Account Number Of Loged In User
    private int accNumber = 0;

    //The Sudoku Puzzle Generated
    private static int[][] puzzle = new int[9][9];
    //The Sudoku Puzzle Generated Correct solution 
    private static int[][] solvedPuzzle = new int[9][9];
    //Answer without generated numbers
    private static int[][] answer = new int[9][9];
    //The Sudoku Board User Working on 
    private static int[][] userAnswer = new int[9][9];
    //1 To 1 checking if the useranswer is correct 
    private boolean[][] answered = new boolean[9][9];
    //How many not answered
    private int answerLeft = 0;

    //The Sudoku Puzzle Generated In One Dimension Array
    private int[] tempPuzzle = new int[81];

    //The Textfield Object Which Hold The Text Box Used For Sudoku Board
    private JTextField[][] arrTxtGrid = new JTextField[9][9];
    
    private int gameLevel = 0;//receive game level
    private int genLevel = 0; //To Parse Into Sudoku Generator Constructor
    private String level = "";
 
   /*=============Timer Valiables==============*/
    private Thread timerThread;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private boolean timeRunning = true;
    /*=============Timer Valiables==============*/
  /*====================Valiables=====================*/
    
    public Game(int inAccNumber, int inLevel) {//Game Class Contructor
        super("Sudoku Solver @Game");
        initComponents();
        
        accNumber = inAccNumber;
        lblUserInfo.setText("User: " + dbConnection.getAccUsername(inAccNumber));//Set User Label

        determineLevel(inLevel);
        lblMode.setText("Mode: " + level);//Set Mode Label
        startGame();//Start Game ======> Initialize Puzzles 

    }//Game Class Contructor

    //<editor-fold defaultstate="collapsed" desc="BoardUpdate">
    private int[][] toGrid() {
        int pos1_1 = 0, pos1_2 = 0, pos1_3 = 0, pos1_4 = 0, pos1_5 = 0, pos1_6 = 0, pos1_7 = 0, pos1_8 = 0, pos1_9 = 0,
                pos2_1 = 0, pos2_2 = 0, pos2_3 = 0, pos2_4 = 0, pos2_5 = 0, pos2_6 = 0, pos2_7 = 0, pos2_8 = 0, pos2_9 = 0,
                pos3_1 = 0, pos3_2 = 0, pos3_3 = 0, pos3_4 = 0, pos3_5 = 0, pos3_6 = 0, pos3_7 = 0, pos3_8 = 0, pos3_9 = 0,
                pos4_1 = 0, pos4_2 = 0, pos4_3 = 0, pos4_4 = 0, pos4_5 = 0, pos4_6 = 0, pos4_7 = 0, pos4_8 = 0, pos4_9 = 0,
                pos5_1 = 0, pos5_2 = 0, pos5_3 = 0, pos5_4 = 0, pos5_5 = 0, pos5_6 = 0, pos5_7 = 0, pos5_8 = 0, pos5_9 = 0,
                pos6_1 = 0, pos6_2 = 0, pos6_3 = 0, pos6_4 = 0, pos6_5 = 0, pos6_6 = 0, pos6_7 = 0, pos6_8 = 0, pos6_9 = 0,
                pos7_1 = 0, pos7_2 = 0, pos7_3 = 0, pos7_4 = 0, pos7_5 = 0, pos7_6 = 0, pos7_7 = 0, pos7_8 = 0, pos7_9 = 0,
                pos8_1 = 0, pos8_2 = 0, pos8_3 = 0, pos8_4 = 0, pos8_5 = 0, pos8_6 = 0, pos8_7 = 0, pos8_8 = 0, pos8_9 = 0,
                pos9_1 = 0, pos9_2 = 0, pos9_3 = 0, pos9_4 = 0, pos9_5 = 0, pos9_6 = 0, pos9_7 = 0, pos9_8 = 0, pos9_9 = 0;

        /*  int pos1_1 = 4, pos1_2 = 0, pos1_3 = 0, pos1_4 = 0, pos1_5 = 0, pos1_6 = 0, pos1_7 = 0, pos1_8 = 0, pos1_9 = 3,
            pos2_1 = 0, pos2_2 = 1, pos2_3 = 2, pos2_4 = 0, pos2_5 = 0, pos2_6 = 0, pos2_7 = 7, pos2_8 = 6, pos2_9 = 0,
            pos3_1 = 0, pos3_2 = 6, pos3_3 = 0, pos3_4 = 2, pos3_5 = 0, pos3_6 = 3, pos3_7 = 0, pos3_8 = 4, pos3_9 = 0,
            pos4_1 = 0, pos4_2 = 0, pos4_3 = 0, pos4_4 = 0, pos4_5 = 3, pos4_6 = 2, pos4_7 = 0, pos4_8 = 0, pos4_9 = 0,
            pos5_1 = 0, pos5_2 = 4, pos5_3 = 0, pos5_4 = 7, pos5_5 = 0, pos5_6 = 5, pos5_7 = 0, pos5_8 = 8, pos5_9 = 0,
            pos6_1 = 0, pos6_2 = 5, pos6_3 = 0, pos6_4 = 9, pos6_5 = 4, pos6_6 = 0, pos6_7 = 0, pos6_8 = 3, pos6_9 = 0,
            pos7_1 = 0, pos7_2 = 2, pos7_3 = 0, pos7_4 = 6, pos7_5 = 0, pos7_6 = 1, pos7_7 = 0, pos7_8 = 7, pos7_9 = 0,
            pos8_1 = 0, pos8_2 = 3, pos8_3 = 8, pos8_4 = 0, pos8_5 = 0, pos8_6 = 0, pos8_7 = 2, pos8_8 = 1, pos8_9 = 0,
            pos9_1 = 5, pos9_2 = 0, pos9_3 = 0, pos9_4 = 0, pos9_5 = 0, pos9_6 = 0, pos9_7 = 0, pos9_8 = 0, pos9_9 = 8;*/
        int[][] retGrid = new int[9][9];
        //Line1
        if (!txtGrid1_1.getText().equals("")) {
            pos1_1 = Integer.parseInt(txtGrid1_1.getText());
        }
        if (!txtGrid1_2.getText().equals("")) {
            pos1_2 = Integer.parseInt(txtGrid1_2.getText());
        }
        if (!txtGrid1_3.getText().equals("")) {
            pos1_3 = Integer.parseInt(txtGrid1_3.getText());
        }
        if (!txtGrid1_4.getText().equals("")) {
            pos1_4 = Integer.parseInt(txtGrid1_4.getText());
        }
        if (!txtGrid1_5.getText().equals("")) {
            pos1_5 = Integer.parseInt(txtGrid1_5.getText());
        }
        if (!txtGrid1_6.getText().equals("")) {
            pos1_6 = Integer.parseInt(txtGrid1_6.getText());
        }
        if (!txtGrid1_7.getText().equals("")) {
            pos1_7 = Integer.parseInt(txtGrid1_7.getText());
        }
        if (!txtGrid1_8.getText().equals("")) {
            pos1_8 = Integer.parseInt(txtGrid1_8.getText());
        }
        if (!txtGrid1_9.getText().equals("")) {
            pos1_9 = Integer.parseInt(txtGrid1_9.getText());
        }
        retGrid[0][0] = pos1_1;
        retGrid[0][1] = pos1_2;
        retGrid[0][2] = pos1_3;
        retGrid[0][3] = pos1_4;
        retGrid[0][4] = pos1_5;
        retGrid[0][5] = pos1_6;
        retGrid[0][6] = pos1_7;
        retGrid[0][7] = pos1_8;
        retGrid[0][8] = pos1_9;

        //Line2
        if (!txtGrid2_1.getText().equals("")) {
            pos2_1 = Integer.parseInt(txtGrid2_1.getText());
        }
        if (!txtGrid2_2.getText().equals("")) {
            pos2_2 = Integer.parseInt(txtGrid2_2.getText());
        }
        if (!txtGrid2_3.getText().equals("")) {
            pos2_3 = Integer.parseInt(txtGrid2_3.getText());
        }
        if (!txtGrid2_4.getText().equals("")) {
            pos2_4 = Integer.parseInt(txtGrid2_4.getText());
        }
        if (!txtGrid2_5.getText().equals("")) {
            pos2_5 = Integer.parseInt(txtGrid2_5.getText());
        }
        if (!txtGrid2_6.getText().equals("")) {
            pos2_6 = Integer.parseInt(txtGrid2_6.getText());
        }
        if (!txtGrid2_7.getText().equals("")) {
            pos2_7 = Integer.parseInt(txtGrid2_7.getText());
        }
        if (!txtGrid2_8.getText().equals("")) {
            pos2_8 = Integer.parseInt(txtGrid2_8.getText());
        }
        if (!txtGrid2_9.getText().equals("")) {
            pos2_9 = Integer.parseInt(txtGrid2_9.getText());
        }
        retGrid[1][0] = pos2_1;
        retGrid[1][1] = pos2_2;
        retGrid[1][2] = pos2_3;
        retGrid[1][3] = pos2_4;
        retGrid[1][4] = pos2_5;
        retGrid[1][5] = pos2_6;
        retGrid[1][6] = pos2_7;
        retGrid[1][7] = pos2_8;
        retGrid[1][8] = pos2_9;

        //Line3
        if (!txtGrid3_1.getText().equals("")) {
            pos3_1 = Integer.parseInt(txtGrid3_1.getText());
        }
        if (!txtGrid3_2.getText().equals("")) {
            pos3_2 = Integer.parseInt(txtGrid3_2.getText());
        }
        if (!txtGrid3_3.getText().equals("")) {
            pos3_3 = Integer.parseInt(txtGrid3_3.getText());
        }
        if (!txtGrid3_4.getText().equals("")) {
            pos3_4 = Integer.parseInt(txtGrid3_4.getText());
        }
        if (!txtGrid3_5.getText().equals("")) {
            pos3_5 = Integer.parseInt(txtGrid3_5.getText());
        }
        if (!txtGrid3_6.getText().equals("")) {
            pos3_6 = Integer.parseInt(txtGrid3_6.getText());
        }
        if (!txtGrid3_7.getText().equals("")) {
            pos3_7 = Integer.parseInt(txtGrid3_7.getText());
        }
        if (!txtGrid3_8.getText().equals("")) {
            pos3_8 = Integer.parseInt(txtGrid3_8.getText());
        }
        if (!txtGrid3_9.getText().equals("")) {
            pos3_9 = Integer.parseInt(txtGrid3_9.getText());
        }
        retGrid[2][0] = pos3_1;
        retGrid[2][1] = pos3_2;
        retGrid[2][2] = pos3_3;
        retGrid[2][3] = pos3_4;
        retGrid[2][4] = pos3_5;
        retGrid[2][5] = pos3_6;
        retGrid[2][6] = pos3_7;
        retGrid[2][7] = pos3_8;
        retGrid[2][8] = pos3_9;

        //Line4
        if (!txtGrid4_1.getText().equals("")) {
            pos4_1 = Integer.parseInt(txtGrid4_1.getText());
        }
        if (!txtGrid4_2.getText().equals("")) {
            pos4_2 = Integer.parseInt(txtGrid4_2.getText());
        }
        if (!txtGrid4_3.getText().equals("")) {
            pos4_3 = Integer.parseInt(txtGrid4_3.getText());
        }
        if (!txtGrid4_4.getText().equals("")) {
            pos4_4 = Integer.parseInt(txtGrid4_4.getText());
        }
        if (!txtGrid4_5.getText().equals("")) {
            pos4_5 = Integer.parseInt(txtGrid4_5.getText());
        }
        if (!txtGrid4_6.getText().equals("")) {
            pos4_6 = Integer.parseInt(txtGrid4_6.getText());
        }
        if (!txtGrid4_7.getText().equals("")) {
            pos4_7 = Integer.parseInt(txtGrid4_7.getText());
        }
        if (!txtGrid4_8.getText().equals("")) {
            pos4_8 = Integer.parseInt(txtGrid4_8.getText());
        }
        if (!txtGrid4_9.getText().equals("")) {
            pos4_9 = Integer.parseInt(txtGrid4_9.getText());
        }
        retGrid[3][0] = pos4_1;
        retGrid[3][1] = pos4_2;
        retGrid[3][2] = pos4_3;
        retGrid[3][3] = pos4_4;
        retGrid[3][4] = pos4_5;
        retGrid[3][5] = pos4_6;
        retGrid[3][6] = pos4_7;
        retGrid[3][7] = pos4_8;
        retGrid[3][8] = pos4_9;

        //Line5
        if (!txtGrid5_1.getText().equals("")) {
            pos5_1 = Integer.parseInt(txtGrid5_1.getText());
        }
        if (!txtGrid5_2.getText().equals("")) {
            pos5_2 = Integer.parseInt(txtGrid5_2.getText());
        }
        if (!txtGrid5_3.getText().equals("")) {
            pos5_3 = Integer.parseInt(txtGrid5_3.getText());
        }
        if (!txtGrid5_4.getText().equals("")) {
            pos5_4 = Integer.parseInt(txtGrid5_4.getText());
        }
        if (!txtGrid5_5.getText().equals("")) {
            pos5_5 = Integer.parseInt(txtGrid5_5.getText());
        }
        if (!txtGrid5_6.getText().equals("")) {
            pos5_6 = Integer.parseInt(txtGrid5_6.getText());
        }
        if (!txtGrid5_7.getText().equals("")) {
            pos5_7 = Integer.parseInt(txtGrid5_7.getText());
        }
        if (!txtGrid5_8.getText().equals("")) {
            pos5_8 = Integer.parseInt(txtGrid5_8.getText());
        }
        if (!txtGrid5_9.getText().equals("")) {
            pos5_9 = Integer.parseInt(txtGrid5_9.getText());
        }
        retGrid[4][0] = pos5_1;
        retGrid[4][1] = pos5_2;
        retGrid[4][2] = pos5_3;
        retGrid[4][3] = pos5_4;
        retGrid[4][4] = pos5_5;
        retGrid[4][5] = pos5_6;
        retGrid[4][6] = pos5_7;
        retGrid[4][7] = pos5_8;
        retGrid[4][8] = pos5_9;

        //Line6
        if (!txtGrid6_1.getText().equals("")) {
            pos6_1 = Integer.parseInt(txtGrid6_1.getText());
        }
        if (!txtGrid6_2.getText().equals("")) {
            pos6_2 = Integer.parseInt(txtGrid6_2.getText());
        }
        if (!txtGrid6_3.getText().equals("")) {
            pos6_3 = Integer.parseInt(txtGrid6_3.getText());
        }
        if (!txtGrid6_4.getText().equals("")) {
            pos6_4 = Integer.parseInt(txtGrid6_4.getText());
        }
        if (!txtGrid6_5.getText().equals("")) {
            pos6_5 = Integer.parseInt(txtGrid6_5.getText());
        }
        if (!txtGrid6_6.getText().equals("")) {
            pos6_6 = Integer.parseInt(txtGrid6_6.getText());
        }
        if (!txtGrid6_7.getText().equals("")) {
            pos6_7 = Integer.parseInt(txtGrid6_7.getText());
        }
        if (!txtGrid6_8.getText().equals("")) {
            pos6_8 = Integer.parseInt(txtGrid6_8.getText());
        }
        if (!txtGrid6_9.getText().equals("")) {
            pos6_9 = Integer.parseInt(txtGrid6_9.getText());
        }
        retGrid[5][0] = pos6_1;
        retGrid[5][1] = pos6_2;
        retGrid[5][2] = pos6_3;
        retGrid[5][3] = pos6_4;
        retGrid[5][4] = pos6_5;
        retGrid[5][5] = pos6_6;
        retGrid[5][6] = pos6_7;
        retGrid[5][7] = pos6_8;
        retGrid[5][8] = pos6_9;

        //Line7
        if (!txtGrid7_1.getText().equals("")) {
            pos7_1 = Integer.parseInt(txtGrid7_1.getText());
        }
        if (!txtGrid7_2.getText().equals("")) {
            pos7_2 = Integer.parseInt(txtGrid7_2.getText());
        }
        if (!txtGrid7_3.getText().equals("")) {
            pos7_3 = Integer.parseInt(txtGrid7_3.getText());
        }
        if (!txtGrid7_4.getText().equals("")) {
            pos7_4 = Integer.parseInt(txtGrid7_4.getText());
        }
        if (!txtGrid7_5.getText().equals("")) {
            pos7_5 = Integer.parseInt(txtGrid7_5.getText());
        }
        if (!txtGrid7_6.getText().equals("")) {
            pos7_6 = Integer.parseInt(txtGrid7_6.getText());
        }
        if (!txtGrid7_7.getText().equals("")) {
            pos7_7 = Integer.parseInt(txtGrid7_7.getText());
        }
        if (!txtGrid7_8.getText().equals("")) {
            pos7_8 = Integer.parseInt(txtGrid7_8.getText());
        }
        if (!txtGrid7_9.getText().equals("")) {
            pos7_9 = Integer.parseInt(txtGrid7_9.getText());
        }
        retGrid[6][0] = pos7_1;
        retGrid[6][1] = pos7_2;
        retGrid[6][2] = pos7_3;
        retGrid[6][3] = pos7_4;
        retGrid[6][4] = pos7_5;
        retGrid[6][5] = pos7_6;
        retGrid[6][6] = pos7_7;
        retGrid[6][7] = pos7_8;
        retGrid[6][8] = pos7_9;

        //Line8
        if (!txtGrid8_1.getText().equals("")) {
            pos8_1 = Integer.parseInt(txtGrid8_1.getText());
        }
        if (!txtGrid8_2.getText().equals("")) {
            pos8_2 = Integer.parseInt(txtGrid8_2.getText());
        }
        if (!txtGrid8_3.getText().equals("")) {
            pos8_3 = Integer.parseInt(txtGrid8_3.getText());
        }
        if (!txtGrid8_4.getText().equals("")) {
            pos8_4 = Integer.parseInt(txtGrid8_4.getText());
        }
        if (!txtGrid8_5.getText().equals("")) {
            pos8_5 = Integer.parseInt(txtGrid8_5.getText());
        }
        if (!txtGrid8_6.getText().equals("")) {
            pos8_6 = Integer.parseInt(txtGrid8_6.getText());
        }
        if (!txtGrid8_7.getText().equals("")) {
            pos8_7 = Integer.parseInt(txtGrid8_7.getText());
        }
        if (!txtGrid8_8.getText().equals("")) {
            pos8_8 = Integer.parseInt(txtGrid8_8.getText());
        }
        if (!txtGrid8_9.getText().equals("")) {
            pos8_9 = Integer.parseInt(txtGrid8_9.getText());
        }
        retGrid[7][0] = pos8_1;
        retGrid[7][1] = pos8_2;
        retGrid[7][2] = pos8_3;
        retGrid[7][3] = pos8_4;
        retGrid[7][4] = pos8_5;
        retGrid[7][5] = pos8_6;
        retGrid[7][6] = pos8_7;
        retGrid[7][7] = pos8_8;
        retGrid[7][8] = pos8_9;

        //Line9
        if (!txtGrid9_1.getText().equals("")) {
            pos9_1 = Integer.parseInt(txtGrid9_1.getText());
        }
        if (!txtGrid9_2.getText().equals("")) {
            pos9_2 = Integer.parseInt(txtGrid9_2.getText());
        }
        if (!txtGrid9_3.getText().equals("")) {
            pos9_3 = Integer.parseInt(txtGrid9_3.getText());
        }
        if (!txtGrid9_4.getText().equals("")) {
            pos9_4 = Integer.parseInt(txtGrid9_4.getText());
        }
        if (!txtGrid9_5.getText().equals("")) {
            pos9_5 = Integer.parseInt(txtGrid9_5.getText());
        }
        if (!txtGrid9_6.getText().equals("")) {
            pos9_6 = Integer.parseInt(txtGrid9_6.getText());
        }
        if (!txtGrid9_7.getText().equals("")) {
            pos9_7 = Integer.parseInt(txtGrid9_7.getText());
        }
        if (!txtGrid9_8.getText().equals("")) {
            pos9_8 = Integer.parseInt(txtGrid9_8.getText());
        }
        if (!txtGrid9_9.getText().equals("")) {
            pos9_9 = Integer.parseInt(txtGrid9_9.getText());
        }
        retGrid[8][0] = pos9_1;
        retGrid[8][1] = pos9_2;
        retGrid[8][2] = pos9_3;
        retGrid[8][3] = pos9_4;
        retGrid[8][4] = pos9_5;
        retGrid[8][5] = pos9_6;
        retGrid[8][6] = pos9_7;
        retGrid[8][7] = pos9_8;
        retGrid[8][8] = pos9_9;
        
        return retGrid;
    }
    
    private void updateBoard() {
        //Line 1
        txtGrid1_1.setText(String.valueOf(puzzle[0][0]));
        txtGrid1_2.setText(String.valueOf(puzzle[0][1]));
        txtGrid1_3.setText(String.valueOf(puzzle[0][2]));
        txtGrid1_4.setText(String.valueOf(puzzle[0][3]));
        txtGrid1_5.setText(String.valueOf(puzzle[0][4]));
        txtGrid1_6.setText(String.valueOf(puzzle[0][5]));
        txtGrid1_7.setText(String.valueOf(puzzle[0][6]));
        txtGrid1_8.setText(String.valueOf(puzzle[0][7]));
        txtGrid1_9.setText(String.valueOf(puzzle[0][8]));

        //Line 2
        txtGrid2_1.setText(String.valueOf(puzzle[1][0]));
        txtGrid2_2.setText(String.valueOf(puzzle[1][1]));
        txtGrid2_3.setText(String.valueOf(puzzle[1][2]));
        txtGrid2_4.setText(String.valueOf(puzzle[1][3]));
        txtGrid2_5.setText(String.valueOf(puzzle[1][4]));
        txtGrid2_6.setText(String.valueOf(puzzle[1][5]));
        txtGrid2_7.setText(String.valueOf(puzzle[1][6]));
        txtGrid2_8.setText(String.valueOf(puzzle[1][7]));
        txtGrid2_9.setText(String.valueOf(puzzle[1][8]));

        //Line 3
        txtGrid3_1.setText(String.valueOf(puzzle[2][0]));
        txtGrid3_2.setText(String.valueOf(puzzle[2][1]));
        txtGrid3_3.setText(String.valueOf(puzzle[2][2]));
        txtGrid3_4.setText(String.valueOf(puzzle[2][3]));
        txtGrid3_5.setText(String.valueOf(puzzle[2][4]));
        txtGrid3_6.setText(String.valueOf(puzzle[2][5]));
        txtGrid3_7.setText(String.valueOf(puzzle[2][6]));
        txtGrid3_8.setText(String.valueOf(puzzle[2][7]));
        txtGrid3_9.setText(String.valueOf(puzzle[2][8]));

        //Line 4
        txtGrid4_1.setText(String.valueOf(puzzle[3][0]));
        txtGrid4_2.setText(String.valueOf(puzzle[3][1]));
        txtGrid4_3.setText(String.valueOf(puzzle[3][2]));
        txtGrid4_4.setText(String.valueOf(puzzle[3][3]));
        txtGrid4_5.setText(String.valueOf(puzzle[3][4]));
        txtGrid4_6.setText(String.valueOf(puzzle[3][5]));
        txtGrid4_7.setText(String.valueOf(puzzle[3][6]));
        txtGrid4_8.setText(String.valueOf(puzzle[3][7]));
        txtGrid4_9.setText(String.valueOf(puzzle[3][8]));

        //Line 5
        txtGrid5_1.setText(String.valueOf(puzzle[4][0]));
        txtGrid5_2.setText(String.valueOf(puzzle[4][1]));
        txtGrid5_3.setText(String.valueOf(puzzle[4][2]));
        txtGrid5_4.setText(String.valueOf(puzzle[4][3]));
        txtGrid5_5.setText(String.valueOf(puzzle[4][4]));
        txtGrid5_6.setText(String.valueOf(puzzle[4][5]));
        txtGrid5_7.setText(String.valueOf(puzzle[4][6]));
        txtGrid5_8.setText(String.valueOf(puzzle[4][7]));
        txtGrid5_9.setText(String.valueOf(puzzle[4][8]));

        //Line 6
        txtGrid6_1.setText(String.valueOf(puzzle[5][0]));
        txtGrid6_2.setText(String.valueOf(puzzle[5][1]));
        txtGrid6_3.setText(String.valueOf(puzzle[5][2]));
        txtGrid6_4.setText(String.valueOf(puzzle[5][3]));
        txtGrid6_5.setText(String.valueOf(puzzle[5][4]));
        txtGrid6_6.setText(String.valueOf(puzzle[5][5]));
        txtGrid6_7.setText(String.valueOf(puzzle[5][6]));
        txtGrid6_8.setText(String.valueOf(puzzle[5][7]));
        txtGrid6_9.setText(String.valueOf(puzzle[5][8]));

        //Line 7
        txtGrid7_1.setText(String.valueOf(puzzle[6][0]));
        txtGrid7_2.setText(String.valueOf(puzzle[6][1]));
        txtGrid7_3.setText(String.valueOf(puzzle[6][2]));
        txtGrid7_4.setText(String.valueOf(puzzle[6][3]));
        txtGrid7_5.setText(String.valueOf(puzzle[6][4]));
        txtGrid7_6.setText(String.valueOf(puzzle[6][5]));
        txtGrid7_7.setText(String.valueOf(puzzle[6][6]));
        txtGrid7_8.setText(String.valueOf(puzzle[6][7]));
        txtGrid7_9.setText(String.valueOf(puzzle[6][8]));

        //Line 8 
        txtGrid8_1.setText(String.valueOf(puzzle[7][0]));
        txtGrid8_2.setText(String.valueOf(puzzle[7][1]));
        txtGrid8_3.setText(String.valueOf(puzzle[7][2]));
        txtGrid8_4.setText(String.valueOf(puzzle[7][3]));
        txtGrid8_5.setText(String.valueOf(puzzle[7][4]));
        txtGrid8_6.setText(String.valueOf(puzzle[7][5]));
        txtGrid8_7.setText(String.valueOf(puzzle[7][6]));
        txtGrid8_8.setText(String.valueOf(puzzle[7][7]));
        txtGrid8_9.setText(String.valueOf(puzzle[7][8]));

        //Line 9 
        txtGrid9_1.setText(String.valueOf(puzzle[8][0]));
        txtGrid9_2.setText(String.valueOf(puzzle[8][1]));
        txtGrid9_3.setText(String.valueOf(puzzle[8][2]));
        txtGrid9_4.setText(String.valueOf(puzzle[8][3]));
        txtGrid9_5.setText(String.valueOf(puzzle[8][4]));
        txtGrid9_6.setText(String.valueOf(puzzle[8][5]));
        txtGrid9_7.setText(String.valueOf(puzzle[8][6]));
        txtGrid9_8.setText(String.valueOf(puzzle[8][7]));
        txtGrid9_9.setText(String.valueOf(puzzle[8][8]));
    }
    
    private void setGridVariable() {
        arrTxtGrid[0][0] = txtGrid1_1;
        arrTxtGrid[0][1] = txtGrid1_2;
        arrTxtGrid[0][2] = txtGrid1_3;
        arrTxtGrid[0][3] = txtGrid1_4;
        arrTxtGrid[0][4] = txtGrid1_5;
        arrTxtGrid[0][5] = txtGrid1_6;
        arrTxtGrid[0][6] = txtGrid1_7;
        arrTxtGrid[0][7] = txtGrid1_8;
        arrTxtGrid[0][8] = txtGrid1_9;
        
        arrTxtGrid[1][0] = txtGrid2_1;
        arrTxtGrid[1][1] = txtGrid2_2;
        arrTxtGrid[1][2] = txtGrid2_3;
        arrTxtGrid[1][3] = txtGrid2_4;
        arrTxtGrid[1][4] = txtGrid2_5;
        arrTxtGrid[1][5] = txtGrid2_6;
        arrTxtGrid[1][6] = txtGrid2_7;
        arrTxtGrid[1][7] = txtGrid2_8;
        arrTxtGrid[1][8] = txtGrid2_9;
        
        arrTxtGrid[2][0] = txtGrid3_1;
        arrTxtGrid[2][1] = txtGrid3_2;
        arrTxtGrid[2][2] = txtGrid3_3;
        arrTxtGrid[2][3] = txtGrid3_4;
        arrTxtGrid[2][4] = txtGrid3_5;
        arrTxtGrid[2][5] = txtGrid3_6;
        arrTxtGrid[2][6] = txtGrid3_7;
        arrTxtGrid[2][7] = txtGrid3_8;
        arrTxtGrid[2][8] = txtGrid3_9;
        
        arrTxtGrid[3][0] = txtGrid4_1;
        arrTxtGrid[3][1] = txtGrid4_2;
        arrTxtGrid[3][2] = txtGrid4_3;
        arrTxtGrid[3][3] = txtGrid4_4;
        arrTxtGrid[3][4] = txtGrid4_5;
        arrTxtGrid[3][5] = txtGrid4_6;
        arrTxtGrid[3][6] = txtGrid4_7;
        arrTxtGrid[3][7] = txtGrid4_8;
        arrTxtGrid[3][8] = txtGrid4_9;
        
        arrTxtGrid[4][0] = txtGrid5_1;
        arrTxtGrid[4][1] = txtGrid5_2;
        arrTxtGrid[4][2] = txtGrid5_3;
        arrTxtGrid[4][3] = txtGrid5_4;
        arrTxtGrid[4][4] = txtGrid5_5;
        arrTxtGrid[4][5] = txtGrid5_6;
        arrTxtGrid[4][6] = txtGrid5_7;
        arrTxtGrid[4][7] = txtGrid5_8;
        arrTxtGrid[4][8] = txtGrid5_9;
        
        arrTxtGrid[5][0] = txtGrid6_1;
        arrTxtGrid[5][1] = txtGrid6_2;
        arrTxtGrid[5][2] = txtGrid6_3;
        arrTxtGrid[5][3] = txtGrid6_4;
        arrTxtGrid[5][4] = txtGrid6_5;
        arrTxtGrid[5][5] = txtGrid6_6;
        arrTxtGrid[5][6] = txtGrid6_7;
        arrTxtGrid[5][7] = txtGrid6_8;
        arrTxtGrid[5][8] = txtGrid6_9;
        
        arrTxtGrid[6][0] = txtGrid7_1;
        arrTxtGrid[6][1] = txtGrid7_2;
        arrTxtGrid[6][2] = txtGrid7_3;
        arrTxtGrid[6][3] = txtGrid7_4;
        arrTxtGrid[6][4] = txtGrid7_5;
        arrTxtGrid[6][5] = txtGrid7_6;
        arrTxtGrid[6][6] = txtGrid7_7;
        arrTxtGrid[6][7] = txtGrid7_8;
        arrTxtGrid[6][8] = txtGrid7_9;
        
        arrTxtGrid[7][0] = txtGrid8_1;
        arrTxtGrid[7][1] = txtGrid8_2;
        arrTxtGrid[7][2] = txtGrid8_3;
        arrTxtGrid[7][3] = txtGrid8_4;
        arrTxtGrid[7][4] = txtGrid8_5;
        arrTxtGrid[7][5] = txtGrid8_6;
        arrTxtGrid[7][6] = txtGrid8_7;
        arrTxtGrid[7][7] = txtGrid8_8;
        arrTxtGrid[7][8] = txtGrid8_9;
        
        arrTxtGrid[8][0] = txtGrid9_1;
        arrTxtGrid[8][1] = txtGrid9_2;
        arrTxtGrid[8][2] = txtGrid9_3;
        arrTxtGrid[8][3] = txtGrid9_4;
        arrTxtGrid[8][4] = txtGrid9_5;
        arrTxtGrid[8][5] = txtGrid9_6;
        arrTxtGrid[8][6] = txtGrid9_7;
        arrTxtGrid[8][7] = txtGrid9_8;
        arrTxtGrid[8][8] = txtGrid9_9;
    }

    //</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblUserInfo = new javax.swing.JLabel();
        lblMode = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        lblHour = new javax.swing.JLabel();
        lblMinutes = new javax.swing.JLabel();
        lblSeconds = new javax.swing.JLabel();
        txtGrid1_1 = new javax.swing.JTextField();
        txtGrid1_2 = new javax.swing.JTextField();
        txtGrid1_3 = new javax.swing.JTextField();
        txtGrid1_4 = new javax.swing.JTextField();
        txtGrid1_5 = new javax.swing.JTextField();
        txtGrid1_6 = new javax.swing.JTextField();
        txtGrid1_7 = new javax.swing.JTextField();
        txtGrid1_8 = new javax.swing.JTextField();
        txtGrid1_9 = new javax.swing.JTextField();
        txtGrid2_1 = new javax.swing.JTextField();
        txtGrid2_2 = new javax.swing.JTextField();
        txtGrid2_3 = new javax.swing.JTextField();
        txtGrid2_4 = new javax.swing.JTextField();
        txtGrid2_5 = new javax.swing.JTextField();
        txtGrid2_7 = new javax.swing.JTextField();
        txtGrid2_6 = new javax.swing.JTextField();
        txtGrid2_8 = new javax.swing.JTextField();
        txtGrid2_9 = new javax.swing.JTextField();
        txtGrid3_1 = new javax.swing.JTextField();
        txtGrid3_2 = new javax.swing.JTextField();
        txtGrid3_3 = new javax.swing.JTextField();
        txtGrid3_4 = new javax.swing.JTextField();
        txtGrid3_5 = new javax.swing.JTextField();
        txtGrid3_6 = new javax.swing.JTextField();
        txtGrid3_7 = new javax.swing.JTextField();
        txtGrid3_8 = new javax.swing.JTextField();
        txtGrid3_9 = new javax.swing.JTextField();
        txtGrid4_1 = new javax.swing.JTextField();
        txtGrid4_2 = new javax.swing.JTextField();
        txtGrid4_3 = new javax.swing.JTextField();
        txtGrid4_4 = new javax.swing.JTextField();
        txtGrid4_5 = new javax.swing.JTextField();
        txtGrid4_6 = new javax.swing.JTextField();
        txtGrid4_7 = new javax.swing.JTextField();
        txtGrid4_8 = new javax.swing.JTextField();
        txtGrid4_9 = new javax.swing.JTextField();
        txtGrid5_1 = new javax.swing.JTextField();
        txtGrid5_2 = new javax.swing.JTextField();
        txtGrid5_3 = new javax.swing.JTextField();
        txtGrid5_4 = new javax.swing.JTextField();
        txtGrid5_5 = new javax.swing.JTextField();
        txtGrid5_6 = new javax.swing.JTextField();
        txtGrid5_7 = new javax.swing.JTextField();
        txtGrid5_8 = new javax.swing.JTextField();
        txtGrid5_9 = new javax.swing.JTextField();
        txtGrid6_1 = new javax.swing.JTextField();
        txtGrid6_2 = new javax.swing.JTextField();
        txtGrid6_3 = new javax.swing.JTextField();
        txtGrid6_4 = new javax.swing.JTextField();
        txtGrid6_5 = new javax.swing.JTextField();
        txtGrid6_6 = new javax.swing.JTextField();
        txtGrid6_7 = new javax.swing.JTextField();
        txtGrid6_8 = new javax.swing.JTextField();
        txtGrid6_9 = new javax.swing.JTextField();
        txtGrid7_1 = new javax.swing.JTextField();
        txtGrid7_2 = new javax.swing.JTextField();
        txtGrid7_3 = new javax.swing.JTextField();
        txtGrid7_4 = new javax.swing.JTextField();
        txtGrid7_5 = new javax.swing.JTextField();
        txtGrid7_6 = new javax.swing.JTextField();
        txtGrid7_7 = new javax.swing.JTextField();
        txtGrid7_8 = new javax.swing.JTextField();
        txtGrid7_9 = new javax.swing.JTextField();
        txtGrid8_1 = new javax.swing.JTextField();
        txtGrid8_2 = new javax.swing.JTextField();
        txtGrid8_3 = new javax.swing.JTextField();
        txtGrid8_4 = new javax.swing.JTextField();
        txtGrid8_5 = new javax.swing.JTextField();
        txtGrid8_6 = new javax.swing.JTextField();
        txtGrid8_7 = new javax.swing.JTextField();
        txtGrid8_8 = new javax.swing.JTextField();
        txtGrid8_9 = new javax.swing.JTextField();
        txtGrid9_1 = new javax.swing.JTextField();
        txtGrid9_2 = new javax.swing.JTextField();
        txtGrid9_3 = new javax.swing.JTextField();
        txtGrid9_4 = new javax.swing.JTextField();
        txtGrid9_5 = new javax.swing.JTextField();
        txtGrid9_6 = new javax.swing.JTextField();
        txtGrid9_7 = new javax.swing.JTextField();
        txtGrid9_8 = new javax.swing.JTextField();
        txtGrid9_9 = new javax.swing.JTextField();
        lblBoard = new javax.swing.JLabel();
        btnFinish = new javax.swing.JButton();
        btnHint = new javax.swing.JButton();
        btnRest = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon.png"))); // NOI18N
        getContentPane().add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 110));

        lblTitle.setFont(new java.awt.Font("Rage Italic", 1, 68)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Sudoku Solver");
        lblTitle.setToolTipText("");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 70));

        lblUserInfo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblUserInfo.setText("User:      ");
        getContentPane().add(lblUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 290, 50));

        lblMode.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblMode.setText("Mode:      ");
        getContentPane().add(lblMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 310, 50));

        lblTimer.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTimer.setText("Timer:");
        getContentPane().add(lblTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 50));

        lblHour.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblHour.setText("00:");
        lblHour.setToolTipText("Hour Used");
        getContentPane().add(lblHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 137, 60, -1));

        lblMinutes.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblMinutes.setText("00:");
        lblMinutes.setToolTipText("Minute Used");
        getContentPane().add(lblMinutes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 137, 60, -1));

        lblSeconds.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblSeconds.setText("00");
        lblSeconds.setToolTipText("Second Used");
        getContentPane().add(lblSeconds, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 137, 40, -1));

        txtGrid1_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_1.setBorder(null);
        txtGrid1_1.setFocusCycleRoot(true);
        txtGrid1_1.setOpaque(false);
        txtGrid1_1.setVerifyInputWhenFocusTarget(false);
        txtGrid1_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 60, 50));

        txtGrid1_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_2.setBorder(null);
        txtGrid1_2.setOpaque(false);
        txtGrid1_2.setPreferredSize(new java.awt.Dimension(20, 43));
        txtGrid1_2.setVerifyInputWhenFocusTarget(false);
        txtGrid1_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 50, 50));

        txtGrid1_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_3.setBorder(null);
        txtGrid1_3.setOpaque(false);
        txtGrid1_3.setVerifyInputWhenFocusTarget(false);
        txtGrid1_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 60, 50));

        txtGrid1_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_4.setBorder(null);
        txtGrid1_4.setOpaque(false);
        txtGrid1_4.setVerifyInputWhenFocusTarget(false);
        txtGrid1_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 50, 50));

        txtGrid1_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_5.setBorder(null);
        txtGrid1_5.setOpaque(false);
        txtGrid1_5.setVerifyInputWhenFocusTarget(false);
        txtGrid1_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 60, 50));

        txtGrid1_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_6.setBorder(null);
        txtGrid1_6.setOpaque(false);
        txtGrid1_6.setVerifyInputWhenFocusTarget(false);
        txtGrid1_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 50, 50));

        txtGrid1_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_7.setBorder(null);
        txtGrid1_7.setOpaque(false);
        txtGrid1_7.setVerifyInputWhenFocusTarget(false);
        txtGrid1_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 50, 50));

        txtGrid1_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_8.setBorder(null);
        txtGrid1_8.setOpaque(false);
        txtGrid1_8.setVerifyInputWhenFocusTarget(false);
        txtGrid1_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 60, 50));

        txtGrid1_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid1_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid1_9.setBorder(null);
        txtGrid1_9.setOpaque(false);
        txtGrid1_9.setVerifyInputWhenFocusTarget(false);
        txtGrid1_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid1_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid1_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 50, 50));

        txtGrid2_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_1.setBorder(null);
        txtGrid2_1.setOpaque(false);
        txtGrid2_1.setVerifyInputWhenFocusTarget(false);
        txtGrid2_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 60, 60));

        txtGrid2_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_2.setBorder(null);
        txtGrid2_2.setOpaque(false);
        txtGrid2_2.setVerifyInputWhenFocusTarget(false);
        txtGrid2_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 50, 60));

        txtGrid2_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_3.setBorder(null);
        txtGrid2_3.setOpaque(false);
        txtGrid2_3.setVerifyInputWhenFocusTarget(false);
        txtGrid2_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 60, 60));

        txtGrid2_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_4.setBorder(null);
        txtGrid2_4.setOpaque(false);
        txtGrid2_4.setVerifyInputWhenFocusTarget(false);
        txtGrid2_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 50, 60));

        txtGrid2_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_5.setBorder(null);
        txtGrid2_5.setOpaque(false);
        txtGrid2_5.setVerifyInputWhenFocusTarget(false);
        txtGrid2_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 60, 60));

        txtGrid2_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_7.setBorder(null);
        txtGrid2_7.setOpaque(false);
        txtGrid2_7.setVerifyInputWhenFocusTarget(false);
        txtGrid2_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 50, 60));

        txtGrid2_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_6.setBorder(null);
        txtGrid2_6.setOpaque(false);
        txtGrid2_6.setVerifyInputWhenFocusTarget(false);
        txtGrid2_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 50, 60));

        txtGrid2_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_8.setBorder(null);
        txtGrid2_8.setOpaque(false);
        txtGrid2_8.setVerifyInputWhenFocusTarget(false);
        txtGrid2_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 60, 60));

        txtGrid2_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid2_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid2_9.setBorder(null);
        txtGrid2_9.setOpaque(false);
        txtGrid2_9.setVerifyInputWhenFocusTarget(false);
        txtGrid2_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid2_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid2_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 50, 60));

        txtGrid3_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_1.setBorder(null);
        txtGrid3_1.setOpaque(false);
        txtGrid3_1.setVerifyInputWhenFocusTarget(false);
        txtGrid3_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 60, 50));

        txtGrid3_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_2.setBorder(null);
        txtGrid3_2.setOpaque(false);
        txtGrid3_2.setVerifyInputWhenFocusTarget(false);
        txtGrid3_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 50, 50));

        txtGrid3_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_3.setBorder(null);
        txtGrid3_3.setOpaque(false);
        txtGrid3_3.setVerifyInputWhenFocusTarget(false);
        txtGrid3_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 60, 50));

        txtGrid3_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_4.setBorder(null);
        txtGrid3_4.setOpaque(false);
        txtGrid3_4.setVerifyInputWhenFocusTarget(false);
        txtGrid3_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 50, 50));

        txtGrid3_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_5.setBorder(null);
        txtGrid3_5.setOpaque(false);
        txtGrid3_5.setVerifyInputWhenFocusTarget(false);
        txtGrid3_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 60, 50));

        txtGrid3_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_6.setBorder(null);
        txtGrid3_6.setOpaque(false);
        txtGrid3_6.setVerifyInputWhenFocusTarget(false);
        txtGrid3_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 50, 50));

        txtGrid3_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_7.setBorder(null);
        txtGrid3_7.setOpaque(false);
        txtGrid3_7.setVerifyInputWhenFocusTarget(false);
        txtGrid3_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 50, 50));

        txtGrid3_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_8.setBorder(null);
        txtGrid3_8.setOpaque(false);
        txtGrid3_8.setVerifyInputWhenFocusTarget(false);
        txtGrid3_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 60, 50));

        txtGrid3_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid3_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid3_9.setBorder(null);
        txtGrid3_9.setOpaque(false);
        txtGrid3_9.setVerifyInputWhenFocusTarget(false);
        txtGrid3_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid3_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid3_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 50, 50));

        txtGrid4_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_1.setBorder(null);
        txtGrid4_1.setOpaque(false);
        txtGrid4_1.setVerifyInputWhenFocusTarget(false);
        txtGrid4_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 60, 60));

        txtGrid4_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_2.setBorder(null);
        txtGrid4_2.setOpaque(false);
        txtGrid4_2.setVerifyInputWhenFocusTarget(false);
        txtGrid4_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 50, 60));

        txtGrid4_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_3.setBorder(null);
        txtGrid4_3.setOpaque(false);
        txtGrid4_3.setVerifyInputWhenFocusTarget(false);
        txtGrid4_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 60, 60));

        txtGrid4_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_4.setBorder(null);
        txtGrid4_4.setOpaque(false);
        txtGrid4_4.setVerifyInputWhenFocusTarget(false);
        txtGrid4_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 50, 60));

        txtGrid4_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_5.setBorder(null);
        txtGrid4_5.setOpaque(false);
        txtGrid4_5.setVerifyInputWhenFocusTarget(false);
        txtGrid4_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 60, 60));

        txtGrid4_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_6.setBorder(null);
        txtGrid4_6.setOpaque(false);
        txtGrid4_6.setVerifyInputWhenFocusTarget(false);
        txtGrid4_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 50, 60));

        txtGrid4_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_7.setBorder(null);
        txtGrid4_7.setOpaque(false);
        txtGrid4_7.setVerifyInputWhenFocusTarget(false);
        txtGrid4_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 50, 60));

        txtGrid4_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_8.setBorder(null);
        txtGrid4_8.setOpaque(false);
        txtGrid4_8.setVerifyInputWhenFocusTarget(false);
        txtGrid4_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 60, 60));

        txtGrid4_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid4_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid4_9.setBorder(null);
        txtGrid4_9.setOpaque(false);
        txtGrid4_9.setVerifyInputWhenFocusTarget(false);
        txtGrid4_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid4_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid4_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 50, 60));

        txtGrid5_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_1.setBorder(null);
        txtGrid5_1.setOpaque(false);
        txtGrid5_1.setVerifyInputWhenFocusTarget(false);
        txtGrid5_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 60, 50));

        txtGrid5_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_2.setBorder(null);
        txtGrid5_2.setOpaque(false);
        txtGrid5_2.setVerifyInputWhenFocusTarget(false);
        txtGrid5_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 50, 50));

        txtGrid5_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_3.setBorder(null);
        txtGrid5_3.setOpaque(false);
        txtGrid5_3.setVerifyInputWhenFocusTarget(false);
        txtGrid5_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 60, 50));

        txtGrid5_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_4.setBorder(null);
        txtGrid5_4.setOpaque(false);
        txtGrid5_4.setVerifyInputWhenFocusTarget(false);
        txtGrid5_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 50, 50));

        txtGrid5_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_5.setBorder(null);
        txtGrid5_5.setOpaque(false);
        txtGrid5_5.setVerifyInputWhenFocusTarget(false);
        txtGrid5_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 60, 50));

        txtGrid5_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_6.setBorder(null);
        txtGrid5_6.setOpaque(false);
        txtGrid5_6.setVerifyInputWhenFocusTarget(false);
        txtGrid5_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 50, 50));

        txtGrid5_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_7.setBorder(null);
        txtGrid5_7.setOpaque(false);
        txtGrid5_7.setVerifyInputWhenFocusTarget(false);
        txtGrid5_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 50, 50));

        txtGrid5_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_8.setBorder(null);
        txtGrid5_8.setOpaque(false);
        txtGrid5_8.setVerifyInputWhenFocusTarget(false);
        txtGrid5_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 60, 50));

        txtGrid5_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid5_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid5_9.setBorder(null);
        txtGrid5_9.setOpaque(false);
        txtGrid5_9.setVerifyInputWhenFocusTarget(false);
        txtGrid5_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid5_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid5_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 50, 50));

        txtGrid6_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_1.setBorder(null);
        txtGrid6_1.setOpaque(false);
        txtGrid6_1.setVerifyInputWhenFocusTarget(false);
        txtGrid6_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 60, 60));

        txtGrid6_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_2.setBorder(null);
        txtGrid6_2.setOpaque(false);
        txtGrid6_2.setVerifyInputWhenFocusTarget(false);
        txtGrid6_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 50, 60));

        txtGrid6_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_3.setBorder(null);
        txtGrid6_3.setOpaque(false);
        txtGrid6_3.setVerifyInputWhenFocusTarget(false);
        txtGrid6_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 60, 60));

        txtGrid6_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_4.setBorder(null);
        txtGrid6_4.setOpaque(false);
        txtGrid6_4.setVerifyInputWhenFocusTarget(false);
        txtGrid6_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 50, 60));

        txtGrid6_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_5.setBorder(null);
        txtGrid6_5.setOpaque(false);
        txtGrid6_5.setVerifyInputWhenFocusTarget(false);
        txtGrid6_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 60, 60));

        txtGrid6_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_6.setBorder(null);
        txtGrid6_6.setOpaque(false);
        txtGrid6_6.setVerifyInputWhenFocusTarget(false);
        txtGrid6_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 50, 60));

        txtGrid6_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_7.setBorder(null);
        txtGrid6_7.setOpaque(false);
        txtGrid6_7.setVerifyInputWhenFocusTarget(false);
        txtGrid6_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 50, 60));

        txtGrid6_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_8.setBorder(null);
        txtGrid6_8.setOpaque(false);
        txtGrid6_8.setVerifyInputWhenFocusTarget(false);
        txtGrid6_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 60, 60));

        txtGrid6_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid6_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid6_9.setBorder(null);
        txtGrid6_9.setOpaque(false);
        txtGrid6_9.setVerifyInputWhenFocusTarget(false);
        txtGrid6_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid6_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid6_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 50, 60));

        txtGrid7_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_1.setBorder(null);
        txtGrid7_1.setOpaque(false);
        txtGrid7_1.setVerifyInputWhenFocusTarget(false);
        txtGrid7_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 60, 50));

        txtGrid7_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_2.setBorder(null);
        txtGrid7_2.setOpaque(false);
        txtGrid7_2.setVerifyInputWhenFocusTarget(false);
        txtGrid7_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 50, 50));

        txtGrid7_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_3.setBorder(null);
        txtGrid7_3.setOpaque(false);
        txtGrid7_3.setVerifyInputWhenFocusTarget(false);
        txtGrid7_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 60, 50));

        txtGrid7_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_4.setBorder(null);
        txtGrid7_4.setOpaque(false);
        txtGrid7_4.setVerifyInputWhenFocusTarget(false);
        txtGrid7_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 50, 50));

        txtGrid7_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_5.setBorder(null);
        txtGrid7_5.setOpaque(false);
        txtGrid7_5.setVerifyInputWhenFocusTarget(false);
        txtGrid7_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 60, 50));

        txtGrid7_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_6.setBorder(null);
        txtGrid7_6.setOpaque(false);
        txtGrid7_6.setVerifyInputWhenFocusTarget(false);
        txtGrid7_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 50, 50));

        txtGrid7_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_7.setBorder(null);
        txtGrid7_7.setOpaque(false);
        txtGrid7_7.setVerifyInputWhenFocusTarget(false);
        txtGrid7_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 50, 50));

        txtGrid7_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_8.setBorder(null);
        txtGrid7_8.setOpaque(false);
        txtGrid7_8.setVerifyInputWhenFocusTarget(false);
        txtGrid7_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 60, 50));

        txtGrid7_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid7_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid7_9.setBorder(null);
        txtGrid7_9.setOpaque(false);
        txtGrid7_9.setVerifyInputWhenFocusTarget(false);
        txtGrid7_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid7_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid7_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 50, 50));

        txtGrid8_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_1.setBorder(null);
        txtGrid8_1.setOpaque(false);
        txtGrid8_1.setVerifyInputWhenFocusTarget(false);
        txtGrid8_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 60, 60));

        txtGrid8_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_2.setBorder(null);
        txtGrid8_2.setOpaque(false);
        txtGrid8_2.setVerifyInputWhenFocusTarget(false);
        txtGrid8_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 50, 60));

        txtGrid8_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_3.setBorder(null);
        txtGrid8_3.setOpaque(false);
        txtGrid8_3.setVerifyInputWhenFocusTarget(false);
        txtGrid8_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 60, 60));

        txtGrid8_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_4.setBorder(null);
        txtGrid8_4.setOpaque(false);
        txtGrid8_4.setVerifyInputWhenFocusTarget(false);
        txtGrid8_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 50, 60));

        txtGrid8_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_5.setBorder(null);
        txtGrid8_5.setOpaque(false);
        txtGrid8_5.setVerifyInputWhenFocusTarget(false);
        txtGrid8_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 60, 60));

        txtGrid8_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_6.setBorder(null);
        txtGrid8_6.setOpaque(false);
        txtGrid8_6.setVerifyInputWhenFocusTarget(false);
        txtGrid8_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 50, 60));

        txtGrid8_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_7.setBorder(null);
        txtGrid8_7.setOpaque(false);
        txtGrid8_7.setVerifyInputWhenFocusTarget(false);
        txtGrid8_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 50, 60));

        txtGrid8_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_8.setBorder(null);
        txtGrid8_8.setOpaque(false);
        txtGrid8_8.setVerifyInputWhenFocusTarget(false);
        txtGrid8_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 60, 60));

        txtGrid8_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid8_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid8_9.setBorder(null);
        txtGrid8_9.setOpaque(false);
        txtGrid8_9.setVerifyInputWhenFocusTarget(false);
        txtGrid8_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid8_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid8_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 50, 60));

        txtGrid9_1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_1.setBorder(null);
        txtGrid9_1.setOpaque(false);
        txtGrid9_1.setVerifyInputWhenFocusTarget(false);
        txtGrid9_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_1KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 60, 50));

        txtGrid9_2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_2.setBorder(null);
        txtGrid9_2.setOpaque(false);
        txtGrid9_2.setVerifyInputWhenFocusTarget(false);
        txtGrid9_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_2KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 50, 50));

        txtGrid9_3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_3.setBorder(null);
        txtGrid9_3.setOpaque(false);
        txtGrid9_3.setVerifyInputWhenFocusTarget(false);
        txtGrid9_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_3KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 60, 50));

        txtGrid9_4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_4.setBorder(null);
        txtGrid9_4.setOpaque(false);
        txtGrid9_4.setVerifyInputWhenFocusTarget(false);
        txtGrid9_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_4KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, 50, 50));

        txtGrid9_5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_5.setBorder(null);
        txtGrid9_5.setOpaque(false);
        txtGrid9_5.setVerifyInputWhenFocusTarget(false);
        txtGrid9_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_5KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, 60, 50));

        txtGrid9_6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_6.setBorder(null);
        txtGrid9_6.setOpaque(false);
        txtGrid9_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_6KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 630, 50, 50));

        txtGrid9_7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_7.setBorder(null);
        txtGrid9_7.setOpaque(false);
        txtGrid9_7.setVerifyInputWhenFocusTarget(false);
        txtGrid9_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_7KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 50, 50));

        txtGrid9_8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_8.setBorder(null);
        txtGrid9_8.setOpaque(false);
        txtGrid9_8.setVerifyInputWhenFocusTarget(false);
        txtGrid9_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_8KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, 60, 50));

        txtGrid9_9.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtGrid9_9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrid9_9.setBorder(null);
        txtGrid9_9.setOpaque(false);
        txtGrid9_9.setVerifyInputWhenFocusTarget(false);
        txtGrid9_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrid9_9KeyTyped(evt);
            }
        });
        getContentPane().add(txtGrid9_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 630, 50, 50));

        lblBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Grid.png"))); // NOI18N
        getContentPane().add(lblBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 510, 510));

        btnFinish.setBackground(new java.awt.Color(0, 0, 0));
        btnFinish.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnFinish.setText("Finish");
        btnFinish.setOpaque(false);
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 380, 50));

        btnHint.setBackground(new java.awt.Color(0, 0, 0));
        btnHint.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnHint.setText("Hint");
        btnHint.setToolTipText("This Will Input An Number ");
        btnHint.setOpaque(false);
        btnHint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHintActionPerformed(evt);
            }
        });
        getContentPane().add(btnHint, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 170, 50));

        btnRest.setBackground(new java.awt.Color(0, 0, 0));
        btnRest.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnRest.setText("Reset");
        btnRest.setToolTipText("Clear All The Input");
        btnRest.setOpaque(false);
        btnRest.setRequestFocusEnabled(false);
        btnRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestActionPerformed(evt);
            }
        });
        getContentPane().add(btnRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 170, 50));

        btnHelp.setBackground(new java.awt.Color(0, 0, 0));
        btnHelp.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        btnHelp.setText("Help");
        btnHelp.setOpaque(false);
        btnHelp.setRequestFocusEnabled(false);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 170, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Background5.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 1020));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        if (determineAllAnswerCorrect()) {
            dbConnection.updateBestTime(accNumber, lblHour.getText() + lblMinutes.getText() + lblSeconds.getText());
            //Get Option Seleceted  0 = yes, 1 = no
            int result = JOptionPane.showConfirmDialog(null, "Do You Want To Play Another Game?",
                    "Select An Option From The Following...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (result == 0) {
                this.dispose();
                new Login(true,accNumber).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Thank You For Using This Programm");
                this.dispose();
                new Menu().setVisible(true);
            }
            
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    private void btnRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestActionPerformed
        //Get Option Seleceted  0 = yes, 1 = no
        int result = JOptionPane.showConfirmDialog(null, "The Game Will Reset(You will lose all the input!)",
                "Select An Option From The Following...", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (result == 0) {
            updateBoard();
            disableGenBlock(puzzleHolder.getPuzzle());
        }
    }//GEN-LAST:event_btnRestActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        new Help().setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

//<editor-fold defaultstate="collapsed" desc="CustomMethod">
    public void startGame() {
        //Generate Sudoku Puzzle 2-D Integer
        puzzle = sudokuGenerator.createSudoku(genLevel);
        sudokuSolver = new SudokuSolver(puzzle);
        solvedPuzzle = sudokuSolver.getSolved();
        
        setGridVariable();//Parse board textFields to text Field Array

        //Get Sudoku Puzzle 1-D Integer
        int tempPuz[][] = new int[9][9];
        tempPuzzle = sudokuGenerator.getSudoku();
        int r = -1, c = 0;
        for (int i = 0; i < 81; i++) {
            if (i % 9 == 0) {
                r++;
                c = 0;
            }
            tempPuz[r][c] = tempPuzzle[i];
            c++;
        }
        
        puzzleHolder = new PuzzleHolder(tempPuz);
        disableGenBlock(tempPuz);
        
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (!(tempPuz[x][y] == solvedPuzzle[x][y])) {
                    answer[x][y] = solvedPuzzle[x][y];
                } else {
                    answered[x][y] = true;
                }
                if (!answered[x][y]) {
                    answerLeft++;
                }
            }
        }
        sudokuSolver.printBoard(answer);
        timer();//Start Timer
    }
    
    public void timer() {
        timeRunning = true;
        timerThread = new Thread() {
            public void run() {
                for (;;) {
                    if (timeRunning == true) {
                        try {
                            sleep(1000);
                            if (seconds == 60) {
                                seconds = 0;
                                minutes++;
                            }
                            if (minutes == 60) {
                                seconds = 0;
                                minutes = 0;
                                hours++;
                            }
                            seconds++;
                            lblSeconds.setText(String.valueOf(seconds));
                            lblMinutes.setText(String.valueOf(minutes) + ":");
                            lblHour.setText(String.valueOf(hours) + ":");
                        } catch (Exception e) {
                        }
                    } else {
                        break;
                    }
                }
            }
        };
        timerThread.start();
    }
    
    public void determineLevel(int inLevel) {
        if (inLevel == 1) {
            gameLevel = 1;
            genLevel = 42;
            level = "Easy";
            btnHint.setVisible(true);
        }
        if (inLevel == 2) {
            gameLevel = 2;
            genLevel = 32;
            level = "Medium";
            btnHint.setVisible(true);
        }
        if (inLevel == 3) {
            gameLevel = 3;
            genLevel = 22;
            level = "Hard";
           btnHint.setVisible(false);
        }
    }
    
    public void disableGenBlock(int[][] inPuzzle) {
        updateBoard();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (!(inPuzzle[x][y] == 0)) {
                    arrTxtGrid[x][y].setForeground(Color.gray);
                    arrTxtGrid[x][y].setEditable(false);
                    arrTxtGrid[x][y].setFocusable(false);
                    if (gameLevel == 3) {
                         answerLeft--;
                    }
                } else {
                    arrTxtGrid[x][y].setText("");
                }
            }
        }
        System.out.println("gen: " + answerLeft);
    }
    
    public boolean determineAllAnswerCorrect() {
        updateUserAns();
        if (gameLevel == 1 || gameLevel == 2) {
            updateAnswerLeft();
        }
        System.out.println(answerLeft);
        int tempPuz[][] = new int[9][9];
        tempPuz = puzzleHolder.getPuzzle();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (gameLevel == 1 || gameLevel == 2) {
                    if ((userAnswer[row][column] == answer[row][column]) && !(userAnswer[row][column] == 0) && !(answer[row][column] == tempPuz[row][column])) {
                        arrTxtGrid[row][column].setForeground(Color.green);
                        answered[row][column] = true;
                        updateAnswerLeft();
                    }
                    if (!(userAnswer[row][column] == answer[row][column]) && !(userAnswer[row][column] == 0) && !(answer[row][column] == tempPuz[row][column])) {
                        arrTxtGrid[row][column].setForeground(Color.red);
                        answered[row][column] = false;
                         updateAnswerLeft();
                    }
                }
                
                if (gameLevel == 3) {
                    if ((userAnswer[row][column] == answer[row][column]) && !(userAnswer[row][column] == 0) && !(answer[row][column] == 0)) {
                        answered[row][column] = true;
                    } 
                     updateUserAns();
                     updateAnswerLeft();
                }
            }
        }
        if (answerLeft == 0) {
            timerThread.stop();
            JOptionPane.showMessageDialog(this, "Congratulation! You Have Solved The Puzzle");
            return true;            
        } else {
            updateUserAns();
            JOptionPane.showMessageDialog(this, "Puzzle Not Solved!", "OOPS...", JOptionPane.WARNING_MESSAGE);
            System.out.println("Answer Left: " + answerLeft);
            return false;
        }
    }
    
    public void updateUserAns() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (!answered[x][y]) {
                    if (!arrTxtGrid[x][y].getText().isEmpty()) {
                        userAnswer[x][y] = Integer.parseInt(arrTxtGrid[x][y].getText());
                    } else {
                        userAnswer[x][y] = 0;
                    }
                }
            }
        }
       // updateAnswerLeft();
    }
    
    public void executeHint() {
        updateUserAns();
        if (answerLeft > 0) {
            int r = 0, c = 0;
            getNextHint:
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if (!answered[x][y]) {
                        r = x;
                        c = y;
                        break getNextHint;
                    }
                }
            }
            answered[r][c] = true;
            arrTxtGrid[r][c].setForeground(Color.blue);
            arrTxtGrid[r][c].setText(String.valueOf(answer[r][c]));
            answerLeft--;
        }
        updateUserAns();
    }
    
    public void updateAnswerLeft() {
        int ansLeft = 0;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (!answered[x][y]) {
                    ansLeft++;
                }
            }
        }
        answerLeft = ansLeft;
    }
  
//</editor-fold>  
    
//<editor-fold defaultstate="collapsed" desc="KeyTyped">
    private void txtGrid1_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_1KeyTyped

    private void txtGrid1_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_2KeyTyped

    private void txtGrid1_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_3KeyTyped

    private void txtGrid1_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_4KeyTyped

    private void txtGrid1_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_5KeyTyped

    private void txtGrid1_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_6KeyTyped

    private void txtGrid1_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_7KeyTyped

    private void txtGrid1_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_8KeyTyped

    private void txtGrid1_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid1_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid1_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid1_9KeyTyped

    private void txtGrid2_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_1KeyTyped

    private void txtGrid2_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_2KeyTyped

    private void txtGrid2_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_3KeyTyped

    private void txtGrid2_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_4KeyTyped

    private void txtGrid2_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_5KeyTyped

    private void txtGrid2_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_6KeyTyped

    private void txtGrid2_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_7KeyTyped

    private void txtGrid2_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_8KeyTyped

    private void txtGrid2_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid2_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid2_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid2_9KeyTyped

    private void txtGrid3_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_1KeyTyped

    private void txtGrid3_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_2KeyTyped

    private void txtGrid3_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_3KeyTyped

    private void txtGrid3_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_4KeyTyped

    private void txtGrid3_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_5KeyTyped

    private void txtGrid3_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_6KeyTyped

    private void txtGrid3_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_7KeyTyped

    private void txtGrid3_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_8KeyTyped

    private void txtGrid3_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid3_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid3_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid3_9KeyTyped

    private void txtGrid4_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_1KeyTyped

    private void txtGrid4_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_2KeyTyped

    private void txtGrid4_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_3KeyTyped

    private void txtGrid4_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_4KeyTyped

    private void txtGrid4_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_5KeyTyped

    private void txtGrid4_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_6KeyTyped

    private void txtGrid4_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_7KeyTyped

    private void txtGrid4_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_8KeyTyped

    private void txtGrid4_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid4_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid4_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid4_9KeyTyped

    private void txtGrid5_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_1KeyTyped

    private void txtGrid5_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_2KeyTyped

    private void txtGrid5_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_3KeyTyped

    private void txtGrid5_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_4KeyTyped

    private void txtGrid5_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_5KeyTyped

    private void txtGrid5_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_6KeyTyped

    private void txtGrid5_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_7KeyTyped

    private void txtGrid5_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_8KeyTyped

    private void txtGrid5_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid5_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid5_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid5_9KeyTyped

    private void txtGrid6_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_1KeyTyped

    private void txtGrid6_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_2KeyTyped

    private void txtGrid6_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_3KeyTyped

    private void txtGrid6_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_4KeyTyped

    private void txtGrid6_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_5KeyTyped

    private void txtGrid6_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_6KeyTyped

    private void txtGrid6_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_7KeyTyped

    private void txtGrid6_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_8KeyTyped

    private void txtGrid6_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid6_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid6_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid6_9KeyTyped

    private void txtGrid7_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_1KeyTyped

    private void txtGrid7_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_2KeyTyped

    private void txtGrid7_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_3KeyTyped

    private void txtGrid7_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_4KeyTyped

    private void txtGrid7_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_5KeyTyped

    private void txtGrid7_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_6KeyTyped

    private void txtGrid7_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_7KeyTyped

    private void txtGrid7_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_8KeyTyped

    private void txtGrid7_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid7_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid7_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid7_9KeyTyped

    private void txtGrid8_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_1KeyTyped

    private void txtGrid8_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_2KeyTyped

    private void txtGrid8_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_3KeyTyped

    private void txtGrid8_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_4KeyTyped

    private void txtGrid8_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_5KeyTyped

    private void txtGrid8_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_6KeyTyped

    private void txtGrid8_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_7KeyTyped

    private void txtGrid8_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_8KeyTyped

    private void txtGrid8_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid8_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid8_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid8_9KeyTyped

    private void txtGrid9_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_1KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_1.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_1KeyTyped

    private void txtGrid9_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_2KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_2.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_2KeyTyped

    private void txtGrid9_3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_3KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_3.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_3KeyTyped

    private void txtGrid9_4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_4KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_4.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_4KeyTyped

    private void txtGrid9_5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_5KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_5.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_5KeyTyped

    private void txtGrid9_6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_6KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_6.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_6KeyTyped

    private void txtGrid9_7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_7KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_7.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_7KeyTyped

    private void txtGrid9_8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_8KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_8.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_8KeyTyped

    private void txtGrid9_9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrid9_9KeyTyped
        char keyChar = evt.getKeyChar();
        if (!(Character.isDigit(keyChar)) || txtGrid9_9.getText().length() == 1 || keyChar == KeyEvent.VK_0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGrid9_9KeyTyped

    private void btnHintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHintActionPerformed
        executeHint();
    }//GEN-LAST:event_btnHintActionPerformed
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Generated Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHint;
    private javax.swing.JButton btnRest;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBoard;
    private javax.swing.JLabel lblHour;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMinutes;
    private javax.swing.JLabel lblMode;
    private javax.swing.JLabel lblSeconds;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserInfo;
    private javax.swing.JTextField txtGrid1_1;
    private javax.swing.JTextField txtGrid1_2;
    private javax.swing.JTextField txtGrid1_3;
    private javax.swing.JTextField txtGrid1_4;
    private javax.swing.JTextField txtGrid1_5;
    private javax.swing.JTextField txtGrid1_6;
    private javax.swing.JTextField txtGrid1_7;
    private javax.swing.JTextField txtGrid1_8;
    private javax.swing.JTextField txtGrid1_9;
    private javax.swing.JTextField txtGrid2_1;
    private javax.swing.JTextField txtGrid2_2;
    private javax.swing.JTextField txtGrid2_3;
    private javax.swing.JTextField txtGrid2_4;
    private javax.swing.JTextField txtGrid2_5;
    private javax.swing.JTextField txtGrid2_6;
    private javax.swing.JTextField txtGrid2_7;
    private javax.swing.JTextField txtGrid2_8;
    private javax.swing.JTextField txtGrid2_9;
    private javax.swing.JTextField txtGrid3_1;
    private javax.swing.JTextField txtGrid3_2;
    private javax.swing.JTextField txtGrid3_3;
    private javax.swing.JTextField txtGrid3_4;
    private javax.swing.JTextField txtGrid3_5;
    private javax.swing.JTextField txtGrid3_6;
    private javax.swing.JTextField txtGrid3_7;
    private javax.swing.JTextField txtGrid3_8;
    private javax.swing.JTextField txtGrid3_9;
    private javax.swing.JTextField txtGrid4_1;
    private javax.swing.JTextField txtGrid4_2;
    private javax.swing.JTextField txtGrid4_3;
    private javax.swing.JTextField txtGrid4_4;
    private javax.swing.JTextField txtGrid4_5;
    private javax.swing.JTextField txtGrid4_6;
    private javax.swing.JTextField txtGrid4_7;
    private javax.swing.JTextField txtGrid4_8;
    private javax.swing.JTextField txtGrid4_9;
    private javax.swing.JTextField txtGrid5_1;
    private javax.swing.JTextField txtGrid5_2;
    private javax.swing.JTextField txtGrid5_3;
    private javax.swing.JTextField txtGrid5_4;
    private javax.swing.JTextField txtGrid5_5;
    private javax.swing.JTextField txtGrid5_6;
    private javax.swing.JTextField txtGrid5_7;
    private javax.swing.JTextField txtGrid5_8;
    private javax.swing.JTextField txtGrid5_9;
    private javax.swing.JTextField txtGrid6_1;
    private javax.swing.JTextField txtGrid6_2;
    private javax.swing.JTextField txtGrid6_3;
    private javax.swing.JTextField txtGrid6_4;
    private javax.swing.JTextField txtGrid6_5;
    private javax.swing.JTextField txtGrid6_6;
    private javax.swing.JTextField txtGrid6_7;
    private javax.swing.JTextField txtGrid6_8;
    private javax.swing.JTextField txtGrid6_9;
    private javax.swing.JTextField txtGrid7_1;
    private javax.swing.JTextField txtGrid7_2;
    private javax.swing.JTextField txtGrid7_3;
    private javax.swing.JTextField txtGrid7_4;
    private javax.swing.JTextField txtGrid7_5;
    private javax.swing.JTextField txtGrid7_6;
    private javax.swing.JTextField txtGrid7_7;
    private javax.swing.JTextField txtGrid7_8;
    private javax.swing.JTextField txtGrid7_9;
    private javax.swing.JTextField txtGrid8_1;
    private javax.swing.JTextField txtGrid8_2;
    private javax.swing.JTextField txtGrid8_3;
    private javax.swing.JTextField txtGrid8_4;
    private javax.swing.JTextField txtGrid8_5;
    private javax.swing.JTextField txtGrid8_6;
    private javax.swing.JTextField txtGrid8_7;
    private javax.swing.JTextField txtGrid8_8;
    private javax.swing.JTextField txtGrid8_9;
    private javax.swing.JTextField txtGrid9_1;
    private javax.swing.JTextField txtGrid9_2;
    private javax.swing.JTextField txtGrid9_3;
    private javax.swing.JTextField txtGrid9_4;
    private javax.swing.JTextField txtGrid9_5;
    private javax.swing.JTextField txtGrid9_6;
    private javax.swing.JTextField txtGrid9_7;
    private javax.swing.JTextField txtGrid9_8;
    private javax.swing.JTextField txtGrid9_9;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
    
}//Game Class
