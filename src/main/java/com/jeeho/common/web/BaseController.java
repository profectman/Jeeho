package com.jeeho.common.web;

import com.jeeho.common.persistence.SysRole;
import com.jeeho.common.persistence.User4;
import com.jeeho.common.service.BaseService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    BaseService baseService;

    @ResponseBody
    @RequestMapping(value = {"/test"},method = RequestMethod.GET)
    public String test(){
        return baseService.getSysRoleNameById("1");
    }

    @ResponseBody
    @RequestMapping(value = {"/test01"},method = RequestMethod.GET)
    public SysRole test01(){
        return baseService.getSysRoleById("1");
    }

    @ResponseBody
    @RequestMapping(value = {"/test02"},method = RequestMethod.POST)
    public Map test02(String id,String updateDate) throws Exception{
        SysRole sysRole =  new SysRole();
        sysRole.setId(id);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt=sdf.parse(updateDate);
        sysRole.setUpdateDate(dt);
        baseService.updateSysRole(sysRole);
        Map resultMap = new HashMap<>();
        resultMap.put("flag","1");
        resultMap.put("msg","success");
        return resultMap;
    }

    @RequestMapping(value = {"/test03"},method = RequestMethod.GET)
    public ModelAndView test03(ModelAndView modelAndView){
        modelAndView.setViewName("sys/login");
        return modelAndView;
    }

    @RequestMapping(value = {"/test04/{id}"},method = RequestMethod.GET)
    @ResponseBody
    public Map test04(@PathVariable("id")String id){
        Map resultMap = new HashMap<>();
        resultMap.put("flag","1");
        resultMap.put("msg","success");
        resultMap.put("data",baseService.getUserById(Integer.valueOf(id)));
        return resultMap;
    }

    @RequestMapping(value = {"/test05"},method = RequestMethod.POST)
    @ResponseBody
    public Map test05(@ModelAttribute @Valid User4 user4, BindingResult result){
        Map resultMap = new HashMap<>();
        resultMap.put("flag","1");
        if(result.hasErrors()){
            resultMap.put("msg","failue");
            resultMap.put("data",result.getAllErrors().get(0));
            return resultMap;
        }
        resultMap.put("msg","success");
        resultMap.put("data",user4);
        return resultMap;
    }

    @RequestMapping(value = {"/upload"},method = RequestMethod.POST)
    @ResponseBody
    public Map test06(@RequestParam("file") MultipartFile file,
                      @RequestParam("description") String description, HttpServletRequest request){
        System.out.println("description  : " + description);
        Map resultMap = new HashMap();
        if(!file.isEmpty()){
            //文件位置  文件名
            String path = request.getServletContext().getRealPath("/static/images/");
            String fileName = "PortAntonio_ZH-CN10325538004_1920x1080.jpg";
            File filePath = new File(path, fileName);
            if(!filePath.getParentFile().exists()) {   //判断文件是否存在
                filePath.getParentFile().mkdirs();     //创建文件夹用于存放文件
            }
            try {
                file.transferTo(new File(path,fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            resultMap.put("flag","0");
            resultMap.put("msg","success");
            resultMap.put("data",filePath.getPath());
        }else{
            resultMap.put("flag","1");
            resultMap.put("msg","failure");
            resultMap.put("data","file is empty");
        }
        return resultMap;
    }

    /**
     * HttpHeaders -- headers
     * String downloadFilename = new String(filename.getBytes("UTF-8"),"iso-8859-1");
     * headers.setContentDispositionFromData("attachment",downloadFilename);
     * headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
     * new ResponseEntity(T,header,HttpStatus)
     * 文件下载
     * @param request
     * @param filename
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/download"})
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename,Model model)
            throws Exception {
        String path = request.getServletContext().getRealPath("/static/images/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
    }
}
