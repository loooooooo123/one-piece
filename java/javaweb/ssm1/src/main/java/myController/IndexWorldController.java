package myController;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import baseUtils.JsonUtils;
import pojo.Users;
import pojo.Users2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
 
@Controller
@RequestMapping("/user")
public class IndexWorldController{
 
    private Logger logger = Logger.getLogger(IndexWorldController.class);
 
    @RequestMapping("/index")
    public String index(){
 
        return "index";
    }
    
    //接收json，返回json
    @RequestMapping(value = "/json",method={RequestMethod.GET,RequestMethod.POST},produces="text/html;charset=UTF-8")
    @ResponseBody
    public String json1(Users user,HttpServletResponse response) throws IOException {
    	System.out.print(new JsonUtils().objectToJson(user));
    	return new JsonUtils().objectToJson(user);
    }
    
    //接收xml，返回xml
    @RequestMapping(value = "/xml",method={RequestMethod.GET,RequestMethod.POST}, produces={"application/xml; charset=UTF-8"})
    @ResponseBody
    public Users2 xml1(Users2 user,HttpServletResponse response) throws IOException{
    	System.out.print(user);
    	return user;
    }
 
}