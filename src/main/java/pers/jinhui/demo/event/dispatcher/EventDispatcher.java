package pers.jinhui.demo.event.dispatcher;

import pers.jinhui.demo.event.BaseEvent;
import pers.jinhui.demo.event.EventType;
import pers.jinhui.demo.event.listener.ListenerManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 15:53
 * @Description: 事件分发器
 */
public class EventDispatcher {

    /**
     * 饿汉式单例
     */
    private static EventDispatcher instance = new EventDispatcher();

    /**
     * 事件类型与监听器的映射
     */
    private final Map<EventType, Set<Object>> observers = new HashMap<>();

    /**
     * 事件队列
     */
    private LinkedBlockingQueue<BaseEvent> eventQueue = new LinkedBlockingQueue<>();

    /**
     * 注册事件监听器
     *
     * @param eventType 事件类型
     * @param listener 监听器
     */
    public void registerListener(EventType eventType, Object listener) {
        Set<Object> listeners = observers.get(eventType);
        if (listeners == null) {
            listeners = new CopyOnWriteArraySet<>();
            observers.put(eventType, listeners);
        }
        listeners.add(listener);
    }

    /**
     * 分发事件
     *
     * @param event 事件
     */
    public void dispatchEvent(BaseEvent event) {
        if (event == null) {
            throw new NullPointerException("EVENT IS NULL");
        }
        if (event.isAsync()) {
            eventQueue.offer(event);
        } else {
            processingEvent(event);
        }
    }

    /**
     * 处理事件
     *
     * @param event 事件
     */
    public void processingEvent(BaseEvent event) {
        EventType eventType = event.getEventType();
        Set<Object> listeners = observers.get(eventType);
        if (listeners != null && !listeners.isEmpty()) {
            listeners.forEach(listener -> {
                ListenerManager.dispatchEvent(listener, event);
            });
        }
    }

    private EventDispatcher() {
        new Thread(new EventWorker()).start();
    }


    public static EventDispatcher getInstance() {
        return instance;
    }

    private class EventWorker implements Runnable {

        @Override
        public void run() {
            while (true) {
                BaseEvent event;
                try {
                    event = eventQueue.take();
                    processingEvent(event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
