package com.kgc.movie.controller;

import com.kgc.movie.pojo.User;
import com.kgc.movie.service.UserLoginService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author shkstart
 * @create 2020-09-10 9:23
 */
@Controller
public class UserController {
    @Resource
    UserLoginService userLoginService;

    @RequestMapping("/doLogin")
    @ResponseBody
    public Map<String, Object> doLogin(HttpSession session, String uName, String uPhone, String uPassword) {
        Map<String, Object> map = new HashMap<>();
        User user = userLoginService.selectLogin(uName, uPhone);
        if (user == null) {
            map.put("status", "false");
            map.put("error", "用户名或手机号不正确");
        } else if (user.getUpassword().equals(uPassword) == false) {
            map.put("status", "false");
            map.put("error", "密码不正确");
        } else {
            session.setAttribute("users",user);
            map.put("status", "true");
        }
        return map;
    }

    @RequestMapping("/toindex")
    public String toindex() {
        return "index";
    }
    @RequestMapping("/doUserAdd")
    @ResponseBody
    public Map<String,Object> doUserAdd(HttpSession session, User user) {
        Map<String,Object> map=new HashMap<>();
        int i = userLoginService.addUser(user);
        if(i>0){
            map.put("status","true");
            session.setAttribute("users",user);
            return map;
        }else{
            map.put("status","false");
        }
        return map;
    }
    private String testStatus(){
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api","7e83349ca870622b917598f3de7efc23"));
        WebResource webResource = client.resource( "http://voice-api.luosimao.com/v1/status.json" );
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        ClientResponse response =  webResource.get( ClientResponse.class );
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        //System.out.print(status);
        //System.out.print(textEntity);
        return textEntity;
    }
    @RequestMapping("/doPhone")
    @ResponseBody
    public Map<String,Object> doPhone2(HttpSession session, String phone) {
        System.out.println(phone);
        Map<String, Object> map = new HashMap<>();
        UserController api = new UserController();
        // just replace key here
        int suiJi = (int) ((Math.random() * 9 + 1) * 100000);
        String suiJi2=String.valueOf(suiJi);
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api", "7e83349ca870622b917598f3de7efc23"));
        WebResource webResource = client.resource(
                "http://voice-api.luosimao.com/v1/verify.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", phone);
        formData.add("code", suiJi2);
        System.out.println(suiJi);
        ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        //System.out.print(textEntity);
        //System.out.print(status);
        String httpResponse = textEntity;
        try {
            JSONObject jsonObj = new JSONObject(httpResponse);
            int error_code = jsonObj.getInt("error");
            String error_msg = jsonObj.getString("msg");
            if (error_code == 0) {
                map.put("a","true");
                map.put("yanZheng",suiJi);
                System.out.println("Send message success.");
            } else {
                map.put("a","false");
                System.out.println("Send message failed,code is " + error_code + ",msg is " + error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        httpResponse = api.testStatus();
        try {
            JSONObject jsonObj = new JSONObject(httpResponse);
            int error_code = jsonObj.getInt("error");
            if (error_code == 0) {
                map.put("a","true");
                map.put("yanZheng",suiJi);
                int deposit = jsonObj.getInt("deposit");
                System.out.println("Fetch deposit success :" + deposit);
            } else {
                map.put("a","false");
                String error_msg = jsonObj.getString("msg");
                System.out.println("Fetch deposit failed,code is " + error_code + ",msg is " + error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
//    @RequestMapping("/doPhone")
//    @ResponseBody
//    public Map<String,Object> doPhone2(HttpSession session,String phone){
//        System.out.println(phone);
//        Map<String,Object> map=new HashMap<>();
//        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
//        String time = formatter.format(new Date());
//        int suiJi = (int) ((Math.random()*9+1)*100000);
//        Client client = Client.create();
//        //a25b77acbbce6a043c1862aad8d46693
//        client.addFilter(new HTTPBasicAuthFilter(
//                "api","f17f051116f654d293ab6b2b4a2930c2"));
//        WebResource webResource = client.resource(
////                "http://sms-api.luosimao.com/v1/send.json");
//                "http://voice-api.luosimao.com/v1/verify.json");
//        MultivaluedMapImpl formData = new MultivaluedMapImpl();
//        formData.add("mobile", phone);
////        formData.add("message", "您于"+time+"申请了星空影城的手机号码注册，效验码是"+suiJi+"【铁壳测试】");
//        formData.add("code", suiJi);
////        formData.add("message", "验证码：286221【铁壳测试】");
//        ClientResponse response =  webResource.type( javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED ).
//                post(ClientResponse.class, formData);
//        String textEntity = response.getEntity(String.class);
//        int status = response.getStatus();
//        UserController api = new UserController();
//        String httpResponse =  textEntity;
//        try {
//            JSONObject jsonObj = new JSONObject( httpResponse );
//            int error_code = jsonObj.getInt("error");
//            String error_msg = jsonObj.getString("msg");
//            if(error_code==0){
//                map.put("a","true");
//                map.put("yanZheng",suiJi);
//                System.out.println("Send message success.");
//            }else{
//                map.put("a","false");
//                System.out.println("Send message failed,code is "+error_code+",msg is "+error_msg);
//            }
//        } catch (JSONException ex) {
//            Logger.getLogger(PreviewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        httpResponse =  api.testStatus();
//        try {
//            JSONObject jsonObj = new JSONObject( httpResponse );
//            int error_code = jsonObj.getInt("error");
//            if( error_code == 0 ){
//                map.put("a","true");
//                map.put("yanZheng",suiJi);
//                int deposit = jsonObj.getInt("deposit");
//                System.out.println("Fetch deposit success :"+deposit);
//            }else{
//                map.put("a","false");
//                String error_msg = jsonObj.getString("msg");
//                System.out.println("Fetch deposit failed,code is "+error_code+",msg is "+error_msg);
//            }
//        } catch (JSONException ex) {
//            Logger.getLogger(PreviewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return map;
//    }
    @RequestMapping("/doSelectAll")
    @ResponseBody
    public Map<String,Object> doSelectAll(String userName,String userPhone) {
        Map<String, Object> map = new HashMap<>();
        List<User> users = userLoginService.selectAll();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUname().equals(userName)){
                map.put("status","true");
                return map;
            }else if(users.get(i).getUphone().equals(userPhone)){
                map.put("status","true");
                return map;
            }else{
                map.put("status","false");
            }
        }
        return map;
    }

    @RequestMapping("/zhuxiao")
    public String zhuxiao(HttpSession session){
        session.invalidate();
        return "login";
    }
}
