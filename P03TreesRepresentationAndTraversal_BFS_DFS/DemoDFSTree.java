package P03TreesRepresentationAndTraversal_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DemoDFSTree {
    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    public static void main(String[] args) {

        List<StringBuilder> rows = new ArrayList<>(Arrays.asList(
                //                 0123456789
                new StringBuilder("..##............"),  //0
                new StringBuilder(".##.###........."),  //1
                new StringBuilder(".#....#........."),  //2
                new StringBuilder(".##.###........."),  //3
                new StringBuilder(".##...#........."),  //4
                new StringBuilder(".######........."),  //5
                new StringBuilder("................"),  //6
                new StringBuilder("................"),  //7
                new StringBuilder("................")   //8

        ));

        fill(rows, 2, 4, 'A');
        printRows(rows);

    }

    private static void printRows(List<StringBuilder> rows) {
        for (StringBuilder row : rows) {
            System.out.println(row.toString());
        }
    }

    private static void fill(List<StringBuilder> matrix, int startRow, int startCol, char fillChar) {
        char oldChar = matrix.get(startRow).charAt(startCol);
        Stack<Cell> nextToFill = new Stack<>();
        nextToFill.push(new Cell(startRow, startCol));

        while (!nextToFill.isEmpty()) {
            Cell currentToFill = nextToFill.pop();
            int row = currentToFill.getRow();
            int col = currentToFill.getCol();
            matrix.get(currentToFill.row).setCharAt(currentToFill.col, fillChar);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            if (matrix.get(row).charAt(col - 1) == oldChar) {
                nextToFill.push(new Cell(row, col - 1));
                //fill(matrix, row, col - 1, fillChar);
            }

            if (matrix.get(row).charAt(col + 1) == oldChar) {
                nextToFill.push(new Cell(row, col + 1));
                //fill(matrix, row, col + 1, fillChar);
            }

            if (matrix.get(row - 1).charAt(col) == oldChar) {
                nextToFill.push(new Cell(row - 1, col));
                //fill(matrix, row - 1, col, fillChar);
            }

            if (matrix.get(row + 1).charAt(col) == oldChar) {
                nextToFill.push(new Cell(row + 1, col));
                //fill(matrix, row + 1, col, fillChar);
            }


            printRows(matrix);
            System.out.println();
        }
    }


}
