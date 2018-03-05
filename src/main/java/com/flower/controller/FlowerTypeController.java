package com.flower.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flower.entity.FlowerType;
import com.flower.service.IFlowerTypeService;

@Controller
@RequestMapping("/flowerType")
public class FlowerTypeController {
	@Autowired
	private IFlowerTypeService iFlowerTypeService;

	@RequestMapping("/type.do")
	public String findType(HttpServletRequest request, Model model) {
		List<FlowerType> type = iFlowerTypeService.findAll();
		request.setAttribute("iFlowerTypeService", type);

		return "flowerType.jsp";
	}

	@RequestMapping("/deleteType.do")
	public String delete(int ftypeId) {
		iFlowerTypeService.deleteByType(ftypeId);
		return "redirect:type.do";
	}
	@RequestMapping("toModifyType.do")
	public String ModifyType(int ftypeId, HttpServletRequest request) {
		FlowerType flowerType = iFlowerTypeService.findFlowerType(ftypeId);
		request.setAttribute("flowerTypeService", flowerType);
		List<FlowerType> superType = iFlowerTypeService.finAllSuper();
		request.setAttribute("iFlowerTypeService", superType);
		FlowerType superName = iFlowerTypeService.findSuperName(ftypeId);
		if(superName == null) {
			request.setAttribute("superType", "无");
		}else {
			request.setAttribute("typeService", superName);
		}
		return "modifyType.jsp";
	}

	@RequestMapping("modify.do")
	public String modify(FlowerType flowerType, String ftypeName) {
		String[] typeArray = ftypeName.split(",");
		String arr = typeArray[0];
		String arr2 = typeArray[1];
		
		if (arr2.equals("无")) {
			flowerType.setFatherId(0);
		} else {
			FlowerType flower = iFlowerTypeService.findByTypeName(arr2);
			flowerType.setFatherId(flower.getFtypeId());
		}
		flowerType.setFtypeName(arr);
		iFlowerTypeService.updateFlowerType(flowerType);
		return "redirect:type.do";
	}

	@RequestMapping("toAddType.do")
	public String toAddType(HttpServletRequest request) {
		List<FlowerType> superType = iFlowerTypeService.finAllSuper();
		request.setAttribute("iFlowerTypeService", superType);
		request.setAttribute("notNull", "名字不能为空");

		System.out.println(superType);
		return "addType.jsp";
	}

	@RequestMapping("addType.do")
	public String addType(String ftypeName,HttpServletRequest request) {
		String[] typeArray = ftypeName.split(",");
		String arr = typeArray[0];
		String arr2 = typeArray[1];
		if(arr.equals("") || arr.equals("名字不能为空")) {
			return "redirect:toAddType.do";
		}
		FlowerType ftype = new FlowerType();
		if (arr2.equals("无")) {
			ftype.setFatherId(0);
		} else {
			FlowerType flower = iFlowerTypeService.findByTypeName(arr2);
			ftype.setFatherId(flower.getFtypeId());
		}
		ftype.setFtypeName(arr);

		iFlowerTypeService.addFlowerType(ftype);
		return "redirect:type.do";
	}
}
