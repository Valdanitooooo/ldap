package com.troila.openldap;

import java.util.ArrayList;

import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.SearchResultEntry;

/**
 * 创建用户
 * 2016年12月16日上午9:49:05
 * @author wangchao
 */
public class LdapCreateEntry {
	
	public static void createEntry(String baseDN, String uid, ArrayList<Attribute> attributes) {
		String entryDN = "uid=" + uid + "," + baseDN;
		try {
			// 连接LDAP
			LDAPConnection connection = LdapConnection.openConnection();
			
			SearchResultEntry entry = connection.getEntry(entryDN);
			if (entry == null) {
				// 不存在则创建
				connection.add(entryDN, attributes);
				System.out.println("创建用户" + entryDN + "成功！");
			} else {
				System.out.println("用户" + entryDN + "已存在！");
			}
		} catch (Exception e) {
			System.out.println("创建用户出现错误，错误信息如下：\n" + e.getMessage());
		}
	}
	
}
