package wang.zhiyong.spec4j.model.tenant.domain;

import java.util.ArrayList;
import java.util.List;
import wang.zhiyong.spec4j.model.tenant.dataobject.TenantDO;
import wang.zhiyong.spec4j.model.tenant.enums.TenantStatusEnum;

/**
 * 租户领域对象
 *
 * @author WangZhiyong
 * @date 2022/6/17 10:19
 */
public class Tenant extends TenantDO {

  public Tenant() {
  }

  public Tenant(TenantDO t) {
    setId(t.getId());
    setName(t.getName());
    setStatus(t.getStatus());
    setCreateTime(t.getCreateTime());
  }

  public boolean isEnabled() {
    return TenantStatusEnum.ENABLED.getStatus().equals(getStatus());
  }

  public boolean isDisabled() {
    return TenantStatusEnum.DISABLED.getStatus().equals(getStatus());
  }

  public static List<Tenant> ofList(List<TenantDO> tList) {
    List<Tenant> result = new ArrayList<>(tList.size());
    tList.forEach(t -> result.add(new Tenant(t)));
    return result;
  }
}
