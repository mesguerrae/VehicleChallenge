package com.leanfactory.challenge.objects;

public class Surface {
    private int numRows;
    private int numCols;

    public Surface(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

}
