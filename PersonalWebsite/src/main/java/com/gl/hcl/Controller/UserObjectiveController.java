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
import com.gl.hcl.Model.UserObjective;
import com.gl.hcl.Service.UserObjectiveService;
import com.gl.hcl.Service.UserService;

@Controller
public class UserObjectiveController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserObjectiveService userObjectiveService;

	// function to navigate to edit user objective page
	@RequestMapping(value = "/update_user_objective/{id}")
	public ModelAndView edit(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserObjective> list2 = userObjectiveService.getAllUserObjectiveByUserID(user.getId());

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_objective", list2);

		return new ModelAndView("update_user_objective", "model", model2);

	}

	// function to create new user objective
	@RequestMapping(value = "/create_new_user_objective/{id}")
	public ModelAndView create_user_objective(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserObjective> list2 = userObjectiveService.getAllUserObjectiveByUserID(user.getId());

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_objective", list2);

		return new ModelAndView("create_new_user_objective", "model", model2);

	}

	// function to add new user objective to database
	@RequestMapping(value = "/addNewObjective", method = RequestMethod.POST)
	public String saveRegistrationObjective(@Validated UserObjective userobjective, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "create_new_user_objective";
		}

		User user = userService.getUserByID(userobjective.getUser_id());

		userObjectiveService.addNewUserObjective(userobjective);

		return "redirect:update_user_objective/" + user.getId();
	}

	// function to navitage to edit user objective page
	@RequestMapping(value = "/edituserobjective/{user_id}/{id}")
	public ModelAndView edit_user_objective(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserObjective userobjective = userObjectiveService.getUserObjectiveByID(id);

		model.addAttribute("userobjective", userobjective);

		return new ModelAndView("edituserobjective");

	}

	// function to submit edit user objective to database
	@RequestMapping(value = "/editObjectivesubmit", method = RequestMethod.POST)
	public String saveeditObjective(@Validated UserObjective userobjective, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		UserObjective ub = userObjectiveService.getUserObjectiveByID(userobjective.getId());

		userObjectiveService.updateUserObjective(userobjective);

		return "redirect:update_user_objective/" + ub.getUser_id();
	}

	// function to delete user objective
	@RequestMapping(value = "/deleteuserobjective/{user_id}/{id}")
	public ModelAndView delete_user_objective(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserObjective userobjective = userObjectiveService.getUserObjectiveByID(id);
		userObjectiveService.deleteUserObjective(id);

		return new ModelAndView("redirect:/update_user_objective/" + userobjective.getUser_id());

	}

}
