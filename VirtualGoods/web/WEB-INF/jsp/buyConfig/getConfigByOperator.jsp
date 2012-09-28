<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="br.com.supportcomm.virtualgoodscore.pojo.BuyConfig" %>

<c:choose>
	<c:when test="${buyConfig.mesCorrenteAtivo == 1 }">
		<c:set var="currentMonthChecked" value="checked=\"checked\""/>
		<c:set var="numberOfDaysChecked" value=""/>
	</c:when>
	
	<c:otherwise>
		<c:set var="currentMonthChecked" value=""/>
		<c:set var="numberOfDaysChecked" value="checked=\"checked\""/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${buyConfig.codConfigAtivo == 1}">
		<c:set var="enabledChecked" value="checked"/>
	</c:when>
	<c:otherwise>
		<c:set var="enabledChecked" value=""/>
	</c:otherwise>
</c:choose>

<div class="clearfix">
	<label for="xlInput">Limitar por</label>
	<div class="input">
		<input type="radio" name=buyConfig.mesCorrenteAtivo id="buyConfig.mesCorrenteAtivo" ${currentMonthChecked} value="1"/>&nbsp;Mês Corrente
	</div>	
	
	<div class="input" >
		<input type="radio" name=buyConfig.mesCorrenteAtivo id="buyConfig.mesCorrenteAtivo" ${numberOfDaysChecked} value="0" />&nbsp;Número de dias
		&nbsp;
		<input class="mini" type="text" name="buyConfig.nuDias" id="buyConfig.nuDias" size="3" maxlength="3" value="${buyConfig.nuDias}" />
	</div>
</div>

<div class="clearfix">
	<label for="xlInput">Valor máximo R$</label>
	<div class="input" >
		<input class="mini" id="buyConfig.vlMax" name="buyConfig.vlMax" type="text" maxlength="10" value="${buyConfig.vlMax}" />
		<span class="help-block">Exemplo: 40.99 (Utilizar "." ponto para separação de decimal / centavos)</span>
	</div>
</div>

<div class="clearfix">
	<label for="xlInput">Mensagem</label>
	<div class="input">
		<textarea style="width: 500px; height: 82px;" id="buyConfig.msgLimiteExcedido" name="buyConfig.msgLimiteExcedido">${buyConfig.msgLimiteExcedido}</textarea>
	</div>
</div>

<div class="clearfix">
	<label for="xlInput">Habilitado</label>
	<div class="input">
		<div class="input-prepend">
			<label class="add-on">
				<input type="checkbox" ${enabledChecked} name="buyConfig.codConfigAtivo" id="buyConfig.codConfigAtivo" value="1" />
			</label>
		</div>
	</div>
</div>

