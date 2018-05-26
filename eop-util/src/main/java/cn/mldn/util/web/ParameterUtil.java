package cn.mldn.util.web;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 该类主要实现的是一个参数的接收程序类 可以帮助开发者简化表单封装或不封装时的参数处理问题
 * 
 * @author mldn
 */
public class ParameterUtil {
	private static final long SIZE_MAX = 3145728; // 总体文件大小
	private static final long FILE_SIZE_MAX = 1048576; // 单个文件大小
	private static final String DEFAULT_CHARSET = "UTF-8"; // 获取的文件编码信息
	private HttpServletRequest request; // 通过request获取数据
	private String charset; // 参数接收编码
	private ServletFileUpload fileUpload; // 文件上传对象
	private Map<String, List<FileItem>> paramMap; // 接收全部的请求参数
	private String parentFile; // 文件上传保存的父路径

	/**
	 * 构造一个参数工具类
	 * 
	 * @param request
	 *            请求对象
	 * @param tempDir
	 *            临时的保存目录
	 */
	public ParameterUtil(HttpServletRequest request, String tempDir) {
		this(request, tempDir, SIZE_MAX, FILE_SIZE_MAX, DEFAULT_CHARSET);
	}

	/**
	 * 构造一个参数工具类
	 * 
	 * @param request
	 *            请求对象
	 * @param tempDir
	 *            临时的保存目录
	 * @param parentFile
	 *            设置一个相对的父目录的路径
	 */
	public ParameterUtil(HttpServletRequest request, String tempDir, String parentFile) {
		this(request, tempDir, SIZE_MAX, FILE_SIZE_MAX, DEFAULT_CHARSET, parentFile);
	}

