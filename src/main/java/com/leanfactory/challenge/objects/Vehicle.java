package com.leanfactory.challenge.objects;

public class Vehicle {

    private int currentRow;
    private int currentCol;

    private int rows;
    private Surface surface;

    public Vehicle(Surface surface,int row) {
        this.surface = surface;
        this.currentRow = row;
        this.currentCol = 0;
        this.rows = row;

    }

    public boolean move(int numSteps, char direction) {
        int newRow = currentRow;
        int newCol = currentCol;


        switch (direction) {
            case 'N':
                newRow -= numSteps;
                break;
            case 'S':
                newRow += numSteps;
                break;
            case 'E':
                newCol += numSteps;
                break;
            case 'O':
                newCol -= numSteps;
                break;
        }

        if (surface.isInBounds(newRow, newCol)) {
            currentRow = newRow;
            currentCol = newCol;
            System.out.println(String.format("(%d,%d)", this.rows -currentRow, currentCol));
            return true;
        } else {
            System.out.println("Se ha detenido el avance por salir de los límites");
            return false;
        }
    }

}
