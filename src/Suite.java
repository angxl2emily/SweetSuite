import java.util.*;

public class Suite{
    private ArrayList<Student> mates = new ArrayList<>();
    private String name;
    private int size;

    public Suite(String n, ArrayList<Student> arr){
        name = n;
        for(int i = 0; i < arr.size(); i++){
            mates.add(arr.get(i));
        }
        size = arr.size();
    }

    public void add(Student x){
        mates.add(x);
        size++;
    }

    public void changeName(String n){
        name = n;
    }

    public ArrayList<Student> getMates(){
        return mates;
    }

    public void printMates(){
        System.out.println("Current suitemates in " + name + ":");
        for(int i = 0; i < mates.size(); i++){
            System.out.println(mates.get(i).getId() + " " + mates.get(i).getName());
        }
    }

    public String getName(){
        return name;
    }

    public Student getStudentById(int uni){
        for(int i = 0; i < size; i++){
            if(mates.get(i).getId() == uni){
                return mates.get(i);
            }
        }
        System.out.println("non-existant uni");
        System.exit(0);
        return null;
    }

    public Student getStudentByName(String n){
        for(int i = 0; i < size; i++){
            if(mates.get(i).getName().equals(n)){
                return mates.get(i);
            }
        }
        System.out.println("non-existant name");
        return null;
    }
}
