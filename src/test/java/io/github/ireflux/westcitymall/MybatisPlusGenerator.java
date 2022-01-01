package io.github.ireflux.westcitymall;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class MybatisPlusGenerator {

    @Test
    void generator() {
        FastAutoGenerator.create("jdbc:mysql://192.168.31.108:3306/west_city_mall?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("zhaoxinyang") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/home/rdz/project/generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("io.github.ireflux") // 设置父包名
                            .moduleName("westcitymall") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/home/rdz/project/generator")); // 设置mapperXml生成路径
                })
                .templateConfig(builder -> {
                    builder.entity("/templates/entity.java")
                            .service("/templates/service.java")
                            .serviceImpl("/templates/serviceImpl.java")
                            .mapper("/templates/mapper.java")
                            .mapperXml("/templates/mapper.xml")
                            .controller("/templates/controller.java")
                            .build();
                })
                .strategyConfig(builder -> {
                    builder.addInclude("brand_info") // 设置需要生成的表名
                            .addTablePrefix(); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
