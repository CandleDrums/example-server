/**
 * @Project example-server-core
 * @package com.cds.example.server.core.query
 * @Class ModelNameQueryServiceImpl.java
 * @Date [date]
 * @Copyright [copyright]
 */
package com.cds.example.server.rest.query;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.model.ModelNameVO;
import com.cds.api.example.query.ModelNameQueryService;
import com.cds.base.biz.service.BaseService;
import com.cds.base.common.page.Page;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.rest.impl.BaseQueryServiceImpl;
import com.cds.example.dep.biz.service.ModelNameService;

/**
 * @Description [name]查询Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class ModelNameQueryServiceImpl extends BaseQueryServiceImpl<ModelNameVO> implements ModelNameQueryService {

    @Autowired
    private ModelNameService tableNameService;

    @Override
    public ResponseResult<ModelNameVO> detail(@RequestParam("pk") @NotNull Serializable pk) {
        return super.detail(pk);
    }

    @Override
    public ResponseResult<List<ModelNameVO>> query(ModelNameVO tableName) {
        return super.query(tableName);
    }

    @Override
    public ResponseResult<ModelNameVO> queryUnique(@NotNull ModelNameVO params) {
        return super.queryUnique(params);
    }

    @Override
    public ResponseResult<Page<ModelNameVO>> queryPage(@NotNull Page<ModelNameVO> page) {
        return super.queryPage(page);
    }

    @Override
    protected BaseService<ModelNameVO> getService() {
        return tableNameService;
    }

}
