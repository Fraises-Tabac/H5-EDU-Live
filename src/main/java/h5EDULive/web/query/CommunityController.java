package h5EDULive.web.query;

import h5EDULive.service.impl.CommunityServiceImpl;
import h5EDULive.web.dto.PostDetail;
import h5EDULive.web.dto.PostSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommunityController {
    @Autowired
    private CommunityServiceImpl communityService;

    @RequestMapping("/community")
    public String community(){
        return "community";
    }

    @RequestMapping("/community/summaries")
    @ResponseBody
    public List<PostSummary> getPostSummaries(@RequestParam("page") int page) {
		Sort sort = new Sort(Sort.Direction.DESC, "postId");
		Pageable pageable = PageRequest.of(page, 15, sort);
		return communityService.getPostsSummaries(pageable);
	}

    @RequestMapping("/community/post")
    public String post(){
        return "post";
    }

    @RequestMapping("/community/post/detail")
    @ResponseBody
    public PostDetail getPostDetail(@RequestParam int postId, @RequestParam("page") int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "postId");
		Pageable pageable = PageRequest.of(page, 15, sort);
        return communityService.getPostDetail(postId, pageable);
    }

    @RequestMapping("/community/add")
    @ResponseBody
    public String addPost(@RequestBody String postInfo, HttpServletRequest request) {
        return communityService.addPost((int)request.getSession().getAttribute("userId"), postInfo);
    }

    @RequestMapping("/community/respond")
    @ResponseBody
    public String addResponse(@RequestBody String responseInfo, HttpServletRequest request) {
        return communityService.addResponse((int)request.getSession().getAttribute("userId"), responseInfo);
    }
}
