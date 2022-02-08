package h5EDULive.dao;

import h5EDULive.dao.domain.BanList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created on 2019-7-8.
 */
public interface BanListRepository extends JpaRepository<BanList, Integer>, JpaSpecificationExecutor<BanList> {

    BanList findByUserId(int userId);

    void deleteByUserId(int userId);
}
