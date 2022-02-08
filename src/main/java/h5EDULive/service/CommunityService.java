package h5EDULive.service;

import h5EDULive.web.dto.PostDetail;
import h5EDULive.web.dto.PostSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommunityService {
    List<PostSummary> getPostsSummaries(Pageable pageable);
    PostDetail getPostDetail(int postId, Pageable pageable);
    String addPost(int userId, String postInfo);
    String addResponse(int userId, String responseInfo);
    String removePost(int postId);
    String removeResponse(int resId);
}
