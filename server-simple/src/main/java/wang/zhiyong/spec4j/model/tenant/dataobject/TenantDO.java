package wang.zhiyong.spec4j.model.tenant.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import wang.zhiyong.spec4j.model.tenant.enums.TenantStatusEnum;

/**
 * 租户数据类
 *
 * @author WangZhiyong
 * @date 2022/6/17 10:13
 */
@Data
@TableName("wzy_tenant")
public class TenantDO {

  @TableId(type = IdType.AUTO)
  private Integer id;

  /**
   * 租户的名称
   */
  private String name;

  /**
   * 租户的域名
   */
  private String domain;

  /**
   * @see TenantStatusEnum
   */
  private Integer status;

  /**
   * 租户的创建时间
   */
  private LocalDateTime createTime;
}
