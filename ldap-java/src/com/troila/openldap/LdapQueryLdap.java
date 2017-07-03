package com.troila.openldap;

import java.util.Collection;

import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.controls.SubentriesRequestControl;

/**
 * 查询
 * 2016年12月16日上午9:50:21
 * @author wangchao
 */
public class LdapQueryLdap {

	public static void queryLdap(String searchDN, String filter) {
		try {
			// 连接LDAP
			LDAPConnection connection = LdapConnection.openConnection();
			
			// 查询企业所有用户 
			//SearchScope.BASE表示只把基准DN作为搜索对象。
			//SearchScope.ONE表示把基准DN的第一层子结点作为搜索对象，而基准DN不在其中。
			//SearchScope.SUB表示把基准DN及其以下的整棵子树都作为搜索对象。
			SearchRequest searchRequest = new SearchRequest(searchDN, SearchScope.SUB, "(" + filter + ")");
			searchRequest.addControl(new SubentriesRequestControl());
			SearchResult searchResult = connection.search(searchRequest);
			System.out.println(">>>共查询到" + searchResult.getSearchEntries().size() + "条记录");
			int index = 1;
			for (SearchResultEntry entry : searchResult.getSearchEntries()) {
				System.out.println((index++) + "\t" + entry.getDN());
				System.out.println("|---- Attributes list: ");
				// 获取各字段的值
				Collection<Attribute> attributes = entry.getAttributes();
				for (Attribute attribute : attributes) {
					System.out.println("|---- ---- " + attribute.getName() + " = " + attribute.getValue());
				}
				// 获取指定字段的值
//				if (entry.hasAttribute("userPassword")) {
//					System.out.println("userPassword=" + entry.getAttributeValue("userPassword"));
//				}
			}
		} catch (Exception e) {
			System.out.println("查询错误，错误信息如下：\n" + e.getMessage());
		}
	}
	
}
