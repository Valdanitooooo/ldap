#coding:utf-8
'''
搜索条目

@author:     wangchao
'''

import ldap

try:
    l = ldap.open("172.26.17.35")
    l.protocol_version = ldap.VERSION3
    baseDN = "dc=topenldap,dc=com"
    # LDAP搜索作用域：SCOPE_BASE（对象本身）、
    # SCOPE_ONELEVEL（对象的直接子项）、SCOPE_SUBTREE（对象及其所有后代）
    searchScope = ldap.SCOPE_SUBTREE
    # 检索所有属性
    retrieveAttributes = None 
    searchFilter = "cn=*"
    
    ldap_result_id = l.search(baseDN, searchScope, searchFilter, retrieveAttributes)
    result_set = []
    while 1:
        result_type, result_data = l.result(ldap_result_id, 0)
        if (result_data == []):
            break
        else:
            if result_type == ldap.RES_SEARCH_ENTRY:
                result_set.append(result_data)
    print result_set
    
    l.unbind_s()
except ldap.LDAPError, e:
    print e