import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.flush();
            System.out.println("Привет!");
            System.out.println("1 - Добавить данные");
            System.out.println("2 - Провести сортировку Gnome Sort");
            System.out.println("3 - Провести сортировку Shaker Sort");
            System.out.println("4 - Выход");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    //добавить ввод количества элементов и способ добавления
                    System.out.println("Второе меню");
                    break;
                case 2:
                    //вызов метода сортировки Gnome Sort
                    System.out.println("Gnome Sort");
                    break;
                case 3:
                    //вызов метода сортировки Shaker Sort
                    System.out.println("Shaker Sort");
                    break;
                case 4:
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println("Неверный ввод. Введите число от 1 до 4");

            }

        }

    }
}