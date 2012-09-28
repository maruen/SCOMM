<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <select name="regra.la.id" id="regra.la.id">
        <option value="">selecione...</option>                
        <c:forEach items="${laList}" var="la">
        	<c:if test="${regra.la.id == null or regra.la.id != la.id }">
				<option value="${la.id}">${la.nome }</option>
			</c:if>
			<c:if test="${regra.la.id != null and regra.la.id == la.id }">
				<option value="${la.id}" selected="selected">${la.nome }</option>
			</c:if>			
		</c:forEach> 
    </select>