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
import com.gl.hcl.Model.UserExperience;
import com.gl.hcl.Service.UserExperienceService;
import com.gl.hcl.Service.UserService;

@Controller
public class UserExperienceController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserExperienceService userExperienceService;

	// function to navigate to edit user experience page
	@RequestMapping(value = "/update_user_experience/{id}")
	public ModelAndView edit(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserExperience> list2 = userExperienceService.getAllUserExperienceByUserID(user.getId());
		System.out.println("Dadasd");
		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_experience", list2);

		return new ModelAndView("update_user_experience", "model", model2);

	}

	// function to create new user experience
	@RequestMapping(value = "/create_new_user_experience/{id}")
	public ModelAndView create_user_experience(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserExperience> list2 = userExperienceService.getAllUserExperienceByUserID(user.getId());

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_experience", list2);

		return new ModelAndView("create_new_user_experience", "model", model2);

	}

	// function to add new user experience
	@RequestMapping(value = "/addNewExperience", method = RequestMethod.POST)
	public String saveRegistrationExperience(@Validated UserExperience userexperience, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "create_new_user_experience";
		}

		User user = userService.getUserByID(userexperience.getUser_id());

		userExperienceService.addNewUserExperience(userexperience);

		return "redirect:update_user_experience/" + user.getId();
	}

	// function to navigate to edit user experience page
	@RequestMapping(value = "/edituserexperience/{user_id}/{id}")
	public ModelAndView edit_user_experience(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserExperience userexperience = userExperienceService.getUserExperienceByID(id);

		model.addAttribute("userexperience", userexperience);

		return new ModelAndView("edituserexperience");

	}

	// function to submit edit user experience to database
	@RequestMapping(value = "/editExperiencesubmit", method = RequestMethod.POST)
	public String saveeditExperience(@Validated UserExperience userexperience, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		UserExperience ub = userExperienceService.getUserExperienceByID(userexperience.getId());

		userExperienceService.updateUserExperience(userexperience);

		return "redirect:update_user_experience/" + ub.getUser_id();
	}

	// fucntion to delete user experience
	@RequestMapping(value = "/deleteuserexperience/{user_id}/{id}")
	public ModelAndView delete_user_experience(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserExperience userexperience = userExperienceService.getUserExperienceByID(id);
		userExperienceService.deleteUserExperience(id);

		return new ModelAndView("redirect:/update_user_experience/" + userexperience.getUser_id());

	}

}
