package fa.training.utils;

import java.util.Scanner;

public class Validate {
    private Scanner Input = new Scanner(System.in);

    public int checkInput() {
        int input;
        while(true) {
            try {
                input = Integer.parseInt(Input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println( "Please input number !!!" );
                System.out.print( "Input choice: " );
            }
        }
        return input;
    }

    public int checkInputNumber(String str) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number !!!");
                System.out.print(str);
            }
        }
        return input;
    }

    public String checkRegex(String str, String regex) {
        String input;
        boolean check = false;
        do {
            System.out.print(str);
            input = Input.nextLine();
            check = input.matches(regex);
            if (!check) {
                System.out.println("Wrong format !!! Please input again. Ex: 678-3-16-1486" );
            }
        } while (!check);
        return input;
    }

}
