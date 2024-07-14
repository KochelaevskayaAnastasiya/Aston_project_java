package ru.aston;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice = 0;
        Integer[] array = new Integer[0];
        while (choice != 4) {
            System.out.flush();
            System.out.println("Привет!");
            System.out.println("Текущий массив:" + Arrays.toString(array));
            System.out.println("1 - Добавить/изменить массив");
            System.out.println("2 - Провести сортировку Gnome Sort");
            System.out.println("3 - Провести сортировку Shaker Sort");
            System.out.println("4 - Выход");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    //добавить ввод количества элементов и способ добавления
                    System.out.println("Введите размер массива:");
                    String size = scan.nextLine();
                    int n;
                    try {
                        n = Integer.parseInt(size);
                        if (n <= 0) {
                            throw new IllegalArgumentException("Размер массива должен быть больше нуля. Выберете заново интересующий пункт.");
                        }
                        int choiceType = 0;
                        while (choiceType != 4) {
                            System.out.println("Выберете способ ввода данных");
                            System.out.println("1 - С консоли");
                            System.out.println("2 - Из файла");
                            System.out.println("3 - Рандомно");
                            System.out.println("4 - Вернуться в главное меню");
                            choiceType = scan.nextInt();
                            scan.nextLine();
                            switch (choiceType) {
                                case 1:
                                    System.out.println("Введите массив целых чисел через пробел:");
                                    String arrayString = scan.nextLine();
                                    try {
                                        List<Integer> result = new ArrayList<>(
                                                Arrays.stream(arrayString.split(" "))
                                                        .map(Integer::parseInt)
                                                        .toList());
                                        boolean rightCount = false;
                                        while (!rightCount){
                                            if (result.size()<n)
                                            {
                                                System.out.printf("Количество введенных элементов недостаточно! Введите еще %s элементов:%n", n - result.size());
                                                String arrayStringAdd = scan.nextLine();
                                                List<Integer> arrayAdd = Arrays.stream(arrayStringAdd.split(" "))
                                                        .map(Integer::parseInt)
                                                        .toList();
                                                result.addAll(arrayAdd);
                                            }
                                            else {
                                                if(result.size()>n){
                                                    System.out.printf("Количество введенных элементов превыщает размер массива. %s элементов было отброшено%n", result.size() - n);
                                                    result = result.subList(0, n);
                                                }
                                                rightCount = true;
                                                choiceType = 4;
                                            }
                                        }
                                        array = result.toArray(Integer[]::new);
                                    }catch (NumberFormatException e){
                                        System.out.println("Неверный ввод. Числа должны быть целые.");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Укажите путь к файлу с данными");
                                    String filePath = scan.nextLine();

                                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                                        StringBuilder result = new StringBuilder();
                                        int i;
                                        while ((i = reader.read()) != -1){
                                            result.append((char)i);
                                        }
                                    //    array = getArray...
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Файл не найден. Повторите ввод.");
                                    } catch (IOException e) {
                                        System.out.println("Ошибка ввода. Убедитесь, что файл содержит массив целых чисел.");
                                    }
                                    break;
                                case 3:
                                    array = new Random().ints(-100,100).limit(n).boxed().toArray(Integer[]::new);
                                    choiceType = 4;
                                    break;
                                case 4:
                                    System.out.println("Возвращаемся в главное меню.");
                                    break;
                                default:
                                    System.out.println("Неверный ввод. Введите число от 1 до 3");
                            }
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Размер массива должен быть целым числом. Выберете заново интересующий пункт.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
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