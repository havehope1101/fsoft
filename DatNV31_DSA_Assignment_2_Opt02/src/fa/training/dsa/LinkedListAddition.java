package fa.training.dsa;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListAddition {
    public static LinkedList<Integer> linkedListAdd() {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        System.out.println("Enter the number of elements in the first list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements of the first list: ");
        for (int i = 0; i < n; i++) {
            list1.add(scanner.nextInt());
        }
        System.out.println("Enter the number of elements in the second list: ");
        int m = scanner.nextInt();
        System.out.println("Enter the elements of the second list: ");
        for (int i = 0; i < m; i++) {
            list2.add(scanner.nextInt());
        }
        int carry = 0;
        int sum;
        while (!list1.isEmpty() || !list2.isEmpty()) {
            sum = carry + (list1.isEmpty() ? 0 : list1.removeFirst()) + (list2.isEmpty() ? 0 : list2.removeFirst());
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            result.add(sum);
        }
        if (carry > 0) {
            result.add(carry);
        }
        for (Integer i : result) {
            System.out.print(i);
        }
        scanner.close();
        return result;
    }
}

