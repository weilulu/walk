package com.walk.start.common.page.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Page <T> extends PageRequest implements Iterable<T> {

	protected List<T> items = null;
	protected long totalItems = -1;
	
	protected String temp = null; 

	public Page() {
	}

	public Page(PageRequest request) {
		this.pageNo = request.pageNo;
		this.pageSize = request.pageSize;
		this.countTotal = request.countTotal;
		this.orderBy = request.orderBy;
		this.orderDir = request.orderDir;
	}
	
	public List<T> getItems() {
		return items;
	}
	
	public void setItems(final List<T> items) {
		this.items = items;
	}
	
	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(final long totalItems) {
		this.totalItems = totalItems;
	}
	
	@Override
	public Iterator<T> iterator() {
		return items.iterator();
	}
	
	public int getTotalPages() {
		return (int) Math.ceil((double) totalItems / (double) getPageSize());

	}
	
	public boolean hasNextPage() {
		return (getPageNo() + 1 < getTotalPages());
	}
	
	public boolean isLastPage() {
		return !hasNextPage();
	}
	
	public int getNextPage() {
		if (hasNextPage()) {
			return getPageNo() + 1;
		} else {
			return getPageNo();
		}
	}

	public boolean hasPrePage() {
		return (getPageNo() > 1);
	}

	public boolean isFirstPage() {
		return !hasPrePage();
	}
	
	public int getPrePage() {
		if (hasPrePage()) {
			return getPageNo() - 1;
		} else {
			return getPageNo();
		}
	}
	
	public List<Integer> getSlider(int count) {
		int halfSize = count / 2;
		int totalPage = getTotalPages();

		int startPageNo = Math.max(getPageNo() - halfSize, 1);
		int endPageNo = Math.min(startPageNo + count - 1, totalPage);

		if (endPageNo - startPageNo < count) {
			startPageNo = Math.max(endPageNo - count, 1);
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = startPageNo; i <= endPageNo; i++) {
			result.add(i);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "Page [items=" + items + ", totalItems=" + totalItems + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", orderBy=" + orderBy + ", orderDir=" + orderDir + ", countTotal=" + countTotal + ", getItems()="
				+ getItems() + ", getTotalItems()=" + getTotalItems() + ", iterator()=" + iterator()
				+ ", getTotalPages()=" + getTotalPages() + ", hasNextPage()=" + hasNextPage() + ", isLastPage()="
				+ isLastPage() + ", getNextPage()=" + getNextPage() + ", hasPrePage()=" + hasPrePage()
				+ ", isFirstPage()=" + isFirstPage() + ", getPrePage()=" + getPrePage() + ", getPageNo()="
				+ getPageNo() + ", getPageSize()=" + getPageSize() + ", getOrderBy()=" + getOrderBy()
				+ ", getOrderDir()=" + getOrderDir() + ", getSort()=" + getSort() + ", isOrderBySetted()="
				+ isOrderBySetted() + ", isCountTotal()=" + isCountTotal() + ", getOffset()=" + getOffset()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}
	
}

