//          Zaki Jefferson
//          24 October 2019
//          Project: Knights Tour
/*          Description: This problem allows
 *              the user to input rows
 *              and columns to complete a
 *              small area. The missing spaces
 *              will then fill themselves in.
 */


package Projects;

import runKnightTour.KnightMoves;

import java.util.*;

public class KnightTour {

    public class KnightMoves {

        public final int COMPLETE_TOUR = 64;
        private ChessBoard kBoard = new ChessBoard();
        private int[][] moves = new int[8][2];
        private int stepNumber;
        private int currentRow;
        private int currentCol;
        private int startRow;
        private int startCol;

        public KnightMoves() {
            moves[0][0] = -2; // move 0 row offset
            moves[0][1] = 1; // move 0 col offset

            moves[1][0] = -1; // move 1 row offset
            moves[1][1] = 2; // move 1 col offset

            moves[2][0] = 1; // move 2 row offset
            moves[2][1] = 2; // move 2 col offset

            moves[3][0] = 2; // move 3 row offset
            moves[3][1] = 1; // move 3 col offset

            moves[4][0] = 2; // move 4 row offset
            moves[4][1] = -1; // move 4 col offset

            moves[5][0] = 1; // move 5 row offset
            moves[5][1] = -2; // move 5 col offset

            moves[6][0] = -1; // move 6 row offset
            moves[6][1] = -2; // move 6 col offset

            moves[7][0] = -2; // move 7 row offset
            moves[7][1] = -1; // move 7 col offset

            stepNumber = 0;
            startRow = startCol = 1;
            currentRow = currentCol = 1;

        }

        /*
         * Description:  Get the starting board Position (row, col) for the
         * KNIGHT from program user
         */

        public void getStartPosition() {

            Scanner input = new Scanner(System.in);

            System.out.print("\n enter a starting location for the knight's row ");
            startRow = input.nextInt();
            System.out.print("\n enter a starting location for the knight's col ");
            startCol = input.nextInt();

            kBoard.setSquare(startRow, startCol, 1);
            System.out.println(kBoard);

        }

        /*
         * Mutator: runTour()
         */

        public void runTour() {

            getStartPosition();

            // while stepNumber < 64 and takeStep() == true

            // knight should keep stepping

            // if stepNumber is equal to COMPLETE_TOUR

            // report that the knight made a complete tour

            while (stepNumber < 64 && takeStep() == true) {
                if (stepNumber == COMPLETE_TOUR) {
                    System.out.println("To Complete Successfully");
                }
            }

            System.out.println(this);
        }


        private boolean takeStep() {
            boolean step = false;

            Random rand = new Random();

            int random1;
            int attempts = 0;

            random1 = rand.nextInt(8);

            int tryStepRow = 0;
            int tryStepCol = 0;

            do {
                tryStepRow = currentRow + moves[random1][0];
                tryStepCol = currentCol + moves[random1][1];


                if (kBoard.getSquare(tryStepRow, tryStepCol) == 0) {
                    kBoard.setSquare(tryStepRow, tryStepCol, stepNumber++);
                    currentRow = tryStepRow;
                    currentCol = tryStepCol;
                } else {
                    attempts++;
                }
            }
            while (step == false && attempts < 200);
            return step;
        }


        public String toString() {
            String whatHappened = "";

            whatHappened += "Starting location: [" + startRow + ", "

                    + startCol + "]\n";

            whatHappened += " Tour ended after " + stepNumber + " steps\n";

            whatHappened += "The knight got stuck in location ["

                    + (currentRow - 1) + ", " + (currentCol - 1) + "]\n";

            return whatHappened;
        }
    }


    public class ChessBoard {

        public final int ROWS = 8;
        public final int COLS = 8;
        public final int FRAMESIZE = 12;
        private int[][] board = new int[FRAMESIZE][FRAMESIZE];

        public ChessBoard() {
            for (int y = 0; y < board.length; y++) {

                for (int x = 0; x < board[y].length; x++) {

                    board[y][x] = -1;

                }
                for (int r = 2; r < ROWS + 2; r++) {
                    for (int c = 2; c < COLS + 2; c++) {
                        board[r][c] = 0;
                    }
                }


            }
        }

        public String toString() {
            String output = "";
            for (int r = 0; r < FRAMESIZE; r++) {
                for (int c = 0; c < FRAMESIZE; c++) {
                    output += board[r][c];
                    output += "\t";
                }
                output += "\n\n";
            }
            return output;
        }

        /*
         * @param row
         * @param col
         * @param inStep in the range of 1 - 64
         */
        public void setSquare(int row, int col, int inStep) {
            //  adjust input to match 2 - 9
            row += 1;
            col += 1;
            if (row > 1 && row < 10 && col > 1 && col < 10) {
                board[row][col] = inStep;
            }
        }

        public int getSquare(int row, int col) {
            return board[row][col];
        }
    }

    public static void main(String[] args) {
        runKnightTour.KnightMoves tour = new runKnightTour.KnightMoves();
        tour.runTour();
    }
}
