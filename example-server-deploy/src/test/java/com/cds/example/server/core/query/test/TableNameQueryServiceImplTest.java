/**
 * @Project example-server-deploy
 * @Package com.cds.example.server.core.query.test
 * @Class ExampleQueryServiceImplTest.java
 * @Date [date]
 * @Copyright (c) 2020 CandleDrums.com All Right Reserved.
 */
package com.cds.example.server.core.query.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cds.api.example.model.TableNameVO;
import com.cds.api.example.query.TableNameQueryService;
import com.cds.server.Application;

/**
 * @Description Example查询Server测试
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class, TableNameQueryServiceImplTest.class})
public class TableNameQueryServiceImplTest {
    @Autowired
    private TableNameQueryService tableNameQueryService;

    @Test
    void testQueryAll() {
        tableNameQueryService.queryAll(new TableNameVO());
    }
}
