import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ArrayList al = new ArrayList<>();
//        al.add("Kundan Kumar");
//        al.removeAll()
//        System.out.println(al.get(0));
//
//        String[] x = {"a", "b"};
//        x[0] = null;
//
//
//
//        for(int i = 0; i < x.length; i++){
//            x[i] = x[i + 1];
////            System.out.println(x[i]);
//        }
//
//        for(int i = 0; i < x.length; i++){
//
//            System.out.println(x[i]);
//        }

//        HashSet<Integer> hsh =  new HashSet<>();

        HashSet<String> nationalIds = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        String nationalId;
        System.out.println("How many ID do you want to add?: ");
        int nationalIdCount = sc.nextInt();

        while(true) {
            if(nationalIds.size()==nationalIdCount) {
                System.out.println("Size is over");
                break;
            }
            System.out.println("Enter a national ID (Q to quit): ");

            nationalId = sc.nextLine();
            if(nationalId.equalsIgnoreCase("Q")) {
                break;
            }

            if(!nationalIds.add(nationalId)){
                System.out.println("Duplicate national ID");
                continue;
            }

            System.out.println("ID Added.");

        }

        System.out.println(nationalIds);

    }
}