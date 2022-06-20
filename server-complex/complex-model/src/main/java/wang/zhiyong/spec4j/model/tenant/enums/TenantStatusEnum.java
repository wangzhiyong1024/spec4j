package wang.zhiyong.spec4j.model.tenant.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 租户状态枚举
 *
 * @author WangZhiyong
 * @date 2022/6/17 10:15
 */
@Getter
@RequiredArgsConstructor
public enum TenantStatusEnum {

  /**
   * 启用状态
   */
  ENABLED(1),

  /**
   * 禁用状态
   */
  DISABLED(2);

  public static final String DESCRIPTION = "租户状态: 1=启用, 2=禁用";

  private final Integer status;
}
