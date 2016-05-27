<#include "templates/header.ftl">
<#assign spring=JspTaglibs["http://www.springframework.org/tags"] >
<br><br><br><br><br><br>
<script src="/resources/js/cart.js"></script>
<#list cart.getItems() as cart>
<#assign good = cart.getGoods()>
Название: ${good.getName()}<br>
Описание: ${good.getDescription()}<br>
Категория: ${good.getCategory().getName()}<br>
Цена: ${good.getPrice()}<br>
Количество:
<input type="number" name="quantity" placeholder="Количество"
       class="form-control input-small" id="numberProduct${good.getId()}"
       value="${cart.getNumber()}">
<button input type="submit" onclick="deleteProduct(${good.getId()})">Удалить</button>
<button onclick="changeNumberProduct(${good.getId()})">Изменить</button>
</#list>
<br>
<@spring.url var="order" value="/cart/neworder" />
<a href="${order}">Оформить заказ</a>
