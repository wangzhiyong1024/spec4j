package wang.zhiyong.spec4j.model.user.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户数据类
 *
 * @author WangZhiyong
 * @date 2022/6/20 21:14
 */
@Data
@TableName("wzy_user")
public class UserDO {

  @TableId(type = IdType.AUTO)
  private Integer id;

  private String account;

  /**
   * 用户所属的租户ID
   */
  private Integer tenantId;

  /**
   * 用户名称
   */
  private String name;

  /**
   * 群组ID
   */
  private Integer groupId;

  private LocalDateTime createTime;
}
