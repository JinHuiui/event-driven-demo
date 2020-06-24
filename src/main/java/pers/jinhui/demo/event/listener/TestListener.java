package pers.jinhui.demo.event.listener;

import pers.jinhui.demo.event.BeHurtEvent;
import pers.jinhui.demo.event.EventType;
import pers.jinhui.demo.event.LevelUpEvent;
import pers.jinhui.demo.event.annotion.EventHandler;
import pers.jinhui.demo.event.annotion.EventListener;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 16:36
 * @Description: 测试用监听器
 */
@EventListener
public class TestListener {

    @EventHandler(value = EventType.LEVEL_UP)
    public void levelUp(LevelUpEvent event) {
        System.out.println("玩家<" + event.getRoleId() + ">升级了！啦啦啦！！");
    }

    @EventHandler(value = EventType.BE_HURT)
    public void beHurt(BeHurtEvent event) {
        System.out.println("玩家<" + event.getRoleId() + ">挨打了！呜呜呜！！");
    }

}
