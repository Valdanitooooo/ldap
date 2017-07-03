package com.troila.openldap;

import java.util.ArrayList;

import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.SearchResultEntry;
/**
 * 创建代理商
 * 2016年12月16日上午9:44:27
 * @author wangchao
 */
public class LdapCreateDC {
	
	public static void createDC(String baseDN, String dc) {
		String entryDN = "dc=" + dc + "," + baseDN;
		try {
			// 连接LDAP
			LDAPConnection connection = LdapConnection.openConnection();
			
			SearchResultEntry entry = connection.getEntry(entryDN);
			if (entry == null) {
				// 不存在则创建
				ArrayList<Attribute> attributes = new ArrayList<Attribute>();
				attributes.add(new Attribute("objectClass", "top", "organization", "dcObject"));
				attributes.add(new Attribute("dc", dc));
				attributes.add(new Attribute("o", dc));
				connection.add(entryDN, attributes);
				System.out.println("创建代理商" + entryDN + "成功！");
			} else {
				System.out.println("代理商" + entryDN + "已存在！");
			}
		} catch (Exception e) {
			System.out.println("创建代理商出现错误，错误信息如下：\n" + e.getMessage());
		}
	}
	
}
