package h5EDULive.web.query;

import h5EDULive.dao.domain.Course;
import h5EDULive.dao.domain.Exam;
import h5EDULive.service.impl.SearchServiceImpl;
import h5EDULive.web.dto.PostSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchServiceImpl ss;

//    @RequestMapping("/search/page={page}")
//    public List<> getAll(String keywords, @PathVariable int page) {
//        Sort sort = new Sort(Sort.Direction.DESC, "postId");
//		Pageable pageable = PageRequest.of(page, 15, sort);
//        return ss.getCourses(keywords, pageable);
//    }

    @RequestMapping("/search/course")
    @ResponseBody
    public List<Course> getCourses(String keywords, @RequestParam("page") int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "postId");
		Pageable pageable = PageRequest.of(page, 15, sort);
        return ss.getCourses(keywords, pageable);
    }

    @RequestMapping("/search/exam")
    @ResponseBody
    public List<Exam> getExams(String keywords, @RequestParam("page") int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "postId");
		Pageable pageable = PageRequest.of(page, 15, sort);
        return ss.getExams(keywords, pageable);
    }

    @RequestMapping("/search/post")
    @ResponseBody
    public List<PostSummary> getPosts(String keywords, @RequestParam("page") int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "postId");
		Pageable pageable = PageRequest.of(page, 15, sort);
        return ss.getPosts(keywords, pageable);
    }

}
