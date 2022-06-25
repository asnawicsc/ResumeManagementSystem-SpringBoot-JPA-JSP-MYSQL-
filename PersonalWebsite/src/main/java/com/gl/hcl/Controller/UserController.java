package com.gl.hcl.Controller;

import java.io.IOException;
import java.util.Random;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gl.hcl.Service.UserAcknowledgmentsService;
import com.gl.hcl.Service.UserAwardsService;
import com.gl.hcl.Service.UserEducationService;
import com.gl.hcl.Service.UserExperienceService;
import com.gl.hcl.Service.UserObjectiveService;
import com.gl.hcl.Service.UserService;
import com.gl.hcl.Model.User;
import com.gl.hcl.Model.UserAcknowledgments;
import com.gl.hcl.Model.UserAwards;
import com.gl.hcl.Model.UserEducation;
import com.gl.hcl.Model.UserExperience;
import com.gl.hcl.Model.UserObjective;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserObjectiveService userObjectiveService;

	@Autowired
	private UserEducationService userEducationService;

	@Autowired
	private UserExperienceService userExperienceService;

	@Autowired
	private UserAwardsService userAwardsService;

	@Autowired
	private UserAcknowledgmentsService userAcknowledgmentsService;

	// function to redirect in index page when starting the server
	@RequestMapping({ "/", "/index" })
	public String welcome() {

		return "index";
	}

	// function to navigate register new user page
	@RequestMapping(value = "/register_new_resume", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}

	// function to add new user to database
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView saveRegistration(WebRequest request, @Validated @ModelAttribute("user") User user,
			BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) throws IOException {

		long personal_id = Long.parseLong(request.getParameter("personal_id"));

		User user_validate = userService.getUserByPersonalID(personal_id);
		System.out.println(user.getId());
		if (user_validate.getId() == 0) {

			userService.addUser(user);

			return new ModelAndView("/index");

		} else {

			String sb = new String("SAP ID EXIST IN DATABASE ! . Please use other SAP id.");

			Map<String, Object> model3 = new HashMap<String, Object>();

			model3.put("error", sb);

			return new ModelAndView("error/" + user.getId(), "model", model3);

		}

	}

	// function to check user SAP ID base on user input
	@RequestMapping(value = "/resume_detail", method = RequestMethod.POST)
	public ModelAndView resumeDetail(WebRequest request, RedirectAttributes redirAttrs, ModelMap model) {

		long personal_id = Long.parseLong(request.getParameter("personal_id"));

		User user = userService.getUserByPersonalID(personal_id);
		System.out.println(user.getId());
		if (user.getId() == 0) {

			String sb = new String("SAP ID NOT EXIST IN DATABASE ! . Please Register.");

			Map<String, Object> model3 = new HashMap<String, Object>();

			model3.put("error", sb);

			return new ModelAndView("error/" + user.getId(), "model", model3);
		}

		return new ModelAndView("redirect:/resume_detail/" + user.getId());

	}

	// function to navigate to resume_detail page after success find user base on
	// SAP ID
	@RequestMapping(value = "/resume_detail/{id}")
	public ModelAndView edit(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);

		List<UserObjective> list_user_objective = userObjectiveService.getAllUserObjectiveByUserID(user.getId());
		List<UserEducation> list_user_education = userEducationService.getAllUserEducationByUserID(user.getId());
		List<UserExperience> list_user_experience = userExperienceService.getAllUserExperienceByUserID(user.getId());
		List<UserAwards> list_user_awards = userAwardsService.getAllUserAwardsByUserID(user.getId());
		List<UserAcknowledgments> list_user_acknowledgments = userAcknowledgmentsService
				.getAllUserAcknowledgmentsByUserID(user.getId());

		model.addAttribute("user", user);

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("list_user_objective", list_user_objective);
		model2.put("list_user_education", list_user_education);
		model2.put("list_user_experience", list_user_experience);
		model2.put("list_user_awards", list_user_awards);
		model2.put("list_user_acknowledgments", list_user_acknowledgments);

		return new ModelAndView("resume_detail", "model", model2);

	}

	// function to navigate to edit user page
	@RequestMapping(value = "/update_personal_particular/{id}")
	public String update_personal_particular(@PathVariable int id, ModelMap model) {
		User user = userService.getUserByID(id);
		model.addAttribute("user", user);
		return "update_personal_particular";

	}

	// function to update user and submit into database
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ModelAndView updateUser(@Validated @ModelAttribute("user") User user, BindingResult result, ModelMap model,
			@RequestParam(value = "img_src", required = false) MultipartFile img_src,
			RedirectAttributes redirectAttributes) throws IOException {

		if (img_src.isEmpty()) {

			User savedUser = userService.updateUser(user);

			return new ModelAndView("redirect:/resume_detail/" + savedUser.getId());

		} else {

			String fileName = StringUtils.cleanPath(img_src.getOriginalFilename());

			user.setImg_src(fileName);

			User savedUser = userService.updateUser(user);

			String uploadDir = "user-photos/" + savedUser.getId();

			FileUploadUtil.saveFile(uploadDir, fileName, img_src);

			return new ModelAndView("redirect:/resume_detail/" + savedUser.getId());

		}

	}

	// function to navigate to delete page
	@RequestMapping(value = "/delete_resume/{id}")
	public ModelAndView delete_resume(@PathVariable int id, ModelMap model) {

		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk" + "lmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(6);
		for (int i = 0; i < 6; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));

		User user = userService.getUserByID(id);

		Map<String, Object> model2 = new HashMap<String, Object>();
		model2.put("user", user);
		model2.put("random_alpha", sb.toString());

		model.addAttribute("user", user);
		model.addAttribute("random_alpha", sb.toString());

		return new ModelAndView("validate_bot", "model", model2);

	}

	// checking captha for delete resume
	@RequestMapping(value = "/validatebot", method = RequestMethod.POST)
	public ModelAndView validatebot(WebRequest request, RedirectAttributes redirAttrs, ModelMap model) {

		String random_alpha = request.getParameter("random_alpha");

		String user_enter = request.getParameter("user_enter");

		int user_id = Integer.parseInt(request.getParameter("id"));

		System.out.println("random" + random_alpha);

		System.out.println("user_enter" + user_enter);
		if (random_alpha.equals(user_enter)) {

			userService.delete_resume(user_id);
			return new ModelAndView("redirect:/index");
		} else {

			String sb = new String("Wrong Captha");

			Map<String, Object> model4 = new HashMap<String, Object>();

			model4.put("error", sb);
			return new ModelAndView("error/" + user_id, "model", model4);
		}

	}

}
