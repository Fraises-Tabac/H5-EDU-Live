package h5EDULive.web.query;

import com.alibaba.fastjson.JSONObject;
import h5EDULive.dao.domain.Course;
import h5EDULive.service.LiveService;
import h5EDULive.service.CourseService;
import h5EDULive.web.dto.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseController {
    private final CourseService courseService;
    private final LiveService liveService;

    public CourseController(CourseService courseService, LiveService liveService) {
        this.courseService = courseService;
        this.liveService = liveService;
    }

    @RequestMapping("/courseList")
    public String courseList()
    {
        return "courselist";
    }

    @ResponseBody
    @RequestMapping("/course/list")
    public List<Course> getList()
    {
        return courseService.getList();
    }

    @RequestMapping("/course")
    public String course()
    {
        return "coursecont";
    }

    @ResponseBody
    @RequestMapping("/course/info")
    public JSONObject getInfo(int courseId)
    {
        return JsonResult.objToJson(courseService.getInfo(courseId));
    }

    @RequestMapping("/course/record")
    public String record()
    {
        return "record";
    }

    @RequestMapping("/course/live")
    public String live()
    {
        return "live";
    }

    @ResponseBody
    @RequestMapping("/course/live/getStream")
    public JSONObject stream(int courseId)
    {
        return JsonResult.strToJson(liveService.getStream(courseId));
    }
}
