package com.nl.teaching.controller;


import com.nl.teaching.domain.po.PCode;
import com.nl.teaching.service.IPCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nl.teaching.result.Result; // 确保导入正确的Result类

import java.util.List;

@RestController
@RequestMapping("/pCode")
public class PCodeController {

    @Autowired
    public IPCodeService pCodeService;

    @PostMapping("/list")
    public Result queryPcodesByCodeType(Integer codeType) {
        List<PCode> pCodeList = pCodeService.findPcodeListByCodyType(codeType);
        Result result = Result.ok(pCodeList);
        return result;
    }

    // 新增 GET 支持
 /*   @GetMapping("/list")
    public Result queryPcodesByCodeTypeGet(@RequestParam Integer codeType) {
        return Result.ok(pCodeService.findPcodeListByCodyType(codeType));
    }*/



}