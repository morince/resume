package cn.myblog.entity;

import java.io.Serializable;
import java.util.Date;
import org.json.JSONObject;

public class Resume implements Serializable {

	private static final long serialVersionUID = 7423783403718556320L;
	// 简历ID 年(4位)+月(2位)+日(2位)+序列号(5位)=13位 如：2017020300001
	private String resumeId;
	// 用户ID
	private int userId;
	// 应聘职位
	private String jobTitle;
	// 用户姓名
	private String name;
	// 用户性别
	private String gender;
	// 联系地址
	private String address;
	// 联系邮箱（默认为注册邮箱）
	private String userEmail;
	// 优势
	private String advantage;
	// 教育
	private String education;
	// 技能
	private String skills;
	// 经验
	private String experience;
	// 创建日期
	private Date createDate;
	// 修改日期
	private Date modifyDate;
	// 照片
	private String photos;
	// 状态
	private int status;

	public Resume() {

	}

	public Resume(JSONObject jsonObj) {
		this.setResumeId(jsonObj.optString("resumeId"));
		this.setUserId(jsonObj.optInt("userId"));
		this.setJobTitle(jsonObj.optString("jobTitle"));
		this.setName(jsonObj.optString("name"));
		this.setGender(jsonObj.optString("gender"));
		this.setAddress(jsonObj.optString("address"));
		this.setUserEmail(jsonObj.optString("userEmail"));
		this.setAdvantage(jsonObj.optString("advantage"));
		this.setEducation(jsonObj.optString("education"));
		this.setSkills(jsonObj.optString("skills"));
		this.setExperience(jsonObj.optString("experience"));
		this.setStatus(jsonObj.optInt("status"));
		this.setPhotos(jsonObj.optString("photos"));

	}

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "{resumeId:" + '"' + resumeId + '"' + ", userId:" + '"' + userId + '"' + ", jobTitle:" + '"' + jobTitle
				+ '"' + ", name:" + '"' + name + '"' + ", gender:" + '"' + gender + '"' + ", address:" + '"' + address
				+ '"' + ", userEmail:" + '"' + userEmail + '"' + ", advantage:" + '"' + advantage + '"' + ", education:"
				+ '"' + education + '"' + ", skills:" + '"' + skills + '"' + ", experience:" + '"' + experience + '"'
				+ ", createDate:" + '"' + createDate + '"' + ", modifyDate:" + '"' + modifyDate + '"' + ", photos:"
				+ '"' + photos + '"' + '"' + status + '"' + "}";
	}

	/**
	 * 转换为json格式
	 * 
	 * @return
	 */
	public JSONObject toObj() {
		JSONObject jsonObj = new JSONObject(this.toString());
		return jsonObj;
	}

}
