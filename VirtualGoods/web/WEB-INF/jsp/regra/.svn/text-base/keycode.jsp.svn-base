<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <select name="regra.keycode.id" id="regra.keycode.id">
        <option value="">selecione...</option>                
        <c:forEach items="${keycodeList}" var="keycode">
        	<c:if test="${regra.keycode.id == null or regra.keycode.id != keycode.id }">
				<option value="${keycode.id}">${keycode.nome }</option>
			</c:if>
			<c:if test="${regra.keycode.id != null and regra.keycode.id == keycode.id }">
				<option value="${keycode.id}" selected="selected">${keycode.nome }</option>
			</c:if>
		</c:forEach> 
    </select>