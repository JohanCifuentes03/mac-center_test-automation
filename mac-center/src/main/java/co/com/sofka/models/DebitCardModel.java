package co.com.sofka.models;


public class DebitCardModel {
    private String number;
    private String CVV;

    public DebitCardModel() {
    }

    public DebitCardModel(String number, String CVV) {
        this.number = number;
        this.CVV = CVV;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
}
