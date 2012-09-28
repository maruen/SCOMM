<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<%@ include file="../../../header.jsp"  %>

</head>

<body>

	<%@ include file="../../../menu.jsp"  %>
	
	<div class="container">

		<div class="content">
			<!-- Forms
			================================================== -->
			<section id="forms">
			  <div class="page-header">
			    <h2>Sharecode</h2>
			  </div>
			  <div class="row">
			    <div class="span12">
			    
			    	<!-- ADICIONANDO ERROS -->
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
						<span class="label important">${error.message}</span><br />
						</c:forEach>				
					</c:if>
			    
			      <form action="<c:url value="/sharecode/save" />" method="post">
			      	<input type="hidden" name="sharecode.id" id="sharecode.id" value="${sharecode.id}">
			        <fieldset>
			          <legend>${sharecode.id == null || sharecode.id == 0 ? 'Novo Sharecode' : 'Alterar Sharecode' }</legend>
			          <div class="clearfix">
			            <label for="xlInput">Sharecode</label>
			            <div class="input">
			              <input class="xlarge" id="sharecode.nome" name="sharecode.nome" size="30" type="text" maxlength="50" value="${sharecode.nome}"/>
			            </div>
			          </div><!-- /clearfix -->
			          <div class="clearfix">
			            <label for="xlInput">Descrição</label>
			            <div class="input">
			              <input class="xlarge" id="sharecode.descricao" name="sharecode.descricao" size="30" type="text" maxlength="50" value="${sharecode.descricao}" />
			            </div>
			          </div>
			          <div class="clearfix">
			            <label for="xlInput">Tarifação</label>
			            <div class="input">
			              <input class="xlarge" id="sharecode.tarifacao" name="sharecode.tarifacao" size="30" type="text" maxlength="10" value="${sharecode.tarifacao}" />
			              <span class="help-block">Exemplo: 4.99 (Utilizar "." ponto para separação de decimal / centavos)</span>
			            </div>
			          </div>
			          <div class="clearfix">
			            <label for="normalSelect">Operadora</label>
			            <div class="input">
			            	<select name="sharecode.operadora" id="sharecode.operadora">
				                <c:forEach items="${operadoraList}" var="operadora">
								<c:if test="${sharecode.operadora == null or sharecode.operadora != operadora.carrier }">
									<option value="${operadora.carrier}">${operadora.descricao }</option>
								</c:if>
								<c:if test="${sharecode.operadora != null and sharecode.operadora == operadora.carrier }">
									<option value="${operadora.carrier}" selected="selected">${operadora.descricao }</option>
								</c:if>
								</c:forEach>                
				            </select>
			            </div>			            
			          </div><!-- /clearfix -->
			          <div class="well">
			          	<h6>Configurações Mercuri</h6>
			          	  <div class="clearfix">
				            <label for="xlInput">ServiceId</label>
				            <div class="input">
				              <input class="xlarge" id="sharecode.mercuriServiceId" name="sharecode.mercuriServiceId" size="30" type="text" maxlength="4" value="${sharecode.mercuriServiceId}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">ItemId</label>
				            <div class="input">
				              <input class="xlarge" id="sharecode.mercuriItemId" name="sharecode.mercuriItemId" size="30" type="text" maxlength="4" value="${sharecode.mercuriItemId}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">Password</label>
				            <div class="input">
				              <input class="xlarge" id="sharecode.mercuriPassword" name="sharecode.mercuriPassword" size="30" type="text" maxlength="50" value="${sharecode.mercuriPassword}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">UserName</label>
				            <div class="input">
				              <input class="xlarge" id="sharecode.mercuriUsername" name="sharecode.mercuriUsername" size="30" type="text" maxlength="50" value="${sharecode.mercuriUsername}"/>
				            </div>
				          </div><!-- /clearfix -->
				          <div class="clearfix">
				            <label for="xlInput">URL Mercuri</label>
				            <div class="input">
				              <input class="xlarge" id="sharecode.mercuriUrl" name="sharecode.mercuriUrl" size="30" type="text" maxlength="128" value="${sharecode.mercuriUrl}"/>
				              <span class="help-block">Exemplo: http://merc-inter.dc1.supp.com.br</span>
				            </div>
				          </div><!-- /clearfix -->
			          </div>
			          <div class="clearfix">
			            <label for="prependedInput2">Habilitado</label>
			            <div class="input">
			              <div class="input-prepend">
			                <label class="add-on">
			                	<c:if test="${sharecode == null or sharecode.habilitado == true}"><input type="checkbox" name="habilitado" id="habilitado" checked="checked" /></c:if>
			                	<c:if test="${sharecode != null and sharecode.habilitado == false}"><input type="checkbox" name="habilitado" id="habilitado" /></c:if>
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
		</div>

		<footer>
		<p>&copy; SupportComm 2011</p>
		</footer>

	</div>
	<!-- /container -->

</body>
</html>