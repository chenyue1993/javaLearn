package com.chenyue.beans;

import java.util.Set;

//当前的新闻栏目被看作是一方，即子栏目
public class NewsLabel {
	private Integer id;
	private String name;
	private NewsLabel parent;
	private Set<NewsLabel> Children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NewsLabel getParent() {
		return parent;
	}
	public void setParent(NewsLabel parent) {
		this.parent = parent;
	}
	public Set<NewsLabel> getChildren() {
		return Children;
	}
	public void setChildren(Set<NewsLabel> children) {
		Children = children;
	}
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", parent=" + parent
				+ ", Children=" + Children + "]";
	}

	

}
