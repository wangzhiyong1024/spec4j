package wang.zhiyong.spec4j.service.tenant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wang.zhiyong.spec4j.api.TenantService;
import wang.zhiyong.spec4j.manager.tenant.TenantManager;
import wang.zhiyong.spec4j.model.response.DataResponse;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.tenant.command.AddTenantCmd;
import wang.zhiyong.spec4j.model.tenant.command.DelTenantCmd;
import wang.zhiyong.spec4j.model.tenant.dataobject.TenantDO;
import wang.zhiyong.spec4j.model.tenant.query.GetTenantQry;
import wang.zhiyong.spec4j.model.tenant.response.GetTenantResponse;
import wang.zhiyong.spec4j.service.tenant.command.AddTenantCmdExe;
import wang.zhiyong.spec4j.service.tenant.command.DelTenantCmdExe;

/**
 * @author WangZhiyong
 * @date 2022/6/20 20:54
 */
@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

  private final TenantManager tenantManager;

  private final AddTenantCmdExe addTenantCmdExe;
  private final DelTenantCmdExe delTenantCmdExe;

  @Override
  public Response add(AddTenantCmd cmd) {
    return addTenantCmdExe.execute(cmd);
  }

  @Override
  public Response del(DelTenantCmd cmd) {
    return delTenantCmdExe.execute(cmd);
  }

  @Override
  public DataResponse<GetTenantResponse> get(GetTenantQry qry) {
    // 简单方法直接 Service 内实现, 减少复杂度
    TenantDO tenant = tenantManager.getById(qry.getId());
    if (tenant == null) {
      return DataResponse.err("租户不存在");
    }

    // 减少BeanCopy, 防止丢失业务
    GetTenantResponse response = new GetTenantResponse();
    response.setId(tenant.getId());
    response.setName(tenant.getName());
    return DataResponse.ok(response);
  }
}
