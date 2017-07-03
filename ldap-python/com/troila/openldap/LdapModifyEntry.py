#coding:utf-8
'''
编辑条目

@author:     wangchao
'''

import ldap
import ldap.modlist as modlist

try:
    # 连接ldap服务器l = ldap.initialize("ldaps://172.26.17.35.topenldap.com:389/")
    l = ldap.open("172.26.17.35")
    l.protocol_version = ldap.VERSION3
    # 绑定管理员帐号
    l.simple_bind_s("cn=admin,dc=topenldap,dc=com","123456")
    
    # 要编辑的DN
    dn="uid=messi,ou=People,dc=topenldap,dc=com" 
    
    # 旧值和新值
    old = {'description':'User object for replication using slurpd'}
    new = {'description':'Bind object used for replication using slurpd'}
    
    ldif = modlist.modifyModlist(old,new)
    
    l.modify_s(dn,ldif)
    
    l.unbind_s()
except ldap.LDAPError, e:
    print e

