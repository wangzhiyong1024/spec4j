package wang.zhiyong.spec4j.model.tenant.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/17 13:47
 */
@Data
@ApiModel("租户-新增参数")
public class AddTenantCmd {

  @NotBlank
  @ApiModelProperty(value = "租户的名称, 不可重复", required = true)
  private String name;

  @NotBlank
  @ApiModelProperty(value = "租户域名, 不可重复", required = true)
  private String domain;
}
