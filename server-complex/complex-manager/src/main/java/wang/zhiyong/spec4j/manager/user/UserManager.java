package wang.zhiyong.spec4j.manager.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import wang.zhiyong.spec4j.dao.UserMapper;
import wang.zhiyong.spec4j.model.user.dataobject.UserDO;

/**
 * 用户通用业务
 *
 * @author WangZhiyong
 * @date 2022/6/20 21:13
 */
@Component
public class UserManager extends ServiceImpl<UserMapper, UserDO> {

  public boolean hasById(Integer id) {
    return lambdaQuery().eq(UserDO::getId, id).count() > 0;
  }

  public boolean hasAccountByTenantIdAndAccount(Integer tenantId, String account) {
    return lambdaQuery()
        .eq(UserDO::getTenantId, tenantId)
        .eq(UserDO::getAccount, account)
        .count() > 0;
  }
}
