import java.util.*;

public class Purchase {
    final private String buyerName; //who you owe
    private String name;
    private double amt;
    private boolean paid;

    public Purchase(double price , String buyer, String n){
        buyerName = buyer;
        name = n;
        paid = false;
        amt = price; //total price entered / # of people splitting
    }
    public void pay(){
        paid = true;
    }
    public String getName(){
        return name;
    }
    public String getBuyer(){
        return buyerName;
    }
    public double getPrice(){
        return amt;
    }
    public boolean getStatus(){
        System.out.println("paid: ");
        return paid;
    }
}

