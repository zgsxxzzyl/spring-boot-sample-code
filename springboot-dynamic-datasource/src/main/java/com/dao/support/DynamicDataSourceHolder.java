package com.dao.support;

public class DynamicDataSourceHolder {

    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    //获取数据源
    public static String getDataSource() {
        return (String) dataSources.get();
    }

    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }

    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }

}
