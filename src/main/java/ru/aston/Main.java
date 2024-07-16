package ru.aston;

import java.io.*;


import ru.aston.sorting.*;

import java.util.*;

import static ru.aston.sorting.SortOption.*;

public class Main {
    public static void mainMenu(Integer[] array){
        System.out.flush();
        System.out.println("=================================================");
        System.out.println("Текущий массив:" + Arrays.toString(array));
        System.out.println("=================================================");
        System.out.println("1 - Добавить/изменить массив");
        System.out.println("2 - Провести сортировку Gnome Sort");
        System.out.println("3 - Провести сортировку Shaker Sort");
        System.out.println("4 - Выход");
    }

    public static void menuInput(){
        System.out.println("Выберете способ ввода данных");
        System.out.println("1 - С консоли");
        System.out.println("2 - Из файла");
        System.out.println("3 - Рандомно");
        System.out.println("4 - Вернуться в главное меню");
    }

    public static Integer[] getArray(Scanner scan, String arrayString, int n){
        List<Integer> result = new ArrayList<>(
                Arrays.stream(arrayString.split(" "))
                        .filter(s -> !s.isEmpty())
                        .map(Integer::parseInt)
                        .toList());
        boolean rightCount = false;
        while (!rightCount) {
            if (result.size() < n) {
                System.out.printf("Количество элементов недостаточно! Введите еще %s элементов:%n", n - result.size());
                String arrayStringAdd = scan.nextLine();
                List<Integer> arrayAdd = Arrays.stream(arrayStringAdd.split(" "))
                        .filter(s -> !s.isEmpty())
                        .map(Integer::parseInt)
                        .toList();
                result.addAll(arrayAdd);
            } else {
                if (result.size() > n) {
                    System.out.printf("Количество элементов превыщает размер массива. %s элементов было отброшено%n", result.size() - n);
                    result = result.subList(0, n);
                }
                rightCount = true;
            }
        }
        return result.toArray(Integer[]::new);
    }

    public static int getArraySize(Scanner scanner) {
        System.out.println("Введите размер массива:");
        String sizeStr = scanner.nextLine();
        try {
            int size = Integer.parseInt(sizeStr);
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть больше нуля. Попробуйте снова.");
            }
            return size;
        } catch (NumberFormatException e) {
            System.out.println("Размер массива должен быть целым числом. Попробуйте снова.");
            return -1;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static SortOption getTypeSorted(Scanner scan){
        int choiceType = 0;
        SortOption typeSort = null;
        while (choiceType != 4) {
            System.out.println("1 - Обычная сортировка");
            System.out.println("2 - Только четные элементы");
            System.out.println("3 - Только нечетные элементы");
            choiceType = scan.nextInt();
            scan.nextLine();
            switch (choiceType) {
                case 1:
                    typeSort = ALL;
                    choiceType = 4;
                    break;
                case 2:
                    typeSort = EVEN;
                    choiceType = 4;
                    break;
                case 3:
                    typeSort = ODD;
                    choiceType = 4;
                    break;
                default:
                    System.out.println("Неверный ввод. Введите число от 1 до 3");
            }
        }
        return typeSort;
    }

    public static Integer[] getArrayMenu(Scanner scan){
        Integer[] array = new Integer[0];
        int choiceType = 0;
        while (choiceType != 4) {
            menuInput();
            choiceType = scan.nextInt();
            scan.nextLine();
            switch (choiceType) {
                case 1:
                    int n1 = getArraySize(scan);
                    if (n1 > 0) {
                        System.out.println("Введите массив целых чисел через пробел:");
                        String arrayString = scan.nextLine();
                        array = getArray(scan, arrayString, n1);
                        choiceType = 4;
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
                        array = getArray(scan, result.toString(), result.toString().split(" ").length);
                        choiceType = 4;
                    } catch (FileNotFoundException e) {
                        System.out.println("Файл не найден. Повторите ввод.");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    int n3 = getArraySize(scan);
                    if (n3 > 0) {
                        array = new Random().ints(Integer.MIN_VALUE, Integer.MAX_VALUE).limit(n3).boxed().toArray(Integer[]::new);
                        choiceType = 4;
                    }
                    break;
                case 4:
                    System.out.println("Возвращаемся в главное меню.");
                    break;
                default:
                    System.out.println("Неверный ввод. Введите число от 1 до 4");
            }
        }
        return array;
    }
    public static void sortArray(Scanner scan, SortingStrategy sortingStrategy, Integer[] array){
        Integer[] copyArray = Arrays.copyOf(array, array.length);
        SortingResult sortingResult = sortingStrategy.sort(copyArray, getTypeSorted(scan));
        System.out.println("Отсортированный массив: " + Arrays.toString(sortingResult.getArray()));
        System.out.println("Количество перестановок: " + sortingResult.getCountPermutations());
        System.out.println("Время: " + sortingResult.getTimeSpent().toMillis() / 1000.0 + " секунд");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SortingStrategy sortingStrategy;
        int choice = 0;
        Integer[] array = new Integer[0];
        while (choice != 4) {
            try {
                mainMenu(array);
                choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {
                    case 1:
                        array = getArrayMenu(scan);
                        break;
                    case 2:
                        System.out.println("Gnome Sort");
                        sortingStrategy = new GnomeSort();
                        sortArray(scan, sortingStrategy, array);
                        break;
                    case 3:
                        System.out.println("Shaker Sort");
                        sortingStrategy = new ShakerSorting();
                        sortArray(scan, sortingStrategy, array);
                        break;
                    case 4:
                        System.out.println("Завершение работы");
                        break;
                    default:
                        System.out.println("Неверный ввод. Введите число от 1 до 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Числа должны быть целые.");
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Число должны быть целое.");
                scan.nextLine();
            }
        }
    }
}