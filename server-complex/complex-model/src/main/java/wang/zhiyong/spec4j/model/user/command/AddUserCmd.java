package wang.zhiyong.spec4j.model.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/20 22:12
 */
@Data
@ApiModel("新增用户参数")
public class AddUserCmd {

  @NotNull
  @ApiModelProperty(value = "租户ID", required = true)
  private Integer tenantId;

  @NotNull
  @ApiModelProperty(value = "群组ID", required = true)
  private Integer groupId;

  @NotBlank
  @ApiModelProperty(value = "用户名称", required = true)
  private String name;

  @NotBlank
  @ApiModelProperty(value = "用户账号", required = true)
  private String account;
}
