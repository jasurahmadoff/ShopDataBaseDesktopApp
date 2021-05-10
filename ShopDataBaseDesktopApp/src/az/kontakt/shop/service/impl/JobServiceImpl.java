package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.JobDao;
import az.kontakt.shop.model.Job;
import az.kontakt.shop.service.JobService;
import java.util.List;

public class JobServiceImpl implements JobService {

    private JobDao jobDao = null;

    public JobServiceImpl(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public List<Job> getJobList() throws Exception {
        return jobDao.getJobList();
    }

    @Override
    public List<Job> searchJobData(String keyword) throws Exception {
        return jobDao.searchJobData(keyword);
    }

    @Override
    public void deleteJob(Long jobId) throws Exception {
        jobDao.deleteJob(jobId);
    }

    @Override
    public void addJob(Job job) throws Exception {
        jobDao.addJob(job);
    }

    @Override
    public Job getJobById(Long selectedId) throws Exception {
        return jobDao.getJobById(selectedId);
    }

    @Override
    public void updateJob(Job job) throws Exception {
        jobDao.updateJob(job);
    }
}