package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker passwordChecker = new PasswordChecker();
        System.out.print("Введите мин. длину пароля(8 и более): ");
        int lenght = scanner.nextInt();
        passwordChecker.setMinLength(lenght);
        System.out.print("Введите макс. кол-во повторений символов подряд(от 1): ");
        int repits = scanner.nextInt();
        passwordChecker.setMaxRepits(repits);


        Scanner passScan = new Scanner(System.in);
        do {
            System.out.print("Введите пароль или end: ");
            String password = passScan.nextLine();
            if ("end".equals(password)) {
                break;
            }

            if (passwordChecker.verify(password)) {
                System.out.println("Пароль подходит!");
            } else {
                System.out.println("Пароль не подходит!");
            }

        } while (true);
    }

}