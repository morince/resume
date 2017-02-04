package cn.myblog.entity;

public enum StaticEnum {
	/**
	 * ("草稿", 0)
	 */
	DRAFT("草稿", 0),
	/**
	 * ("发布", 1)
	 */
	PUBLISH("发布", 1),
	/**
	 * ("删除", 2)
	 */
	DELETE("删除", 2),
	/**
	 * ("个人", 3)
	 */
	INDIVIDUAL("个人", 3),
	/**
	 * ("其他", 4)
	 */
	OTHERS("其他", 4);
	// 状态名
	private String name;
	// 状态索引
	private int index;

	private StaticEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}

	/**
	 * 通过循环遍历获取name
	 * 
	 * @param index
	 * @return
	 */
	public static String getName(int index) {
		for (StaticEnum se : StaticEnum.values()) {
			if (se.getIndex() == index) {
				return se.getName();

			}
		}

		return null;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}

}
