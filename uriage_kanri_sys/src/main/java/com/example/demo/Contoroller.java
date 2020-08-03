package com.example.demo;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Contoroller {
@Autowired
AnkenService ankenSerivice;

@RequestMapping(value = "/all", method = RequestMethod.GET)
public String getAllUsers(@Validated AnkenEntity Anken,  BindingResult result,
			@PageableDefault(size = 5) Pageable pageable,
			Model model) {
	//Page<AnkenEntity> page = ankenSerivice.searchAnkenAll(pageable);
	Page<IchiranEntity> page = ankenSerivice.searchAnkenAll(pageable);

	//model.addAttribute("users", page.getContent());
	model.addAttribute("anken", page);

return "list";
}
/**
 * 案件新規登録画面を表示
 * @param model Model
 * @return 案件新規登録画面
 */
@GetMapping(value = "/add")
public String displayAdd(Model model) {

  KokyakuEntity kokyaku = new KokyakuEntity();
  StatusEntity status = new StatusEntity();


  model.addAttribute("ankenRequest", new AnkenRequest());
  model.addAttribute("category",kokyaku);
  return "add";
}
/**
 * 案件登録確認画面を表示
 * @param model Model
 * @return 案件登録確認画面
 */
@PostMapping(value = "/addcheck")
public String AddCheck(@Validated @ModelAttribute AnkenRequest ankenRequest, BindingResult result, Model model) {


    if (result.hasErrors()) {
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
        //List<Category> categoryall =ankenRequest.findCategoryAll();
        model.addAttribute("validationError", errorList);
        //model.addAttribute("category",categoryall);
        return "add";
      }
    //Category category = userRepositoryCategory.findById(userRequest.getCategoryid()).get();
	model.addAttribute("ankenRequest", ankenRequest);
	//model.addAttribute("category",category);
    //userService.create(userRequest);
    return "addCheck";
}
@PostMapping(value = "/addcommit")
public String displayAddcommit(@Validated @ModelAttribute AnkenRequest ankenRequest, BindingResult result, Model model) {

	ankenSerivice.create(ankenRequest);
  //model.addAttribute("category",category);
  return "redirect:all";
}

@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
}
}

