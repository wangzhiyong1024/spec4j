package wang.zhiyong.spec4j.web.wechat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.zhiyong.spec4j.api.TenantService;
import wang.zhiyong.spec4j.model.response.DataResponse;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.tenant.command.AddTenantCmd;
import wang.zhiyong.spec4j.model.tenant.command.DelTenantCmd;
import wang.zhiyong.spec4j.model.tenant.query.GetTenantQry;
import wang.zhiyong.spec4j.model.tenant.response.GetTenantResponse;

/**
 * @author WangZhiyong
 * @date 2022/6/20 21:57
 */
@Api(tags = "WECHAT-租户")
@RestController
@RequestMapping("/wechat/tenant")
@RequiredArgsConstructor
public class WechatTenantController {

  private final TenantService tenantService;

  @ApiOperation("新增租户")
  @PostMapping
  public Response add(@Valid @RequestBody AddTenantCmd cmd) {
    return tenantService.add(cmd);
  }

  @ApiOperation("删除租户")
  @DeleteMapping
  public Response del(@Valid @RequestBody DelTenantCmd cmd) {
    return tenantService.del(cmd);
  }

  @ApiOperation("获取租户")
  @GetMapping
  public DataResponse<GetTenantResponse> get(@Valid GetTenantQry qry) {
    return tenantService.get(qry);
  }
}
