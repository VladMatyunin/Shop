<#include "templates/header.ftl">
<#assign spring=JspTaglibs["http://www.springframework.org/tags"] >
<body>
<br><br><br><br><br><br>
<div class="row container marketing" style="background-color: #002400">
<#--<#list catalog as cat>-->
        <#--${cat.getCategory()}-->
    <#--<div class="col-lg-4"-->
<#--<#if cat.getGoods()??>-->
        <#--<#list cat.goods as goodList>-->
            <#--Название: ${goodList.getName()}<br>-->
            <#--Описание: ${goodList.getDescription()}<br>-->
            <#--Категория: ${goodList.getCategory().getName()}<br>-->
            <#--Цена: ${goodList.getPrice()}<br>-->
        <#--</#list>-->
<#--</#if>-->
    <#--</div>-->
<#--</#list>-->


</div>


<div class="container">


    <@spring.url var="firstUrl" value="/catalog/1" />
    <@spring.url var="lastUrl" value="/catalog/${totalPages}" />
    <@spring.url var="prevUrl" value="/catalog/${page - 1}" />
    <@spring.url var="thisUrl" value="/catalog/${page}" />
    <@spring.url var="nextUrl" value="/catalog/${page + 1}" />

    <@spring.url var="ByCost" value="/catalog/sort/cost" />
    <@spring.url var="ByName" value="/catalog/sort/name" />
    <@spring.url var="ByCategory" value="/catalog/sort/category" />
    <@spring.url var="ByStock" value="/catalog/sort/stock" />

    <a href="${ByCost}">SortByCost</a> | <a href="${ByName}">SortByName</a> | <a href="${ByCategory}">SortByCategory</a> | <a href="${ByCost}">StockSort</a>
        <#list catalog as goodList>
            Название: ${goodList.getName()}<br>
            Описание: ${goodList.getDescription()}<br>
            Категория: ${goodList.getCategory().getName()}<br>
            Цена: ${goodList.getPrice()}<br>
            <@spring.url var="view" value="/view/${goodList.getId()}" />
            <@spring.url var="add_cart" value="/cart/add/${goodList.getId()}" />
            <a href="${view}">Просмотреть</a>
            <a href="${add_cart}">Добавить в корзину</a>
        </#list>
    </div>
<a href="${firstUrl}">1</a> | <a href="${prevUrl}">${page-1}</a> | <a href="${thisUrl}">${page}</a> | <a href="${nextUrl}">${page+1}</a> |  <a href="${lastUrl}">${totalPages}</a>
</body>