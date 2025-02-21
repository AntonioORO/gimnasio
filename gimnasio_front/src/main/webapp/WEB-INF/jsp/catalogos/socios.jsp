
<!-- Page-header start -->
<div class="page-header">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline">
					<h4>Socios</h4>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item" style="float: left;"><a
						href="index.html"> <i class="feather icon-box"></i>
					</a></li>
					<li class="breadcrumb-item" style="float: left;"><a href="#!">Catálogos</a>
					</li>
					<li class="breadcrumb-item" style="float: left;"><a href="#!">Socios</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->


<div class="page-body">
	<div class="row" id="row-get-all">
		<div class="card">
			<div class="card-block">
				<div class="col-sm-12">
					<button class="btn btn-primary btn-outline-primary"
						style="float: right;" onclick="nuevaMembresia()">
						<i class="fa fa-plus"></i>Nuevo
					</button>
					<br /> <br /> <br />
				</div>
				<div class="dt-responsive table-responsive">
					<table id="tablaprincipal" class="table table-striped  nowrap"
						style="width: 100%;">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Apellido paterno</th>
								<th>Apellido materno</th>
								<th>Inicio membresía</th>
								<th>fin membresía</th>
								<th>Entrenador</th>
								<th width="10px">Acción</th>
							</tr>
						</thead>
						<tbody id="cont-tabla">


						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<div class="row" id="row-new" style="display: none">

		<div class="card">
			<div class="card-header">
				<h5 id="titleAddUpdate">Nuevo socio</h5>
			</div>
			<div class="card-block">
				<div class="row">
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="nombre" class="form-label block">Nombre
								(*):</label>
						</div>
						<div class="col-sm-12">
							<input id="nombre" name="nombre" type="text"
								class=" form-control" maxlength="50" >
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="apaterno" class="form-label block">Apellido
								paterno (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="apaterno" name="apaterno" type="text"
								class=" form-control" maxlength="50">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="amaterno" class="form-label block">Apellido
								materno (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="amaterno" name="amaterno" type="text"
								class=" form-control" >
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="fecha-nacimiento" class="form-label block">Fecha
								Nacimiento (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="fecha-nacimiento" name="fecha-nacimiento"  type="date" 
								class=" form-control" maxlength="50">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="membresia" class="form-label block">Membresia
								(*):</label>
						</div>
						<div class="col-sm-12">
							<select class="js-membresias col-sm-12" id="membresia"></select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="userName-2" class="form-label block">Inicio
								de membresía:</label>
						</div>
						<div class="col-sm-12">
							<input class="form-control" type="date" id="inicio-membresia" />
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="costo-membresia" class="form-label block">Entrenador
								(*):</label>
						</div>
						<div class="col-sm-12">
							<select class="js-entredadores col-sm-12" id="entrenador">
							</select>
						</div>
					</div>
				</div>

				<br /> <br />
				<div class="row">
					<br /> <br />
					<center>
						<button onclick="listaMembresia()"
							class="btn btn-primary btn-square">Cancelar</button>
						&nbsp;
						<button onclick="guardarSocio()"
							class="btn btn-success btn-square">Guardar</button>
					</center>

				</div>
			</div>
		</div>
	</div>
</div>





<script>
	var arrProducts;
	var idRegistro = null;
	function getAll() {
		preload();
		$
				.ajax({
					url : '${contextPath}/catalogo/socios/getAll',
					type : 'GET',
					dataType : 'json',
					contentType : 'application/json',
					async : false,
					success : function(response) {
						postload();
						if (response.codigo == 0) {
							var contTabla = '';
							arrProducts = response.data;

							$
									.each(
											arrProducts,
											function(index, value) {
												contTabla += '<tr>';
												contTabla += '<td>'
														+ value.nombre
														+ '</td>';
												contTabla += '<td>'
														+ value.apaterno
														+ '</td>';
												contTabla += '<td>'
														+ value.amaterno
														+ '</td>';
												contTabla += '<td>'
														+ value.inicio_membresia
														+ '</td>';
												contTabla += '<td>'
														+ value.fin_membresia
														+ '</td>';
												contTabla += '<td>'
														+ value.usuario_responsable
														+ '</td>';

												contTabla += '<td>';
												contTabla += '<center>';
												contTabla += '<button class="btn btn-primary btn-outline-primary fa fa-pencil"';
												contTabla += 'title="Editar" onclick="editarRegistro('
														+ value.id
														+ ')"></button>';
												contTabla += '<button class="btn btn-warning btn-outline-warning fa fa-trash"';
												contTabla += 'title="Eliminar" onclick="eliminarRegistro('
														+ value.id
														+ ',\''
														+ value.nombre+' '+ value.apaterno+' '+value.amaterno
														+ '\')"></button>';
												contTabla += '</center>';
												contTabla += '</td>';
												contTabla += '</tr>';
											});

							$('#cont-tabla').html(contTabla);
							$('#tablaprincipal').DataTable({
								"ordering" : true
							});

						}
					},
					error : function() {
						postload();
					}
				});

	}

	function consultaEntrenadores() {
		var entrenadores = [];
		entrenadores.push({
			"id" : 0,
			"text" :"----Seleccione----"
		});
		$.ajax({
			url : '${contextPath}/catalogo/usuarios/getUserParaSocio',
			type : 'GET',
			dataType : 'json',
			contentType : 'application/json',
			async : false,
			success : function(response) {
				postload();
				if (response.codigo == 0) {
					var contTabla = '';
					arrProducts = response.data;
					$.each(arrProducts, function(index, value) {
						console.log("value->" + value);
						entrenadores.push({
							"id" : value.id,
							"text" : value.usuario
						});

					});
					$(".js-entredadores").select2({
						data : entrenadores
					});
					console.log(entrenadores);

				}
			},
			error : function() {
				postload();
			}
		});

	}
	function consultaMembresias() {
		var membresias = [];
		membresias.push({
			"id" : 0,
			"text" :"----Seleccione----"
		});
		$.ajax({
			url : '${contextPath}/catalogo/membresia/getAll',
			type : 'GET',
			dataType : 'json',
			contentType : 'application/json',
			async : false,
			success : function(response) {
				postload();
				if (response.codigo == 0) {
					var contTabla = '';
					arrProducts = response.data;
					$.each(arrProducts, function(index, value) {
						console.log("value->" + value);
						membresias.push({
							"id" : value.id,
							"text" : "$ " + value.costo + " - "
									+ value.descripcion
						});

					});
					$(".js-membresias").select2({
						data : membresias
					});

				}
			},
			error : function() {
				postload();
			}
		});

	}

	function guardarSocio() {

		var nombre = $('#nombre').val();
		var apaterno = $('#apaterno').val();
		var amaterno = $('#amaterno').val();
		var fechaNac = $('#fecha-nacimiento').val();
		var membresia = $('#membresia').val();
		var inicioMembresia = $('#inicio-membresia').val();
		var entrenador = $('#entrenador').val();
		var monto_membresia=$('#membresia').select2("data")[0].text;
		monto_membresia=monto_membresia.split("-")[0];
		monto_membresia=monto_membresia.replace("$", "");
		monto_membresia=monto_membresia.replace(" ", "");
		
		console.log("Monto entrenador->"+entrenador);
		
		if (nombre == "" || apaterno == "" || amaterno == ""||
				fechaNac == ""|| membresia == null || membresia == "null" || membresia == "" || inicioMembresia == ""
				||entrenador==""||entrenador==0||membresia==0||entrenador==null||entrenador=="null") {
			swal("Información", "Los campos marcados con * son obligatorios.","info");
		} else {
			var textoModal="";
			var textoUpdate="";
			if(idRegistro==null){
				textoUpdate="Registro de socio exitoso.";
				 textoModal="Se dará de alta un nuevo socio, asegurese de cobrar $ "+(monto_membresia)+" de la membresia, ¿Desea continuar?";
			}else{
				textoUpdate="Actualización de socio exitosa.";
				 textoModal="Se modificará el socio, ¿Desea continuar?";
							
			}
		
			swal(
					{
						title : "Atención",
						text : textoModal,
						type : "warning",
						showCancelButton : true,
						confirmButtonClass : "btn-danger",
						cancelButtonText : "No, Cancelar",
						confirmButtonText : "Si, continuar",
						closeOnConfirm : false
					},
					function() {
						preload();
						var jsonData = {
							"id" : idRegistro,
							"nombre" : nombre,
							"apaterno" : apaterno,
							"amaterno" : amaterno,
							"fecha_nacimiento" : fechaNac,
							"membresia" :{ "id" :membresia,"costo":monto_membresia},
							"inicio_membresia":inicioMembresia,
							"usuario_responsable" : entrenador
						};

						$.ajax({
									url : '${contextPath}/catalogo/socios/saveUpdate',
									type : 'POST',
									data : JSON.stringify(jsonData),
									dataType : 'json',
									async : true,
									contentType : 'application/json',
									success : function(response) {
										postload();
										if (response.codigo == 0) {
											swal(
													"Completo",
													textoUpdate,
													"success");
											catalogoProductosIndex('catalogoSocios');
										}
										if (response.codigo == 409) {
											swal(
													"Conflicto",
													"El socio que trata de ingresar ya existe",
													"error");
										}
									},
									error : function() {
										postload();
										swal(
												"Error",
												"Error al registrar al socio",
												"error");
									}
								});

					});
		}
	}

	function nuevaMembresia() {

		idRegistro = null;
		$('#titleAddUpdate').text("Nuevo socio");
		$('#nombre').val("");
		$('#apaterno').val("");
		$('#amaterno').val("");
		$('#fecha-nacimiento').val("");
		$('#inicio-membresia').val("");
		$('#entrenador').val("");

		$('#row-get-all').hide();
		$('#row-new').show();

	}

	function eliminarRegistro(id, nombre) {

		var jsonDelete = {
			"id" : id
		};
		swal(
				{
					title : "Atención",
					text : "Se eliminará el socio: " + nombre
							+ ", ¿ Desea continuar ?",
					type : "warning",
					showCancelButton : true,
					confirmButtonClass : "btn-danger",
					cancelButtonText : "No, Cancelar",
					confirmButtonText : "Si, continuar",
					closeOnConfirm : false
				},
				function() {
					preload();
					$
							.ajax({
								url : '${contextPath}/catalogo/socios/delete',
								type : 'POST',
								data : JSON.stringify(jsonDelete),
								dataType : 'json',
								async : true,
								contentType : 'application/json',
								success : function(response) {
									postload();
									if (response.codigo == 0) {
										swal("Eliminación exitosa", "",
												"success");
										catalogoProductosIndex('catalogoSocios');
									} else {
										swal("Error",
												"Error al eliminar el socio",
												"error");
									}

								},
								error : function() {
									postload();
									swal("Error", "Error al eliminar el socio",
											"error");
								}
							});

				});

	}

	function editarRegistro(id) {
		idRegistro = id;
		var current = {};
		$.each(arrProducts, function(index, value) {
			if (value.id == id) {
				current = value;
			}
		});
		console.log("Objeto current--");
		
		console.log(current);
		
		$('#nombre').val(current.nombre);
		$('#apaterno').val(current.apaterno);
		$('#amaterno').val(current.amaterno);
		$('#fecha-nacimiento').val(current.fecha_nacimiento_combo);
		$("#membresia").select2().val(current.id_membresia).trigger("change");
		$('#inicio-membresia').val(current.inicio_membresia_combo);
		$("#entrenador").select2().val(current.id_usuario_responsable).trigger("change");
		$('#titleAddUpdate').text("Modificar socio");
	
		$('#row-get-all').hide();
		$('#row-new').show();
	}

	function listaMembresia() {
		$('#nombre').val("");
		$('#apaterno').val("");
		$('#amaterno').val("");
		$('#fecha-nacimiento').val("");
		$('#inicio-membresia').val("");
		$('#entrenador').val("");

		$('#row-get-all').show();
		$('#row-new').hide();
	}
	consultaEntrenadores();
	consultaMembresias();
	getAll();
</script>