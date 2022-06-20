package wang.zhiyong.spec4j.manager.group;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import wang.zhiyong.spec4j.dao.GroupMapper;
import wang.zhiyong.spec4j.model.group.dataobject.GroupDO;

/**
 * 群组通用业务
 *
 * @author WangZhiyong
 * @date 2022/6/20 21:31
 */
@Component
public class GroupManager extends ServiceImpl<GroupMapper, GroupDO> {

  public boolean hasById(Integer id) {
    return lambdaQuery().eq(GroupDO::getId, id).count() > 0;
  }
}
