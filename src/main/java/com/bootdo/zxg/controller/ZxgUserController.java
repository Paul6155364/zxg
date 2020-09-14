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

import com.bootdo.zxg.domain.ZxgUserDO;
import com.bootdo.zxg.service.ZxgUserService;
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
@RequestMapping("/zxg/zxgUser")
public class ZxgUserController {
	@Autowired
	private ZxgUserService zxgUserService;
	
	@GetMapping()
	@RequiresPermissions("zxg:zxgUser:zxgUser")
	String ZxgUser(){
	    return "zxg/zxgUser/zxgUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("zxg:zxgUser:zxgUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZxgUserDO> zxgUserList = zxgUserService.list(query);
		int total = zxgUserService.count(query);
		PageUtils pageUtils = new PageUtils(zxgUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("zxg:zxgUser:add")
	String add(){
	    return "zxg/zxgUser/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("zxg:zxgUser:edit")
	String edit(@PathVariable("id") String id,Model model){
		ZxgUserDO zxgUser = zxgUserService.get(id);
		model.addAttribute("zxgUser", zxgUser);
	    return "zxg/zxgUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("zxg:zxgUser:add")
	public R save( ZxgUserDO zxgUser){
		if(zxgUserService.save(zxgUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("zxg:zxgUser:edit")
	public R update( ZxgUserDO zxgUser){
		zxgUserService.update(zxgUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgUser:remove")
	public R remove( String id){
		if(zxgUserService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("zxg:zxgUser:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		zxgUserService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 获取代理
	 */
	@ResponseBody
	@PostMapping("/zxgUser")
	@RequiresPermissions("zxg:zxgUser:zxgUser")
	public List<Map<String,Object>> zxgUser(){
		return zxgUserService.zxgUser();
	}
}
