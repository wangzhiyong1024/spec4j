package wang.zhiyong.spec4j.model.response;

/**
 * Web 层返回对象
 *
 * @author WangZhiyong
 * @date 2022/6/17 15:54
 */
public interface WebResponse {

  Integer SUCCESS_CODE = 200;
  Integer ERROR_CODE = 500;

  Integer getCode();

  String getMessage();
}
