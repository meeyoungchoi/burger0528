package main;

import controller.BurgerController;
import controller.IngredientController;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BurgerController bg = new BurgerController();
    static IngredientController ig = new IngredientController();
    public static void main(String[] args) {
        while (true) {
            System.out.println("1.버거관리 2.재료관리 3.종료");
            int num = scanner.nextInt();

            if (num == 1) {
                burgerStart();
            } else if (num == 2) {
                ingredientStart();
            } else {
                System.out.println("프로그램 종료");
                break;
            }

        }
    }

    public static void burgerStart() {
        while (true) {
            System.out.println("1.버거목록 2.버거추가 3.버거삭제 4.버거조회 5.버거수정 6.종료");
            int num = scanner.nextInt();

            if (num == 1) {
                bg.printList();
            } else if (num == 2) {
                bg.create();
            } else if (num == 3) {
                bg.delete();
            } else if (num == 4) {
                bg.show();
            } else if (num == 5) {
                bg.update();
            } else {
                System.out.println("버거 종료");
                break;
            }



        }
    }

    public static void ingredientStart() {
        while (true) {
            System.out.println("1.재료목록 2.재료추가 3.재료삭제 4.재료조회 5.재료수정 6.종료");
            int num = scanner.nextInt();

            if (num == 1) {
                ig.printList();
            } else if (num == 2) {
                ig.create();
            } else if (num == 3) {
                ig.delete();
            } else if (num == 4) {
                ig.show();
            } else if (num == 5) {
                ig.update();
            } else {
                System.out.println("재료종료");
                break;
            }

        }
    }


}
