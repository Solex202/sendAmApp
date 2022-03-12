package africa.semicolon.sendAm.dtos.request;

public class AddPackageRequest {

//    private int id;
    private double weightInGrammes;
    private String name;

    public double getWeightInGrammes() {
        return weightInGrammes;
    }

    public void setWeightInGrammes(double weightInGrammes) {
        this.weightInGrammes = weightInGrammes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddPackageRequest{" +
                "weightInGrammes=" + weightInGrammes +
                ", name='" + name + '\'' +
                '}';
    }
}
