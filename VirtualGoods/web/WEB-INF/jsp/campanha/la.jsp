<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <select name="la.id" id="la.id" onchange="select()">
        <option value="0">Selecione...</option>                
        <c:forEach items="${laList}" var="la">
        	<c:if test="${la_selected.id == la.id}">
        		<option value="${la.id}" selected="selected">${la.nome}</option>
        	</c:if>
        	<c:if test="${la_selected.id != la.id}">
        		<option value="${la.id}">${la.nome}</option>
        	</c:if>
		</c:forEach> 
    </select>