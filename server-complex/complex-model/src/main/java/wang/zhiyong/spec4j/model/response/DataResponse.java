package wang.zhiyong.spec4j.model.response;

/**
 * 携带数据的返回对象
 *
 * @author WangZhiyong
 * @date 2022/6/17 14:52
 */
public class DataResponse<T> implements WebResponse {

  private Integer code;

  private String message;

  private T data;

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

  public T getData() {
    return data;
  }

  public void setData(T data) {
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

  public static <T> DataResponse<T> ok(T data) {
    DataResponse<T> resp = new DataResponse<>();
    resp.setCode(SUCCESS_CODE);
    resp.setMessage("ok");
    resp.setData(data);
    return resp;
  }

  public static <T> DataResponse<T> err(String message) {
    DataResponse<?> resp = new DataResponse<>();
    resp.setCode(ERROR_CODE);
    resp.setMessage(message);
    return (DataResponse<T>) resp;
  }
}
