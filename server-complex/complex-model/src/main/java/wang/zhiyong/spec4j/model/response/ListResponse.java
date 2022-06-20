package wang.zhiyong.spec4j.model.response;

import java.util.List;

/**
 * 携带数据的返回对象
 *
 * @author WangZhiyong
 * @date 2022/6/17 14:52
 */
public class ListResponse<T> implements WebResponse {

  private Integer code;

  private String message;

  private List<T> data;

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

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "DataResponse{" +
        "code=" + code +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }

  public static <T> ListResponse<T> ok(List<T> data) {
    ListResponse<T> resp = new ListResponse<>();
    resp.setCode(SUCCESS_CODE);
    resp.setMessage("ok");
    resp.setData(data);
    return resp;
  }

  public static <T> ListResponse<T> err(String message) {
    ListResponse<?> resp = new ListResponse<>();
    resp.setCode(ERROR_CODE);
    resp.setMessage(message);
    return (ListResponse<T>) resp;
  }
}
