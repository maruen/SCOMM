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
			    <h2>Parceiro</h2>
			  </div>
			  <div class="row">
			    <div class="span12">
			    
			    	<!-- ADICIONANDO ERROS -->
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
						<span class="label important">${error.message}</span><br />
						</c:forEach>				
					</c:if>
			    
			      <form action="<c:url value="/parceiro/save" />" method="post">
			      	<input type="hidden" name="parceiro.id" id="parceiro.id" value="${parceiro.id}">
			        <fieldset>
			          <legend>${parceiro.id == null || parceiro.id == 0 ? 'Novo Parceiro' : 'Alterar Parceiro' }</legend>
			          <div class="clearfix">
			            <label for="xlInput">Nome</label>
			            <div class="input">
			              <input class="xlarge" id="parceiro.nome" name="parceiro.nome" size="30" type="text" maxlength="50" value="${parceiro.nome}"/>
			            </div>
			          </div><!-- /clearfix -->
			          <div class="clearfix">
			            <label for="xlInput">Nome Performance</label>
			            <div class="input">
			              <input class="xlarge" id="parceiro.nomePerformance" name="parceiro.nomePerformance" size="30" type="text" maxlength="50" value="${parceiro.nomePerformance}" />
			            </div>
			          </div>
			          <div class="clearfix">
			            <label for="xlInput">Qtd Retentativa</label>
			            <div class="input">
			              <input class="xlarge" id="parceiro.retentativa" name="parceiro.retentativa" size="30" type="text" maxlength="4" value="${parceiro.retentativa}" />
			            </div>
			          </div>
			          
			          <div class="clearfix">
			            <label for="xlInput">Schedule</label>
			            <div class="input">
			              <input class="xlarge" id="parceiro.timeSchedule" name="parceiro.timeSchedule" size="30" type="text" maxlength="4" value="${parceiro.timeSchedule}" />
			              <span class="help-block">Tempo em (MINUTOS)</span>
			            </div>			            
			          </div>
			          
			          <div class="clearfix">
			            <label for="xlInput">Tamanho do Voucher</label>
			            <div class="input">
			              <input class="xlarge" id="parceiro.voucherSize" name="parceiro.voucherSize" size="30" type="text" maxlength="4" value="${parceiro.voucherSize}" />
			              <span class="help-block">Número de caracteres do voucher</span>
			            </div>			            
			          </div>
			          
			          <div class="clearfix">
			            <label for="multiSelect">LA</label>
			            <div class="input">
			            	<select class="medium" size="5" multiple="multiple" name="las" id="las">
		            		<c:if test="${not empty laList}">
		            		<c:forEach items="${laList}" var="la">
		            			<c:if test="${la.selected}"><option value="${la.id}" selected="selected">${la.nome }</option></c:if>
								<c:if test="${not la.selected}"><option value="${la.id}">${la.nome }</option></c:if>								
							</c:forEach>
							</c:if>
							</select>			            
			              <span class="help-block">Para selecionar mais de um LA mantenha a tecla CTRL pressionada e selecione os LA's</span>
			            </div>			            
			          </div><!-- /clearfix -->
			          
			          <div class="clearfix">
			            <label for="xlInput">Login WebService</label>
			            <div class="input">
			              <input class=small id="parceiro.voucherWSLogin" name="parceiro.voucherWSLogin" size="30" type="text" maxlength="12" value="${parceiro.voucherWSLogin}" />
			              <span class="help-block">Login de acesso ao Web Service de consulta e atualização de Voucher.</span>
			            </div>			            
			          </div>
			          
			          <div class="clearfix">
			            <label for="xlInput">Senha WebService</label>
			            <div class="input">
			              <input class="small" id="parceiro.voucherWSPasswd" name="parceiro.voucherWSPasswd" size="30" type="text" maxlength="12" value="${parceiro.voucherWSPasswd}" />
			              <span class="help-block">Senha de acesso ao Web Services, máximo de 12 caracteres</span>
			            </div>			            
			          </div>
			          
			          			          
			          <div class="clearfix">
			            <label for="prependedInput2">Habilitado</label>
			            <div class="input">
			              <div class="input-prepend">
			                <label class="add-on">
			                	<c:if test="${parceiro == null or parceiro.habilitado == true}"><input type="checkbox" name="habilitado" id="habilitado" checked="checked" /></c:if>
			                	<c:if test="${parceiro != null and parceiro.habilitado == false}"><input type="checkbox" name="habilitado" id="habilitado" /></c:if>
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