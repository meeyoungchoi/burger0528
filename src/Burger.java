public class Burger {

    private Integer id = 0;
    private String name;
    private Integer price;


    public Burger(Integer id2, String name, Integer price) {
        this.id = id2;
        this.name = name;
        this.price = price;
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



}
