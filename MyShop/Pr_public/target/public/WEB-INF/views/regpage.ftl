<html>
<#include "templates/header.ftl">
<br><br><br><br><br><br>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] >
<@form.form commandName = "regForm"  action = "/reg" method = "post" >
<div class="container">
    <h1 class="form-signin-heading">Регистрация</h1>
    <h2 class="form-signin-heading">Обязательные поля*</h2>
    <span class="checkbox"> Имя</span>
    <@form.input path="username" cssClass="form-control"  />
    <@form.errors path="username" cssStyle="color: red;" />
    <label class="checkbox">Фамилия</label>
    <@form.input path="surname" cssClass="form-control"  />
    <@form.errors path="surname" cssStyle="color: red;" />
    <label class="checkbox">Почта</label>
    <@form.input path="mail" cssClass="form-control"  />
    <@form.errors path="mail" cssStyle="color: red;" />
    <h3>Придумайте пароль</h3>
    <label class="checkbox">Пароль</label>
    <@form.password path="password" cssClass="form-control" />
    <@form.errors path="password" cssStyle="color: red;" />
    <label class="checkbox">Подтвердите Пароль</label>
    <@form.password path="confirmpass" cssClass="form-control"/>
    <@form.errors path="confirmpass" cssStyle="color: red;" />
    <h2 class="form-signin-heading">Прочее</h2>
    <label class="checkbox">Возраст</label>
    <@form.input path="age" cssClass="form-control" />
    <@form.errors path="age" cssStyle="color: red;" />
    <label class="checkbox">Город</label>
    <@form.input path="city" cssClass="form-control" />
    <@form.errors path="city" cssStyle="color: red;" />
    <label class="checkbox">Телефон</label>
    <@form.input path="phone" cssClass="form-control" />
    <@form.errors path="phone" cssStyle="color: red;" />
    <label class="checkbox">
        <@form.checkbox path="checked"/> Я согласен с условиями пользования
        <@form.errors path="checked" cssStyle="color: red;" />
    </label>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Регистрация</button>
</div>
</@form.form>

<#include "templates/footer.ftl">
</html>