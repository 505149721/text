package hnuc.cn.util;

import java.util.List;

public class Page<T> {
  private Integer curPage;
  private Integer pageSize;
  private Integer totalCount;
  private List<T> list;

public Page(Integer curPage, Integer pageSize) {
	super();
	this.curPage = curPage;
	this.pageSize = pageSize;
}
public int getPrePage() {
	if(curPage>1) {
		return curPage-1;
	}
	return curPage;
}
public int getNextPage() {
	if(curPage<this.getTotalPage()) {
		return curPage+1;
	}
	return curPage;
}
public Integer getTotalPage() {
	return (totalCount+pageSize-1)/pageSize;	
}

public Integer getCurPage() {
	return curPage;
}
public void setCurPage(Integer curPage) {
	this.curPage = curPage;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}

public Integer getTotalCount() {
	return totalCount;
}

public void setTotalCount(Integer totalCount) {
	this.totalCount = totalCount;
}

public List<T> getList() {
	return list;
}

public void setList(List<T> list) {
	this.list = list;
}


  
}
