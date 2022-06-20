package wang.zhiyong.spec4j.common;

/**
 * 布尔值哦那个聚类
 *
 * @author WangZhiyong
 * @date 3/24/2021 20:00
 */
public final class Booleans {

  public static final int INT_TRUE = 1;
  public static final int INT_FALSE = 0;

  /**
   * int 值的布尔判断, null=false, 0=false, 1=true
   *
   * @param val 布尔值, 只允许0或1或null
   */
  public static boolean isTrue(Integer val) {
    if (val == null) {
      return false;
    }
    if (val == 0) {
      return false;
    }
    if (val == 1) {
      return true;
    }
    throw new RuntimeException("错误的int布尔值, 只允许0或1或null, 实际值=" + val);
  }

  public static boolean isFalse(Integer val) {
    return !isTrue(val);
  }
}
