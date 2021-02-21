/**
 * @Project example-server-core
 * @package com.cds.server.example.rest.manage
 * @Class ModelNameManageServiceImpl.java
 * @Date [date]
 * @Copyright [copyright]
 */
package com.cds.server.example.rest.manage;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.manage.ModelNameManageService;
import com.cds.api.example.model.ModelNameVO;
import com.cds.base.biz.service.BaseService;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.rest.impl.BaseManageServiceImpl;
import com.cds.example.dep.biz.service.ModelNameService;

/**
 * @Description [name]管理Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class ModelNameManageServiceImpl extends BaseManageServiceImpl<ModelNameVO> implements ModelNameManageService {

    @Autowired
    private ModelNameService tableNameService;

    @Override
    public ResponseResult<ModelNameVO> save(@NotNull ModelNameVO tableName) {
        return super.save(tableName);
    }

    @Override
    public ResponseResult<Integer> saveAll(@NotNull List<ModelNameVO> valueList) {
        return super.saveAll(valueList);
    }

    @Override
    public ResponseResult<ModelNameVO> modify(@NotNull ModelNameVO tableName) {
        return super.modify(tableName);
    }

    @Override
    public ResponseResult<Boolean> delete(@RequestParam("pk") @NotNull Serializable pk) {
        return super.delete(pk);
    }

    @Override
    protected BaseService<ModelNameVO> getService() {
        return tableNameService;
    }
}
