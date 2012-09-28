<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal-header">
  <a href="#" class="close">&times;</a>
  <h3>Excluir Regra</h3>
</div>
<div class="modal-body">
  <p>Tem certeza que deseja excluir a Regra ${regra.nome}?</p>
</div>
<div class="modal-footer">
  <a href="<c:url value="/regra/excluir/${regra.id}" />" class="btn primary">Confirmar</a>
  <a href="#" onclick="javascript:$('#modal-excluir').modal('hide')" class="btn secondary">Cancelar</a>
</div>