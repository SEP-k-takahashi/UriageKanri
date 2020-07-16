package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
	Page<AnkenEntity> page = ankenSerivice.searchAnkenAll(pageable);

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


  model.addAttribute("ankenRequest", new AnkenRequest());
  //model.addAttribute("category",category);
  return "add";
}
}
