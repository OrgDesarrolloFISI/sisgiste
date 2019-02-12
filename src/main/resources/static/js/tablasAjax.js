function enviarBusqueda() {
	var idLugarIncidencia = $("#seleccionLugarIncidencia").val();
	var problema = $("#problemaPalabraClave").val();
	//alert('idLugarIncidencia: ' + idLugarIncidencia + '. Problema: ' + problema+ '.')
	$.ajax({
		type : 'POST',
		url : '/sisgiste/ajax/mostrarIncidencias',
		data : {
			idLugarIncidencia : idLugarIncidencia,
			problema : problema
		},
		success : function(data) {
			//alert(data);
			$("#tabla").html(data);
		},
		error : function(e) {
			alert("Error " + e);
		}
	});
};

$("#formularioProblema").submit(function(e) {
    e.preventDefault();
});