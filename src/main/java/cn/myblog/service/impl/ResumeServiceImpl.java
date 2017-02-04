package cn.myblog.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.myblog.dao.ResumeDao;
import cn.myblog.entity.CommonCode;
import cn.myblog.entity.Resume;
import cn.myblog.service.ResumeService;
@Service
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private ResumeDao dao;
	
	
	public boolean saveProfile(JSONObject jsonObj) {
		String sid = getResumeId();
		jsonObj.put("resumeId", sid);
		return dao.saveProfile(new Resume(jsonObj));
	}
	

	public boolean updateProfile(JSONObject jsonObj) {
		// TODO Auto-generated method stub
		return false;
	}	
	
	
	
	/**
	 * 获取resumeID号，构成规则：年(4位)+月(2位)+日(2位)+序列号(5位)=13位
	 * @return
	 */
	public String getResumeId() {

		String seq = Integer.toString(dao.getResumeSeq(CommonCode.resumeSeq));
		StringBuffer appendZero = new StringBuffer();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		appendZero.append(sdf.format(date));
		//如果seq超过5位则重置序列
		if (seq.length() > 5) {
			dao.resetSeq(CommonCode.resumeSeq);
			seq = Integer.toString(dao.getResumeSeq(CommonCode.resumeSeq));
		}
		
		for (int i = 0; i < 5 - seq.length(); i++) {
			appendZero.append("0");
		}

		appendZero.append(seq);

		return appendZero.toString();
	}


}
