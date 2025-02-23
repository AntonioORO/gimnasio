   <div class="modal fade" id="large-Modal" tabindex="-1"
        role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Búsqueda de socio</h4>
                    <button type="button" class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close">
                        <span
                            aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                 	<div class="row">
					<div class="col-sm-3">
						<div class="col-sm-12">
							<label for="nombre" class="form-label block">Nombre :</label>
						</div>
						<div class="col-sm-12">
							<input id="nombre" name="nombre" type="text"
								class=" form-control" maxlength="50" >
						</div>
					</div>
					<div class="col-sm-3">
						<div class="col-sm-12">
							<label for="apaterno" class="form-label block">Apellido
								paterno :</label>
						</div>
						<div class="col-sm-12">
							<input id="apaterno" name="apaterno" type="text"
								class=" form-control" maxlength="50">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="col-sm-12">
							<label for="amaterno" class="form-label block">Apellido
								materno :</label>
						</div>
						<div class="col-sm-12">
							<input id="amaterno" name="amaterno" type="text"
								class=" form-control" >
						</div>
					</div>
					<div class="col-sm-3">
						<div class="col-sm-12">
                                 &nbsp;							
						</div>
						<div class="col-sm-12">
							<button onclick="buscarSocio()"
							class="btn btn-success btn-square">Buscar</button>
						</div>
					</div>
					
				</div>
                 
                 
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

<div class="row">
	<div class="col-xl-12 col-md-12">
		<div class="card">

			<div class="card-block">
				<div class="row">
					<div class="col-sm-8">
						<div class="col-sm-8">
							<label for="userName-2" class="form-label ">Producto/
								codigo:</label>
						</div>
						<div class="col-sm-8">
							<input id="codigoBarras" name="codigoBarras" type="text"
								class=" form-control" maxlength="50" onkeypress="onlyNumbers()" autoComplete="off">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="userName-2" class="form-label ">&nbsp;&nbsp;</label>
						</div>
						<div class="col-sm-12">
							<button class="btn btn-success" onclick="renovarMembresia()">
								<i class="fa fa-vcard"></i>Renovar membresia
							</button>
						</div>
					</div>
				</div>
				<div class="row">
					<br />
					<div class="col-sm-8">
						<div class="card-block table-border-style">
							<div class="table-responsive" style="height: 400px;">
								<br />

								<table class="table table-styling table-hover table-striped ">
									<thead>
										<tr class=" table-primary">
											<th style="width: 100px">Codigo</th>
											<th>Producto</th>
											<th style="width: 100px">Cantidad</th>
											<th style="width: 100px">Precio</th>
											<th style="width: 100px">Importe</th>
										</tr>
									</thead>
									<tbody id="productosCarrito">

									</tbody>

								</table>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="row">
							<div class="card-header">
								<h5 id="numArt">Total a pagar (0 Articulos):</h5>
							</div>
							<div class="card-block">
								<center>
									<h1 id="importeFinal">$ 0.00</h1>

								</center>
								
							</div>
							<div class="card-footer ">
								<div class="row text-center b-t-default">

									<div class="col-6 b-r-default m-t-15">
										<button class="btn btn-primary" onclick="cancelVenta()">
											<i class="fa fa-close"></i>Cancelar
										</button>

									</div>
									<div class="col-6 b-r-default m-t-15">
										<button class="btn btn-success">
											<i class="fa fa-dollar"></i>Cobrar
										</button>

									</div>
								</div>
							</div>
						</div>

					</div>

				</div>

			</div>


		</div>
	</div>
</div>

<script type="text/javascript">
	var arrProd = [];

	$("#codigoBarras").on('keypress', function(e) {
		if (e.which == 13) {

			consultaProductos();
		}
	});

	function consultaProductos() {

		var jsonData = {
			"codigo_barras" : $("#codigoBarras").val()
		};

		$.ajax({
			url : '${contextPath}/catalogo/producto/getByCode',
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(jsonData),
			contentType : 'application/json',
			async : false,
			success : function(response) {
				postload();
				if (response.codigo == 0) {
					var p = response.data;

					validarArticulos(p);

				} else {
					swal("Información", "Producto no encontrado", "info");
				}
				
				$('#codigoBarras').val("");
			},
			error : function() {
				postload();
			}
		});

	}

	function validarArticulos(articulo) {

		var existe = false;
		for (let i = 0; i < arrProd.length; i++) {
			if (articulo.id == arrProd[i].id) {
				existe = true;
				arrProd[i].cantidad = arrProd[i].cantidad + 1;
				arrProd[i].total = arrProd[i].costo_venta * arrProd[i].cantidad;

				break;
			}
		}

		if (!existe) {
			arrProd.push({
				"id" : articulo.id,
				"codigo_barras" : articulo.codigo_barras,
				"descripcion" : articulo.descripcion,
				"costo_venta" : articulo.costo_venta,
				"total" : articulo.costo_venta,
				"cantidad" : 1

			});

		}

		addArticulo();
	}

	function addArticulo() {
		var articulosTabla = '';
		var acumulado=0;
		var artAcum=0;
		for (let i = 0; i < arrProd.length; i++) {
			
			acumulado+=arrProd[i].total;
			articulosTabla += '<tr >';
			articulosTabla += '<th>'+arrProd[i].codigo_barras+'</th>';
			articulosTabla += '<th>'+arrProd[i].descripcion+'</th>';
			articulosTabla += '<th>'+arrProd[i].cantidad+'</th>';
			articulosTabla += '<th>'+arrProd[i].costo_venta+'</th>';
			articulosTabla += '<th>'+arrProd[i].total+'</th>';
			articulosTabla += '</tr>';
			artAcum+=arrProd[i].cantidad;

		}
		
		$('#numArt').text("Total a pagar ( "+artAcum+" Articulo"+(artAcum>1?"s":"")+" ) :");
		$('#importeFinal').html("$ "+acumulado);
		$('#productosCarrito').html(articulosTabla);

	}
	
	function cancelVenta(){
		swal(
				{
					title : "Atención",
					text : "Se cancelará la venta en curso, ¿ Desea Continuar ?",
					type : "warning",
					showCancelButton : true,
					confirmButtonClass : "btn-danger",
					cancelButtonText : "No",
					confirmButtonText : "Si",
					closeOnConfirm : true
				},
				function() {
					
					catalogoProductosIndex('dashpunto');
					
				});
		
	}
	
	function renovarMembresia(){
		$('#large-Modal').modal('show');
		
	}
	
	function buscarSocio(){
		var nombre=$("#nombre").val();
		var apaterno=$("#apaterno").val();
		var amaterno=$("#amaterno").val();
		
		var jsonData = {
				"nombre" : nombre,
				"apaterno" : apaterno,
				"amaterno" : amaterno
			};
		$.ajax({
			url : '${contextPath}/catalogo/socios/findByUserNames',
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(jsonData),
			contentType : 'application/json',
			async : false,
			success : function(response) {
				postload();
				if (response.codigo == 0) {
					var p = response.data;

					validarArticulos(p);

				} else {
					swal("Información", "Socio no encontrado", "info");
				}
				
			},
			error : function() {
				postload();
			}
		});
		
		
		  
	}
	
</script>
