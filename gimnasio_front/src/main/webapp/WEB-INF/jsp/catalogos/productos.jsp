
<!-- Page-header start -->
<div class="page-header">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline">
					<h4>Catálogo de productos</h4>
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
					<li class="breadcrumb-item" style="float: left;"><a href="#!">Productos</a>
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
						style="float: right;" onclick="nuevoProducto()">
						<i class="fa fa-plus"></i>Nuevo
					</button>
					<br /> <br /> <br />
				</div>
				<div class="dt-responsive table-responsive">
					<table id="tablaprincipal" class="table table-striped  nowrap"
						style="width: 100%;">
						<thead>
							<tr>
								<th>Código</th>
								<th>Descripción</th>
								<th>Costo compra</th>
								<th>Costo venta</th>
								<th>Stock</th>
								<th>Stock Minimo</th>
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


	<div class="row" id="row-new" style="display:none">

		<div class="card">
			<div class="card-header">
				<h5 id="titleAddUpdate">Nuevo producto</h5>
			</div>
			<div class="card-block">
				<div class="row">
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="codigo-barras" class="form-label block">Código de barras (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="codigo-barras" name="codigo-barras" type="text" class=" form-control" maxlength="50" onkeypress="onlyNumbers()">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="descripcion" class="form-label block">Descripción (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="descripcion" name="descripcion" type="text" class=" form-control" maxlength="50">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="costo-compra" class="form-label block">Costo compra (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="costo-compra" name="costo-compra" type="text" class=" form-control" onkeypress='precios(event)'>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="costo-venta" class="form-label block">Costo venta (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="costo-venta" name="costo-venta" type="text" class=" form-control" onkeypress='precios(event)'>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="stock" class="form-label block">Stock (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="stock" name="costo-compra" type="text" class=" form-control" onkeypress="onlyNumbers()">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="stock-minimo" class="form-label block">Stock minimo (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="stock-minimo" name="costo-compra" type="text" class=" form-control" onkeypress="onlyNumbers()">
						</div>
					</div>
					
				</div>
				<br />
				<br />
				<div class="row">
					<br /> <br />
					<center>
						<button onclick="listaProductos()" class="btn btn-primary btn-square">Cancelar</button>
						&nbsp; 
						<button onclick="guardarProducto()"  class="btn btn-success btn-square">Guardar</button>
					</center>
		
				</div>
			</div>
		</div>
	</div>
</div>





<script>
   var arrProducts;
   var idRegistro=null;
	function getAll() {
		preload();
		$.ajax({
					url : '${contextPath}/catalogo/producto/getAll',
					type : 'GET',
					dataType : 'json',
					contentType : 'application/json',
					async:false,
					success : function(response) {
						postload();
						if (response.codigo == 0) {
							var contTabla = '';
							arrProducts=response.data;
							$.each(arrProducts,function(index, value) {
												contTabla += '<tr>';
												contTabla += '<td>'
														+ value.codigo_barras
														+ '</td>';
												contTabla += '<td>'
														+ value.descripcion
														+ '</td>';
												contTabla += '<td>'
														+ value.costo_compra
														+ '</td>';
												contTabla += '<td>'
														+ value.costo_venta
														+ '</td>';
												contTabla += '<td>'
														+ value.stock + '</td>';
												contTabla += '<td>'
														+ value.stock_minimo
														+ '</td>';
												contTabla += '<td>';
												contTabla += '<center>';
												contTabla += '<button class="btn btn-primary btn-outline-primary fa fa-pencil"';
	    		   contTabla+='title="Editar" onclick="editarRegistro('+value.id+')"></button>';
												contTabla += '<button class="btn btn-warning btn-outline-warning fa fa-trash"';
	    		   contTabla+='title="Eliminar" onclick="eliminarRegistro('+value.id+',\''+value.descripcion+'\')"></button>';
												contTabla += '</center>';
												contTabla += '</td>';
												contTabla += '</tr>';
											});

							$('#cont-tabla').html(contTabla);
							$('#tablaprincipal').DataTable({
								 "ordering": true
							});


						}
					},
					error : function() {
						postload();
					}
				});

	}

	function guardarProducto(){
		
		var cod=$('#codigo-barras').val();
		var des=$('#descripcion').val();
		var cos=$('#costo-compra').val();
		var cosvta=$('#costo-venta').val();
		var stock=$('#stock').val();
		var minstock=$('#stock-minimo').val();
		if(cod==""||des==""||cos==""||cosvta==""||stock==""||minstock==""){
			swal("Información", "Los campos marcados con * son obligatorios.", "info");
			
		}else{
			swal({
				title: "Atención",
				text: "Se dará de alta un nuevo producto, desea continuar",
				type: "warning",
				showCancelButton: true,
				confirmButtonClass: "btn-danger",
				cancelButtonText: "No, Cancelar",
				confirmButtonText: "Si, continuar",
				closeOnConfirm: false
			},
			function(){
				preload();
				
				var jsonData={
					"id":idRegistro,	
					"codigo_barras":cod,
					"descripcion":des,
					"costo_compra":cos,
					"costo_venta":cosvta,
					"stock":stock,
					"stock_minimo":minstock
					};
				
		    	$.ajax({
		    	    url: '${contextPath}/catalogo/producto/saveUpdate',
		    	    type: 'POST',
		    	    data: JSON.stringify(jsonData),
		    	    dataType: 'json',
		    	    async:true,
		            contentType: 'application/json',
		    	    success: function (response) {
		    	    	postload();
		    	       if(response.codigo==0){
		    	    	   swal("Completo", "Registro de producto exitoso.", "success");
		    	    	   catalogoProductosIndex();
		    	       }
		    	       if(response.codigo==409){
		    	    	   swal("Conflicto", "El código que trata de ingresar ya existe", "error");
		    	       }
		    	    },
		    	    error: function () {
		    	    	postload();
		    	    	 swal("Error", "Error al registrar el producto", "error");
		    	    }
		    	}); 
				
			});
		}
	}
	
	function nuevoProducto() {
		idRegistro=null;
		$('#titleAddUpdate').text("Nuevo producto");
		
		$('#codigo-barras').val("");
		$('#descripcion').val("");
		$('#costo-compra').val("");
		$('#costo-venta').val("");
		$('#stock').val("");
		$('#stock-minimo').val("");
		
		$('#row-get-all').hide();
		$('#row-new').show();
	}
	
	function eliminarRegistro(id,nombre) {
		
	var jsonDelete={
				"id":id
				};
	  swal({
			title: "Atención",
			text: "Se eliminará el producto: "+nombre+", ¿ Desea continuar ?",
			type: "warning",
			showCancelButton: true,
			confirmButtonClass: "btn-danger",
			cancelButtonText: "No, Cancelar",
			confirmButtonText: "Si, continuar",
			closeOnConfirm: false
		},
		function(){
			preload();
			$.ajax({
	    	    url: '${contextPath}/catalogo/producto/delete',
	    	    type: 'POST',
	    	    data: JSON.stringify(jsonDelete),
	    	    dataType: 'json',
	    	    async:true,
	            contentType: 'application/json',
	    	    success: function (response) {
	    	    	postload();
	    	       if(response.codigo==0){
	    	    	   swal("Eliminación exitosa", "", "success");
	    	    	   catalogoProductosIndex();
	    	       }else{
	    	    	   swal("Error", "Error al eliminar el producto", "error"); 
	    	       }
	    	       
	    	    },
	    	    error: function () {
	    	     postload();
	    	     swal("Error", "Error al eliminar el producto", "error");
	    	    }
	    	}); 
			
		});
		
		
	}
		
	function editarRegistro(id) {
		idRegistro=id;
		var current={};
		$.each(arrProducts,
				function(index, value) {
			if(value.id==id){
				current=value;
			}
		});
		
		$('#titleAddUpdate').text("Modificar producto");
		$('#codigo-barras').val(current.codigo_barras);
		$('#descripcion').val(current.descripcion);
		$('#costo-compra').val(current.costo_compra);
		$('#costo-venta').val(current.costo_venta);
		$('#stock').val(current.stock);
		$('#stock-minimo').val(current.stock_minimo);
		$('#row-get-all').hide();
		$('#row-new').show();
	}
	
	function listaProductos() {
		$('#codigo-barras').val("");
		$('#descripcion').val("");
		$('#costo-compra').val("");
		$('#costo-venta').val("");
		$('#stock').val("");
		$('#stock-minimo').val("");
		$('#row-get-all').show();
		$('#row-new').hide();
		}
	
	getAll();
</script>