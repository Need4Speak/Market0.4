/**   
* @Title: PageServiceImplTest.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年3月8日 下午3:24:56 
* @version V1.0   
*/
package com.pancake.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pancake.entity.OrderTable;
import com.pancake.entity.Page;

/**
 * @author m
 *
 */
public class PageServiceImplTest {
	@Autowired
	private PageServiceImpl psi = new PageServiceImpl();
	
	@Test
	public void testQueryForGoodPage() {
		Page page = psi.queryForGoodPage(1, 3);
		System.out.println(page.getPageSize());
		System.out.println(page.getPageNo());
		System.out.println(page.getTotalRecords());
	}

}
