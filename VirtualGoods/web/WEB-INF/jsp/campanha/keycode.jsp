<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <select name="keycode.id" id="keycode.id" onchange="select()">
        <option value="0">Selecione...</option>                
        <c:forEach items="${keycodeList}" var="keycode">
        	<c:if test="${keycode_selected.id == keycode.id}">
        		<option value="${keycode.id}" selected="selected">${keycode.nome }</option>
        	</c:if>
        	<c:if test="${keycode_selected.id != keycode.id}">
        		<option value="${keycode.id}">${keycode.nome }</option>
        	</c:if>
		</c:forEach> 
    </select>