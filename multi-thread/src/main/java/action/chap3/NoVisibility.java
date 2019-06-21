package action.chap3;

/**
 * 在没有同步的情况下共享变量
 *
 * @author dengguoqing
 * @date 2019/5/15
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            System.out.println("进入子线程");
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        System.out.println("主线程");
        number = 42;
        ready = true;
    }

}
