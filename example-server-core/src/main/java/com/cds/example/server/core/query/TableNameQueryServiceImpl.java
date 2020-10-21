/**
 * @Project example-server-core
 * @package com.cds.example.server.core.query
 * @Class TableNameQueryServiceImpl.java
 * @Date [date]
 * @Copyright [copyright]
 */
package com.cds.example.server.core.query;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.model.TableNameVO;
import com.cds.api.example.query.TableNameQueryService;
import com.cds.base.biz.service.GeneralService;
import com.cds.base.common.page.Page;
import com.cds.base.common.page.PageResult;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.GeneralQueryServiceImpl;
import com.cds.example.dep.biz.service.TableNameService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description [name]查询Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
@Slf4j
public class TableNameQueryServiceImpl extends GeneralQueryServiceImpl<TableNameVO> implements TableNameQueryService {

    @Autowired
    private TableNameService tableNameService;

    @Override
    public ResponseResult<TableNameVO> detail(@RequestParam(value = "num", required = true) @NotNull String num) {
        return super.detail(num);
    }

    @Override
    public ResponseResult<List<TableNameVO>> queryAll(@RequestBody @NotNull TableNameVO tableName) {
        return super.queryAll(tableName);
    }

    @Override
    public ResponseResult<PageResult<TableNameVO>> queryPagingList(@RequestBody @NotNull Page<TableNameVO> page) {
        return super.queryPagingList(page);
    }

    @Override
    protected GeneralService<TableNameVO> getService() {
        return tableNameService;
    }

}
