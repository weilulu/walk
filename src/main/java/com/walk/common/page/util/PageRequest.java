package com.walk.common.page.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页参数封装类.
 * 
 * 
 */
public class PageRequest {
	// 当前页页号
	protected int pageNo = 1;
	// 每页显示数量
	protected int pageSize = 10;
	// 排序字段
	protected String orderBy = null;
	// 排序方向
	protected String orderDir = null;
	// 是否默认计算总记录数
	protected boolean countTotal = true;

	public PageRequest() {
	}

	public PageRequest(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	/**
	 * 获得当前页的页号, 序号从1开始, 默认为1.
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号, 序号从1开始, 低于1时自动调整为1.
	 */
	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;

		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}

	/**
	 * 获得每页的记录数量, 默认为10.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数量, 低于1时自动调整为1.
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < 1) {
			this.pageSize = 1;
		}
	}

	/**
	 * 获得排序字段, 无默认值. 多个排序字段时用','分隔.
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * 设置排序字段, 多个排序字段时用','分隔.
	 */
	public void setOrderBy(final String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * 获得排序方向, 无默认值.
	 */
	public String getOrderDir() {
		return orderDir;
	}

	/**
	 * 设置排序方式向.
	 * 
	 * @param orderDir
	 *            可选值为desc或asc,多个排序字段时用','分隔.
	 */
	public void setOrderDir(final String orderDir) {
		if (orderDir == null)
			return;
		String lowcaseOrderDir = orderDir.toLowerCase();

		// 检查order字符串的合法值
		String[] orderDirs = lowcaseOrderDir.split(",");
		for (String orderDirStr : orderDirs) {
			if (!Sort.DESC.equals(orderDirStr) && !Sort.ASC.equals(orderDirStr)) {
				throw new IllegalArgumentException("排序方向" + orderDirStr
						+ "不是合法值");
			}
		}

		this.orderDir = lowcaseOrderDir;
	}

	/**
	 * 获得排序参数.
	 */
	public List<Sort> getSort() {
		if (orderBy == null || orderBy.length() < 1)
			return null;
		String[] orderBys = orderBy.split(",");
		String[] orderDirs = orderDir.split(",");
		if (orderDirs.length != orderBys.length)
			throw new IllegalArgumentException("分页多重排序参数中,排序字段与排序方向的个数不相等");

		List<Sort> orders = new ArrayList<Sort>();
		for (int i = 0; i < orderBys.length; i++) {
			orders.add(new Sort(orderBys[i], orderDirs[i]));
		}

		return orders;
	}

	/**
	 * 是否已设置排序字段,无默认值.
	 */
	public boolean isOrderBySetted() {
		return (orderBy != null && orderBy.length() > 0 && orderDir != null && orderDir
				.length() > 0);
	}

	/**
	 * 是否默认计算总记录数.
	 */
	public boolean isCountTotal() {
		return countTotal;
	}

	/**
	 * 设置是否默认计算总记录数.
	 */
	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}

	/**
	 * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置, 序号从0开始.
	 */
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
