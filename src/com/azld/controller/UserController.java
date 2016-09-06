package com.azld.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.azld.model.User;
import com.azld.service.UserService;




@Controller
@RequestMapping("/user")
public class UserController
{
	@Resource
	private UserService		auserservice;
	
    @RequestMapping("/list")  
    public ModelAndView tolist(HttpServletRequest request,Model model)
    {  
    	Integer uid = Integer.parseInt(request.getParameter("id"));
        
        List<User> userlist = this.auserservice.list(uid);
        
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("users", userlist);
        ModelAndView mav=new ModelAndView("user/userlist",map1);
        
        return mav;
    }

    @ResponseBody  
    @RequestMapping("/list3")  
    public String list(HttpServletRequest request, HttpServletResponse response,String contentType2)
    {  

        String content = null;  
        Map map = new HashMap();  
        ObjectMapper mapper = new ObjectMapper();  
  
        map.put("filename1", "test.text");
        map.put("fileName2", "a.txt");  
        
        User auser = new User();
        auser.setName("user0003");
        
        User buser = this.auserservice.getuserwithPK(auser);
        map.put("user1", buser);
        
        User cuser = this.auserservice.getuserwithuid(5);
        map.put("user2", cuser);
        
        try {
			content = mapper.writeValueAsString(map);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
        return content;
    }  
    
	@RequestMapping("/showuserinfo/{username}")
    public ModelAndView toshowuserinfowithname(ModelMap modelMap, @PathVariable String username)
    {
		String uname = username;
		
		User cuser = new User();
		cuser.setName(uname);
		
		User buser = this.auserservice.getuserwithPK(cuser);

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("user", buser);
        ModelAndView mav=new ModelAndView("user/userinfo",map1);
        return mav;
    }
	
	@RequestMapping("/suid/{userid}")
    public ModelAndView toshowuserinfowithid(ModelMap modelMap, @PathVariable int userid)
    {
		User buser = this.auserservice.getuserwithuid(userid);

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("user", buser);
        ModelAndView mav=new ModelAndView("user/userinfo",map1);
        return mav;
    }
	
    @RequestMapping("/login")  
    public ModelAndView tologin(HttpServletRequest request,Model model)
    {  
        String username = request.getParameter("name");
        String userpwd = request.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(userpwd);
        
        User buser = this.auserservice.login(user);
        
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("user", buser);
        ModelAndView mav=new ModelAndView("user/userinfo",map1);
        
        return mav;
    }
    
    @RequestMapping("/add")  
    public ModelAndView toadd(HttpServletRequest request,Model model)
    {  
        String username = request.getParameter("name");
        String userpwd = request.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(userpwd);
        
        User buser = this.auserservice.add(user);

        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("user", buser);
        ModelAndView mav=new ModelAndView("user/userinfo",map1);
        
        return mav;
    }
    
    
    
    
    
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model)
    {  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.auserservice.getuserwithuid(userId);  
        model.addAttribute("user", user);  
        return "showUser";  	
    }
    
    @RequestMapping("/showUserinfo")  
    public String toUserinfo(HttpServletRequest request,Model model)
    {  
//    	ServletWebRequest servletWebRequest=new ServletWebRequest(request);
//    	HttpServletResponse response=servletWebRequest.getResponse();
    	
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.auserservice.getuserwithuid(userId);
        
        request.setAttribute("name", user.getName());
//        model.addAttribute("user", user);
//        String sret = "user id:" + user.getId() + "user name:" + user.getName();
        return "userlist";
    }

    @RequestMapping("/info")  
    public String toname(HttpServletRequest request, Model model)
    {        
        request.setAttribute("name", request.getParameter("id"));
        return "userlist";
    }

    @RequestMapping("/info2")  
    public ModelAndView toname2(HttpServletRequest request, Model model)
    {        
        request.setAttribute("name", request.getParameter("id"));
        
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("id", request.getParameter("id"));
        map1.put("name", request.getParameter("id"));
        ModelAndView mav=new ModelAndView("userlist2",map1);
        
        return mav;
    }

    @RequestMapping("/info/{name}")  
    public String toUsername(HttpServletRequest request, String name)
    {      	
//        int userId = Integer.parseInt(request.getParameter("id"));  
//        User user = this.auserservice.getuserwithuid(userId);
        
        request.setAttribute("name", name);
//        model.addAttribute("user", user);
//        String sret = "user id:" + user.getId() + "user name:" + user.getName();
        return "userlist";
    }

    @RequestMapping(value="/info/{id}",method=RequestMethod.GET)
    public String getProductInfo(User user, HttpServletRequest request,HttpServletResponse response) throws Exception {
  
    	request.setAttribute("name", user.getId());
    	System.out.println("id:"+user.getId());
    	return "userlist";
        
    }

    
}
