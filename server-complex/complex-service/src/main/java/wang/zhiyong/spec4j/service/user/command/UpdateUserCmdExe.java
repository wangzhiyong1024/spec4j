package wang.zhiyong.spec4j.service.user.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wang.zhiyong.spec4j.manager.group.GroupManager;
import wang.zhiyong.spec4j.manager.user.UserManager;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.user.command.UpdateUserCmd;
import wang.zhiyong.spec4j.model.user.dataobject.UserDO;

/**
 * @author WangZhiyong
 * @date 2022/6/20 22:20
 */
@Component
@RequiredArgsConstructor
public class UpdateUserCmdExe {

  private final GroupManager groupManager;
  private final UserManager userManager;

  public Response execute(UpdateUserCmd cmd) {
    if (!userManager.hasById(cmd.getUserId())) {
      return Response.err("用户不存在");
    }
    if (cmd.needUpdateGroupId() && !groupManager.hasById(cmd.getNewGroupId())) {
      return Response.err("群组不存在");
    }

    UserDO updateUser = new UserDO();
    updateUser.setId(cmd.getUserId());
    updateUser.setGroupId(cmd.getNewGroupId());
    if (cmd.needUpdateUserName()) {
      updateUser.setName(cmd.getNewName());
    }
    userManager.updateById(updateUser);
    return Response.ok();
  }
}
