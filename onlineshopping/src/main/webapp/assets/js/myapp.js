$(function() {
	switch (menu) {
	case 'About':
		$('#about').addClass("active");
		break;

	case 'Manage Products':
		$('#manageProducts').addClass("active");
		break;

	case 'User Cart':
		$('#navbarDropdown1').addClass("active");
		break;

	case 'All Products':
		$('#navbarDropdown2').addClass("active");
		break;

	default:
		$('#home').addClass("active");
		break;
	}

	var $table = $('#productListTable');

	if ($table.length) {

		// console.log('Inside the table ');

		// execiute the below code only where we have this table

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Data', '5 Data', '10 Data', 'Semua' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : '',

					},
					columns : [
							{
								data : 'name',
							},
							{
								data : 'brand'
							},
							{
								data : 'untiPrice',
								mRender : function(data, type, row) {
									return 'Rp ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href= "'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary mr-5">Lihat</a>&#160;';

									if (userRole == 'ADMIN') {
										str += '<a href= "'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product " class="btn btn-warning ml-5">Edit</a>';

									} else {
										if (row.quantity < 1) {

											str += '<a href= "javascript:void(0)" class="btn btn-success ml-5 disabled "><strike>Add to Cart</strike></a>';

										} else {
											str += '<a href= "'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/product " class="btn btn-success ml-5">Add to Cart</a>';

										}

									}

									return str;
								}

							}, ]
				});
	}

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	/*------*/
	/* handle refresh cart */
	$('button[name="refreshCart"]')
			.click(
					function() {
						var cartLineId = $(this).attr('value');
						var countElement = $('#count_' + cartLineId)
						var originalCount = countElement.attr('value');
						var currentCount = countElement.val();
						
						//only when the count has changed
						if(currentCount !== originalCount){
							
							if(currentCount < 1 || currentCount > 3){
								
								countElement.val(originalCount);
								bootbox.alert({
									size:'medium',
									title: 'error',
									message: 'Product count should be min 1 and max 3!'
								});
							}else{
								var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount ;
								//forward it to the controller
								window.location.href = updateUrl ;
							}
							
						}				
						
					});

	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {

						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked) ? 'You want to activete the produck?'
								: 'You want to deactivate the product';

						var value = checkbox.prop('value');

						bootbox
								.confirm({
									size : 'medium',
									title : 'Product Activation & Deactivation',
									message : dMsg,
									callback : function(confirmed) {
										if (confirmed) {

											console.log(value);
											bootbox
													.alert({
														size : 'medium',
														title : 'information',
														message : 'You are going to perform operation on product'
																+ value
													})

										} else {
											checkbox.prop('checked', !checked);
										}
									}
								})

					});

	// data table for admin

	var $adminProductTable = $('#adminProductsTable');

	if ($adminProductTable.length) {

		// console.log('Inside the table ');

		// execiute the below code only where we have this table

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Data', '30 Data', '50 Data', 'Semua' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : '',

					},
					columns : [
							{
								data : 'id',
							},

							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>';
									}
									return data;
								}
							},

							{
								data : 'untiPrice',
								mRender : function(data, type, row) {
									return 'Rp ' + data
								}
							},

							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<label class="switch">';

									if (data) {
										str += '<input type ="checkbox" checked="checked" value ="'
												+ row.id + '" /> ';
									} else {
										str += '<input type ="checkbox"  value ="'
												+ row.id + '" /> ';
									}

									str += '<div class="slider"></div></label>';
									return str;

								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">Edit</a>';
									return str;
								}
							} ],

					initComplete : function() {
						var api = this.api();
						api.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activete the produck?'
													: 'You want to deactivate the product';

											var value = checkbox.prop('value');

											bootbox.confirm({
														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {

																console.log(value);
																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';
																$.post(activationUrl, function(data) {
																					bootbox.alert({
																								size : 'medium',
																								title : 'information',
																								message : data
																							});
																				});

															} else {
																checkbox.prop('checked', !checked);
															}
														}
													})

										});
					}

				});
	}

	// ------------------------------

	var $categoryForm = $('#categoryForm');
	if ($categoryForm.length) {
		$categoryForm
				.validate({
					rules : {
						name : {
							required : true,
							minlength : 2,
						},

						description : {
							required : true
						}

					},
					messages : {

						name : {
							required : 'Please add the category name',
							minlength : 'The category name should not be less then 2 characters'
						},

						description : {
							required : 'Please add a description for this category!'
						}
					},

					errorElement : 'em',
					errorPlacement : function(error, element) {
						error.addClass('help-block');
						error.insertAfter(element);
					}

				})
	}

	
	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	if (token.length > 0 && header.length > 0) {
		// set the token header for ajax request
		$(dokument).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);

		});
	}

	if ($loginForm.length) {

		$loginForm.validate({
			rules : {
				username : {
					required : true,
					email : true

				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please enter your email!',
					email : 'Please enter a valid email address!'
				},
				password : {
					required : 'Please enter your password!'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				// Add the 'help-block' class to the error element
				error.addClass("help-block");

				// add the error label after the input element
				error.insertAfter(element);
			}
		}

		);

	}

});
