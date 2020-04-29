package top.whatimiss.littlenote.modules.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whatimiss.littlenote.common.entity.Result;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.modules.diary.entity.DiaryEntity;
import top.whatimiss.littlenote.modules.diary.service.DiaryService;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/28  下午5:48
 * @description 日记的controller
 */

@RestController
@RequestMapping("diary")
public class DiaryController {


    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    /**
     * 新建日记
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody DiaryEntity diaryEntity) {
        diaryService.save(diaryEntity);
        return Result.success();
    }

    /**
     * 编辑日记
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody DiaryEntity diaryEntity) {
        diaryService.updateById(diaryEntity);
        return Result.success();
    }

    /**
     * 日记列表
     * @return
     */
    @GetMapping("list")
    public Result list(@RequestParam Map params) {
        PageUtils pageUtils = diaryService.getList(params);
        return Result.success(pageUtils);
    }

    /**
     * 日记类型字典列表
     */
    @GetMapping("diaryTypeList")
    public Result diaryTypeList() {
        List<Map<String, Object>> mapList = diaryService.diaryTypeList();
        return Result.success(mapList);
    }




}
