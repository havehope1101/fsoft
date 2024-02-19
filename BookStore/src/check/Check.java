package check;

import java.util.Scanner;

public class Check {
    private Scanner Input = new Scanner(System.in);

    public int checkInput() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED_BOLD + "Hãy Nhập Số !!!" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + "Nhập Lựa Chọn: " + ConsoleColors.RESET);
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
                System.out.println(ConsoleColors.RED_BOLD + "Hãy Nhập Số !!!" + ConsoleColors.RESET);
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
                System.out.println(ConsoleColors.RED_BOLD + "Không Đúng Định Dạng !!!" + ConsoleColors.RESET);
            }
        } while (!check);
        return input;
    }
}
