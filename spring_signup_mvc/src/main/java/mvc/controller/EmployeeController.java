package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvc.dao.EmployeeDao;
import mvc.dto.Employee;

@Controller
public class EmployeeController {

	@Autowired
	Employee employee;
	@Autowired
	EmployeeDao dao;

	@RequestMapping("loademployee")
	public ModelAndView loademployee() {

		ModelAndView andView=new ModelAndView();
		andView.addObject("emp",employee);
		andView.setViewName("signup.jsp");

		return andView;
	}

	@RequestMapping("signup")
	public ModelAndView saveEmployee(@ModelAttribute("emp") Employee employee) {

		dao.saveEmployee(employee);
		ModelAndView andView=new ModelAndView("login.jsp");
		andView.addObject("Msg","Account Created Successfully");
		return andView; 


	}

	
	@PostMapping("login")
	public ModelAndView login(@RequestParam String email,@RequestParam String password)
	{
		ModelAndView andView=new ModelAndView();
		Employee employee=dao.login(email);

		if(employee==null)
		{
			andView.setViewName("login.jsp");
			andView.addObject("Msg","Invalid Email");
		}
		else
		{
			if(password.equals(employee.getPassword()))
					{
				andView.setViewName("result.jsp");
				andView.addObject("list",dao.fetchAll());
				andView.addObject("Msg","Logged In Successfully");
					}
			else
			{
				andView.setViewName("login.jsp");
				andView.addObject("Msg","Invalid Password");
			}
		}
		return andView;
	}
	
	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam int id)
	{    	dao.delete(id);
		ModelAndView andView=new ModelAndView("result.jsp");
		andView.addObject("list",dao.fetchAll());
		andView.addObject("Msg","deleted successfully");
		return andView;
	}
	
	@RequestMapping("edit")
	public ModelAndView edit(@RequestParam int id)
	{
		ModelAndView andView=new ModelAndView("Edit.jsp");
		andView.addObject("emp",dao.find(id));
		
		
		return andView;
	}
	
	@PostMapping("update")
	public ModelAndView update(@ModelAttribute("emp") Employee employee) {

		dao.edit(employee);
		
		ModelAndView andView=new ModelAndView("result.jsp");
		andView.addObject("list",dao.fetchAll());
		andView.addObject("Msg","data updated successfully");
		
		return andView; 

	}

}
