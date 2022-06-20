package wang.zhiyong.spec4j.api;

import wang.zhiyong.spec4j.model.response.ListResponse;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.user.command.AddUserCmd;
import wang.zhiyong.spec4j.model.user.command.UpdateUserCmd;
import wang.zhiyong.spec4j.model.user.query.SearchUserQry;
import wang.zhiyong.spec4j.model.user.response.SearchUserResponse;

/**
 * 用户服务接口
 *
 * @author WangZhiyong
 * @date 2022/6/20 22:12
 */
public interface UserService {

  Response add(AddUserCmd cmd);

  Response update(UpdateUserCmd cmd);

  ListResponse<SearchUserResponse> search(SearchUserQry qry);
}
