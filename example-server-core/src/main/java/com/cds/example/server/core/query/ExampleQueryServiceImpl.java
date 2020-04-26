/**
 * @Project example-server-core
 * @package com.cds.example.server.core.query
 * @Class ExampleQueryServiceImpl.java
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

import com.cds.api.example.model.ExampleVO;
import com.cds.api.example.query.ExampleQueryService;
import com.cds.base.biz.service.GeneralService;
import com.cds.base.common.page.Page;
import com.cds.base.common.page.PageResult;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.GeneralQueryServiceImpl;
import com.cds.example.dep.biz.service.ExampleService;
import com.cds.example.dep.dal.model.ExampleDO;

/**
 * @Description [name]查询Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class ExampleQueryServiceImpl extends GeneralQueryServiceImpl<ExampleVO> implements ExampleQueryService {

    @Autowired
    private ExampleService exampleService;

    @Override
    public ResponseResult<ExampleVO> detail(@RequestParam(value = "num", required = true) @NotNull String num) {
        return super.detail(num);
    }

    @Override
    public ResponseResult<Boolean> contains(@RequestBody @NotNull ExampleVO example) {
        return super.contains(example);
    }

    @Override
    public ResponseResult<List<ExampleVO>> queryAll(@RequestBody @NotNull ExampleVO example) {
        return super.queryAll(example);
    }

    @Override
    public ResponseResult<PageResult<ExampleVO>> queryPagingList(@RequestBody @NotNull Page<ExampleVO> page) {
        return super.queryPagingList(page);
    }

    @Override
    protected GeneralService<ExampleVO, ExampleDO> getService() {
        return exampleService;
    }

}
