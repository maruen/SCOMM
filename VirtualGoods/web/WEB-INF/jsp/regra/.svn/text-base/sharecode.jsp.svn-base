<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <c:if test="${not empty sharecodeList and qtd > 1}">
    	<select name="sharecode" id="sharecode">
        <option value="">selecione...</option>                
        <c:forEach items="${sharecodeList}" var="sharecode">
        	<c:if test="${shareSelected == null or shareSelected != sharecode.id }">
				<option value="${sharecode.id}">${sharecode.nome }</option>
			</c:if>
			<c:if test="${shareSelected != null and shareSelected == sharecode.id }">
				<option value="${sharecode.id}" selected="selected">${sharecode.nome }</option>
			</c:if>        	
		</c:forEach> 
    	</select>
    </c:if>
    <c:if test="${not empty sharecodeList and qtd == 1}">
    	<c:forEach items="${sharecodeList}" var="sharecode">
    		<input class="xlarge" id="" name="" disabled="disabled" size="30" type="text" maxlength="50" value="${sharecode.nome}"/>
    		<input type="hidden" name="sharecode" id="sharecode" value="${sharecode.id}" />
    	</c:forEach>
    </c:if>    