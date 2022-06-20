package wang.zhiyong.spec4j.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 集合工具类
 *
 * @author Wang.Zhiyong
 * @date 2020/9/1 10:54
 */
public class ListUtils {

  private ListUtils() {
  }

  /**
   * 集合是否为空
   *
   * @param list 集合
   * @return true: 为空
   */
  public static boolean isEmpty(List<?> list) {
    return list == null || list.isEmpty();
  }

  /**
   * 集合是否不为空
   *
   * @param list 集合
   * @return true: 不为空
   */
  public static boolean isNotEmpty(List<?> list) {
    return !isEmpty(list);
  }

  /**
   * 排序并获取第一个元素
   */
  public static <T> T sortAndGetFirst(List<T> list) {
    list.sort(null);
    return list.get(0);
  }

  /**
   * 获取第一个元素
   *
   * @param list 集合
   * @param <T> 元素泛型
   * @return 集合为空时返回空对象
   */
  public static <T> T getFirst(List<T> list) {
    return isNotEmpty(list) ? list.get(0) : null;
  }

  /**
   * 仅有一个元素
   *
   * @param list 检查的集合
   */
  public static boolean isOnlyOne(List<?> list) {
    return isNotEmpty(list) && list.size() == 0;
  }

  /**
   * 集合size是否大于1
   *
   * @param list 集合
   */
  public static boolean isGTOneSize(List<?> list) {
    return isNotEmpty(list) && list.size() > 1;
  }

  /**
   * 移除所有元素
   *
   * @param list 原集合
   * @param remove 要移除的集合
   */
  public static <T> void removeAll(List<T> list, List<T> remove) {
    if (isNotEmpty(remove)) {
      list.removeAll(remove);
    }
  }

  /**
   * 复制集合
   *
   * @param source 源
   * @param additional 额外的元素
   * @param <T> 元素泛型
   * @return 复制完成后的集合, 全新的, 不会与原集合有冲突
   */
  public static <T> List<T> copy(List<T> source, T... additional) {
    List<T> result = new ArrayList<>(source == null ? Collections.emptyList() : source);
    if (additional != null) {
      result.addAll(Arrays.asList(additional));
    }
    return result;
  }

  /**
   * 合并集合
   */
  public static <T> List<T> merge(List<T>... list) {
    List<T> allList = new ArrayList<>();
    Arrays.stream(list).forEach(allList::addAll);
    return allList;
  }

  /**
   * 收集集合中的对象属性集合
   *
   * @param source 原始集合
   * @param mapper 元素的属性映射
   * @param <I> 元素泛型
   * @param <O> 元素属性泛型, 也是返回对象
   * @return 集合中元素属性的集合
   */
  public static <I, O> List<O> collect(List<I> source, Function<? super I, ? extends O> mapper) {
    if (isEmpty(source)) {
      return Collections.emptyList();
    }
    return source.stream().map(mapper).collect(Collectors.toList());
  }

  public static <T> int count(List<T> source, Predicate<? super T> filterPredicate) {
    return (int) source.stream().filter(filterPredicate).count();
  }
}
