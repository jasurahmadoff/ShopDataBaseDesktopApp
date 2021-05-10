package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.Customer;
import az.kontakt.shop.model.Job;
import java.sql.*;
import java.util.*;

public class JobDaoImpl implements JobDao {

    @Override
    public List<Job> getJobList() throws Exception {

        List<Job> jobList = new ArrayList<>();

        String sql = "SELECT ID, NAME, DESCRIPTION FROM JOB "
                + "WHERE ACTIVE = 1 ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Job job = new Job();
                job.setId(rs.getLong("ID"));
                job.setName(rs.getString("NAME"));
                job.setDescription(rs.getString("DESCRIPTION"));
                jobList.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobList;
    }

    @Override
    public List<Job> searchJobData(String keyword) throws Exception {
        List<Job> jobList = new ArrayList<>();

        String sql = "SELECT ID, NAME, DESCRIPTION FROM JOB "
                + "WHERE ACTIVE = 1 "
                + "         AND (   LOWER (NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (DESCRIPTION) LIKE LOWER (?))\n"
                + "ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Job job = new Job();
                job.setId(rs.getLong("ID"));
                job.setName(rs.getString("NAME"));
                job.setDescription(rs.getString("DESCRIPTION"));

                jobList.add(job);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobList;
    }

    @Override
    public void deleteJob(Long jobId) throws Exception {

        String sql = "UPDATE JOB SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, jobId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addJob(Job job) throws Exception {

        String sql = "INSERT INTO JOB(ID, NAME, DESCRIPTION) "
                + "VALUES(JOB_SEQ.NEXTVAL, ?, ?)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, job.getName());
            ps.setString(2, job.getDescription());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Job getJobById(Long selectedId) throws Exception {

        String sql = "SELECT ID, NAME, DESCRIPTION "
                + "FROM JOB "
                + "WHERE ID = ?";

        Job job = new Job();

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, selectedId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                job.setId(rs.getLong("ID"));
                job.setName(rs.getString("NAME"));
                job.setDescription(rs.getString("DESCRIPTION"));
            }
        }
        return job;
    }

    @Override
    public void updateJob(Job job) throws Exception {

        String sql = "UPDATE JOB SET NAME = ?, DESCRIPTION = ? "
                + "WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, job.getName());
            ps.setString(2, job.getDescription());
            ps.setLong(3, job.getId());
            ps.execute();
            c.commit();
        }
    }
}
