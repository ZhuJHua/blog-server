package com.zjh.j2eework.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.zjh.j2eework.entity.Category;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import static com.zjh.j2eework.util.HttpCode.BAD_REQUEST;
import static com.zjh.j2eework.util.HttpCode.OK;

/**
 * @Description Category control
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;
    
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    
    /**
     * 获取所有分类
     */
    @GetMapping
    @SaCheckLogin
    public Result getCategory() {
        return new Result(OK.getCode(), OK.getDescription(), categoryService.findAllCategory());
    }
    
    /**
     * 增加分类
     */
    @PostMapping
    @SaCheckLogin
    public Result addCategory(@RequestBody Category category) {
        if (categoryService.findByCategoryName(category.getCategoryName()).isPresent()) {
            return new Result(BAD_REQUEST.getCode(), "添加失败，分类已经存在！", "");
        } else {
            return new Result(OK.getCode(), "添加分类成功", categoryService.addCategory(category));
        }
    }
    
    /**
     * 删除分类
     */
    @DeleteMapping
    @SaCheckLogin
    public Result delCategory(@RequestParam(name = "id") Long id) {
        categoryService.delCategory(id);
        return new Result(OK.getCode(), "删除分类成功", "");
    }
    
    /**
     * 修改分类
     */
    @PutMapping
    @SaCheckLogin
    public Result updateCategory(@RequestBody Category category) {
        if (categoryService.findByCategoryName(category.getCategoryName()).isPresent()) {
            return new Result(BAD_REQUEST.getCode(), "修改失败，分类已经存在！", "");
        } else {
            return new Result(OK.getCode(), "修改分类成功", categoryService.updateCategory(category));
        }
    }
}
