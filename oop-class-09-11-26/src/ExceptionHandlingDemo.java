public class ExceptionHandlingDemo {

//    void testThrow() throws ArithmeticException {
//        int x = 8/0;
//        System.out.println(x);
//    }
    public static void main(String[] args) {
        int x;
        int[] y = {1,2,3,4};
        try {
            x = 8 / 0;

        }catch (Exception e) {
            System.out.println(e);
        } finally {

        }
        System.out.println("heressdfs");
//        this.testThrow();
    }



}
