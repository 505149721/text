package hnuc.cn.entity;

public class Author {
	private Integer author_id;
	private String name;
	private String brief;
	
	public Author(Integer author_id) {
		super();
		this.author_id = author_id;
	}
	public Author(Integer author_id, String name) {
		super();
		this.author_id = author_id;
		this.name = name;
	}
	public Author(Integer author_id, String name, String brief) {
		super();
		this.author_id = author_id;
		this.name = name;
		this.brief = brief;
	}
	public Author() {
		super();
	}
	public Integer getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
}
