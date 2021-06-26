package com.nipun.ujjawal.mandiRecycler;

public class MyListData {
    private int name;
    
    private int rate;
    private int price;
    private int min;
    private int km;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public MyListData(int name, int rate, int price, int min, int km) {
        this.name = name;
        this.rate = rate;
        this.price = price;
        this.min = min;
        this.km = km;

        
    }



}  