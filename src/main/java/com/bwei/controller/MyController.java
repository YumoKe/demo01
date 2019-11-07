package com.bwei.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bwei.beans.Brand;
import com.bwei.beans.Goods;
import com.bwei.beans.Kinds;
import com.bwei.beans.MySort;
import com.bwei.service.BrandService;
import com.bwei.service.GoodsService;
import com.bwei.service.KindsService;
import com.bwei.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MyController {

	@Resource
	GoodsService gs;
	
	@Resource
	KindsService ks;
	
	@Resource
	BrandService bs;
	
	// 列表------------------------------------------------
	@RequestMapping("list")
	public ModelAndView findAll(@RequestParam(defaultValue="1")Integer pageNum,String price,String cot,String weight){
		MySort sort = MySort.getInstance();
		if (price != null && price != "") {
			String pri = "g.price "+price;
			sort.setPrice(pri);
		}
		if (cot != null && cot != "") {
			String cot1 = "g.cot "+cot;
			sort.setCot(cot1);
		}
		
		if (weight != null && weight != "") {
			String weight1 = "g.weight " + weight;
			sort.setWeight(weight1);
		}
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(pageNum, 1);
		List<Goods> list = gs.findAll(sort);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		mav.setViewName("list");
		mav.getModel().put("page",page);
		mav.getModel().put("list", list);
		mav.getModel().put("mysort", sort);
		System.out.println(sort);
		return mav;
	}
	
	@RequestMapping("toAdd")
	public String toAdd(Model mod){
		mod.addAttribute("goods",new Goods());
		return "add";
	}
	
	@RequestMapping("add")
	public String add(Goods good,MultipartFile img) throws IllegalStateException, IOException{
		String imgurl = FileUtils.upload(img);
		good.setImgurl(imgurl);
		gs.add(good);
		return "redirect:list";
	}
	
	@RequestMapping("del")
	public String del(Integer gid){
		gs.del(gid);
		return "redirect:list";
	}
	
	@RequestMapping("toUpd")
	@ResponseBody
	public Goods toUpd(Integer gid){
		 Goods upd = gs.toUpd(gid);
		 System.out.println(upd);
		 return upd;
	}
	
	@RequestMapping("upd")
	public String upd(Goods goods) {
		System.out.println(goods);
		gs.upd(goods);
		return "redirect:list";
	}
	
	// 新增与修改下拉框---------------------------------------
	@RequestMapping("kind")
	@ResponseBody
	public List<Kinds> findKinds(){
		return ks.findAll();
	}
	
	@RequestMapping("brand")
	@ResponseBody
	public List<Brand> findBrand(){
		return bs.findAll();
	}
	
	@RequestMapping("looking")
	public void look(String path,HttpServletRequest request,
			HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
}
