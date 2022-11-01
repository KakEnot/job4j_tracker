package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            while (matches < 1 || matches > 3 || matches > count) {
                System.out.println("Ошибка! Введите число от 1 до 3:");
                matches = Integer.parseInt(input.nextLine());
            }
            count -= matches;
            System.out.println(count);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}

/*2. В методе main добавьте цикл. Игра заканчивается, когда игрок забрал последние спички. В цикле нужно проверять
количество спичек.
3. Сделайте ввод данных от пользователя. Сначала первый игрок вводит число от 1 до 3, потом второй и
так далее. Когда игрок ввел цифру, нужно показать сколько спичек осталось на столе.
4. Добавьте валидацию пользовательского ввода: перевод хода и пересчёт спичек должен производиться только
 если введённое количество находится в пределах от 1 до 3 (включительно), и при этом не больше числа оставшихся
 спичек (count). В противном случае пользователю должно быть показано сообщение об ошибке.*/