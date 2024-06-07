package com.dongyoung.noAlone.category.controller;

import com.dongyoung.noAlone.category.model.InsertRequestCategoryModel;
import com.dongyoung.noAlone.category.model.SearchCondition;
import com.dongyoung.noAlone.category.model.UpdateRequestCategoryModel;
import com.dongyoung.noAlone.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.PanelUI;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
@Log4j2
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("list")
    public String list(Model model, @PageableDefault(size = 10) Pageable pageable, SearchCondition search) {
        model.addAttribute("maxPage", 10);
        model.addAttribute("list",categoryService.findAllbyQueryDsl(search,pageable));
        return "category/list";
    }

    @GetMapping("/find/{categoryId}")
    public String find(@PathVariable(value="categoryId") Long categoryId, Model model) {
        model.addAttribute("info",categoryService.find(categoryId));
        return "category/view";
    }

    @GetMapping("/save")
    public String saveForm() {
        return "category/saveForm";
    }

    @PostMapping("/save")
    public String save(InsertRequestCategoryModel categoryModel) {
        categoryService.save(categoryModel);
        return "redirect:/category/list";
    }

    @GetMapping("/update/{categoryId}")
    public String updateForm(@PathVariable(value="categoryId") Long categoryId, Model model) {
        model.addAttribute("info",categoryService.find(categoryId));
        return "category/updateForm";
    }

    @PostMapping("update")
    public String update(UpdateRequestCategoryModel categoryModel) {
        categoryService.update(categoryModel);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{categoryId}")
    public String delete(@PathVariable(value="categoryId") Long categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/category/list";
    }
}
