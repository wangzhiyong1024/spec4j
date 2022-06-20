package wang.zhiyong.spec4j.web.configuration;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import wang.zhiyong.spec4j.model.response.Response;

/**
 * 通用异常处理类
 *
 * @author WangZhiyong
 * @date 2022/6/17 14:38
 */
@RestController
@ControllerAdvice
public class SpecControllerAdvice {

  @ExceptionHandler(ConstraintViolationException.class)
  public Response exceptionHandler(ConstraintViolationException e) {
    StringBuilder message = new StringBuilder();
    for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
      message.append(constraintViolation.getMessage());
    }
    return Response.err(message.toString());
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
  public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    return Response.err(e.getBindingResult().getFieldError().getDefaultMessage());
  }
}
