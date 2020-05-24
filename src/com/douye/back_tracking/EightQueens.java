package com.douye.back_tracking;

public class EightQueens {

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.caculateQueen(8);
    }

    int[] rows;
    int ways;
    public void caculateQueen(int count) {
        rows = new int[count];
        place(0);
        System.out.println("共有【" + ways + "】种摆放方法");
    }

    public void place(int row) {
        if (row == rows.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < rows.length; col++) {
            if (isValide(row,col)) {
                rows[row] = col;
                place(row+1);
            }
        }
    }

    public boolean isValide(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (rows[i] == col) return false;
            if (row - i == Math.abs(col-rows[i])) return false;
        }
        return true;
    }
    public void show(){
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                if (rows[i] == j) System.out.print(1+" ");
                else System.out.print(0+" ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }


}
