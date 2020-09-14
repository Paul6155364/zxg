package com.bootdo.zxg.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.zxg.domain.ZxgMarketingDO;
import com.bootdo.zxg.service.ZxgMarketingService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author teacherMa
 * @email teacherMa@163.com
 * @date 2020-08-07 16:46:51
 */
 
@Controller
@RequestMapping("/zxg/zxgMarketing")
public class ZxgMarketingController {
	@Autowired
	private ZxgMarketingService zxgMarketingService;
	
	@GetMapping()
	@RequiresPermissions("zxg:zxgMarketing:zxgMarketing")
	String ZxgMarketing(){
	    return "zxg/zxgMarketing/zxgMarketing";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("zxg:zxgMarketing:zxgMarketing")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZxgMarketingDO> zxgMarketingList = zxgMarketingService.list(query);
		int total = zxgMarketingService.count(query);
		PageUtils pageUtils = new PageUtils(zxgMarketingList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("zxg:zxgMarketing:add")
	String add(){
	    return "zxg/zxgMarketing/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("zxg:zxgMarketing:edit")
	String edit(@PathVariable("id") String id,Model model){
		ZxgMarketingDO zxgMarketing = zxgMarketingService.get(id);
		model.addAttribute("zxgMarketing", zxgMarketing);
	    return "zxg/zxgMarketing/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("zxg:zxgMarketing:add")
	public R save( ZxgMarketingDO zxgMarketing){
		if(zxgMarketingService.save(zxgMarketing)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("zxg:zxgMarketing:edit")
	public R update( ZxgMarketingDO zxgMarketing){
		zxgMarketingService.update(zxgMarketing);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgMarketing:remove")
	public R remove( String id){
		if(zxgMarketingService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgMarketing:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		zxgMarketingService.batchRemove(ids);
		return R.ok();
	}


	
}
