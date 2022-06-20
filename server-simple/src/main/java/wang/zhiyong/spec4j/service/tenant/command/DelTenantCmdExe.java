package wang.zhiyong.spec4j.service.tenant.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wang.zhiyong.spec4j.manager.group.GroupManager;
import wang.zhiyong.spec4j.manager.tenant.TenantManager;
import wang.zhiyong.spec4j.manager.user.UserManager;
import wang.zhiyong.spec4j.model.group.dataobject.GroupDO;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.tenant.command.DelTenantCmd;
import wang.zhiyong.spec4j.model.user.dataobject.UserDO;

/**
 * 删除租户执行器
 *
 * @author WangZhiyong
 * @date 2022/6/20 21:08
 */
@Component
@RequiredArgsConstructor
public class DelTenantCmdExe {

  private final UserManager userManager;
  private final GroupManager groupManager;
  private final TenantManager tenantManager;

  @Transactional(rollbackFor = Exception.class, timeout = 30)
  public Response execute(DelTenantCmd cmd) {
    if (!tenantManager.hasById(cmd.getId())) {
      return Response.err("租户不存在");
    }
    clearUser(cmd);
    clearGroup(cmd);
    tenantManager.removeById(cmd.getId());
    return Response.ok();
  }

  void clearUser(DelTenantCmd cmd) {
    userManager.lambdaUpdate().eq(UserDO::getTenantId, cmd.getId()).remove();
  }

  void clearGroup(DelTenantCmd cmd) {
    groupManager.lambdaUpdate().eq(GroupDO::getTenantId, cmd.getId()).remove();
  }
}
