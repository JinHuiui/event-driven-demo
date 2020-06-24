package pers.jinhui.demo.event;

/**
 * @Author: wu jinhui
 * @Date: 2020/6/24 15:42
 * @Description: 基础事件
 */
public abstract class BaseEvent {

    /**
     * 事件类型
     */
    private final EventType eventType;

    /**
     * 是否为异步的
     */
    private final boolean isAsync;

    public BaseEvent(EventType eventType, boolean isAsync) {
        this.eventType = eventType;
        this.isAsync = isAsync;
    }

    public EventType getEventType() {
        return eventType;
    }

    public boolean isAsync() {
        return isAsync;
    }
}
