/**
 * @Project example-server-core
 * @package com.cds.example.server.core.query
 * @Class TableNameQueryServiceImpl.java
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

import com.cds.api.example.model.TableNameVO;
import com.cds.api.example.query.TableNameQueryService;
import com.cds.base.biz.service.GeneralService;
import com.cds.base.common.page.Page;
import com.cds.base.common.page.PageResult;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.GeneralQueryServiceImpl;
import com.cds.example.dep.biz.service.TableNameService;
import com.cds.example.dep.dal.model.TableNameDO;

/**
 * @Description [name]查询Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class TableNameQueryServiceImpl extends GeneralQueryServiceImpl<TableNameVO> implements TableNameQueryService {

    @Autowired
    private TableNameService tableService;

    @Override
    public ResponseResult<TableNameVO> detail(@RequestParam(value = "num", required = true) @NotNull String num) {
        return super.detail(num);
    }

    @Override
    public ResponseResult<Boolean> contains(@RequestBody @NotNull TableNameVO example) {
        return super.contains(example);
    }

    @Override
    public ResponseResult<List<TableNameVO>> queryAll(@RequestBody @NotNull TableNameVO example) {
        return super.queryAll(example);
    }

    @Override
    public ResponseResult<PageResult<TableNameVO>> queryPagingList(@RequestBody @NotNull Page<TableNameVO> page) {
        return super.queryPagingList(page);
    }

    @Override
    protected GeneralService<TableNameVO, TableNameDO> getService() {
        return tableService;
    }

}
