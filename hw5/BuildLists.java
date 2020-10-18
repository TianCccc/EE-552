package hw5;

/**
 * @author Tiancheng Xu
 * Write a program to create an ArrayList<Integer>.
 * Fill it with numbers from 1 to 1000.
 * Then remove every even number.
 * Then remove every multiple of 3 remaining
 * Then remove every multiple of 5
 * Then remove every multiple of 7
 * Then sum the array, and print.
 */

 import java.util.ArrayList;

 public class BuildLists {
    public static void main (String[] args) {
        ArrayList<Integer> ary = new ArrayList<Integer>();
        
        // Fill it with numbers from 1 to 1000
        for (int i = 1; i <= 1000; i++) {
            ary.add(i);
        }
        System.out.println(ary);

        // Remove every even number
        for (int i = ary.size() - 1; i >= 0; i--) {
            if (ary.get(i) % 2 == 0) {
                ary.remove(i);
            }
        }
        System.out.println(ary);

        // Then remove every multiple of 3 remaining
        for (int i = ary.size() - 1; i >= 0; i--) {
            if (ary.get(i) % 3 == 0) {
                ary.remove(i);
            }
        }
        System.out.println(ary);

        // Then remove every multiple of 5 remaining
        for (int i = ary.size() - 1; i >= 0; i--) {
            if (ary.get(i) % 5 == 0) {
                ary.remove(i);
            }
        }
        System.out.println(ary);

        // Then remove every multiple of 7 remaining
        for (int i = ary.size() - 1; i >= 0; i--) {
            if (ary.get(i) % 7 == 0) {
                ary.remove(i);
            }
        }
        System.out.println(ary);

        // Sum the array
        int sum = 0;
        for (int i = 0; i < ary.size(); i++) {
            sum += ary.get(i);
        }
        System.out.println(sum);
    }
 }