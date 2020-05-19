/**
 * @Project example-server-core
 * @package com.cds.example.server.core.manage
 * @Class TableManageServiceImpl.java
 * @Date [date]
 * @Copyright (c) 2019 CandleDrums.com All Right Reserved.
 */
package com.cds.example.server.core.manage;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.manage.TableManageService;
import com.cds.api.example.model.TableVO;
import com.cds.base.biz.service.GeneralService;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.GeneralManageServiceImpl;
import com.cds.example.dep.biz.service.TableService;
import com.cds.example.dep.dal.model.TableDO;

/**
 * @Description [name]管理Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class TableManageServiceImpl extends GeneralManageServiceImpl<TableVO> implements TableManageService {

    @Autowired
    private TableService tableService;

    @Override
    public ResponseResult<TableVO> add(@RequestBody @NotNull TableVO example) {
        return super.add(example);
    }

    @Override
    public ResponseResult<TableVO> modify(@RequestBody @NotNull TableVO t) {
        return super.modify(t);
    }

    @Override
    public ResponseResult<Boolean> delete(@RequestParam(value = "num", required = true) @NotNull String num) {

        return super.delete(num);
    }

    @Override
    protected GeneralService<TableVO, TableDO> getService() {
        return tableService;
    }

}
