package myController;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import baseUtils.JsonUtils;
import net.sf.json.JSONArray;
import pojo.Upload;
import pojo.UploadPojo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 

/*文件上传*/

@Controller
@RequestMapping("/upload")
public class UploadController{
 
    private Logger logger = Logger.getLogger(UploadController.class);
	//临时上传下载路径
	public String temp = "E:\\project\\java_project\\ssm1\\src\\main\\webapp\\static\\uploads\\images";
 
    @RequestMapping("/form")
    public String upload(){
        return "upload";
    }
    
    /*处理单个文件上传逻辑，单文件和多文件公用此方法
     * 
     * @params file MultipartFile 上传的文件MultipartFile file对象
     * @return Upload Upload 包含上传信息的Upload对象
     * */
    public Upload uploadDo(MultipartFile file) throws IllegalStateException, IOException {
    	//限制3M以下
        if (file.getSize() > 3000000) {
        	return new Upload("",file.getOriginalFilename()+"超过了指定大小");
        }
    	
    	if(!file.isEmpty()) {

    		
    		//创建子目录，检测目录是否存在，如果不存在自动创建
    		String dir_time = new  SimpleDateFormat("yyyyMMdd").format(new Date()); 
    		File file1 = new File(temp+dir_time);
    		file1.mkdir();
    		
    		//文件上传的目录
    		String path = temp+File.separator+dir_time;
    		//上传文件名称
    		String filename = file.getOriginalFilename();
    		
    		/* 从当时时间MD5强制重命名图片*/
            String pic_time = new  SimpleDateFormat("yyyyMMddHHmmss").format(new Date());   
            String pic_type = file.getContentType();
            String pic_newname = pic_time;
            if(pic_type.equals("image/jpeg")||pic_type.equals("image/jpg")){
            	pic_newname =   pic_time.concat(".jpg");
            } else if (pic_type.equals("image/png")){
            	pic_newname = pic_time.concat(".png");
            } else if(pic_type.equals("image/bmp")){
            	pic_newname =  pic_time.concat(".bmp");
            } else if(pic_type.equals("image/gif")){
            	pic_newname = pic_time.concat(".gif");
            } else {
            	return new Upload("","文件格式不正确，请上传jpg,png,fig图片");
            } 
            
    		//转换file对象
    		File filepath = new File(path,filename);
    		//判断路径是否存在，如果不存在就创建一个
    		if(!filepath.getParentFile().exists()) {
    			filepath.getParentFile().mkdirs();
    		}
    		//将上传文件保存在一个目标文件中
    		file.transferTo(new File(path+File.separator+pic_newname));
    		return new Upload("static/uploads/images/"+dir_time+'/'+pic_newname,"上传成功");
    	}else {
    		return new Upload("","上传失败");
    	}
    }
    
    //单文件上传，接收 desc文件描述 和 file流，返回json
    @RequestMapping(value = "/uploadOne",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String uploadOne(HttpServletRequest request,
    		@RequestParam("desc") String desc,
    		@RequestParam("file") MultipartFile file
    ) throws IOException {
    	//打印表单其他传参
    	System.out.println(desc);
    	
    	//返回上传结果
    	return new JsonUtils().objectToJson(new UploadController().uploadDo(file));
    }
    /* MultipartFile对象方法如下：
     * 
     * byte[] getBytes()	获取文件的数据
     * String getContentType()	获取文件MIME类型，如image/jpeg等
     * InputStream getInputStream()	获取文件流
     * String getName()	获取表单中文件组建的名字
     * String getOriginalFilename()	获取上传文件的原名
     * long getSize()	获取文件的字节大小，单位byte
     * boolean isEmpty()	是否有上传的文件
     * void transferTo(File dest)	将上传文件保存在一个文件中
     *  
     *  */
 
    //多文件上传，接收 desc文件描述 和 数组file[]流，返回json
    @RequestMapping(value = "/uploadAll",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String uploadAll(HttpServletRequest request,
    		@RequestParam("desc2") String desc,
    		@RequestParam("file") MultipartFile[] files
    ) throws IOException, InterruptedException {
    	
    	//打印表单其他传参
    	System.out.println(desc);
    	
    	//用于存储所有上传文件
    	ArrayList<Upload> list1 = new ArrayList();
    	
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i]; 

                list1.add(new UploadController().uploadDo(file));
                
                //1秒后执行下一个操作，防止多图片覆盖bug
                Thread.sleep(1000);
                
            }
        }
    	
        //list转json
        JSONArray jsonData = JSONArray.fromObject(list1);
        
    	//返回上传结果
    	return new JsonUtils().objectToJson(jsonData);
    }
    
    //单文件上传——pojo方式，接收 desc文件描述 和 file流，返回json
    @RequestMapping(value = "/uploadOnePojo",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String uploadOnePojo(HttpServletRequest request,UploadPojo up) throws IOException {
    	//打印表单其他传参
    	System.out.println(up);
    	
    	//返回上传结果
    	return new JsonUtils().objectToJson(new UploadController().uploadDo(up.getFile()));
    }
    
    //单文件下载——接收filename文件名及后辍，返回file流
    @RequestMapping(value = "/downloadOne",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
    public ResponseEntity<byte[]> downloadOne(HttpServletRequest request,@RequestParam String filename) throws IOException {
    	//打印传参
    	System.out.println(filename);
    	
    	//根据名称读取文件
    	File file1 = new File(temp+"/"+filename);
    	
    	//下载文件名显示，解决中文乱码
    	String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
    	
    	//设置下载信息头部
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentDispositionFormData("attachment", downloadFileName);
    	//二级制刘数据，常见的文件下载
    	headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    	
    	//201 HttpStatus.CREATED
    	return new ResponseEntity<byte[]> (FileUtils.readFileToByteArray(file1), headers,HttpStatus.CREATED);
    }
    
}