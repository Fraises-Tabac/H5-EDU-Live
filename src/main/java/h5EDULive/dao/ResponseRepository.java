package h5EDULive.dao;

import h5EDULive.dao.domain.Post;
import h5EDULive.dao.domain.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ResponseRepository extends JpaRepository<Response, Integer>, JpaSpecificationExecutor<Post> {

    Response findByResId(int resId);

    void deleteByResId(int resId);

    void deleteByPId(int pId);

    @Modifying
    @Query(value = "update response set content=?2 where res_id=?1",nativeQuery = true)
    void updateByResId(int resid,String text);

}
