package com.walk.start.common.page.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 */
public class PageRequest {
	protected int pageNo = 1;
	protected int pageSize = 10;
	protected String orderBy = null;
	protected String orderDir = null;
	protected boolean countTotal = true;

	public PageRequest() {
	}

	public PageRequest(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;

		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < 1) {
			this.pageSize = 1;
		}
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(final String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(final String orderDir) {
		if (orderDir == null)
			return;
		String lowcaseOrderDir = orderDir.toLowerCase();

		String[] orderDirs = lowcaseOrderDir.split(",");
		for (String orderDirStr : orderDirs) {
			if (!Sort.DESC.equals(orderDirStr) && !Sort.ASC.equals(orderDirStr)) {
				throw new IllegalArgumentException("param is illegal");
			}
		}

		this.orderDir = lowcaseOrderDir;
	}

	public List<Sort> getSort() {
		if (orderBy == null || orderBy.length() < 1)
			return null;
		String[] orderBys = orderBy.split(",");
		String[] orderDirs = orderDir.split(",");
		if (orderDirs.length != orderBys.length)
			throw new IllegalArgumentException("exception....");

		List<Sort> orders = new ArrayList<Sort>();
		for (int i = 0; i < orderBys.length; i++) {
			orders.add(new Sort(orderBys[i], orderDirs[i]));
		}

		return orders;
	}

	public boolean isOrderBySetted() {
		return (orderBy != null && orderBy.length() > 0 && orderDir != null && orderDir
				.length() > 0);
	}

	public boolean isCountTotal() {
		return countTotal;
	}

	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}

	public int getOffset() {
		return ((pageNo - 1) * pageSize);
	}

	public static class Sort {
		public static final String ASC = "asc";
		public static final String DESC = "desc";

		private final String property;
		private final String dir;

		public Sort(String property, String dir) {
			this.property = property;
			this.dir = dir;
		}

		public String getProperty() {
			return property;
		}

		public String getDir() {
			return dir;
		}
	}

	@Override
	public String toString() {
		return "PageRequest [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", orderBy=" + orderBy + ", orderDir=" + orderDir
				+ ", countTotal=" + countTotal + "]";
	}
}
