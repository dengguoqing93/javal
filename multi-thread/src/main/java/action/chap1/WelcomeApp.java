package action.chap1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定义Thread子类方式创建线程
 *
 * @author dengguoqing
 * @date 2019/3/18
 */
public class WelcomeApp {
    private static final Logger log = LoggerFactory.getLogger(WelcomeApp.class);


    public static void main(String[] args) throws Exception {
        Thread welcomeThread = new WelcomeThread();
        welcomeThread.setName("幻影");
        welcomeThread.start();

        log.info("1.Welcome ! this is {}", Thread.currentThread().getName());
    }

    static class WelcomeThread extends Thread {
        @Override
        public void run() {
            log.info("2.welcome! i'm {}.", Thread.currentThread().getName());
        }
    }
}
