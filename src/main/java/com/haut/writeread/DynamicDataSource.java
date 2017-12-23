package com.haut.writeread;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSourceKey();
    }
}
