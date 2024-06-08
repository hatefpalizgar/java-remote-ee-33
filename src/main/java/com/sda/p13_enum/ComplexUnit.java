package com.sda.p13_enum;

public enum ComplexUnit {
   CENTIMETER(1),
   INCH(2),
   FOOT(3),
   METER(4);

   private int order;

    ComplexUnit(int order) {
        this.order = order;
    }

    public double whatIsMyOrder() {
        return order;
    }
}
