package cn.myblog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.myblog.entity.Resume;

@Repository
public interface ResumeDao {
	
	boolean saveProfile(@Param("Resume")Resume resume);
	
	int getResumeSeq(String seqName);
	
	int resetSeq(String seqName);
	
}
