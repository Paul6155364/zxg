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

import com.bootdo.zxg.domain.ZxgProfitsDO;
import com.bootdo.zxg.service.ZxgProfitsService;
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
@RequestMapping("/zxg/zxgProfits")
public class ZxgProfitsController {
	@Autowired
	private ZxgProfitsService zxgProfitsService;
	
	@GetMapping()
	@RequiresPermissions("zxg:zxgProfits:zxgProfits")
	String ZxgProfits(){
	    return "zxg/zxgProfits/zxgProfits";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("zxg:zxgProfits:zxgProfits")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZxgProfitsDO> zxgProfitsList = zxgProfitsService.list(query);
		int total = zxgProfitsService.count(query);
		PageUtils pageUtils = new PageUtils(zxgProfitsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("zxg:zxgProfits:add")
	String add(){
	    return "zxg/zxgProfits/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("zxg:zxgProfits:edit")
	String edit(@PathVariable("id") String id,Model model){
		ZxgProfitsDO zxgProfits = zxgProfitsService.get(id);
		model.addAttribute("zxgProfits", zxgProfits);
	    return "zxg/zxgProfits/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("zxg:zxgProfits:add")
	public R save( ZxgProfitsDO zxgProfits){
		if(zxgProfitsService.save(zxgProfits)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("zxg:zxgProfits:edit")
	public R update( ZxgProfitsDO zxgProfits){
		zxgProfitsService.update(zxgProfits);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgProfits:remove")
	public R remove( String id){
		if(zxgProfitsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgProfits:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		zxgProfitsService.batchRemove(ids);
		return R.ok();
	}
	
}
