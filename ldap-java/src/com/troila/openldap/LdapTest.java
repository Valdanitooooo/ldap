package com.troila.openldap;

import java.util.ArrayList;
import java.util.HashMap;

import com.unboundid.ldap.sdk.Attribute;

/**
 * test
 * 2016年12月16日上午9:52:36
 * @author wangchao
 */
public class LdapTest {

	public static void main(String[] args) {
		String root = "com";
		String dc = "topenldap";
//		String ou = "People";
//		String uid = "timfox";
		String filter = "objectClass=*";
		
		
//		 HashMap<String,String> data = new HashMap<String,String>(0);
//         data.put("userPassword", "123456");
//         data.put("cn", "wangchao");
//         data.put("uid", "user03");  
	          
//	      修改用户信息
//	     LdapModifyEntry.modifyEntry("uid=" + uid + ",ou=" + ou + ",dc=" + dc + ",dc=" + root, data);
		
//	     //查询用户信息
        LdapQueryLdap.queryLdap("dc=" + dc + ",dc=" + root, filter);
        
//		创建用户
//        ArrayList<Attribute> attributes = new ArrayList<Attribute>();
//        attributes.add(new Attribute(
//                        "objectClass" 
//                        , "top"
//                        , "inetOrgPerson"//企业职工对象类
//                ));
//        attributes.add(new Attribute("uid", uid));//用户名
//        attributes.add(new Attribute("cn", "Tim Fox"));//姓名
//        attributes.add(new Attribute("sn", "Fox"));//姓
//        attributes.add(new Attribute("employeeNumber", "15116"));//工号
//        attributes.add(new Attribute("userPassword", "123456"));//密码
//        attributes.add(new Attribute("description", "hahaha"));//备注
//        attributes.add(new Attribute("mobileTelephoneNumber", "15202281000"));//移动电话
//        
//		LdapCreateEntry.createEntry("ou=" + ou + ",dc=" + dc + ",dc=" + root, uid, attributes);
		
		
//      //删除用户信息
//    LdapDeleteEntry.deleteEntry("uid=" + uid + ",ou=" + ou + ",dc=" + dc + ",dc=" + root);
//    LdapDeleteEntry.deleteEntry("cn=zhangsan,ou=" + ou + ",dc=" + dc + ",dc=" + root);
    

		
		
//      //创建代理商
//    createDC("dc=" + root, dc);
      
//    //创建组
//    createO("dc=" + dc + ",dc=" + root, o);
      
//    //创建组织单元
//    LdapCreateOU.createOU("dc=" + dc + ",dc=" + root, ou);
	}
	
}
