package controller;

import dto.BurgerForm;
import vo.Burger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BurgerController {
    static List<Burger> burgerList = new ArrayList<>();
    static int count = 0;

    Scanner scanner = new Scanner(System.in);

    public void create() {
        System.out.println("버거 이름을 입력하세요 예)와퍼");
        String name = scanner.next();

        System.out.println("버거 가격을 입력하세요 예)6000");
        Integer price = scanner.nextInt();

        count += 1;

        BurgerForm form = new BurgerForm(count, name, price);
        System.out.println(form.toString());
        Burger burger = form.toEntity();
        System.out.println(burger.toString());

        burgerList.add(burger);

    }

    public void printList() {
        for (int i = 0; i < burgerList.size(); i++) {
            System.out.println(burgerList.get(i).toString());
        }
    }

    public void delete() {
        int delIdx = checkBurger();

        burgerList.remove(delIdx);
        //질문 모든 데이터 삭제시 새로추가할때 0인덱스부터 추가되어야 하는가 아니면 마지막 id를 기준으로 1이 더해져서 값이 들어가야 하는가?

    }


    public int checkBurger() {
        printList();
        System.out.println("삭제할 버거 번호를 입력하세요");
        int delNum = scanner.nextInt();

        int index = 0;
        for (int i = 0; i < burgerList.size(); i++) {
            if (delNum == burgerList.get(i).getId2()) {
                index = i;
                break;
            }
        }

        return index;
    }


    public void show() {
        printList();
        System.out.println("조회할 버거 번호를 입력하세요");
        int id = scanner.nextInt();

        int idx = 0;
        for (int i = 0; i < burgerList.size(); i++) {
            if (id == burgerList.get(i).getId2()) {
                idx = i;
                break;
            }
        }

        System.out.println(burgerList.get(idx).toString());

    }

    public void update() {
        printList();

        System.out.println("업데이트할 버거 번호를 입력하세요");
        int updateId = scanner.nextInt();

        int idx = -1;
        for (int i = 0; i < burgerList.size(); i++) {
            if (updateId == burgerList.get(i).getId2()) {
                idx = i;
                break;
            }
        }

        while (idx != -1) {
            System.out.println("이름: " + burgerList.get(idx).getName() + "수정하시겠습니까? ");
            String updateName = scanner.next();
            int updatePrice = -1;

            if (!(updateName.equals(""))) {
                System.out.println("가격: " + burgerList.get(idx).getPrice() + "수정하시겠습니까?");
                updatePrice = scanner.nextInt();


            } else if (updateName.equals(null)) {
                updateName = burgerList.get(idx).getName();

                System.out.println("가격: " + burgerList.get(idx).getPrice() + "수정하시겠습니까?");
                updatePrice = scanner.nextInt();

            }

            //질문 업데이트 구조가 이렇게 돌아가는것?
            BurgerForm form = new BurgerForm();
            form.setId(updateId);
            System.out.println("updateId: " + updateId);
            form.setName(updateName);
            form.setPrice(updatePrice);

            Burger burger = new Burger();
            burger.setId2(form.getId());
            System.out.println(burger.getId2());
            burger.setName(form.getName());
            burger.setPrice(form.getPrice());

            burgerList.get(idx).setId2(burger.getId2());
            burgerList.get(idx).setName(burger.getName());
            burgerList.get(idx).setPrice(burger.getPrice());

            break;

        }

    }



}
