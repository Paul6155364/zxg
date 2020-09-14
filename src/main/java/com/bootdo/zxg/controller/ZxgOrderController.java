package com.bootdo.zxg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.zxg.service.ZxgAgentService;
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

import com.bootdo.zxg.domain.ZxgOrderDO;
import com.bootdo.zxg.service.ZxgOrderService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-08-05 10:06:22
 */
 
@Controller
@RequestMapping("/zxg/zxgOrder")
public class ZxgOrderController {
	@Autowired
	private ZxgOrderService zxgOrderService;

	
	@GetMapping()
	@RequiresPermissions("zxg:zxgOrder:zxgOrder")
	String ZxgOrder(){
	    return "zxg/zxgOrder/zxgOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("zxg:zxgOrder:zxgOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("status","1");
        Query query = new Query(params);
		List<ZxgOrderDO> zxgOrderList = zxgOrderService.list(query);
		int total = zxgOrderService.count(query);
		PageUtils pageUtils = new PageUtils(zxgOrderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("zxg:zxgOrder:add")
	String add(){
	    return "zxg/zxgOrder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("zxg:zxgOrder:edit")
	String edit(@PathVariable("id") String id,Model model){
		ZxgOrderDO zxgOrder = zxgOrderService.get(id);
		model.addAttribute("zxgOrder", zxgOrder);
	    return "zxg/zxgOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("zxg:zxgOrder:add")
	public R save( ZxgOrderDO zxgOrder){
		if(zxgOrderService.save(zxgOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("zxg:zxgOrder:edit")
	public R update( ZxgOrderDO zxgOrder){
		if(StringUtils.isNotBlank(zxgOrder.getSettlementId())){
			return R.error("不能修改已经结算订单");
		}
		zxgOrderService.update(zxgOrder);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgOrder:remove")
	public R remove( String id){
		ZxgOrderDO zxgOrder = zxgOrderService.get(id);
		if(StringUtils.isNotBlank(zxgOrder.getSettlementId())){
			return R.error("不能删除已经结算订单");
		}
		if(zxgOrderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgOrder:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		zxgOrderService.batchRemove(ids);
		return R.ok();
	}
	
}
