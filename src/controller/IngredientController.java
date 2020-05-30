package controller;

import dto.IngredientForm;
import vo.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IngredientController {
    static List<Ingredient> ingredientList = new ArrayList<>();
    static int count = 0;

    Scanner scanner = new Scanner(System.in);

    public void create() {

        System.out.println("재료 이름을 입력하세요 예)소스 ");
        String name = scanner.next();

        System.out.println("재료 가격을 입력하세요 에) 100");
        int price = scanner.nextInt();

        count += 1;

        IngredientForm form = new IngredientForm(count, name, price);
        System.out.println(form.toString());

        Ingredient ingredient = form.toEntity();
        System.out.println(ingredient.toString());

        ingredientList.add(ingredient);

    }


    public void delete() {
        printList();

        System.out.println("삭제할 재료 번호를 입력하세요");
        Integer id = scanner.nextInt();

        Integer index = findIdx(id);
        Boolean status = checkId(id);

        if (status == true) {
            //질문 삭제할때 번호로 삭제가 안되는 이유?
            ingredientList.remove(ingredientList.get(index));
            System.out.println(id + "번 재료 삭제완료");

        } else if (status == false) {
            System.out.println("삭제할수 없는 번호 입니다.");
        }

    }

    public void printList() {
        for (int i = 0; i < ingredientList.size(); i++) {
            System.out.println(ingredientList.get(i).toString());
        }
    }

    public boolean checkId(Integer id) {
        boolean status = false;
        int idx = -1;

        for (int i = 0; i < ingredientList.size(); i++) {
            if (id == ingredientList.get(i).getId()) {
                idx = i;
                break;
            }
        }

        if (idx != -1) {
            status = true;
        } else {
            status = false;
        }

        return status;
    }


    public void show() {
        printList();

        System.out.println("조회할 버거 번호를 입력하세요");
        Integer id = scanner.nextInt();

        Integer index = findIdx(id);

        System.out.println(ingredientList.get(index).toString());
    }

    public int findIdx(Integer id) {
        int index = -1;

        for (int i = 0; i < ingredientList.size(); i++) {
            if (id == ingredientList.get(i).getId()) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("존재하지 않는 아이디 입니다.");
        }

        return index;
    }


    public void update() {
        printList();

        System.out.println("업데이트할 버거 번호를 입력하세요");
        Integer num = scanner.nextInt();

        boolean status = checkId(num);

        if (status == true) {
            int index = findIdx(num);

            System.out.println("[" + ingredientList.get(index).getName() + "] " +  " 수정할 이름을 입력하세요");
            String updateName = scanner.next();

            System.out.println("[" + ingredientList.get(index).getPrice() + "] " + " 수정할 가격을 입력하세요");
            Integer updatePrice = scanner.nextInt();

            IngredientForm form = new IngredientForm();
            form.setId(num);
            form.setName(updateName);
            form.setPrice(updatePrice);

            System.out.println(form.toString());

//			Ingredient ing = new Ingredient();
//			ing.setId(form.getId());
//			ing.setName(form.getName());
//			ing.setPrice(form.getPrice());

            Ingredient ing = form.toEntity();


            System.out.println(ing.toString());

            ingredientList.get(index).setId(ing.getId());
            ingredientList.get(index).setName(ing.getName());
            ingredientList.get(index).setPrice(ing.getPrice());

            System.out.println(ingredientList.get(index).toString());


        }

    }
}
