package wang.zhiyong.spec4j.model.tenant.event;

import org.springframework.context.ApplicationEvent;

/**
 * 新增租户事件
 *
 * @author WangZhiyong
 * @date 2022/6/20 21:03
 */
public class CreatedTenantEvent extends ApplicationEvent {

  /**
   * 租户ID
   */
  private final Integer tenantId;

  public CreatedTenantEvent(Object source, Integer tenantId) {
    super(source);
    this.tenantId = tenantId;
  }

  public Integer getTenantId() {
    return tenantId;
  }

  @Override
  public String toString() {
    return "EnabledTenantEvent{" +
        "tenantId=" + tenantId +
        '}';
  }
}
