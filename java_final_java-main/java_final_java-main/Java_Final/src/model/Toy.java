package model;

public class Toy {
    int id;
    String name;
    int quantity;
    int weight;

    public String info() {
        return "Toy.info : " +
                "id = " + this.getId() +
                " name = " + this.getName() +
                " quantity = " + this.getQuantity() +
                " weight " + this.getWeight();
    }

    public Toy() {
    }

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
