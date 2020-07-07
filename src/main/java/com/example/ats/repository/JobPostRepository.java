package com.example.ats.repository;

import com.example.ats.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Long> {

    @Query("SELECT jobpost from JobPost jobpost LEFT JOIN jobpost.jobType jt LEFT JOIN jobpost.jobLocations jl WHERE jl.joblocationcity LIKE :jlcity OR jl.joblocationstate LIKE :jlstate OR jl.joblocationcountry LIKE :jlcountry OR jt.jobtypename LIKE :jtname")
    List<JobPost> findByjobtypename(@Param("jtname") String jtname,@Param("jlcity") String jlcity,@Param("jlstate") String jlstate,@Param("jlcountry") String jlcountry);

    @Query("SELECT jobpost from JobPost jobpost LEFT JOIN jobpost.jobType jt LEFT JOIN jobpost.jobLocations jl WHERE jl.joblocationcity LIKE :searchtext OR jl.joblocationstate LIKE :searchtext OR jl.joblocationcountry LIKE :searchtext OR jt.jobtypename LIKE :searchtext")
    List<JobPost> SearchJob(@Param("searchtext") String searchtext);
}
