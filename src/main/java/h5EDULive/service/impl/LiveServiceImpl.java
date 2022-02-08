package h5EDULive.service.impl;

import h5EDULive.dao.LiveRepository;
import h5EDULive.service.LiveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LiveServiceImpl implements LiveService {
    @Resource
    LiveRepository liveRepository;

    @Override
    public String getStream(int courseId) {
        return liveRepository.findByCourseId(courseId).getStream();
    }
}
