package dto;

import vo.Ingredient;

public class IngredientForm {
    private Integer id;
    private String name;
    private Integer price;

    public IngredientForm() {

    }

    public IngredientForm(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Ingredient toEntity() {
        return new Ingredient(id, name, price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "IngredientForm [id=" + id + ", name=" + name + ", price=" + price + "]";
    }


}
