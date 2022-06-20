package wang.zhiyong.spec4j.model.user.domain;

import java.time.LocalDateTime;
import wang.zhiyong.spec4j.model.user.dataobject.UserDO;

/**
 * 用户领域对象
 *
 * @author WangZhiyong
 * @date 2022/6/20 21:32
 */
public class User extends UserDO {

  /**
   * 领域内的业务方法直接沉淀到领域类中, 聚合业务
   */
  public boolean isThisYearCreated() {
    return LocalDateTime.now().getYear() == getCreateTime().getYear();
  }
}
