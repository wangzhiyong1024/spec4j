package wang.zhiyong.spec4j.service.tenant.command;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wang.zhiyong.spec4j.manager.EventManager;
import wang.zhiyong.spec4j.manager.group.GroupManager;
import wang.zhiyong.spec4j.manager.tenant.TenantManager;
import wang.zhiyong.spec4j.manager.user.UserManager;
import wang.zhiyong.spec4j.model.group.dataobject.GroupDO;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.tenant.command.AddTenantCmd;
import wang.zhiyong.spec4j.model.tenant.dataobject.TenantDO;
import wang.zhiyong.spec4j.model.tenant.enums.TenantStatusEnum;
import wang.zhiyong.spec4j.model.tenant.event.CreatedTenantEvent;
import wang.zhiyong.spec4j.model.user.dataobject.UserDO;

/**
 * 新增租户命令执行器
 *
 * @author WangZhiyong
 * @date 2022/6/20 21:00
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AddTenantCmdExe {

  private final TenantManager tenantManager;
  private final GroupManager groupManager;
  private final UserManager userManager;

  @Transactional(rollbackFor = Exception.class, timeout = 10)
  public Response execute(AddTenantCmd cmd) {
    if (tenantManager.hasDomain(cmd.getDomain())) {
      return Response.err("域名已经存在: " + cmd.getDomain());
    }
    if (tenantManager.hasName(cmd.getName())) {
      return Response.err("名称已经存在: " + cmd.getName());
    }

    TenantDO newTenant = createTenantDO(cmd);
    tenantManager.save(newTenant);

    GroupDO newDefaultGroup = createDefaultGroupDO(newTenant);
    groupManager.save(newDefaultGroup);

    UserDO newRootUser = createRootUserDO(newTenant, newDefaultGroup);
    userManager.save(newRootUser);

    log.info("新增租户 id={}, group={}, root={}", newTenant.getId(), newDefaultGroup.getId(),
        newRootUser.getId());

    EventManager.publish(new CreatedTenantEvent(this, newTenant.getId()));
    return Response.ok();
  }

  private TenantDO createTenantDO(AddTenantCmd cmd) {
    TenantDO tenant = new TenantDO();
    tenant.setName(cmd.getName());
    tenant.setDomain(cmd.getDomain());
    tenant.setStatus(TenantStatusEnum.DISABLED.getStatus());
    tenant.setCreateTime(LocalDateTime.now());
    return tenant;
  }

  private GroupDO createDefaultGroupDO(TenantDO newTenant) {
    GroupDO defaultGroup = new GroupDO();
    defaultGroup.setTenantId(newTenant.getId());
    defaultGroup.setName(newTenant.getName());
    defaultGroup.setCreateTime(LocalDateTime.now());
    return defaultGroup;
  }

  private UserDO createRootUserDO(TenantDO newTenant, GroupDO defaultGroup) {
    String rootName = "root";
    String rootAccount = rootName + "@" + newTenant.getDomain();

    UserDO user = new UserDO();
    user.setAccount(rootAccount);
    user.setTenantId(newTenant.getId());
    user.setName(rootName);
    user.setGroupId(defaultGroup.getId());
    user.setCreateTime(LocalDateTime.now());
    return user;
  }
}
