$(document).ready(function(){
	$(document).bind("contextmenu",function(e){
		return false;
	});
});

function mostrarModalAgregarIncidencia(boton){
	$("#ModalCentrado").show();
	var IDIncidencia=$(boton).attr("IDIncidencia");
	$("#idIncidencia").val(IDIncidencia);
	
}
function cerrarModalAgregarIncidencia(){
	$("#ModalCentrado").hide();
}


function mostrarModal(boton){
	$("#ModalCentradoGuardar").show();
	
	var IDIncidencia=$(boton).attr("IDIncidencia");
	var IDRecepcionista=$(boton).attr("IDRecepcionista");
	var nombreRecepcionista=$(boton).attr("nombreRecepcionista");
	var IDOficina=$(boton).attr("IDOficina");
	var nombreOficina=$(boton).attr("nombreOficina");
	
	$("#idIncidenciaGuardar").val(IDIncidencia);
	$("#recepcionistaInputHiddenGuardar").val(IDRecepcionista);
	$("#oficinaInputHiddenGuardar").val(IDOficina);
	
	
	$("#numeroTicket").text(IDIncidencia);
	$("#opcionRecepcionista").attr("th:value",IDRecepcionista);
	$("#opcionRecepcionista").attr("text",nombreRecepcionista);
	$("#opcionOficina").attr("th:value",IDOficina);
	$("#opcionOficina").attr("text",nombreOficina);
	
	
	var opcionRecepcionista= new Option(nombreRecepcionista,IDRecepcionista);
	$(opcionRecepcionista).html(nombreRecepcionista);
	var opcionOficina= new Option(nombreOficina,IDOficina);
	$(opcionOficina).html(nombreOficina);
	
	$("#recepcionistaInputGuardar").empty();
	$("#recepcionistaInputGuardar").append(opcionRecepcionista);
	
	$("#oficinaInputGuardar").empty();
	$("#oficinaInputGuardar").append(opcionOficina);
	
	
}

function cerrarModalGuardarIncidencia(){
	$("#ModalCentradoGuardar").hide();
}
