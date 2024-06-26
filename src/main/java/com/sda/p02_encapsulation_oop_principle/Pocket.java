package com.sda.p02_encapsulation_oop_principle;

public class Pocket {
    private double money;

    public Pocket(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0 || money > 3000) {
            System.out.println("I do not have enough space in my pocket for as much money");
        } else {
            this.money = money;
        }
    }
}
