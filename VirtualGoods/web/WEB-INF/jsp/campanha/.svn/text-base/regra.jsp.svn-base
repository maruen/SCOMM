<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <table class="bordered-table">
       <thead>
         <tr>
           <th></th>
           <th>Nome</th>
           <th>Parceiro</th>
           <th>LA</th>
           <th>Keycode</th>
           <th>Sharecode</th>				            
         </tr>
       </thead>
       <tbody>
       	<c:if test="${not empty regraList}">						
			<c:forEach items="${regraList}" var="regra">
				<tr>
					<td>
						<c:if test="${campanha.regra.id == null or campanha.regra.id != regra.id }">
							<input type="radio" name="campanha.regra.id" id="campanha.regra.id" value="${regra.id}" />
						</c:if>
						<c:if test="${campanha.regra.id != null and campanha.regra.id == regra.id }">
							<input type="radio" checked="checked" name="campanha.regra.id" id="campanha.regra.id" value="${regra.id}" />
						</c:if>											
					</td>
					<td>${regra.nome}</td>
	            	<td>${regra.parceiro.nome}</td>
	            	<td>${regra.la.nome}</td>
	            	<td>${regra.keycode.nome}</td>
	            	<td>${regra.sharecodeFormat}</td>						            	
	          	</tr>
			</c:forEach>				
		</c:if>
       </tbody>
     </table>