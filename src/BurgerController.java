import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BurgerController {
    Scanner scanner = new Scanner(System.in);
    static List<Burger> burgerList = new ArrayList<>();
    static Integer count = 0;

    public void addBurger() {
        System.out.println(" 버거이름을 입력하세요(에) 와퍼)");
        String name = scanner.next();


        System.out.println(" 버거 가격을 입력하세요 (에) 5900)");
        int price = scanner.nextInt();

        count += 1;
        BurgerForm form = new BurgerForm(count, name, price);
        System.out.println(form.getId() + " , " + form.getName() + " , " + form.getPrice());
        Burger burger = form.toEntity();
        System.out.println(burger.getId() + " , " + burger.getName() + " , " + burger.getPrice());

        burgerList.add(burger);

    }

    public void printList() {
        for (int i = 0; i < burgerList.size(); i++) {
            System.out.println(burgerList.get(i).getId() + " " + burgerList.get(i).getName() + " " + burgerList.get(i).getPrice());
        }
    }

    public void editBurger() {
        for (int i = 0; i < burgerList.size(); i++) {
            System.out.println(burgerList.get(i).getId() + " " + burgerList.get(i).getName() + " " + burgerList.get(i).getPrice());
        }

        System.out.println("수정할 버거 번호를 입력하세요");
        int index = scanner.nextInt();//3


        System.out.println("index: " + index);//3

        updateBurger(index);//3


    }


    public void updateBurger(Integer index) {//3
        String answer = null;
        String updateName = null;
        Integer updatePrice = null;
        int idx = -1;
        for (int i = 0; i < burgerList.size(); i++) {
            if (index == burgerList.get(i).getId()) {
                idx = i;//1
                System.out.println("idx: " + idx);
                break;
            }
        }

        int idx2 = idx;
        while (idx2 != -1) {
            System.out.println("id: " + burgerList.get(idx).getId());
            System.out.println("name: " + burgerList.get(idx).getName() + " 수정하시겠습니까? (y / n)");
            answer = scanner.next();
            if (answer.equals("y")) {
                System.out.println("수정할 버거 이름을 입력하세요");
                updateName = scanner.next();

                System.out.println("price: " + burgerList.get(idx).getPrice() + "수정하시겠습니까? (y / n)");
                answer = scanner.next();

                if (answer.equals("y")) {
                    updatePrice = scanner.nextInt();

                } else {
                    updatePrice = burgerList.get(idx).getPrice();
                    break;
                }



            } else if (answer.equals("n")) {
                updateName = burgerList.get(idx2).getName();
                System.out.println("price: " + burgerList.get(idx).getPrice() + "수정하시겠습니까? (y / n)");
                answer = scanner.next();

                if (answer.equals("y")) {
                    updatePrice = scanner.nextInt();



                } else {
                    updatePrice = burgerList.get(idx).getPrice();
                    break;
                }


            }

            break;


        }

        BurgerForm form = new BurgerForm(index, updateName, updatePrice);
        System.out.println(form.getId() + " , " + form.getName() + " , " + form.getPrice());
        Burger burger = form.toEntity();
        System.out.println(burger.getId() + " , " + burger.getName() + " , " + burger.getPrice());
        burgerList.get(idx).setId(index);
        burgerList.get(idx).setName(updateName);
        burgerList.get(idx).setPrice(updatePrice);


        System.out.println("===========================");
        System.out.println(burgerList.get(idx).getId() + " , " + burgerList.get(idx).getName() + " , " + burgerList.get(idx).getPrice());



    }

    public void deleteBurger() {
        printList();

        System.out.println("삭제할 번호를 입력하세요");
        int deleteIdx = scanner.nextInt();
        int id = -1;

        for (int i = 0; i < burgerList.size(); i++) {
            if (deleteIdx == burgerList.get(i).getId()) {
                id = i;
                break;
            }
        }


        burgerList.remove(id);
        System.out.println(deleteIdx + "번 삭제완료");

    }

    public void show() {
        printList();

        System.out.println("조회할 버거 번호를 입력하세요");
        int num = scanner.nextInt();

        int idx = -1;
        for (int i = 0; i < burgerList.size(); i++ ) {
            if (num == burgerList.get(i).getId()) {
                idx = i;
            }
        }

        System.out.println(burgerList.get(idx).getId() + " , " + burgerList.get(idx).getName() + " , " + burgerList.get(idx).getPrice());



    }




}
