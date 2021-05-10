package az.kontakt.shop.service;

import az.kontakt.shop.model.Job;
import java.util.List;

public interface JobService {

    List<Job> getJobList() throws Exception;

    List<Job> searchJobData(String keyword) throws Exception;

    void deleteJob(Long jobId) throws Exception;

    void addJob(Job job) throws Exception;

    Job getJobById(Long selectedId) throws Exception;

    void updateJob(Job job) throws Exception;
}
