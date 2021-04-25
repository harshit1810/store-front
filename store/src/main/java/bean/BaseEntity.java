package bean;

import java.util.Date;

public class BaseEntity {

	public BaseEntity() {
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String key;
	private int version;
	private Date createdAt;
	private Date lastModifiedAt;
	private String createdBy;
	private String lastModifiedBy;
}
