
$(function() {

	$("#navbar-search-bar").autocomplete(
		{
			source: function(request, response) {
				$.ajax({
					url: '/api/producto/buscar/' + $("#navbar-search-bar").val(),
					type: 'get',
					dataType: "json",
					success: function(data) {
						response( $.map(data, function (item) {
							return{label: item.nombreProducto, value:item.nombreProducto    }
						}))
					},
					error: function(xhr, status, error){
						console.log(error);
					}	
				});
			}
		}
		
		,
		{
			delay: 0,
			minLength: 1
		}
    );

    $('#btn-buscar-producto').click(function(){
       if ($("#navbar-search-bar").val() != "")
          window.location.href='/subcategoria/General/1/' + $("#navbar-search-bar").val();
   })
}
);

