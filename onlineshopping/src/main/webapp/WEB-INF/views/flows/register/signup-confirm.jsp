<%@include file="../shered/flows-header.jsp" %>
<div class="container">
	
	<div class="row">
	
		<div class="col-sm-6">
		
			<div class="card">
  				<div class="card-body">
    				<h5 class="card-title mb-2">Personal Details</h5>
    				<p><strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong></p>
					<p><strong>${registerModel.user.email}</strong></p>
					<p><strong>${registerModel.user.contactNumber}</strong></p>
					<p><strong>${registerModel.user.role}</strong></p>
					<p>
						<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
					</p>
  				</div>
			</div>
	
		</div>
		
		<div class="col-sm-6">
		
		<div class="card">
  			<div class="card-body">
    			<h5 class="card-title">Billing Address</h5>
    			<p>${registerModel.billing.addressLineOne}, ${registerModel.billing.addressLineTwo}, </p>
				<p>${registerModel.billing.city} -  ${registerModel.billing.postalCode}, </p>
				<p>${registerModel.billing.state}</p>
				<p>${registerModel.billing.country}</p>
				<p>
					<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
				</p>
  			</div>
		</div>
		
		
		</div>
	
	</div>
	
	<div class="text-center mt-5">
				
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-success">Confirm</a>
				
	</div>

</div>
<%@include file="../shered/flows-footer.jsp" %>