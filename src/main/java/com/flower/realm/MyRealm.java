package com.flower.realm;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.User;
import com.flower.jedis.JedisClient;
import com.flower.service.IUserService;

public class MyRealm extends AuthorizingRealm{

	@Resource
	private IUserService userService;
	@Autowired
	private JedisClient jedis;	
	
	
	/**
	 * 为当限前登录的用户授予角色和权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		Subject subject=SecurityUtils.getSubject();
		
		String u_phone=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		
		String result = jedis.get(subject.getSession().getId()+":roles");
		Set<String> roles=new HashSet<String>();
		if(result==null){
		   roles = userService.findRoles(u_phone);
		   jedis.set(subject.getSession().getId()+":roles",JSONObject.toJSONString(roles));
		}else{
			roles.addAll(JSONObject.parseArray(result,String.class));
		}
		authorizationInfo.setRoles(roles);
		authorizationInfo.setStringPermissions(userService.findPermissions(u_phone));
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String u_phone=(String)token.getPrincipal();
			User user=userService.getByU_phone(u_phone);
			if(user!=null){
				AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getU_phone(),user.getU_pwd(),"xx");
				return authcInfo;
			}else{
				return null;				
			}
	}

}
