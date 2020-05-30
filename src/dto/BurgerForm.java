package dto;

import vo.Burger;

public class BurgerForm {
    private static Integer id = 0;
    private String name;
    private Integer price;

    public BurgerForm() {

    }


    public BurgerForm(Integer idx2, String updateName, Integer updatePrice) {
        id = idx2;
        this.name =  updateName;
        this.price = updatePrice;
    }


    public Burger toEntity() {
        return new Burger(id ,name, price);
    }

    public  Integer getId() {
        return id;
    }

    public  void setId(Integer id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
