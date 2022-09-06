public class TTest extends Thread{
    static int share;

    public static void main(String[] args) {

        TTest t1 = new TTest();
        TTest t2 = new TTest();

        t1.start();
        t2.start();
    }

    public void run() {
        for (int count = 0; count < 10; count++) {
            System.out.println(share++);

            try {
                sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
