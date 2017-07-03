#coding:utf-8
'''
新建条目

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
    
    # 新建条目的DN
    dn="uid=messi,ou=People,dc=topenldap,dc=com"
    
    # 条目的内容
    attrs = {}
    # 对象类
    attrs['objectclass'] = ['top','inetOrgPerson']
    # 名字
    attrs['cn'] = 'leo messi'
    # 姓
    attrs['sn'] = 'messi'
    # 工号
    attrs['employeeNumber'] = '15118'
    # 密码
    attrs['userPassword'] = '123456'
    # 备注
    attrs['description'] = 'User object for replication using slurpd'
    # 手机号
    attrs['mobileTelephoneNumber'] = '13823332333'
    
    # 使用modlist-module将我们的命令转为添加函数的良好方法
    ldif = modlist.addModlist(attrs)
    
    # 对ldap服务器执行同步的添加操作
    l.add_s(dn,ldif)
    
    # 断开服务器连接释放资源
    l.unbind_s()
except ldap.LDAPError, e:
    print e