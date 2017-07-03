#coding:utf-8
#!/usr/bin/python –u
'''
连接ldap

@author:     wangchao
'''

import ldap
try:
    l = ldap.open("172.26.17.35")
    
    #如果使用的是v2版本就用ldap.VERSION2
    l.protocol_version = ldap.VERSION3    

    
    username = "cn=admin, dc=topenldap, dc=com"
    password  = "123456"

    l.simple_bind(username, password)
except ldap.LDAPError, e:
    print e