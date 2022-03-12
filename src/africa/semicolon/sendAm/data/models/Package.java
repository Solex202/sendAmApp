package africa.semicolon.sendAm.data.models;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private int id;
    private  User owner;

    private final List<Status> statusList = new ArrayList<>();
    private String name;
    private double weightInGrammes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }



    public List<Status> getStatusList() {
        return statusList;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", owner=" + owner +
                ", statusList=" + statusList +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getWeightInGrammes() {
        return weightInGrammes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeightInGrammes(double weightInGrammes) {
        this.weightInGrammes = weightInGrammes;
    }
}
