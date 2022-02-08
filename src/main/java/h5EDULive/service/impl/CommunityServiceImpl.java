package h5EDULive.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import h5EDULive.dao.PostRepository;
import h5EDULive.dao.PostResponseRepository;
import h5EDULive.dao.ResponseRepository;
import h5EDULive.dao.UserRepository;
import h5EDULive.dao.domain.Post;
import h5EDULive.dao.domain.PostResponse;
import h5EDULive.dao.domain.Response;
import h5EDULive.dao.domain.User;
import h5EDULive.service.CommunityService;
import h5EDULive.web.dto.PostDetail;
import h5EDULive.web.dto.PostSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private PostRepository postRepository;
    @Resource
    private ResponseRepository responseRepository;
    @Resource
    private PostResponseRepository postResponseRepository;

    @Override
    public List<PostSummary> getPostsSummaries(Pageable pageable) {
        List<Post> posts = postRepository.findAll(pageable).getContent();
        List<PostSummary> postSummaries = new ArrayList<>();
        for (Post post:posts)
            postSummaries.add(new PostSummary(
                    post.getPostId(),
                    post.getTitle(),
                    post.getAuthor(),
                    post.getHeat(),
                    post.getPubTime(),
                    post.getLatestTime()
            ));
        return postSummaries;
    }

    @Override
    public PostDetail getPostDetail(int postId, Pageable pageable) {
        Post post = postRepository.findByPostId(postId);
        List<PostResponse> postResponses = postResponseRepository.findAllByPostId(postId, pageable).getContent();
        List<Response> responses = new ArrayList<>();
        for (PostResponse postResponse:postResponses)
            responses.add(responseRepository.findByResId(postResponse.getResId()));
        PostDetail postDetail = new PostDetail(
                post.getTitle(),
                post.getAuthor(),
                post.getHeat(),
                post.getBody(),
                post.getPubTime(),
                responses
        );
        return postDetail;
    }

    @Override
    @Transactional
    public String addPost(int userId, String postInfo) {
        JSONObject jobj = JSON.parseObject(postInfo);
        Post post = new Post();
        User user = userRepository.findById(userId);
        post.setTitle(jobj.get("title").toString());
        post.setAuthor(user.getUsername());
        post.setHeat(0);
        post.setBody(jobj.get("body").toString());
        try {
            postRepository.saveAndFlush(post);
        }catch (Exception e){
            return "";
        }
        return "SUCCESS";
    }

    @Override
    @Transactional
    public String addResponse(int userId, String responseInfo) {
        User user = userRepository.findById(userId);
        JSONObject jobj = JSON.parseObject(responseInfo);
        Response response = new Response();
        response.setpId((int)jobj.get("pId"));
        response.setResponder(user.getUsername());
        response.setContent(jobj.get("content").toString());
        response.setLike(0);
        response.setDislike(0);
        responseRepository.save(response);
        return "SUCCESS";
    }

    @Override
    @Transactional
    public String removePost(int postId) {
        try {
            int page=0,size=10;
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(page, size, sort);

            List<PostResponse> postResponses = postResponseRepository.findAllByPostId(postId,pageable).getContent();
            for (PostResponse postResponse : postResponses)
                removeResponse(postResponse.getResId());
            postRepository.deleteByPostId(postId);
        } catch(Exception e) {
            return "";
        }
        return "SUCCESS";
    }

    @Override
    @Transactional
    public String removeResponse(int resId) {
        try {
            responseRepository.deleteByResId(resId);
            responseRepository.deleteByPId(resId);
            postResponseRepository.deleteByResId(resId);
        } catch(Exception e) {
            return "";
        }
        return "SUCCESS";
    }
}