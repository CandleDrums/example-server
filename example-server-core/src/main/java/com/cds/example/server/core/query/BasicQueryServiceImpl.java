/**
 * @Project example-server-core
 * @Package com.cds.example.server.core.query
 * @Class BasicQueryServiceImpl.java
 * @Date Nov 6, 2020 11:22:12 AM
 * @Copyright (c) 2020 CandleDrums.com All Right Reserved.
 */
package com.cds.example.server.core.query;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.model.BasicVO;
import com.cds.api.example.query.BasicQueryService;
import com.cds.base.biz.service.BaseService;
import com.cds.base.common.page.Page;
import com.cds.base.common.page.PageResult;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.BaseQueryServiceImpl;
import com.cds.example.dep.biz.service.BasicService;

/**
 * @Description TODO 填写描述信息
 * @Notes 未填写备注
 * @author liming
 * @Date Nov 6, 2020 11:22:12 AM
 */
@RestController
public class BasicQueryServiceImpl extends BaseQueryServiceImpl<BasicVO> implements BasicQueryService {

    @Autowired
    private BasicService tableNameService;

    @Override
    public ResponseResult<BasicVO> detail(@NotNull Serializable id) {
        return super.detail(id);
    }

    @Override
    public ResponseResult<BasicVO> detail(@NotNull BasicVO value) {
        return null;
    }

    @Override
    public ResponseResult<List<BasicVO>> queryAll(@NotNull BasicVO tableName) {
        return super.queryAll(tableName);
    }

    @Override
    public ResponseResult<PageResult<BasicVO>> queryPagingList(@NotNull Page<BasicVO> page) {
        return super.queryPagingList(page);
    }

    @Override
    protected BaseService<BasicVO> getService() {
        return tableNameService;
    }

}
