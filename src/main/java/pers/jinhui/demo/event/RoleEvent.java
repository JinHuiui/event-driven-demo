package pers.jinhui.demo.event;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 15:48
 * @Description: 与角色有关的事件
 */
public abstract class RoleEvent extends BaseEvent{

    /**
     * 角色ID
     */
    private final long roleId;

    public RoleEvent(EventType eventType, boolean isAsync, long roleId) {
        super(eventType, isAsync);
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }
}
