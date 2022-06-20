package wang.zhiyong.spec4j.web.wechat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.zhiyong.spec4j.api.UserService;
import wang.zhiyong.spec4j.model.response.ListResponse;
import wang.zhiyong.spec4j.model.response.Response;
import wang.zhiyong.spec4j.model.user.command.AddUserCmd;
import wang.zhiyong.spec4j.model.user.command.UpdateUserCmd;
import wang.zhiyong.spec4j.model.user.query.SearchUserQry;
import wang.zhiyong.spec4j.model.user.response.SearchUserResponse;

/**
 * @author WangZhiyong
 * @date 2022/6/20 21:57
 */
@Api(tags = "WECHAT-用户")
@RestController
@RequestMapping("/wechat/user")
@RequiredArgsConstructor
public class WechatUserController {

  private final UserService userService;

  @ApiOperation("新增用户")
  @PostMapping
  public Response add(@Valid @RequestBody AddUserCmd cmd) {
    return userService.add(cmd);
  }

  @ApiOperation("更新用户")
  @PutMapping
  public Response del(@Valid @RequestBody UpdateUserCmd cmd) {
    return userService.update(cmd);
  }

  @ApiOperation("搜索用户")
  @GetMapping
  public ListResponse<SearchUserResponse> get(@Valid SearchUserQry qry) {
    return userService.search(qry);
  }
}
