package wang.zhiyong.spec4j.model.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/20 22:14
 */
@Data
@ApiModel("更新用户参数")
public class UpdateUserCmd {

  @NotNull
  @ApiModelProperty(value = "用户ID", required = true)
  private Integer userId;

  @ApiModelProperty("新的组ID")
  private Integer newGroupId;

  @ApiModelProperty("用户姓名")
  private String newName;

  public boolean needUpdateGroupId() {
    return newGroupId != null;
  }

  public boolean needUpdateUserName() {
    return newName != null && !"".equals(newName);
  }
}
