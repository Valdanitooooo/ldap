package com.troila.openldap;

import com.unboundid.ldap.sdk.LDAPConnection;

/**
 * 
 * <b>类说明：</b><p>连接LDAP服务器</p>
 * <b>创建时间：</b><p>2017年2月21日下午3:28:32</p>
 * @author wangchao
 */
public class LdapConnection {
	// 服务器IP
	private static String ldapHost = "172.26.17.35";
	// 端口号 389为非加密端口、636为加密端口
	private static int ldapPort = 389;
	// 登录账号（管理员）
	private static String ldapBindDN = "cn=admin,dc=topenldap,dc=com";
	// 密码
	private static String ldapPassword = "123456";
	// 连接
	private static LDAPConnection connection = null;
	
	/** 连接LDAP */
	public static LDAPConnection openConnection() {
		if (connection == null) {
			try {
				connection = new LDAPConnection(ldapHost, ldapPort, ldapBindDN, ldapPassword);
				System.out.println("login ldap server successfully.");
			} catch (Exception e) {
				System.out.println("连接LDAP出现错误：\n" + e.getMessage());
			}
		}
		return connection;
	}
}
