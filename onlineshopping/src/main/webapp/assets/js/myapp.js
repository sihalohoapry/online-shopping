$(function() {
	switch (menu) {
	case 'About':
		$('#about').addClass("active");
		break;

	default:
		$('#home').addClass("active");
		break;
	}

	var $table = $('#productListTable');

	if ($table.length) {
		 
//		console.log('Inside the table ');

		// execiute the below code only where we have this table

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		} 
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Data', '5 Data', '10 Data', 'Semua' ] ],
			pageLength : 5,
			ajax: {
				url: jsonUrl,
				dataSrc: '',
				
			},
			columns: [
				{
					data: 'name',
				},
				{
					data: 'brand'
				},
				{
					data: 'untiPrice',
					mRender: function(data, type, row){
						return 'Rp ' + data
					}
				},
				{
					data: 'quantity',
					mRender: function(data,type,row){
						if(data<1){
							return '<span style="color:red">Out of Stock</span>';
						}
						return data;
					}
				},
				{
					data: 'id',
					mRender: function (data, type, row){
						var str = '';
						str += '<a href= "' +window.contextRoot+'/show/'+data+'/product" class="btn btn-primary mr-5">Lihat</a>&#160;';
						
						if(row.quantity<1){
							
							str += '<a href= "javascript:void(0)" class="btn btn-success ml-5 disabled "><strike>Add to Cart</strike></a>';
							
							
						}else{
							str += '<a href= "' +window.contextRoot+'/cart/add/'+data+'/product " class="btn btn-success ml-5">Add to Cart</a>';
						
						}
						
						return str;
					}
						
				},
			]
		});
	}

});