package wang.zhiyong.spec4j.service.user.query;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wang.zhiyong.spec4j.manager.user.UserManager;
import wang.zhiyong.spec4j.model.response.ListResponse;
import wang.zhiyong.spec4j.model.user.dataobject.UserDO;
import wang.zhiyong.spec4j.model.user.query.SearchUserQry;
import wang.zhiyong.spec4j.model.user.response.SearchUserResponse;

/**
 * @author WangZhiyong
 * @date 2022/6/20 22:20
 */
@Component
@RequiredArgsConstructor
public class SearchUserResponseExe {

  private final UserManager userManager;

  public ListResponse<SearchUserResponse> execute(SearchUserQry qry) {
    LambdaQueryChainWrapper<UserDO> query = buildCondition(qry);

    List<SearchUserResponse> responseList = new ArrayList<>();
    for (UserDO userDO : query.list()) {
      SearchUserResponse response = new SearchUserResponse();
      response.setId(userDO.getId());
      response.setName(userDO.getName());
      responseList.add(response);
    }
    return ListResponse.ok(responseList);
  }

  /**
   * 构造复杂条件, 复杂条件不属于通用业务, 所以可以直接调用数据层
   */
  public LambdaQueryChainWrapper<UserDO> buildCondition(SearchUserQry qry) {
    LambdaQueryChainWrapper<UserDO> query = userManager.lambdaQuery();
    if (qry.hasKeyword()) {
      query.and(
          q -> q.like(UserDO::getName, qry.getKeyword())
              .or().like(UserDO::getAccount, qry.getKeyword())
      );
    }
    if (qry.getGroupId() != null) {
      query.eq(UserDO::getGroupId, qry.getGroupId());
    }
    return query;
  }
}
