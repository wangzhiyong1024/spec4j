package wang.zhiyong.spec4j.model.tenant.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/17 17:25
 */
@Data
@ApiModel("获取租户信息响应值")
public class GetTenantResponse {

  @ApiModelProperty("租户ID")
  private Integer id;

  @ApiModelProperty("租户名称")
  private String name;
}
