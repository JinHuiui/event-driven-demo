package pers.jinhui.demo.event;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 17:09
 * @Description: 收到伤害事件
 */
public class BeHurtEvent extends RoleEvent {
    public BeHurtEvent(EventType eventType, boolean isAsync, long roleId) {
        super(eventType, isAsync, roleId);
    }
}
