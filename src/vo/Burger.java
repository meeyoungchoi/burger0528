package vo;

public class Burger {
    private Integer id2;
    private String name;
    private Integer price;

    public Burger() {

    }

    public Burger(Integer id, String name, Integer price) {
        this.id2 = id;
        this.name = name;
        this.price = price;
    }


    public Integer getId2() {
        return id2;
    }


    public void setId2(Integer id2) {
        this.id2 = id2;
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
        return "Burger [id2=" + id2 + ", name=" + name + ", price=" + price + "]";
    }



}
