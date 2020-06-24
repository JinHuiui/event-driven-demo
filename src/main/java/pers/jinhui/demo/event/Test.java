package pers.jinhui.demo.event;

import pers.jinhui.demo.event.dispatcher.EventDispatcher;
import pers.jinhui.demo.event.listener.ListenerManager;
import pers.jinhui.demo.event.listener.TestListener;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 16:34
 * @Description: 测试类
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ListenerManager.init();
        EventDispatcher instance = EventDispatcher.getInstance();
        TestListener testListener = new TestListener();
        instance.registerListener(EventType.LEVEL_UP, testListener);
        instance.registerListener(EventType.BE_HURT, testListener);

        new Thread(() -> {
            while (true) {
                instance.dispatchEvent(new LevelUpEvent(EventType.LEVEL_UP, true, 1));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                instance.dispatchEvent(new BeHurtEvent(EventType.BE_HURT, true, 1));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {

        }

    }
}
