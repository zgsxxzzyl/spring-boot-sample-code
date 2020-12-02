package com.framework.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyh
 * @version 1.0.0 2018-11-26
 * @当前线程数据源
 * @since 1.0.0 2018-11-26
 */
public class DynamicDataSourceContextHolder {

    /**
     * 存放当前线程使用的数据源类型信息
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    /**
     * 存放数据源id
     */
    public static List<String> dataSourceIds = new ArrayList<String>();

    /**
     * 获得数据源
     */
    public static String getDateSoureType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 设置数据源
     */
    public static void setDateSoureType(String dsType) {
        CONTEXT_HOLDER.set(dsType);
    }

    /**
     * 清空数据源
     */
    public static void clearDateSoureType() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 判断当前数据源是否存在
     *
     * @param dataSourceId
     * @return
     */
    public static boolean isContainsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }
}
