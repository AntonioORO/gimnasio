
<!-- Page-header start -->
<div class="page-header">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline">
					<h4>Catálogo de membresias</h4>
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
					<li class="breadcrumb-item" style="float: left;"><a href="#!">Membresias</a>
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
								<th>Meses</th>
								<th>Descripción</th>
								<th>Costo</th>
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
				<h5 id="titleAddUpdate">Nueva membresia</h5>
			</div>
			<div class="card-block">
				<div class="row">
					<div class="col-sm-4">
						<div class="col-sm-12">
							<label for="meses-membresia" class="form-label block">Meses (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="meses-membresia" name="meses-membresia" type="text" class=" form-control" maxlength="50" onkeypress="onlyNumbers()">
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
							<label for="costo-membresia" class="form-label block">Costo (*):</label>
						</div>
						<div class="col-sm-12">
							<input id="costo-membresia" name="costo-membresia" type="text" class=" form-control" onkeypress='precios(event)'>
						</div>
					</div>
				</div>
				<br />
				<br />
				<div class="row">
					<br /> <br />
					<center>
						<button onclick="listaMembresia()" class="btn btn-primary btn-square">Cancelar</button>
						&nbsp; 
						<button onclick="guardarMembresia()"  class="btn btn-success btn-square">Guardar</button>
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
					url : '${contextPath}/catalogo/membresia/getAll',
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
														+ value.meses
														+ '</td>';
												contTabla += '<td>'
														+ value.descripcion
														+ '</td>';
												contTabla += '<td>'
														+ value.costo
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

	function guardarMembresia(){
		
		var meses=$('#meses-membresia').val();
		var des=$('#descripcion').val();
		var cos=$('#costo-membresia').val();
	
		if(meses==""||des==""||cos==""){
			swal("Información", "Los campos marcados con * son obligatorios.", "info");
			
		}else{
			swal({
				title: "Atención",
				text: "Se dará de alta la nueva membresia, desea continuar",
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
					"meses":meses,
					"descripcion":des,
					"costo":cos
				
					};
				
		    	$.ajax({
		    	    url: '${contextPath}/catalogo/membresia/saveUpdate',
		    	    type: 'POST',
		    	    data: JSON.stringify(jsonData),
		    	    dataType: 'json',
		    	    async:true,
		            contentType: 'application/json',
		    	    success: function (response) {
		    	    	postload();
		    	       if(response.codigo==0){
		    	    	   swal("Completo", "Registro de membresia exitosa.", "success");
		    	    	   catalogoProductosIndex('catalogoMembresias');
		    	       }
		    	       if(response.codigo==409){
		    	    	   swal("Conflicto", "La membresia que trata de ingresar ya existe", "error");
		    	       }
		    	    },
		    	    error: function () {
		    	    	postload();
		    	    	 swal("Error", "Error al registrar la membresia", "error");
		    	    }
		    	}); 
				
			});
		}
	}
	
	function nuevaMembresia() {
		idRegistro=null;
		$('#titleAddUpdate').text("Nueva membresia");
		
		$('#meses-membresia').val("");
		$('#descripcion').val("");
		$('#costo-membresia').val("");
		$('#row-get-all').hide();
		$('#row-new').show();
	}
	
	function eliminarRegistro(id,nombre) {
		
	var jsonDelete={
				"id":id
				};
	  swal({
			title: "Atención",
			text: "Se eliminará la membresia: "+nombre+", ¿ Desea continuar ?",
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
	    	    url: '${contextPath}/catalogo/membresia/delete',
	    	    type: 'POST',
	    	    data: JSON.stringify(jsonDelete),
	    	    dataType: 'json',
	    	    async:true,
	            contentType: 'application/json',
	    	    success: function (response) {
	    	    	postload();
	    	       if(response.codigo==0){
	    	    	   swal("Eliminación exitosa", "", "success");
	    	    	   catalogoProductosIndex('catalogoMembresias');
	    	       }else{
	    	    	   swal("Error", "Error al eliminar la membresia", "error"); 
	    	       }
	    	       
	    	    },
	    	    error: function () {
	    	     postload();
	    	     swal("Error", "Error al eliminar la membresia", "error");
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
		
		$('#titleAddUpdate').text("Modificar membresia");
		$('#meses-membresia').val(current.meses);
		$('#descripcion').val(current.descripcion);
		$('#costo-membresia').val(current.costo);
		
		$('#row-get-all').hide();
		$('#row-new').show();
	}
	
	function listaMembresia() {
		$('#meses-membresia').val("");
		$('#descripcion').val("");
		$('#costo-membresia').val("");
		
		$('#row-get-all').show();
		$('#row-new').hide();
		}
	
	getAll();
</script>