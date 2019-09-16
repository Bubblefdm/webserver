package com.stopec.gy.mybatis.handler;

import com.stopec.gy.mapper.CreateMysqlTablesMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

public class AutoTableTKMapperScannerConfigurer extends MapperScannerConfigurer implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {
    private AutoTableHandle autoTableHandle;
    private String packs;
    private String tableAuto;
    private ApplicationContext appCtx;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (this.autoTableHandle == null) {
            CreateMysqlTablesMapper createMysqlTablesMapper = this.appCtx.getBean(CreateMysqlTablesMapper.class);
            this.autoTableHandle = new AutoTableHandle(createMysqlTablesMapper, this.packs, this.tableAuto);
            this.autoTableHandle.createMysqlTable();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.appCtx = applicationContext;
    }

    public void setPacks(String packs) {
        this.packs = packs;
    }

    public void setTableAuto(String tableAuto) {
        this.tableAuto = tableAuto;
    }

    @Override
    public void setBasePackage(String basePackage) {
        super.setBasePackage(basePackage);
    }
}
