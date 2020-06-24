package pers.jinhui.demo.event.annotion;

import java.lang.annotation.*;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 15:51
 * @Description: 事件监听器
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventListener {
}
