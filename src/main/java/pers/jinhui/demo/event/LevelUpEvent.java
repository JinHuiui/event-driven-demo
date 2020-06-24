package pers.jinhui.demo.event;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 16:36
 * @Description: 升级事件
 */
public class LevelUpEvent extends RoleEvent {

    public LevelUpEvent(EventType eventType, boolean isAsync, long roleId) {
        super(eventType, isAsync, roleId);
    }
}
