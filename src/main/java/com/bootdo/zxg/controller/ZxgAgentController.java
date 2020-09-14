package com.bootdo.zxg.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.bootdo.zxg.domain.ZxgAgentDO;
import com.bootdo.zxg.service.ZxgAgentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-08-06 09:30:12
 */
 
@Controller
@RequestMapping("/zxg/zxgAgent")
public class ZxgAgentController {
	@Autowired
	private ZxgAgentService zxgAgentService;
	
	@GetMapping()
	@RequiresPermissions("zxg:zxgAgent:zxgAgent")
	String ZxgAgent(){
	    return "zxg/zxgAgent/zxgAgent";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("zxg:zxgAgent:zxgAgent")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZxgAgentDO> zxgAgentList = zxgAgentService.list(query);
		int total = zxgAgentService.count(query);
		PageUtils pageUtils = new PageUtils(zxgAgentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("zxg:zxgAgent:add")
	String add(){
	    return "zxg/zxgAgent/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("zxg:zxgAgent:edit")
	String edit(@PathVariable("id") String id,Model model){
		ZxgAgentDO zxgAgent = zxgAgentService.get(id);
		model.addAttribute("zxgAgent", zxgAgent);
	    return "zxg/zxgAgent/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("zxg:zxgAgent:add")
	public R save( ZxgAgentDO zxgAgent){
		if(zxgAgentService.save(zxgAgent)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("zxg:zxgAgent:edit")
	public R update( ZxgAgentDO zxgAgent){
		ZxgAgentDO zxgAgentOld = zxgAgentService.get(zxgAgent.getId());
		zxgAgent.setInDate(zxgAgentOld.getInDate());
		if(!zxgAgentOld.getAgentName().equals(zxgAgent.getAgentName())){
			zxgAgent.setAgentId(UUID.randomUUID().toString().replaceAll("-",""));
		}else{
			zxgAgent.setAgentId(zxgAgentOld.getAgentId());
		}
		zxgAgentService.update(zxgAgent);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgAgent:remove")
	public R remove( String id){
		if(zxgAgentService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgAgent:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		zxgAgentService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 获取代理
	 */
	@ResponseBody
	@PostMapping("/zxgAgent")
	@RequiresPermissions("zxg:zxgAgent:zxgAgent")
	public List<Map<String,Object>> zxgAgent(){
		return zxgAgentService.zxgAgent();
	}
	
}
