package h5EDULive.web.query;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import h5EDULive.dao.domain.Course;
import h5EDULive.service.CourseService;
import h5EDULive.service.TeacherCourseService;
import h5EDULive.web.dto.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class TeacherCourseController {

    private final TeacherCourseService teacherCourseService;
    private final CourseService courseService;

    public TeacherCourseController(TeacherCourseService teacherCourseService, CourseService courseService) {
        this.teacherCourseService = teacherCourseService;
        this.courseService = courseService;
    }

    @ResponseBody
    @RequestMapping("/teacher/list")
    public JSONArray getList(int id){
        return JsonResult.listToJson(teacherCourseService.getList(id));

    }

    @ResponseBody
    @RequestMapping("/teacher/add")
    public JSONObject add(int tchId, int courseId){
        teacherCourseService.insert(tchId, courseId);
        return JsonResult.strToJson("添加成功");
    }

    @ResponseBody
    @RequestMapping("/teacher/delete")
    public JSONObject delete(int courseId){
        teacherCourseService.delete(courseId);
        return JsonResult.strToJson("删除成功");
    }

    @ResponseBody
    @RequestMapping("/teacher/modify")
    public JSONObject modify(int courseId, String dep){
        teacherCourseService.modifyInfo(courseId, dep);
        return JsonResult.strToJson("修改成功");
    }

    public String upload(MultipartFile file,String savePath)
    {
        if (file.isEmpty()) {
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
        String newName = pikId + "." + fileExt;
        File fileSave = new File(savePath, newName);
        try {
            file.transferTo(fileSave);
            return newName;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }


    @RequestMapping("/upload")
    @ResponseBody
    public JSONObject uploadCourse(MultipartFile[] file, Course course) throws IllegalStateException, IOException {
        if(file.length >= 2)
        {
            String picName = upload(file[0],"/stat/videos/pic");
            String videoName = upload(file[1],"stat/videos");
            String picWebPaths = "http://39.106.107.209:8080/stat/videos/pic" + picName;
            String videoWebPaths = "http://39.106.107.209:8080/stat/videos" + videoName;
            course.setPic(picWebPaths);
            course.setVideo(videoWebPaths);
            courseService.insert(course);
            return JsonResult.strToJson("上传成功");
        }else
        {
            return JsonResult.strToJson("上传失败");
        }
    }

    @RequestMapping("/getStreamName")
    public void getStreamName(String streamName) {

    }
}
