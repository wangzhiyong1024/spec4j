package wang.zhiyong.spec4j.model.tenant.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/17 13:51
 */
@Data
@ApiModel("租户-查询参数")
public class GetTenantQry {

  @NotNull
  @ApiModelProperty(value = "租户ID", required = true)
  private Integer id;
}
