/**
 * @Project example-server-core
 * @package com.cds.example.server.core.manage
 * @Class TableNameManageServiceImpl.java
 * @Date [date]
 * @Copyright (c) 2019 CandleDrumS.com All Right Reserved.
 */
package com.cds.example.server.core.manage;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.manage.TableNameManageService;
import com.cds.api.example.model.TableNameVO;
import com.cds.base.biz.service.GeneralService;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.GeneralManageServiceImpl;
import com.cds.example.dep.biz.service.TableNameService;
import com.cds.example.dep.dal.model.TableNameDO;

/**
 * @Description [name]管理Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class TableNameManageServiceImpl extends GeneralManageServiceImpl<TableNameVO>
    implements TableNameManageService {

    @Autowired
    private TableNameService tableNameService;

    @Override
    public ResponseResult<TableNameVO> add(@RequestBody @NotNull TableNameVO tableName) {
        return super.add(tableName);
    }

    @Override
    public ResponseResult<TableNameVO> modify(@RequestBody @NotNull TableNameVO tableName) {
        return super.modify(tableName);
    }

    @Override
    public ResponseResult<Boolean> delete(@RequestParam(value = "num", required = true) @NotNull String num) {
        return super.delete(num);
    }

    @Override
    protected GeneralService<TableNameVO, TableNameDO> getService() {
        return tableNameService;
    }

}
