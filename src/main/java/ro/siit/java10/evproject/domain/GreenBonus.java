package ro.siit.java10.evproject.domain;

public class GreenBonus {

    private int greenBonus; // = 10 000;
    private int totalBonusFund; //= 10 000 000;

    public GreenBonus(){

    }

    public GreenBonus(int greenBonus, int totalBonusFund) {
        this.greenBonus = greenBonus;
        this.totalBonusFund = totalBonusFund;
    }

    public int getGreenBonus() {
        return greenBonus;
    }

    public GreenBonus setGreenBonus(int greenBonus) {
        this.greenBonus = greenBonus;
        return this;
    }

    public int getTotalBonusFund() {
        return totalBonusFund;
    }

    public GreenBonus setTotalBonusFund(int totalBonusFund) {
        this.totalBonusFund = totalBonusFund;
        return this;
    }
}
