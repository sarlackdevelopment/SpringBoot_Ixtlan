<#import "parts/common.ftl" as c>

<@c.page>

<form method="post" enctype="multipart/form-data">
  <input type="file" name="file">
  <input type="hidden" name="_csrf" value="${_csrf.token}" />
  <button class="btn btn-primary" type="submit">Добавить файл</button>
</form>

</@c.page>