package com.ztax.iam.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * mybatis代码生成器
 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class PubCodeGenerator {

    public static void main(String[] args)  throws Exception {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        ResourceBundle rb = ResourceBundle.getBundle("genreator");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setServiceName("%sService");//service 命名方式
        gc.setServiceImplName("%sServiceImpl");//service impl 命名方式
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setAuthor("dingl");
        gc.setIdType(IdType.UUID);
        gc.setFileOverride(true);
        // 开启 activeRecord 模式
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);

        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        //注意Mysql 驱动版本问题 我这为8版本
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(rb.getString("jdbc.username"));
        dsc.setPassword(rb.getString("jdbc.password"));
        dsc.setUrl(rb.getString("jdbc.url"));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(new String("模块名"));
        pc.setParent(rb.getString("parent"));
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/templates/controller");
        tc.setService("/templates/service-interface");
        tc.setServiceImpl("/templates/service");
        tc.setEntity("/templates/entity");
        tc.setMapper("/templates/mapper");
        tc.setXml("/templates/mapper.xml");
        mpg.setTemplate(tc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategy.setEntityLombokModel();
        strategy.setEntityBuilderModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(rb.getString("tables.name").split(","));
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
