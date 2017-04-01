package com.walk.common.page.util;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ������װ��.
 * 
 * 
 */
public class PageRequest {
	// ��ǰҳҳ��
	protected int pageNo = 1;
	// ÿҳ��ʾ����
	protected int pageSize = 10;
	// �����ֶ�
	protected String orderBy = null;
	// ������
	protected String orderDir = null;
	// �Ƿ�Ĭ�ϼ����ܼ�¼��
	protected boolean countTotal = true;

	public PageRequest() {
	}

	public PageRequest(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	/**
	 * ��õ�ǰҳ��ҳ��, ��Ŵ�1��ʼ, Ĭ��Ϊ1.
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * ���õ�ǰҳ��ҳ��, ��Ŵ�1��ʼ, ����1ʱ�Զ�����Ϊ1.
	 */
	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;

		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}

	/**
	 * ���ÿҳ�ļ�¼����, Ĭ��Ϊ10.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ����ÿҳ�ļ�¼����, ����1ʱ�Զ�����Ϊ1.
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < 1) {
			this.pageSize = 1;
		}
	}

	/**
	 * ��������ֶ�, ��Ĭ��ֵ. ��������ֶ�ʱ��','�ָ�.
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * ���������ֶ�, ��������ֶ�ʱ��','�ָ�.
	 */
	public void setOrderBy(final String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * ���������, ��Ĭ��ֵ.
	 */
	public String getOrderDir() {
		return orderDir;
	}

	/**
	 * ��������ʽ��.
	 * 
	 * @param orderDir
	 *            ��ѡֵΪdesc��asc,��������ֶ�ʱ��','�ָ�.
	 */
	public void setOrderDir(final String orderDir) {
		if (orderDir == null)
			return;
		String lowcaseOrderDir = orderDir.toLowerCase();

		// ���order�ַ����ĺϷ�ֵ
		String[] orderDirs = lowcaseOrderDir.split(",");
		for (String orderDirStr : orderDirs) {
			if (!Sort.DESC.equals(orderDirStr) && !Sort.ASC.equals(orderDirStr)) {
				throw new IllegalArgumentException("������" + orderDirStr
						+ "���ǺϷ�ֵ");
			}
		}

		this.orderDir = lowcaseOrderDir;
	}

	/**
	 * ����������.
	 */
	public List<Sort> getSort() {
		if (orderBy == null || orderBy.length() < 1)
			return null;
		String[] orderBys = orderBy.split(",");
		String[] orderDirs = orderDir.split(",");
		if (orderDirs.length != orderBys.length)
			throw new IllegalArgumentException("��ҳ�������������,�����ֶ���������ĸ��������");

		List<Sort> orders = new ArrayList<Sort>();
		for (int i = 0; i < orderBys.length; i++) {
			orders.add(new Sort(orderBys[i], orderDirs[i]));
		}

		return orders;
	}

	/**
	 * �Ƿ������������ֶ�,��Ĭ��ֵ.
	 */
	public boolean isOrderBySetted() {
		return (orderBy != null && orderBy.length() > 0 && orderDir != null && orderDir
				.length() > 0);
	}

	/**
	 * �Ƿ�Ĭ�ϼ����ܼ�¼��.
	 */
	public boolean isCountTotal() {
		return countTotal;
	}

	/**
	 * �����Ƿ�Ĭ�ϼ����ܼ�¼��.
	 */
	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}

	/**
	 * ����pageNo��pageSize���㵱ǰҳ��һ����¼���ܽ�����е�λ��, ��Ŵ�0��ʼ.
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
