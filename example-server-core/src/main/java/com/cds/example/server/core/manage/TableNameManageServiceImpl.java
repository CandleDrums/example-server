/**
 * @Project example-server-core
 * @package com.cds.example.server.core.manage
 * @Class TableNameManageServiceImpl.java
 * @Date [date]
 * @Copyright [copyright]
 */
package com.cds.example.server.core.manage;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.manage.TableNameManageService;
import com.cds.api.example.model.TableNameVO;
import com.cds.base.biz.service.BaseService;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.BaseManageServiceImpl;
import com.cds.example.dep.biz.service.TableNameService;

/**
 * @Description [name]管理Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class TableNameManageServiceImpl extends BaseManageServiceImpl<TableNameVO> implements TableNameManageService {

    @Autowired
    private TableNameService tableNameService;

    @Override
    public ResponseResult<TableNameVO> save(@NotNull TableNameVO tableName) {
        return super.save(tableName);
    }

    @Override
    public ResponseResult<TableNameVO> modify(@NotNull TableNameVO tableName) {
        return super.modify(tableName);
    }

    @Override
    public ResponseResult<Boolean> delete(@NotNull Serializable num) {
        return super.delete(num);
    }

    @Override
    protected BaseService<TableNameVO> getService() {
        return tableNameService;
    }
}
