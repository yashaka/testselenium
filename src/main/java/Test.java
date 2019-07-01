package PACKAGE_NAME;

public class Test {

    public static void main(String[] args) {
       A a1 = new A(new I() {
           public void test() {
               System.out.println("A1");
           }
       });

        A a2 = new A(new I() {
            public void test() {
                System.out.println("A2");
            }
        });

        a1.test();
        a2.test();
    }

    public static class A {

        private final I i;

        public A(I i) {
            this.i = i;
        }

        public void test() {
            i.test();
        }


    }

    public interface I {

       void test();

    }

}
