import java.util.*;

public class Student{

    private String name;
    private int id;
    private HashMap<String, Double> debt = new HashMap<>();
    private Stack<Purchase> purchases = new Stack<>();
    private int pointer;

    public Student(String n , int uni){
        name = n;
        id = uni;
        debt.clear();
        purchases.clear();
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public void printDebt(){
        for(String x : debt.keySet()){
            System.out.println(x + debt.get(x));
        }
    }

    public String getRecent(){
        return purchases.peek().getName() + " " + purchases.peek().getPrice()+
                " " + purchases.peek().getStatus();
    }

    public String getOldest(){
        Purchase p = purchases.firstElement();
        return p.getName() + " " + p.getPrice() + " " + p.getStatus();
    }

    public void addPurchase(Purchase p){
        purchases.add(p);
        debt.put(p.getBuyer(), debt.get(p.getBuyer()) + p.getPrice());
    }

    public void payPurchase(int index){
        Purchase focus = purchases.get(index);
        String receiver = focus.getBuyer();

        System.out.println("paying" + receiver +
                " $" + focus.getPrice() + " for "
                + focus.getName()+ "...");
        purchases.get(index).pay();
        System.out.println(focus.getStatus() + "!");

        debt.put(receiver, debt.get(receiver) - focus.getPrice());

        System.out.println("current debt to " + receiver + "has been updated to: " + debt.get(receiver));
    }

    public void getUnpaid(){
        int count = 0;
        for(Purchase p: purchases){
            if(!p.getStatus()){
                System.out.println(count + ". " + p.getPrice() + " owed to" + p.getBuyer() + " for " + p.getName());
            }
            count++;
        }
    }

}
