package h5EDULive.web.query;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import h5EDULive.service.impl.StudentCourseServiceImpl;
import h5EDULive.web.dto.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentCourseController {

    private final StudentCourseServiceImpl stuCourseService;

    public StudentCourseController(StudentCourseServiceImpl stuCourseService) {
        this.stuCourseService = stuCourseService;
    }

    @RequestMapping("/student/course")
    public String studentCourse() {
        return "mycourse";
    }

    @ResponseBody
    @RequestMapping("/student/courseList")
    public JSONArray getList(int id)
    {
        return JsonResult.listToJson(stuCourseService.getList(id));
    }

    @ResponseBody
    @RequestMapping("/student/add")
    public JSONObject add(int stuId, int courseId)
    {
        if(stuCourseService.insert(stuId, courseId))
        {
            return JsonResult.strToJson("添加成功");
        }else{
            return JsonResult.strToJson("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping("/student/delete")
    public JSONObject delete(int stuId, int courseId)
    {
        stuCourseService.remove(stuId, courseId);
        return JsonResult.strToJson("删除成功");
    }

    @ResponseBody
    @RequestMapping("/student/info")
    public JSONObject getInfo(int id)
    {
        return JsonResult.strToJson(stuCourseService.getInfo(id));
    }

    @ResponseBody
    @RequestMapping("/student/record")
    public JSONObject getRecord(int id)
    {
        return JsonResult.strToJson(stuCourseService.getRecord(id));
    }

    @RequestMapping("/student/live")
    public String getLive() {
        return "/live";
    }

}
