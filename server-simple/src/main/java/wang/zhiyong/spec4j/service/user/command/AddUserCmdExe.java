package wang.zhiyong.spec4j.service.user.command;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import wang.zhiyong.spec4j.manager.group.GroupManager;
import wang.zhiyong.spec4j.manager.tenant.TenantManager;
import wang.zhiyong.spec4j.manager.user.UserManager;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.user.command.AddUserCmd;
import wang.zhiyong.spec4j.model.user.dataobject.UserDO;

/**
 * 新增用户执行器
 *
 * @author WangZhiyong
 * @date 2022/6/20 22:20
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AddUserCmdExe {

  private final TenantManager tenantManager;
  private final GroupManager groupManager;
  private final UserManager userManager;

  public Response execute(AddUserCmd cmd) {
    if (!tenantManager.hasById(cmd.getTenantId())) {
      return Response.err("租户不存在");
    }
    if (!groupManager.hasById(cmd.getGroupId())) {
      return Response.err("群组不存在");
    }
    if (userManager.hasAccountByTenantIdAndAccount(cmd.getTenantId(), cmd.getAccount())) {
      return Response.err("账号已经存在");
    }

    UserDO newUser = createNewUserDO(cmd);
    userManager.save(newUser);
    log.info("新增用户ID={}, 账号={}", newUser.getId(), newUser.getAccount());
    return Response.ok();
  }

  private UserDO createNewUserDO(AddUserCmd cmd) {
    UserDO user = new UserDO();
    user.setAccount(cmd.getAccount());
    user.setTenantId(cmd.getTenantId());
    user.setName(cmd.getName());
    user.setGroupId(cmd.getGroupId());
    user.setCreateTime(LocalDateTime.now());
    return user;
  }
}
