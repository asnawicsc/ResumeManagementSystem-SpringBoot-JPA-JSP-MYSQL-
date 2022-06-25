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
import com.gl.hcl.Model.UserAwards;
import com.gl.hcl.Service.UserAwardsService;
import com.gl.hcl.Service.UserService;

@Controller
public class UserAwardsController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAwardsService userAwardsService;

	// function to navigate to edit user awards page
	@RequestMapping(value = "/update_user_awards/{id}")
	public ModelAndView edit(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserAwards> list2 = userAwardsService.getAllUserAwardsByUserID(user.getId());
		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_awards", list2);

		return new ModelAndView("update_user_awards", "model", model2);

	}

	// function to create new user awards
	@RequestMapping(value = "/create_new_user_awards/{id}")
	public ModelAndView create_user_awards(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserAwards> list2 = userAwardsService.getAllUserAwardsByUserID(user.getId());

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_awards", list2);

		return new ModelAndView("create_new_user_awards", "model", model2);

	}

	// function to add new user awards to database
	@RequestMapping(value = "/addNewAwards", method = RequestMethod.POST)
	public String saveRegistrationAwards(@Validated UserAwards userawards, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "create_new_user_awards";
		}

		User user = userService.getUserByID(userawards.getUser_id());

		userAwardsService.addNewUserAwards(userawards);

		return "redirect:update_user_awards/" + user.getId();
	}

	// function to nevigate to edituserawards page
	@RequestMapping(value = "/edituserawards/{user_id}/{id}")
	public ModelAndView edit_user_awards(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserAwards userawards = userAwardsService.getUserAwardsByID(id);

		model.addAttribute("userawards", userawards);

		return new ModelAndView("edituserawards");

	}

	// function to submit edituserawards to database
	@RequestMapping(value = "/editAwardssubmit", method = RequestMethod.POST)
	public String saveeditAwards(@Validated UserAwards userawards, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		UserAwards ub = userAwardsService.getUserAwardsByID(userawards.getId());

		userAwardsService.updateUserAwards(userawards);

		return "redirect:update_user_awards/" + ub.getUser_id();
	}

	// function to delete exisitng user awards
	@RequestMapping(value = "/deleteuserawards/{user_id}/{id}")
	public ModelAndView delete_user_awards(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserAwards userawards = userAwardsService.getUserAwardsByID(id);
		userAwardsService.deleteUserAwards(id);

		return new ModelAndView("redirect:/update_user_awards/" + userawards.getUser_id());

	}

}
