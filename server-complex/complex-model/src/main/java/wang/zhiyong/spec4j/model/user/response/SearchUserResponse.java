package wang.zhiyong.spec4j.model.user.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/20 22:17
 */
@Data
@ApiModel("搜索用户响应值")
public class SearchUserResponse {

  @ApiModelProperty("用户ID")
  private Integer id;

  @ApiModelProperty("用户名称")
  private String name;
}
