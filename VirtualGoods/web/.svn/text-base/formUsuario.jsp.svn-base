<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Forms
================================================== -->
<section id="forms">
  <div class="page-header">
    <h2>Usuários</h2>
  </div>
  <div class="row">
    <div class="span12">
    
    	<!-- ADICIONANDO ERROS -->
		<c:if test="${not empty errors}">
			<c:forEach items="${errors}" var="error">
			<span class="label important">${error.message}</span><br />
			</c:forEach>				
		</c:if>
    
      <c:if test="${usuario.id == null or usuario.id == 0}"><form action="<c:url value="/usuario/save" />" method="post"></c:if>
      <c:if test="${usuario.id != null and usuario.id != 0}"><form action="<c:url value="/usuario/update" />" method="post"></c:if>
      	<input type="hidden" name="usuario.id" id="usuario.id" value="${usuario.id}">
        <fieldset>
          <legend>${usuario.id == null || usuario.id == 0 ? 'Novo Usuário' : 'Alterar Usuário' }</legend>
          <div class="clearfix">
            <label for="xlInput">Nome</label>
            <div class="input">
              <input class="xlarge" id="usuario.nome" name="usuario.nome" size="30" type="text" maxlength="50" value="${usuario.nome}"/>
            </div>
          </div><!-- /clearfix -->
          <div class="clearfix">
            <label for="xlInput">Login</label>
            <div class="input">
              <input class="xlarge" id="usuario.login" name="usuario.login" size="30" type="text" maxlength="50" value="${usuario.login}" />
            </div>
          </div>
          <div class="clearfix">
            <label for="prependedInput">E-mail</label>
            <div class="input">
              <div class="input-prepend">
                <span class="add-on">@</span>
                <input class="xlarge" id="usuario.email" name="usuario.email" size="30" type="text" maxlength="128" value="${usuario.email}" />
              </div>
              <span class="help-block">Exemplo: sac@supportcomm.com.br</span>
            </div>
          </div><!-- /clearfix -->
          <!-- <div class="clearfix">
            <label for="xlInput">Password</label>
            <div class="input">
              <input class="xlarge" id="usuario.senha" name="usuario.senha" size="30" type="password" maxlength="50" />
            </div>
          </div> -->
          <div class="clearfix">
            <label for="normalSelect">Perfil</label>
            <div class="input">
              <select name="usuario.perfil" id="usuario.perfil">
                <option value="Administrador">Administrador</option>
                <c:if test="${usuario.perfil == null || usuario.perfil eq 'Administrador' }"><option value="Operador">Operador</option></c:if>
                <c:if test="${usuario.perfil != null && usuario.perfil eq 'Operador' }"><option value="Operador" selected="selected">Operador</option></c:if>                
              </select>
            </div>
          </div><!-- /clearfix -->
          <div class="clearfix">
            <label for="prependedInput2">Habilitado</label>
            <div class="input">
              <div class="input-prepend">
                <label class="add-on">
                	<c:if test="${usuario == null or usuario.habilitado == true}"><input type="checkbox" name="habilitado" id="habilitado" checked="checked" /></c:if>
                	<c:if test="${usuario != null and usuario.habilitado == false}"><input type="checkbox" name="habilitado" id="habilitado" /></c:if>
                </label>                
              </div>
            </div>
          </div><!-- /clearfix -->
          
          <div class="actions">
            <input type="submit" class="btn primary" value="Salvar">&nbsp;
          </div>
        </fieldset>
      </form>
    </div>
  </div><!-- /row -->
</section>