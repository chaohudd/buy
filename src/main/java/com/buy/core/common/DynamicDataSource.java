package com.buy.core.common;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import com.buy.core.common.util.GetterUtil;



/**
 * @FileName  DynamicDataSource.java
 * @author colley
 * @version 1.0  Date: 17-8-30 上午9:34
 */
public class DynamicDataSource extends org.apache.tomcat.jdbc.pool.DataSource implements InitializingBean {
    private Resource configLocation;
    private Resource importantConfigLocation;
	private Properties currentProperties;
	private Properties importantCurrentProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (configLocation == null) {
            throw new RuntimeException("configLocation is null");
        }
        
        if (importantConfigLocation == null) {
            throw new RuntimeException("importantConfigLocation is null");
        }

        loadProperties();
        
        loadImportantProperties();

        //
        if (currentProperties == null) {
            throw new RuntimeException("loadProperties by configLocation error!");
        }

        this.setDriverClassName(getString("jdbc.driverClassName"));
        this.setUrl(getString("jdbc.url"));
        this.setUsername(getString("jdbc.username"));
        this.setPassword(getImportantString("jdbc.password"));
        this.setInitialSize(getInt("jdbc.initialSize"));
        this.setMinIdle(getInt("jdbc.minIdle"));
        this.setMaxIdle(getInt("jdbc.maxIdle"));
        this.setMaxWait(getInt("jdbc.maxWait"));
        this.setMaxActive(getInt("jdbc.maxActive"));
        this.setDefaultAutoCommit(getBoolean("jdbc.defaultAutoCommit"));
        this.setRemoveAbandoned(getBoolean("jdbc.removeAbandoned"));
        this.setRemoveAbandonedTimeout(getInt("jdbc.removeAbandonedTimeout"));
        this.setTestOnBorrow(getBoolean("jdbc.testOnBorrow"));
        this.setTestOnReturn(getBoolean("jdbc.testOnReturn"));
        this.setTestWhileIdle(getBoolean("jdbc.testWhileIdle"));
        this.setValidationQuery(getString("jdbc.validationQuery"));
        
    }

    public Resource getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    public void loadProperties() {
        if (configLocation != null) {
            this.currentProperties = new Properties();

            try {
                this.currentProperties.load(configLocation.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public void loadImportantProperties() {
        if (importantConfigLocation != null) {
            this.importantCurrentProperties = new Properties();

            try {
                this.importantCurrentProperties.load(importantConfigLocation.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    

    private String getString(String key) {
        return currentProperties.getProperty(key);
    }

    private int getInt(String key) {
        String value = currentProperties.getProperty(key);

        return GetterUtil.getInteger(value);
    }

    private boolean getImportantBoolean(String key) {
        String value = importantCurrentProperties.getProperty(key);

        return GetterUtil.getBoolean(value);
    }
    
    private String getImportantString(String key) {
        return importantCurrentProperties.getProperty(key);
    }

    private int getImportantInt(String key) {
        String value = importantCurrentProperties.getProperty(key);

        return GetterUtil.getInteger(value);
    }

    private boolean getBoolean(String key) {
        String value = currentProperties.getProperty(key);

        return GetterUtil.getBoolean(value);
    }
    
    public Resource getImportantConfigLocation() {
		return importantConfigLocation;
	}

	public void setImportantConfigLocation(Resource importantConfigLocation) {
		this.importantConfigLocation = importantConfigLocation;
	}
}
