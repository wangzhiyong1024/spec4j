package wang.zhiyong.spec4j.model.response;

/**
 * 响应对象
 *
 * @author WangZhiyong
 * @date 2022/6/17 14:43
 */
public class Response implements WebResponse {

  private Integer code;

  private String message;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Response{" +
        "code=" + code +
        ", message='" + message + '\'' +
        '}';
  }

  public static Response ok() {
    Response resp = new Response();
    resp.setCode(SUCCESS_CODE);
    resp.setMessage("ok");
    return resp;
  }

  public static Response err(String message) {
    Response resp = new Response();
    resp.setCode(ERROR_CODE);
    resp.setMessage(message);
    return resp;
  }
}
