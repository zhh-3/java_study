package job.service.impl;

import job.dao.JobInfoDao;
import job.pojo.JobInfo;
import job.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JobInfoServiceImpl implements JobInfoService {
    @Autowired
    private final JobInfoDao jobInfoDao;

    public JobInfoServiceImpl(JobInfoDao jobInfoDao) {
        this.jobInfoDao = jobInfoDao;
    }

    @Override
    @Transactional
    public void save(JobInfo jobInfo) {
        JobInfo param = new JobInfo();
        param.setUrl(jobInfo.getUrl());
        param.setTime(jobInfo.getTime());

        //执行查询
        List<JobInfo> list = this.findJobInfo(param);
        //判断查询结果
        if (list.size()==0){
            //如果查询结果为空，或者信息数据不存在，或者已经更新，需要新增或者更新数据库信息
            this.jobInfoDao.saveAndFlush(jobInfo);
        }
    }

    @Override
    public List<JobInfo> findJobInfo(JobInfo jobInfo) {
        //设置查询条件
        Example example = Example.of(jobInfo);

        //执行查询
        List list = this.jobInfoDao.findAll(example);
        return list;
    }
}
