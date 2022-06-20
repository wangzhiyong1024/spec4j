package wang.zhiyong.spec4j.model.user.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/20 22:16
 */
@Data
@ApiModel("搜索用户参数")
public class SearchUserQry {

  @ApiModelProperty("组ID")
  private Integer groupId;

  @ApiModelProperty("用户名称, 模糊查询")
  private String keyword;

  @ApiModelProperty(hidden = true)
  public boolean hasKeyword() {
    return keyword != null && !keyword.trim().equals("");
  }
}
