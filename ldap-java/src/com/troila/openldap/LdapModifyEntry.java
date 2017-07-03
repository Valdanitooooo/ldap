package com.troila.openldap;

import java.util.ArrayList;
import java.util.HashMap;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.Modification;
import com.unboundid.ldap.sdk.ModificationType;
import com.unboundid.ldap.sdk.SearchResultEntry;

/**
 * 修改用户信息
 * 2016年12月16日上午9:51:14
 * @author wangchao
 */
public class LdapModifyEntry {

	public static void modifyEntry(String requestDN, HashMap<String,String> data) {
		try {
			// 连接LDAP
			LDAPConnection connection = LdapConnection.openConnection();
			
			SearchResultEntry entry = connection.getEntry(requestDN);
			if (entry == null) {
				System.out.println(requestDN + " user:" + requestDN + " 不存在");
				return;
			}
			// 修改员工信息
			ArrayList<Modification> md = new ArrayList<Modification>();
			for(String key : data.keySet()) {
				md.add(new Modification(ModificationType.REPLACE, key, data.get(key)));
			}
			connection.modify(requestDN, md);

			System.out.println("修改用户信息成功！");
		} catch (Exception e) {
			System.out.println("修改用户信息出现错误，错误信息如下：\n" + e.getMessage());
		}
	}
	
}
