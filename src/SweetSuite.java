import java.util.*;

public class SweetSuite{
    public static void main(String [] args){

        System.out.println("Welcome to your SweetSuite!");

        Scanner in = new Scanner(System.in);

        System.out.println("To setup your suite, enter 1. For other actions, enter 2.");
        int c = in.nextInt();

        Suite su = new Suite("null" , new ArrayList<>());

        if(c == 1){
            System.out.println("Please enter suite name, and occupants names. Ids will be given in the order of names (ex: entering 'mark' first means mark's id is '1'.");
            System.out.println("Once you are finished, enter any integer to continue");
            Scanner set = new Scanner(System.in);
            String n = set.next();
            ArrayList<Student> arr = new ArrayList<>();
            int count = 1;
            while(set.hasNext()){
                Student s = new Student(set.next(), count++);
                su.add(s);
                if(set.hasNextInt()){
                    su.changeName(n);
                    su.printMates();
                    System.out.println();
                    System.out.println("Setup Complete! Run again for further actions");
                    break;
                }
            }
            System.exit(0);
        }
        else if(c == 2){
            System.out.println("Please enter ID to continue");
            Scanner act = new Scanner(System.in);
            int num = act.nextInt();
            Student current = su.getStudentById(num);

            System.out.println("Hello " + current);
            System.out.println("To add purchase, enter 1");
            System.out.println("To see your debts, enter 2");
            System.out.println("To pay off purchase, enter 3");
            System.out.println("To see your most recent purchase, enter 4");
            int d = act.nextInt();

            if(d == 1){
                Scanner dataP = new Scanner(System.in);

                System.out.println("Please enter name of purchase and total");
                String pN = dataP.next();
                double total = dataP.nextDouble();

                System.out.println("How many are splitting this purchase?(Include self)");
                int participants = dataP.nextInt();
                double part = total / participants;

                Purchase p = new Purchase(part, current.getName(), pN);
                String confirm = "";

                System.out.println("Please enter names of the people other than the buyer.");
                for(int i = 0; i < participants - 1; i++){
                    su.getStudentByName(dataP.next()).addPurchase(p);
                    confirm += su.getStudentByName(dataP.next()).getName() +", ";
                }

                System.out.println(confirm + ": each owe $" + part + "to " + current);

                //add statements for other actions 
                System.out.println("To end actions, enter 5. Otherwise:");
                System.out.println("To see your debts, enter 2");
                System.out.println("To pay off purchase, enter 3");
                System.out.println("To see your most recent purchase, enter 4");

                d = act.nextInt();
            }
            if(d == 2){
                System.out.println(current.getName() + "'s current debt");
                current.printDebt();
                System.out.println();

                System.out.println("To end actions, enter 5. Otherwise:");
                System.out.println("To see your debts, enter 2");
                System.out.println("To pay off purchase, enter 3");
                System.out.println("To see your most recent purchase, enter 4");
                d = act.nextInt();
            }
            if(d==3){
                System.out.println("Your most recent purchase is...");
                current.getRecent();
            }
            if(d==4){
                System.out.println(current.getName() + "'s purchases");
                current.getUnpaid();
                System.out.println();

                Scanner data = new Scanner(System.in);

                System.out.println("Enter number of item you want to pay");
                int item = data.nextInt();
                current.payPurchase(item);
            }
            if(d == 5){
                System.exit(0);
            }

        }
        else{
            System.out.println("invalid input");
        }
    }

}