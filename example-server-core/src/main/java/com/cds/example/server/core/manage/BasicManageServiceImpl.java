/**
 * @Project example-server-core
 * @Package com.cds.example.server.core.manage
 * @Class BasicManageServiceImpl.java
 * @Date Nov 6, 2020 11:20:58 AM
 * @Copyright (c) 2020 CandleDrums.com All Right Reserved.
 */
package com.cds.example.server.core.manage;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cds.api.example.manage.BasicManageService;
import com.cds.api.example.model.BasicVO;
import com.cds.base.biz.service.BaseService;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.BaseManageServiceImpl;
import com.cds.example.dep.biz.service.BasicService;

/**
 * @Description TODO 填写描述信息
 * @Notes 未填写备注
 * @author liming
 * @Date Nov 6, 2020 11:20:58 AM
 */
@RestController
public class BasicManageServiceImpl extends BaseManageServiceImpl<BasicVO> implements BasicManageService {

    @Autowired
    private BasicService tableNameService;

    @Override
    public ResponseResult<BasicVO> save(@NotNull BasicVO tableName) {
        return super.save(tableName);
    }

    @Override
    public ResponseResult<Integer> saveAll(@NotNull List<BasicVO> valueList) {
        return super.saveAll(valueList);
    }

    @Override
    public ResponseResult<BasicVO> modify(@NotNull BasicVO tableName) {
        return super.modify(tableName);
    }

    @Override
    public ResponseResult<Boolean> delete(@NotNull Serializable id) {
        return super.delete(id);
    }

    @Override
    protected BaseService<BasicVO> getService() {
        return tableNameService;
    }

}
