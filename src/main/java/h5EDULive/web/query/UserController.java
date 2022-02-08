package h5EDULive.web.query;

import com.alibaba.fastjson.JSONObject;
import h5EDULive.dao.domain.User;
import h5EDULive.service.UserService;
import h5EDULive.web.dto.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 描述：用户
 * @Author ZhangRongrong
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    /* 页面 */
    /* 首页 */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /* 登录 */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /* 登录失败 */
    @RequestMapping("/loginError")
    public String loginFail(){
        return "loginError";
    }

    @RequestMapping("/session_expired")
    public String sessionExpired()
    {
        return "sessionExpired";
    }

    @RequestMapping("/other")
    public String other()
    {
        return "other";
    }
    /* 注册 */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
//
//    /* 修改个人信息 */
//    @GetMapping("/modify")
//    public String modify(){
//        return "modify";
//    }

    /* 功能 */
    /* 注册验证 */
    @ResponseBody
    @PostMapping("/register/check")
    public JSONObject userRegisterCheck(String mobile)
    {
        if(userService.isExist(mobile))
        {
            return JsonResult.strToJson("用户已存在");
        }else{
            return JsonResult.strToJson("用户不存在");
        }
    }

    /* 注册提交 */
    @ResponseBody
    @PostMapping("/register/submit")
    public JSONObject userRegister(User user){
        if(userService.insert(user))
        {
            return JsonResult.strToJson("注册成功");
        }else{
            return JsonResult.strToJson("注册失败");
        }
    }

    /* 查看用户信息 */
    @ResponseBody
    @PostMapping("/getInfo")
    public JSONObject getInfo(int id){
       return JsonResult.objToJson(userService.getInfo(id));
    }

    /* 修改密码验证 */
    @ResponseBody
    @PostMapping("/modify/code/check")
    public JSONObject userPreCodeCheck(int id, String preCode)
    {
        if(userService.isRight(id, preCode))
        {
            return JsonResult.strToJson("密码正确");
        }else{
            return JsonResult.strToJson("密码错误");
        }

    }

    /* 修改密码提交 */
    @ResponseBody
    @PostMapping("/modify/code/submit")
    public JSONObject userPasswordModify(int id, String newCode)
    {
        userService.updatePassword(id, newCode);
        return JsonResult.strToJson("修改成功");
    }

    /* 修改用户名 */
    @ResponseBody
    @PostMapping("/modify/name")
    public JSONObject userNameModify(int id, String name)
    {
        userService.updateName(id, name);
        return JsonResult.strToJson("修改成功");
    }

    /* 修改专业 */
    @ResponseBody
    @PostMapping("/modify/major")
    public JSONObject userMajorModify(int id, String major)
    {
        userService.updateMajor(id, major);
        return JsonResult.strToJson("修改成功");
    }

    /* 修改性别 */
    @ResponseBody
    @PostMapping("/modify/gender")
    public JSONObject userGenderModify(int id, String gender)
    {
        userService.updateGender(id, gender);
        return JsonResult.strToJson("修改成功");
    }

    /* 修改生日 */
    @ResponseBody
    @PostMapping("/modify/birth")
    public JSONObject userBirthModify(int id, String birth)
    {
        userService.updateBirth(id, birth);
        return JsonResult.strToJson("修改成功");
    }

    /* 修改头像 */
    @ResponseBody
    @PostMapping("/modify/profile")
    public JSONObject userProfileModify(int id, MultipartFile file) {
        /* 上传头像 */
        if (file.isEmpty()) {
            return JsonResult.strToJson("上传失败，未选择文件") ;
        }
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
        String newProfileName = pikId + "." + fileExt;
        //上传到哪，跟的是DemoApplication的地址
        String savePaths = "/static/imgs/users/profiles";
        File fileSave = new File(savePaths, newProfileName);
        String webPaths = "http://localhost:8080/stat/imgs/users/profiles/" + newProfileName;
        try {
            file.transferTo(fileSave);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
        /* 存储头像url */
        userService.updateProfile(id, webPaths);
        /* 返回url */
        return JsonResult.strToJson(webPaths);
    }

    /* 修改邮箱 */
    @ResponseBody
    @PostMapping("/modify/mail")
    public JSONObject userMailModify(int id, String mail)
    {
        userService.updateMail(id, mail);
        return JsonResult.strToJson("修改成功");
    }

    /* 修改地址 */
    @ResponseBody
    @PostMapping("/modify/location")
    public JSONObject userLocationModify(int id, String location)
    {
        userService.updateLocation(id, location);
        return JsonResult.strToJson("修改成功");
    }

    /* 修改邮箱 */
    @ResponseBody
    @PostMapping("/modify/description")
    public JSONObject userDescriptionModify(int id, String description)
    {
        userService.updateDescription(id, description);
        return JsonResult.strToJson("修改成功");
    }

    @ResponseBody
    @RequestMapping("/whoami")
    public JSONObject whoami(Principal principal)
    {
        if(userService.getIdentity(principal.getName()))
        {
            Map<String,Object> suc = new HashMap<>();
            suc.put("username", principal.getName());
            suc.put("attr","老师");
            return new JSONObject(suc);
        }else{
            Map<String,Object> suc = new HashMap<>();
            suc.put("username", principal.getName());
            suc.put("attr","学生");
            return new JSONObject(suc);
        }

    }
}
