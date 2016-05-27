<#include "templates/header.ftl">
<br><br><br><br><br><br>
<#list orders as orderlist>
    <#list orderlist.getItems() as orderitem>
        <#assign good = orderitem.getGoods()>
    Название: ${good.getName()}<br>
    Описание: ${good.getDescription()}<br>
    Категория: ${good.getCategory().getName()}<br>
    Цена: ${good.getPrice()}<br>
    Количество:
    </#list>
</#list>