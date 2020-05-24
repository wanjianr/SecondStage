package com.douye.recursion;

public class Hanoi {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(9,"A","B","C");
    }
    public void hanoi(int n, String a, String b, String c) {
        if (n < 2) {
            move(n, a, c);
            return;
        }
        hanoi(n-1,a, c, b);
        move(n,a,c);
        hanoi(n-1, b, a, c);
    }
    private void move(int n, String from, String to) {
        System.out.println("将第【"+ n +"】号盘:" + from + "-->" + to);
    }
    // 1 A->C 2 A-B 1 C->B 3 A->C 1 B-A 2 B-C 1 A=C
}
