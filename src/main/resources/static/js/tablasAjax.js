function enviarBusqueda() {
	var idLugarIncidencia = $("#seleccionLugarIncidencia").val();
	var problema = $("#problemaPalabraClave").val();
	var idEquipo = $("#seleccionEquipo").val();
	//alert('idLugarIncidencia: ' + idLugarIncidencia + '. Problema: ' + problema+ '.')
	$.ajax({
		type : 'POST',
		url : '/ajax/mostrarIncidencias',	//En local va en ->'/sisgiste/ajax/mostrarIncidencias'
		data : {
			idLugarIncidencia : idLugarIncidencia,
			problema : problema,
			idEquipo : idEquipo
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