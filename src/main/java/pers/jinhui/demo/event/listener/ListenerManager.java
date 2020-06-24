package pers.jinhui.demo.event.listener;

import pers.jinhui.demo.event.BaseEvent;
import pers.jinhui.demo.event.BeHurtEvent;
import pers.jinhui.demo.event.EventType;
import pers.jinhui.demo.event.LevelUpEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 16:42
 * @Description: 监听器管理器
 */
public class ListenerManager {
    /**
     * 所有方法
     */
    private static Map<String, Method> methods = new HashMap<>();

    /**
     * 模拟扫描注解
     */
    public static void init() {
        TestListener testListener = new TestListener();
        try {
            Method levelUp = TestListener.class.getDeclaredMethod("levelUp", LevelUpEvent.class);
            Method beHurt = TestListener.class.getDeclaredMethod("beHurt", BeHurtEvent.class);
            methods.put(getKey(TestListener.class, EventType.LEVEL_UP), levelUp);
            methods.put(getKey(TestListener.class, EventType.BE_HURT), beHurt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分发事件
     *
     * @param handler 处理器
     * @param event 事件
     */
    public static void dispatchEvent(Object handler, BaseEvent event) {
        String key = getKey(handler.getClass(), event.getEventType());
        Method method = methods.get(key);
        try {
            method.invoke(handler, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取Key
     *
     * @param handler 处理器
     * @param eventType 事件类型
     * @return Key
     */
    public static String getKey(Class<?> handler, EventType eventType) {
        return handler.getSimpleName() + "-" + eventType.toString();
    }
}
