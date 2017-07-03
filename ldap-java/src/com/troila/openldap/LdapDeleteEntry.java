package com.troila.openldap;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.SearchResultEntry;

/**
 * 删除用户信息
 * 2016年12月16日上午9:52:06
 * @author wangchao
 */
public class LdapDeleteEntry {

	public static void deleteEntry(String requestDN) {
		try {
			// 连接LDAP
			LDAPConnection connection = LdapConnection.openConnection();
			
			SearchResultEntry entry = connection.getEntry(requestDN);
			if (entry == null) {
				System.out.println(requestDN + " user:" + requestDN + " 不存在");
				return;
			}

			// 删除员工信息
			connection.delete(requestDN);

			System.out.println("删除用户信息成功！");
		} catch (Exception e) {
			System.out.println("删除用户信息出现错误，错误信息如下：\n" + e.getMessage());
		}
	}
	
}
