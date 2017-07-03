package com.troila.openldap;

import java.util.ArrayList;

import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.SearchResultEntry;

/**
 * 创建组织
 * 2016年12月16日上午9:45:59
 * @author wangchao
 */
public class LdapCreateO {
	
	public static void createO(String baseDN, String o) {
		String entryDN = "o=" + o + "," + baseDN;
		try {
			// 连接LDAP
			LDAPConnection connection = LdapConnection.openConnection();
			
			SearchResultEntry entry = connection.getEntry(entryDN);
			if (entry == null) {
				// 不存在则创建
				ArrayList<Attribute> attributes = new ArrayList<Attribute>();
				attributes.add(new Attribute("objectClass", "top", "organization"));
				attributes.add(new Attribute("o", o));
				connection.add(entryDN, attributes);
				System.out.println("创建组织" + entryDN + "成功！");
			} else {
				System.out.println("组织" + entryDN + "已存在！");
			}
		} catch (Exception e) {
			System.out.println("创建组织出现错误，错误信息如下：\n" + e.getMessage());
		}
	}
	
}
