package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.EmployeeData;
import com.example.demo.Model.EmployeeList;
import com.example.demo.services.Restservice;

@RestController
public class ControllerRest implements ErrorController {

	private static final String PATH = "/error";

	@Value("${debug}")
	private boolean debug;

	/*
	 * @Autowired private ErrorAttributes errorAtrributes;
	 */

	@Autowired
	private Restservice restservice;

	@RequestMapping("/empdata")
	public EmployeeList data() {
		System.out.println("data");
		return restservice.employeeList();
	}

	@PostMapping("/empdata")
	@ResponseBody
	public void addEmployee(@RequestBody EmployeeData data) {
		System.out.println("name " + data.getName());
		restservice.addEmployees(data);
	}
	/*
	 * @RequestMapping(PATH) ErrorCodeDescription error(HttpServletRequest request ,
	 * HttpServletResponse response) { return new
	 * ErrorCodeDescription(response.getStatus(),getErrotAtribute(request,debug)); }
	 */

	/*
	 * private Map<String, Object> getErrotAtribute(HttpServletRequest request,
	 * boolean includeStackTrace ) { RequestAttributes attribute = new
	 * ServletRequestAttributes(request); return errorAtrributes.getError(request);
	 * }
	 */

	@RequestMapping(PATH)
	public String defaultErrorPath() {
		return "No mapping Found";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
