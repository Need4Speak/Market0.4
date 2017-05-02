/**   
* @Title: PageServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年3月8日 上午10:30:10 
* @version V1.0   
*/
package com.pancake.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pancake.dao.impl.ClassificationDaoImpl;
import com.pancake.dao.impl.GoodDaoImpl;
import com.pancake.dao.impl.CollectionDaoImpl;
import com.pancake.entity.Classification;
import com.pancake.entity.Good;
import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;
import com.pancake.service.PageService;
@Service
public class PageServiceImpl implements PageService {
	private CollectionDaoImpl otdi = new CollectionDaoImpl();
	private GoodDaoImpl gdi = new GoodDaoImpl();
	private ClassificationDaoImpl cdi = new ClassificationDaoImpl();

	/* 
	 * @see com.pancake.service.PageService#queryForPage(int, int)
	 * 分页查询 
	 * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	@Override
	public Page<OrderTable> queryForOrderPage(int currentPage, int pageSize) {
		Page<OrderTable> page = new Page<OrderTable>();        
		//当前页开始记录
		int offset = page.countOffset(currentPage,pageSize); 
		//分页查询结果集
	    List<OrderTable> list = otdi.queryPageList(offset, pageSize); 
		//总记录数
		int allRow = otdi.findAll().size();

	    page.setPageNo(currentPage);
	    page.setPageSize(pageSize);
	    page.setTotalRecords(allRow);
	    page.setList(list);
	    
	    return page;
		}
	
	@Override
	public Page<Good> queryForGoodPage(int currentPage, int pageSize) {
		Page<Good> page = new Page<Good>();        
		//当前页开始记录
		int offset = page.countOffset(currentPage,pageSize); 
		//分页查询结果集
	    List<Good> list = gdi.queryPageList(offset, pageSize); 
		//总记录数
		ArrayList<Good> goodsList = null;
		int classificationId = -1;
		if(classificationId == -1) {
			goodsList = (ArrayList<Good>) gdi.findAllByAddTime();
		}
		else {
			Classification classification = cdi.findById(classificationId);
			goodsList = (ArrayList<Good>) gdi.findByClassification(classification);
		}
		
		// Remove good in goodsList whose status is 0. 0 means this good can not buy.
		Iterator<Good> iter = goodsList.iterator();  
		while(iter.hasNext()){  
			Good good = iter.next();  
		    if(0 == good.getStatus()){  
		        iter.remove();  
		    }  
		} 
		int allRow = goodsList.size();

	    page.setPageNo(currentPage);
	    page.setPageSize(pageSize);
	    page.setTotalRecords(allRow);
	    page.setList(list);
	    
	    return page;
	}
}
