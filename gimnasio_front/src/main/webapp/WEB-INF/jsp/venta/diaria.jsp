


<div class="page-header">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline">
					<h4>Venta Diaria</h4>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item" style="float: left;"><a
						href="index.html"> <i class="feather icon-box"></i>
					</a></li>
					<li class="breadcrumb-item" style="float: left;"><a href="#!">Venta</a>
					</li>
					<li class="breadcrumb-item" style="float: left;"><a href="#!">Diaria</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->


<div class="page-body">


    <div class="modal fade" id="large-Modal" tabindex="-1"
        role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Detalle de venta</h4>
                    <button type="button" class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close">
                        <span
                            aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                   <table id="detalleTb" class="table table-striped  nowrap"
						style="width: 100%;">
						<thead>
							<tr>
								<th>Descripción</th>
								<th>Cantidad</th>
								<th>Precio unitario</th>
								<th>Subtotal</th>
							</tr>
						</thead>
						<tbody id="tablaDetalle">


						</tbody>
					</table>
                </div>
                <div class="modal-footer">
                    <button type="button"
                        class="btn btn-default waves-effect "
                        data-bs-dismiss="modal">Cerrar</button>
                    <button type="button"
                        class="btn btn-primary waves-effect waves-light ">Imprimir ticket</button>
                </div>
            </div>
        </div>
    </div>



	<div class="row" id="row-get-all">
		<div class="card">
			<div class="card-block">
			
			  <div class="row">
			   <div class="col-sm-4">
						<div class="col-sm-12">
							<label for="fecha-nacimiento" class="form-label block">Fecha
								Consulta (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="fecha-consulta" name="fecha-consulta"  type="date"  onchange="ventaDiaria()"
								class=" form-control" maxlength="50">
						</div>
				</div>
				<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="fecha-nacimiento" class="form-label block">Venta
								Total :</label>
						</div>
						<div class="col-sm-12">
							<h1 id="montovta">$ 0.00</h1>
						</div>
				</div>
			  </div> 
			  <br>
			  <br>
			  
			
				<div class="dt-responsive table-responsive">
					<table id="tablaprincipal" class="table table-striped  nowrap"
						style="width: 100%;">
						<thead>
							<tr>
								<th>Folio</th>
								<th>Importe</th>
								<th>Responsable venta</th>
								<th>Fecha</th>
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
	function ventaDiaria() {
		preload();
		var jsonData = {
				"fecha" : $('#fecha-consulta').val()
			};
	        $.ajax({
					url : '${contextPath}/venta/ventaDiaria',
					type : 'POST',
					data : JSON.stringify(jsonData),
					dataType : 'json',
					contentType : 'application/json',
					async : false,
					success : function(response) {
						postload();
						if (response.codigo == 0) {
                            $('#montovta').text(response.data.monto);
							var contTabla = '';
							arrProducts = response.data.ventas;
 console.log('iterando');
							$.each(
											arrProducts,
											function(index, value) {
												contTabla += '<tr>';
												contTabla += '<td>'
														+ value.folio
														+ '</td>';
												contTabla += '<td>'
														+ value.importe
														+ '</td>';
												contTabla += '<td>'
														+ value.usuario
														+ '</td>';
												contTabla += '<td>'
														+ value.fecha
														+ '</td>';
												contTabla += '<td>';
												contTabla += '<center>';
												contTabla += '<button class="btn btn-primary btn-outline-primary fa fa-eye"';
												contTabla += 'title="Ver detalle" onclick="verDetalleVenta('
														+ value.folio
														+ ')"></button>';
													contTabla += '</center>';
												contTabla += '</td>';
												contTabla += '</tr>';
											});
							table.destroy();
							$('#cont-tabla').html(contTabla);
							
							table=$('#tablaprincipal').DataTable({
								"ordering" : true
							});

						}
					},
					error : function() {
						postload();
					}
				});

	}
	
	function verDetalleVenta(idVenta){
		preload();
		var jsonData = {
				"idVenta" :idVenta
			};
	        $.ajax({
					url : '${contextPath}/venta/detalleVentaDiaria',
					type : 'POST',
					data : JSON.stringify(jsonData),
					dataType : 'json',
					contentType : 'application/json',
					async : false,
					success : function(response) {
						postload();
						if (response.codigo == 0) {
					             $('#montovta').text(response.data.monto);
								var contTabla = '';
								var arrProductsD = response.data.detalleVenta;
	 
								$.each(
										arrProductsD,
												function(index, value) {
													contTabla += '<tr>';
													contTabla += '<td>'
															+ value.descripcion
															+ '</td>';
													contTabla += '<td>'
															+ value.cantidad
															+ '</td>';
													contTabla += '<td>'
															+ value.precio_unitario
															+ '</td>';
													contTabla += '<td>'
															+ value.total
															+ '</td>';
												
													contTabla += '</tr>';
												});
								tableDv.destroy();
								$('#tablaDetalle').html(contTabla);
								
								tableDv=$('#detalleTb').DataTable({
									"ordering" : true
								});

							
								$('#large-Modal').modal('show');
							
												}
					},
					error : function() {
						postload();
					}
				});

	}
	
	
	 var tableDv=$('#detalleTb').DataTable({
			"ordering" : false
		});
	 
    var table=$('#tablaprincipal').DataTable({
		"ordering" : true
	});
    
    
	var fechaConsulta=fechaActual();
	$('#fecha-consulta').val(fechaConsulta);
	ventaDiaria();
</script>