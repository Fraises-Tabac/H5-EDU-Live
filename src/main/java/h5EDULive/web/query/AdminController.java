package h5EDULive.web.query;

import h5EDULive.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping("/admin/removeUser")
    public String removeUser(int userId) {
        return adminService.removeUser(userId);
    }

    @RequestMapping("/admin/removeCourse")
    public String removeCourse(int courseId) {
        return adminService.removeCourse(courseId);
    }

    @RequestMapping("/admin/removeExam")
    public String removeExam(int courseId) {
        return adminService.removeExam(courseId);
    }

    @RequestMapping("/admin/removePost")
    public String removePost(int postId) {
        return adminService.removePost(postId);
    }

//    @RequestMapping("/admin/removeResponse")
//    public String removeResponse(int resId) {
//        return adminService.removeResponse(resId);
//    }
}
