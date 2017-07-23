// Wait for DOM to load
document.addEventListener("DOMContentLoaded", function(event) {

	// Put the button into a variable
	var buttonWithClick = document.getElementById("go");

	// Wait for user to click the button
	buttonWithClick.addEventListener("click", function() {

		// Refresh current page
		document.location.reload(true);

	}, false);

	// Test the refresh by outputting the time in milliseconds
	document.getElementById("timestamp").innerText = new Date().getTime();

});
