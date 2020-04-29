package top.whatimiss.littlenote.modules.sentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whatimiss.littlenote.common.entity.Result;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.modules.sentence.entity.SentenceEntity;
import top.whatimiss.littlenote.modules.sentence.service.SentenceService;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/29  上午9:51
 * @description 句子的controller
 */
@RestController
@RequestMapping("sentence")
public class SentenceController {

    private final SentenceService sentenceService;

    @Autowired
    public SentenceController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    /**
     * 新建句子
     *
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody SentenceEntity sentenceEntity) {
        sentenceService.save(sentenceEntity);
        return Result.success();
    }

    /**
     * 编辑句子
     *
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody SentenceEntity sentenceEntity) {
        sentenceService.updateById(sentenceEntity);
        return Result.success();
    }

    /**
     * 句子列表
     *
     * @return
     */
    @GetMapping("list")
    public Result list(@RequestParam Map params) {
        PageUtils pageUtils = sentenceService.getList(params);
        return Result.success(pageUtils);
    }

    @GetMapping("sentenceTypeList")
    public Result sentenceTypeList() {
        List<Map<String, Object>> mapList = sentenceService.sentenceTypeList();
        return Result.success(mapList);
    }
}
