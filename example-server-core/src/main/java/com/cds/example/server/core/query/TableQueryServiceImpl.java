/**
 * @Project example-server-core
 * @package com.cds.example.server.core.query
 * @Class TableQueryServiceImpl.java
 * @Date [date]
 * @Copyright (c) 2019 CandleDrums.com All Right Reserved.
 */
package com.cds.example.server.core.query;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.model.TableVO;
import com.cds.api.example.query.TableQueryService;
import com.cds.base.biz.service.GeneralService;
import com.cds.base.common.page.Page;
import com.cds.base.common.page.PageResult;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.GeneralQueryServiceImpl;
import com.cds.example.dep.biz.service.TableService;
import com.cds.example.dep.dal.model.TableDO;

/**
 * @Description [name]查询Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class TableQueryServiceImpl extends GeneralQueryServiceImpl<TableVO> implements TableQueryService {

    @Autowired
    private TableService tableService;

    @Override
    public ResponseResult<TableVO> detail(@RequestParam(value = "num", required = true) @NotNull String num) {
        return super.detail(num);
    }

    @Override
    public ResponseResult<Boolean> contains(@RequestBody @NotNull TableVO example) {
        return super.contains(example);
    }

    @Override
    public ResponseResult<List<TableVO>> queryAll(@RequestBody @NotNull TableVO example) {
        return super.queryAll(example);
    }

    @Override
    public ResponseResult<PageResult<TableVO>> queryPagingList(@RequestBody @NotNull Page<TableVO> page) {
        return super.queryPagingList(page);
    }

    @Override
    protected GeneralService<TableVO, TableDO> getService() {
        return tableService;
    }

}
