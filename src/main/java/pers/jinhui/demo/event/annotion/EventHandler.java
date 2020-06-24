package pers.jinhui.demo.event.annotion;

import pers.jinhui.demo.event.EventType;

import java.lang.annotation.*;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 16:26
 * @Description: 事件处理器
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

    /**
     * 绑定的事件类型列表
     */
    EventType[] value();
}
