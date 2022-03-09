<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shered/flows-header.jsp" %>
			<div class="container">
			
				<div class="row">
				
					<div class="col-md-6 col-md-offset-3">
					
						<div class="panel panel-primary">
						
							<div class="panel-heading">
							
								<h4>Sign Up - Personal</h4>
								
							</div>
							
							<div class="panel-body">
							
								<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
								
									<div class="form-group mt-2">
										
										<label class="control-label col-md-4">First Name</label>
										<div class="col-md-8">
											<sf:input path="firstName" type="text" class="form-control" placeholder="First Name"/>
										</div>
										
									</div>
									
									<div class="form-group mt-2">
										
										<label class="control-label col-md-4">Last Name</label>
										<div class="col-md-8">
											<sf:input path="lastName" type="text" class="form-control" placeholder="Last Name"/>
										</div>
										
									</div>
									
									<div class="form-group mt-2">
										<label class="control-label col-md-4">Email</label>
										<div class="col-md-8">
											<sf:input path="email" type="text" class="form-control" placeholder="exsample@gmail.com"/>
										</div>
									</div>
									
									<div class="form-group mt-2">
										<label class="control-label col-md-4">Contact Number</label>
										<div class="col-md-8">
											<sf:input path="contactNumber" type="text" class="form-control" placeholder="XXXXXXX" maxlength="10"/>
										</div>
									</div>
									
									<div class="form-group mt-2">
										<label class="control-label col-md-4">Password</label>
										<div class="col-md-8">
											<sf:input path="password" type="password" class="form-control" placeholder="Password"/>
										</div>
									</div>
									
									<div class="form-group mt-2">
										<label class="control-label col-md-4">Select Role</label>
										<div class="col-md-8">
											<label class="radio-inline">
												<sf:radiobutton path="role" value="USER" checked="checked"/>User
											</label>
											<label class="radio-inline" style="margin-left: 20px;">
												<sf:radiobutton path="role" value="SUPPLIER" />Supplier
											</label>
										</div>
									</div>
									
									<div class="form-group mt-2">
										<div class="col-md-offset-4 col-md-8">
											<button type="submit" class="btn btn-primary"
												name="_eventId_billing"
											>
												Next - Billing <span class="glyphicon glyphicon-chevron-right "></span>	
											</button>
										</div>
									</div>
								
								</sf:form>
							</div>
						
						</div>
					
					</div>
				
				</div>
			
			</div>

<%@include file="../shered/flows-footer.jsp" %>