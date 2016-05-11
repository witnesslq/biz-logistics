package cc.aisc.logistics.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by sjf on 16-5-10.
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@MapperScan(basePackages = {"cc.aisc.logistics.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class DbConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbConfig.class);

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        LOGGER.debug("Configuring Druid DataSource.");
        DruidDataSource datasource = new DruidDataSource();
        RelaxedPropertyResolver rpr = new RelaxedPropertyResolver(env, "spring.datasource.");
        datasource.setDbType(rpr.getProperty("type"));
        datasource.setUrl(rpr.getProperty("url"));
        datasource.setDriverClassName(rpr.getProperty("driverClassName"));
        datasource.setUsername(rpr.getProperty("username"));
        datasource.setPassword(rpr.getProperty("password"));
        datasource.setMaxActive(Integer.valueOf(rpr.getProperty("max-active")));
        datasource.setMaxWait(Integer.valueOf(rpr.getProperty("max-wait")));
        datasource.setInitialSize(Integer.valueOf(rpr.getProperty("initial-size")));
        datasource.setTestWhileIdle(Boolean.parseBoolean(rpr.getProperty("test-while-idle")));
        datasource.setTestOnBorrow(Boolean.parseBoolean(rpr.getProperty("test-on-borrow")));
        datasource.setValidationQuery(rpr.getProperty("validation-query"));
        datasource.setMinIdle(Integer.valueOf(rpr.getProperty("min-idle")));
        datasource.setPoolPreparedStatements(Boolean.parseBoolean(rpr.getProperty("pool-prepared-statements")));
        return datasource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource());
            sqlSessionFactoryBean.setTypeAliasesPackage("cc.aisc.model");
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis3/mapper/**/*Mapper.xml"));

            //分页插件
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("reasonable", "true");
            properties.setProperty("supportMethodsArguments", "true");
            properties.setProperty("returnPageInfo", "check");
            properties.setProperty("params", "count=countSql");
            pageHelper.setProperties(properties);
            //添加插件
            sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
            return sqlSessionFactoryBean.getObject();

        } catch (Exception e) {
            LOGGER.warn("Could not configure mybatis session factory");
            return null;
        }

    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //使用指定事务管理器
    // 若@EnableTransactionManagement，系统会使用默认事务管理器
    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
