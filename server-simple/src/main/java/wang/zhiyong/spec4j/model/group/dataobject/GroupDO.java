package wang.zhiyong.spec4j.model.group.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author WangZhiyong
 * @date 2022/6/20 21:30
 */
@Data
@TableName("wzy_group")
public class GroupDO {

  @TableId(type = IdType.AUTO)
  private Integer id;

  /**
   * 租户ID
   */
  private Integer tenantId;

  private String name;

  private LocalDateTime createTime;
}
