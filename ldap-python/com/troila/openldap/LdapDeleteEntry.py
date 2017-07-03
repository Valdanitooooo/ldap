#coding:utf-8
'''
新建条目

@author:     wangchao
'''

import ldap

try:
    # 连接ldap服务器l = ldap.initialize("ldaps://172.26.17.35.topenldap.com:389/")
    l = ldap.open("172.26.17.35")
    l.protocol_version = ldap.VERSION3
    # 绑定管理员帐号
    l.simple_bind_s("cn=admin,dc=topenldap,dc=com","123456")
    
    # 要删除的DN
    deleteDN = "uid=timfox, ou=People,dc=topenldap,dc=com"
    l.delete_s(deleteDN)
    
    l.unbind_s()
except ldap.LDAPError, e:
    print e



