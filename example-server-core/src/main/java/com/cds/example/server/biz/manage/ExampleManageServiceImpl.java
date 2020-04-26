/**
 * @Project example-server-biz
 * @package com.cds.example.server.biz.manage
 * @Class ExampleManageServiceImpl.java
 * @Date [date]
 * @Copyright (c) 2019 CandleDrums.com All Right Reserved.
 */
package com.cds.example.server.biz.manage;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cds.base.biz.service.GeneralService;
import com.cds.base.common.result.ResponseResult;
import com.cds.base.core.impl.GeneralManageServiceImpl;

/**
 * @Description [name]管理Service实现
 * @Notes 未填写备注
 * @author [author]
 * @Date [date]
 */
@RestController
public class ExampleManageServiceImpl extends GeneralManageServiceImpl<ExampleVO> implements ExampleManageService {

    @Autowired
    private ExampleService exampleService;

    @Override
    public ResponseResult<ExampleVO> add(@RequestBody @NotNull ExampleVO example) {
        return super.add(example);
    }

    @Override
    public ResponseResult<ExampleVO> modify(@RequestBody @NotNull ExampleVO t) {
        return super.modify(t);
    }

    @Override
    public ResponseResult<Boolean> delete(@RequestParam(value = "num", required = true) @NotNull String num) {

        return super.delete(num);
    }

    @Override
    protected GeneralService<ExampleVO, ExampleDO> getService() {
        return exampleService;
    }

}
