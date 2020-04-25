package com.jeeho.common.web;

import com.jeeho.common.persistence.User4;
import com.jeeho.common.service.BaseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.FileInputStream;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/resources/spring-context.xml",
        "file:src/main/resources/spring-mvc.xml"
})
@WebAppConfiguration
public class BaseControllerTest {
    @Autowired
    protected WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    BaseService baseService;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test(){
        try {
            MvcResult mvcResult = mockMvc.perform(get("/test"))
                    .andExpect(status().isOk())
                    .andDo(print())  //打印response返回
                    .andReturn();
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01(){
        try {
            MvcResult mvcResult = mockMvc.perform(get("/test01"))
                    .andExpect(status().isOk())
                    .andDo(print())  //打印response返回
                    .andReturn();
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            String contentAsString = mockMvc.perform(post("/test02").param("id", "1").param("updateDate", "2018-9-23 18:38:00"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            System.out.print(contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03(){
        baseService.aspectJTest();
    }

    @Test
    public void test04(){
        String contentAsString = "";
        try {
            contentAsString = mockMvc.perform(get("/test04/1"))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结果为：" + contentAsString);
    }

    @Test
    public void _test04(){
        User4 user4 = baseService.getUserById(1);
        System.out.println("结果为：" + user4.toString());
    }

    @Test
    public void _test05(){
        User4 user4 = new User4();
        user4.setPassWord("222222");
        user4.setUserName("王五");
        user4.setRegTime(new Date());
        baseService.insertUser(user4);
    }

    /**
     * private String userName;
     * private Date regTime;
     * private String passWord;
     */
    @Test
    public void test05() throws Exception{
        String contentAsString = mockMvc.perform(post("/test05").param("userName", "张三")
                .param("regTime","2018-05-06").param("passWord", "aaabbbb"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("test05 request response ---> "+ contentAsString);
    }

    @Test
    public void testUpload(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\PortAntonio_ZH-CN10325538004_1920x1080.jpg");
            MockMultipartFile mockMultipartFile = new MockMultipartFile("file",fis);
            String contentAsString = mockMvc.perform(fileUpload("/upload").file(mockMultipartFile)
                    .param("description", "风景图片"))
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();
            System.out.println("上传文件返回 ---> "+ contentAsString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
