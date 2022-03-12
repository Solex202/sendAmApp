package africa.semicolon.sendAm.dtos.response;

import org.apache.tomcat.util.bcel.classfile.ArrayElementValue;

public class AddPackageResponse {
    private int id;
    private String name;
    private double weightInGrammes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
