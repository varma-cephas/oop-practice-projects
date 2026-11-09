public class Parent {
    private int age;
     String name = "asf";

     Parent(){
         try{
             int x = 10/0;
         } catch(Exception e){
             System.out.println(e.getMessage());
//             throw e;
         } finally {
             System.out.println("Execution completed");
         }

         System.out.println("fffffff");
     }

    void display_info(){
        System.out.println(age);
        System.out.println(name);
    }
}

class  Child extends Parent {
    void  display_info(int x){
        super.name = "aaaaaaa";

        super.display_info();
        System.out.println("asfsafs");
    }
}

class InheritanceDemo extends Parent {
    public static void main(String[] args) {
        Child child = new Child();
        child.display_info(5);
        System.out.println(child);
        Child[] child2 = new Child[4];
        f
    }
}
