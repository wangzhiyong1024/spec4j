package wang.zhiyong.spec4j.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wang.zhiyong.spec4j.api.UserService;
import wang.zhiyong.spec4j.model.response.ListResponse;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.user.command.AddUserCmd;
import wang.zhiyong.spec4j.model.user.command.UpdateUserCmd;
import wang.zhiyong.spec4j.model.user.query.SearchUserQry;
import wang.zhiyong.spec4j.model.user.response.SearchUserResponse;
import wang.zhiyong.spec4j.service.user.command.AddUserCmdExe;
import wang.zhiyong.spec4j.service.user.command.UpdateUserCmdExe;
import wang.zhiyong.spec4j.service.user.query.SearchUserResponseExe;

/**
 * @author WangZhiyong
 * @date 2022/6/20 22:19
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final AddUserCmdExe addUserCmdExe;
  private final UpdateUserCmdExe updateUserCmdExe;
  private final SearchUserResponseExe searchUserResponseExe;

  @Override
  public Response add(AddUserCmd cmd) {
    return addUserCmdExe.execute(cmd);
  }

  @Override
  public Response update(UpdateUserCmd cmd) {
    return updateUserCmdExe.execute(cmd);
  }

  @Override
  public ListResponse<SearchUserResponse> search(SearchUserQry qry) {
    return searchUserResponseExe.execute(qry);
  }
}
