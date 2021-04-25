package bean;

public class Category extends BaseEntity {

	public Category() {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String description;
	private String[] images;
	private String[] banners;
	private boolean published;
	private int level;
	private String parent;
}
