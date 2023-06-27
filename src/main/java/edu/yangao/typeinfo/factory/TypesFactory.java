package edu.yangao.typeinfo.factory;

/**
 * @author YangAo
 */
public interface TypesFactory<T> extends Factory<T> {
    /**
     * 返回类型的Class对象
     * @return 类型的Class对象
     */
    Class<T> type();
}
