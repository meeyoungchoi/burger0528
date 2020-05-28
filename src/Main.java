import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BurgerController bc = new BurgerController();
        while (true) {
            System.out.println("1.버거목록 2.버거추가 3.버거수정 4.버거삭제 5.버거조회");
            int num = scanner.nextInt();

            if (num == 1) {
                bc.printList();
            } else if (num == 2) {
                bc.addBurger();
            } else if (num == 3) {
                bc.editBurger();
            } else if (num == 4) {
                bc.deleteBurger();
            } else if (num == 5) {
                bc.show();
            }



        }
    }
}
