$(function() {
	switch (menu) {
	case 'About':
		$('#about').addClass("active");
		break;

	default:
		$('#home').addClass("active");
		break;
	}

	// code for jquery dataTable
	// create data set

	var products = [

	[ '1', 'ABC' ], [ '2', 'dfg' ], [ '3', 'hij' ], [ '4', 'klm' ],
			[ '5', 'nop' ], [ '6', 'qrs' ], [ '7', 'tuv' ], [ '8', 'wxy' ], [ '8', 'wxy' ], [ '8', 'wxy' ], [ '8', 'wxy' ], [ '8', 'wxy' ], [ '8', 'wxy' ], [ '8', 'wxy' ]

	];

	var $table = $('#productListTable');

	// execiute the below code only where we have this table

	if ($table.length) {
		 console.log('Inside the table ');
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Data', '5 Data', '10 Data', 'Semua']],
			pageLength: 5,
			data : products
		});
	}

});