package com.gl.hcl.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gl.hcl.Model.User;
import com.gl.hcl.Model.UserEducation;

import com.gl.hcl.Service.UserEducationService;
import com.gl.hcl.Service.UserService;

@Controller
public class UserEducationController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserEducationService userEducationService;

	// function to navigate to edit user education page
	@RequestMapping(value = "/update_user_education/{id}")
	public ModelAndView edit(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserEducation> list2 = userEducationService.getAllUserEducationByUserID(user.getId());
		System.out.println("Dadasd");
		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_education", list2);

		return new ModelAndView("update_user_education", "model", model2);

	}

	// function to navigate to create user eduation page
	@RequestMapping(value = "/create_new_user_education/{id}")
	public ModelAndView create_user_education(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserEducation> list2 = userEducationService.getAllUserEducationByUserID(user.getId());

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_education", list2);

		return new ModelAndView("create_new_user_education", "model", model2);

	}

	// function to add new user to database
	@RequestMapping(value = "/addNewEducation", method = RequestMethod.POST)
	public String saveRegistrationEducation(@Validated UserEducation usereducation, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "create_new_user_education";
		}

		User user = userService.getUserByID(usereducation.getUser_id());

		userEducationService.addNewUserEducation(usereducation);

		return "redirect:update_user_education/" + user.getId();
	}

	// function navigate to edit user education page
	@RequestMapping(value = "/editusereducation/{user_id}/{id}")
	public ModelAndView edit_user_education(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserEducation usereducation = userEducationService.getUserEducationByID(id);

		model.addAttribute("usereducation", usereducation);

		return new ModelAndView("editusereducation");

	}

	// function to submit edit user education to database
	@RequestMapping(value = "/editEducationsubmit", method = RequestMethod.POST)
	public String saveeditEducation(@Validated UserEducation usereducation, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		UserEducation ub = userEducationService.getUserEducationByID(usereducation.getId());

		userEducationService.updateUserEducation(usereducation);

		return "redirect:update_user_education/" + ub.getUser_id();
	}

	// function to delete user education
	@RequestMapping(value = "/deleteusereducation/{user_id}/{id}")
	public ModelAndView delete_user_education(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserEducation usereducation = userEducationService.getUserEducationByID(id);
		userEducationService.deleteUserEducation(id);

		return new ModelAndView("redirect:/update_user_education/" + usereducation.getUser_id());

	}
}