	/**
	 * 创建一个参数工具类
	 * 
	 * @param request
	 *            请求对象
	 * @param tempDir
	 *            临时的保存目录
	 * @param sizeMax
	 *            最大的上传文件
	 * @param fileSizeMax
	 *            单个文件的大小控制
	 * @param charset
	 *            编码
	 */
	public ParameterUtil(HttpServletRequest request, String tempDir, long sizeMax, long fileSizeMax, String charset) {
		this.request = request; // 保存request对象
		this.charset = charset; // 保存参数的接收编码
		if (this.request.getContentType() != null && this.request.getContentType().startsWith("multipart/form-data")) { // 必须在保证有上传表单封装的前提下才可以使用FileUpload
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(this.request.getServletContext().getRealPath(tempDir))); // 设置临时目录
			this.fileUpload = new ServletFileUpload(factory);
			this.fileUpload.setSizeMax(sizeMax); // 设置最大上传字节个数
			this.fileUpload.setFileSizeMax(fileSizeMax); // 设置单个文件的字节个数
			if (ServletFileUpload.isMultipartContent(request)) { // 是否使用FileUpload组件处理
				try {// 接收全部参数
					this.paramMap = this.fileUpload.parseParameterMap(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 创建一个参数工具类
	 * 
	 * @param request
	 *            请求对象
	 * @param tempDir
	 *            临时的保存目录
	 * @param sizeMax
	 *            最大的上传文件
	 * @param fileSizeMax
	 *            单个文件的大小控制
	 * @param charset
	 *            编码
	 * @param parentFile
	 *            文件保存父目录
	 */
	public ParameterUtil(HttpServletRequest request, String tempDir, long sizeMax, long fileSizeMax, String charset,
			String parentFile) {
		this.request = request; // 保存request对象
		this.charset = charset; // 保存参数的接收编码
		this.parentFile = parentFile;
		if (this.request.getContentType() != null && this.request.getContentType().startsWith("multipart/form-data")) { // 必须在保证有上传表单封装的前提下才可以使用FileUpload
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(this.request.getServletContext().getRealPath(tempDir))); // 设置临时目录
			this.fileUpload = new ServletFileUpload(factory);
			this.fileUpload.setSizeMax(sizeMax); // 设置最大上传字节个数
			this.fileUpload.setFileSizeMax(fileSizeMax); // 设置单个文件的字节个数
			if (ServletFileUpload.isMultipartContent(request)) { // 是否使用FileUpload组件处理
				try {// 接收全部参数
					this.paramMap = this.fileUpload.parseParameterMap(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取指定参数的MIME类型
	 * 
	 * @param paramName
	 *            参数名称
	 * @return MIME类型
	 */
	public Set<String> getMimes(String paramName) {
		Set<String> names = new HashSet<String>();
		if (this.parentFile == null || ServletFileUpload.isMultipartContent(this.request) == false) {
			return names;
		}
		if (this.paramMap.containsKey(paramName)) { // 接收了指定名称的参数
			List<FileItem> itemList = this.paramMap.get(paramName); // 接收指定参数
			for (FileItem item : itemList) { // 进行所有项的迭代
				names.add(item.getContentType()); // 获取MIME类型
			}
		}
		return names;
	}

	/**
	 * 获取所有的上传文件类型
	 * 
	 * @return 上传文件类型的集合
	 */
	public Set<String> getMimes() {
		Set<String> names = new HashSet<String>();
		if (this.parentFile == null || ServletFileUpload.isMultipartContent(this.request) == false) {
			return names;
		}
		if (ServletFileUpload.isMultipartContent(this.request)) {
			for (Map.Entry<String, List<FileItem>> entry : this.paramMap.entrySet()) {
				for (FileItem item : entry.getValue()) {
					if ((!item.isFormField())) {
						names.add(item.getContentType());
					}
				}
			}
		}
		return names;
	}

	/**
	 * 最简单的上传处理方法，上传到指定的路径上，并且自动进行文件的保存，同时返回保存的文件名称
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 文件名称的集合，如果没有文件返回集合长度为0
	 */
	public Set<String> upload(String paramName) {
		Set<String> names = new HashSet<String>();
		if (this.parentFile == null || ServletFileUpload.isMultipartContent(this.request) == false) {
			return names;
		}
		if (this.paramMap.containsKey(paramName)) { // 接收了指定名称的参数
			List<FileItem> itemList = this.paramMap.get(paramName); // 接收指定参数
			for (FileItem item : itemList) { // 进行所有项的迭代
				String fileName = UUID.randomUUID() + "."
						+ item.getContentType().substring(item.getContentType().lastIndexOf("/") + 1);
				names.add(fileName); // 保存文件名称
				String filePath = this.request.getServletContext().getRealPath(this.parentFile) + fileName; // 文件路径
				try {
					item.write(new File(filePath));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return names;
	}

	/**
	 * 获取指定参数名称对应的参数内容
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 参数内容，如果没有参数返回null
	 */
	public String getParameter(String paramName) {
		String value = null;
		if (ServletFileUpload.isMultipartContent(this.request)) { // 表单封装了
			if (this.paramMap.containsKey(paramName)) { // 接收了指定名称的参数
				List<FileItem> itemList = this.paramMap.get(paramName); // 接收指定参数
				if (itemList.get(0).isFormField()) { // 是一个普通的文本参数
					try { // 获取指定的文本参数
						value = itemList.get(0).getString(this.charset);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		} else { // 表单没有封装，则按照传统的方式获取指定参数数据
			value = this.request.getParameter(paramName);
		}
		return value;
	}

	/**
	 * 返回指定名称的数组参数内容
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 多个内容，如果没有内容返回null
	 */
	public String[] getParameterValues(String paramName) {
		String[] values = null;
		if (ServletFileUpload.isMultipartContent(this.request)) { // 表单封装了
			if (this.paramMap.containsKey(paramName)) { // 有指定的参数
				List<FileItem> itemList = this.paramMap.get(paramName); // 接收指定参数
				values = new String[itemList.size()]; // 开辟指定数组
				int foot = 0; // 操作values数组的脚标
				for (FileItem item : itemList) {
					if (item.isFormField()) {
						try {
							values[foot++] = item.getString(this.charset);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			values = this.request.getParameterValues(paramName);
		}
		return values;
	}

	public String[] getIds() {
		String[] values = this.request.getParameterValues("ids");
		// 实际上返回的不会是一个数组，而是一个包含“，”的字符串
		String ids = values[0];
		return ids.split(",");
	}

	/**
	 * 获取所有请求参数的名字
	 * 
	 * @return 参数的名称集合，如果没有参数返回的集合长度为0
	 */
	public Set<String> getParameterNames() {
		if (ServletFileUpload.isMultipartContent(this.request)) { // 表单封装了
			return this.paramMap.keySet(); // 直接返回全部的key
		} else {
			Set<String> paramNames = new HashSet<String>();
			Enumeration<String> enu = this.request.getParameterNames();
			while (enu.hasMoreElements()) {
				paramNames.add(enu.nextElement());
			}
			return paramNames;
		}
	}

	/**
	 * 创建指定上传文件的文件保存名称，如果没有文件上传，返回的文件名称为null
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 文件名称集合
	 */
	public Set<String> createUUIDFileName(String paramName) {
		Set<String> allNames = new HashSet<String>(); // 保存所有自动创建的名称
		if (ServletFileUpload.isMultipartContent(this.request)) { // 表单封装了
			if (this.paramMap.containsKey(paramName)) { // 参数名称存在
				List<FileItem> allItems = this.paramMap.get(paramName);
				for (FileItem item : allItems) { // 获取每一个上传的文件
					if ((!item.isFormField()) && item.getSize() > 0) { // 不是文本，并且有上传内容
						String fileName = UUID.randomUUID() + "."
								+ item.getContentType().substring(item.getContentType().lastIndexOf("/") + 1);
						allNames.add(fileName); // 保存文件名称
					}
				}
			}
		}
		return allNames;
	}

	/**
	 * 判断是否有文件上传，如果表单封装了则表示有文件上传
	 * 
	 * @return 有文件上传返回true
	 */
	public boolean isUpload() { // 是否有文件上传
		long size = 0; // 上传字节数
		if (ServletFileUpload.isMultipartContent(this.request)) {
			for (Map.Entry<String, List<FileItem>> entry : this.paramMap.entrySet()) {
				for (FileItem item : entry.getValue()) {
					if ((!item.isFormField())) {
						size += item.getSize();
					}
				}
			}
		}
		return size > 0;
	}

	/**
	 * 判断是否有指定文件上传
	 * 
	 * @param paramName
	 * @return 如果有文件上传则返回true，否则返回false
	 */
	public boolean isUpload(String paramName) {
		return this.createUUIDFileName(paramName).size() > 0;
	}

	/**
	 * 实现单个文件的信息保存
	 * 
	 * @param paramName
	 *            参数的名称
	 * @param path
	 *            文件保存路径（文件名称需要单独创建）
	 */
	public void saveUpload(String paramName, String path) {
		if (ServletFileUpload.isMultipartContent(this.request)) { // 表单封装了
			if (this.paramMap.containsKey(paramName)) {
				List<FileItem> allItems = this.paramMap.get(paramName);
				if (allItems.get(0).getSize() > 0) {
					try {
						allItems.get(0).write(new File(path));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 保存多个上传文件的信息
	 * 
	 * @param paramName
	 *            参数名称
	 * @param paths
	 *            要保存的文件的路径
	 */
	public void saveUpload(String paramName, List<String> paths) {
		if (ServletFileUpload.isMultipartContent(this.request)) { // 表单封装了
			if (this.paramMap.containsKey(paramName)) {
				List<FileItem> allItems = this.paramMap.get(paramName);
				for (int x = 0; x < allItems.size(); x++) {
					if (allItems.get(x).getSize() > 0) {
						try {
							allItems.get(x).write(new File(paths.get(x)));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * 获得查询条件的字段
	 * @return 返回列表中模糊查询的字段
	 */
	public String getSearchCol() {
		String searchCol = null;
		if (request.getParameterValues("col") != null && this.getParameterValues("col").length > 0) {
			searchCol = this.getParameterValues("col")[0];
		}
		return searchCol==null?"":searchCol;
	}
	
	/**
	 * 获得模糊查询的条件
	 * @return 返回模糊查询条件
	 */
	public String getSearchKeyWord() {
		String searchKw = null;
		if (this.getParameterValues("kw") != null && this.getParameterValues("kw").length > 0) {
			searchKw = this.getParameterValues("kw")[0];
		}
		return searchKw==null?"":searchKw;
	}
}
