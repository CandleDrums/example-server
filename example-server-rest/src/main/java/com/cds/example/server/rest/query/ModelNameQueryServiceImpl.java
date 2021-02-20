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

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.constant.APIConstants;
import com.cds.api.example.model.ModelNameVO;
import com.cds.api.example.query.ModelNameQueryService;
import com.cds.base.biz.service.BaseService;
import com.cds.base.common.page.Page;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.rest.impl.BaseQueryServiceImpl;
import com.cds.example.dep.biz.service.ModelNameService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description [name]查询Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
@Slf4j
@RolesAllowed({"ADMIN", "CLIENT"})
public class ModelNameQueryServiceImpl extends BaseQueryServiceImpl<ModelNameVO> implements ModelNameQueryService {

    @Autowired
    private ModelNameService tableNameService;

    @Override
    @Cacheable(value = APIConstants.CACHE_PREFIX + "::(detail)::{pk}", key = "#pk")
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
