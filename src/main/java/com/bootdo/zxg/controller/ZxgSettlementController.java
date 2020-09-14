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

import com.bootdo.zxg.domain.ZxgSettlementDO;
import com.bootdo.zxg.service.ZxgSettlementService;
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
@RequestMapping("/zxg/zxgSettlement")
public class ZxgSettlementController {
	@Autowired
	private ZxgSettlementService zxgSettlementService;
	
	@GetMapping()
	@RequiresPermissions("zxg:zxgSettlement:zxgSettlement")
	String ZxgSettlement(){
	    return "zxg/zxgSettlement/zxgSettlement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("zxg:zxgSettlement:zxgSettlement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZxgSettlementDO> zxgSettlementList = zxgSettlementService.list(query);
		int total = zxgSettlementService.count(query);
		PageUtils pageUtils = new PageUtils(zxgSettlementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("zxg:zxgSettlement:add")
	String add(){
	    return "zxg/zxgSettlement/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("zxg:zxgSettlement:edit")
	String edit(@PathVariable("id") String id,Model model){
		ZxgSettlementDO zxgSettlement = zxgSettlementService.get(id);
		model.addAttribute("zxgSettlement", zxgSettlement);
	    return "zxg/zxgSettlement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("zxg:zxgSettlement:add")
	public R save( ZxgSettlementDO zxgSettlement){
		if(zxgSettlementService.save(zxgSettlement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("zxg:zxgSettlement:edit")
	public R update( ZxgSettlementDO zxgSettlement){
		zxgSettlementService.update(zxgSettlement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgSettlement:remove")
	public R remove( String id){
		if(zxgSettlementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgSettlement:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		zxgSettlementService.batchRemove(ids);
		return R.ok();
	}
	
}
