I have yet to find a budget application that works the way I want it to, so I am going to make one. The goal of this is to be supremely flexible, but I'm definitely going to be focusing on the paycheck-to-paycheck crowd initially with the features.

To-Do List : BudgetBoss
<table>
	<thead>
		<tr>
		  <th>Feature</th>
		  <th>Story</th>
		  <th>Status</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		  <td>Initial Prompt</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: There are no existing budgets</li>
		       <li>Then: BudgetBoss should prompt to create a budget, and take name input</li>
		  </td>
		  <td>Implemented</td>
		</tr>
		<tr>
		  <td>BudgetBoss can create Budgets</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: A a new Budget is desired</li>
		       <li>Then: BudgetBoss can generate a Budget object</li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
		<tr>
		  <td>Budgets have start and end dates</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: A a new Budget is created</li>
		       <li>Then: It will have user-defined start and end dates</li>
		  </td>
	 	  <td>Partially Implemented - dates in place, not user-defined</td>
		</tr>
		<tr>
		  <td>Budgets dates are retrievable and changeable</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>And: A a new Budget is created</li>
		       <li>When: The user wants to check or change the start or end date</li>
		       <li>Then: The user can view or alter the dates on the Budget</li>
		  </td>
	 	  <td>Implemented for now</td>
		</tr>
		<tr>
		  <td>BudgetBoss writes Budget objects to disk on exit</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>And: A a new Budget is created</li>
		       <li>When: The user wants to quit the program</li>
		       <li>Then: The user can view or alter the dates on the Budget</li>
		  </td>
	 	  <td>Implemented for now</td>
		</tr>
		<tr>
		  <td>BudgetBoss checks for existing Budgets on startup</td>
		  <td>
		    <ul>
		       <li>Given: A new instance of BudgetBoss</li>
		       <li>When: The program initializes</li>
		       <li>Then: It will check for existing budgets</li>
		       <li>And: If any are found, it will ask the user to use an existing or create a new Budget</li>
		  </td>
	 	  <td>Implemented for now</td>
		</tr>
		</tbody>
	<tfoot>
	</tfoot>
</table>
