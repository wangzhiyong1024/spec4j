package wang.zhiyong.spec4j.api;

import wang.zhiyong.spec4j.model.response.DataResponse;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.tenant.command.AddTenantCmd;
import wang.zhiyong.spec4j.model.tenant.command.DelTenantCmd;
import wang.zhiyong.spec4j.model.tenant.query.GetTenantQry;
import wang.zhiyong.spec4j.model.tenant.response.GetTenantResponse;

/**
 * 租户服务接口
 *
 * @author WangZhiyong
 * @date 2022/6/17 14:42
 */
public interface TenantService {

  Response add(AddTenantCmd cmd);

  Response del(DelTenantCmd cmd);

  DataResponse<GetTenantResponse> get(GetTenantQry qry);
}
