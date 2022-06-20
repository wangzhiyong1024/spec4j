package wang.zhiyong.spec4j.manager.tenant;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import wang.zhiyong.spec4j.dao.TenantMapper;
import wang.zhiyong.spec4j.model.tenant.dataobject.TenantDO;

/**
 * 租户通用业务
 *
 * @author WangZhiyong
 * @date 2022/6/20 20:55
 */
@Component
public class TenantManager extends ServiceImpl<TenantMapper, TenantDO> {

  public boolean hasDomain(String domain) {
    return lambdaQuery().eq(TenantDO::getDomain, domain).count() > 0;
  }

  public boolean hasName(String name) {
    return lambdaQuery().eq(TenantDO::getName, name).count() > 0;
  }

  public boolean hasById(Integer id) {
    return lambdaQuery().eq(TenantDO::getId, id).count() > 0;
  }
}
