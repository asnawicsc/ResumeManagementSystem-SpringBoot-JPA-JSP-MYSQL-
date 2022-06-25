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
import com.gl.hcl.Model.UserAcknowledgments;
import com.gl.hcl.Service.UserAcknowledgmentsService;

import com.gl.hcl.Service.UserService;

@Controller
public class UserAcknowledgmentsController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserAcknowledgmentsService userAcknowledgmentsService;

	// function to navigate to edit user acknowledgments page
	@RequestMapping(value = "/update_user_acknowledgments/{id}")
	public ModelAndView edit(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserAcknowledgments> list2 = userAcknowledgmentsService.getAllUserAcknowledgmentsByUserID(user.getId());
		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_acknowledgments", list2);

		return new ModelAndView("update_user_acknowledgments", "model", model2);

	}

	// function to create new user acknowledgments
	@RequestMapping(value = "/create_new_user_acknowledgments/{id}")
	public ModelAndView create_user_acknowledgments(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserAcknowledgments> list2 = userAcknowledgmentsService.getAllUserAcknowledgmentsByUserID(user.getId());

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("all_user_acknowledgments", list2);

		return new ModelAndView("create_new_user_acknowledgments", "model", model2);

	}

	// function to add new user acknowledgments
	@RequestMapping(value = "/addNewAcknowledgments", method = RequestMethod.POST)
	public String saveRegistrationAcknowledgments(@Validated UserAcknowledgments useracknowledgments,
			BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "create_new_user_acknowledgments";
		}

		User user = userService.getUserByID(useracknowledgments.getUser_id());

		userAcknowledgmentsService.addNewUserAcknowledgments(useracknowledgments);

		return "redirect:update_user_acknowledgments/" + user.getId();
	}

	// function to edit existing user acknowledgments
	@RequestMapping(value = "/edituseracknowledgments/{user_id}/{id}")
	public ModelAndView edit_user_acknowledgments(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserAcknowledgments useracknowledgments = userAcknowledgmentsService.getUserAcknowledgmentsByID(id);

		model.addAttribute("useracknowledgments", useracknowledgments);

		return new ModelAndView("edituseracknowledgments");

	}

	// function to submit edited user acknowledgments
	@RequestMapping(value = "/editAcknowledgmentssubmit", method = RequestMethod.POST)
	public String saveeditAcknowledgments(@Validated UserAcknowledgments useracknowledgments, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {

		UserAcknowledgments ub = userAcknowledgmentsService.getUserAcknowledgmentsByID(useracknowledgments.getId());

		userAcknowledgmentsService.updateUserAcknowledgments(useracknowledgments);

		return "redirect:update_user_acknowledgments/" + ub.getUser_id();
	}

	// function to delete user acknowledgments
	@RequestMapping(value = "/deleteuseracknowledgments/{user_id}/{id}")
	public ModelAndView delete_user_acknowledgments(@PathVariable int user_id, @PathVariable int id, ModelMap model) {
		UserAcknowledgments useracknowledgments = userAcknowledgmentsService.getUserAcknowledgmentsByID(id);
		userAcknowledgmentsService.deleteUserAcknowledgments(id);

		return new ModelAndView("redirect:/update_user_acknowledgments/" + useracknowledgments.getUser_id());

	}

}
