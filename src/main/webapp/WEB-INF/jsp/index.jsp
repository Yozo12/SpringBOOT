<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>


	<div id="demo"></div>

	<script>
		loadContinent();
		function loadContinent() {
			var xhttp = new XMLHttpRequest();
			var out='';
			var i;
			var params="";
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var arrayContinent = JSON.parse(this.responseText);
					out += '<h2>Continent</h2>';
					for (i=0;i< arrayContinent.length;i++) {
						
						params= "'"+arrayContinent[i]+"'";
						out += '<a onclick=" loadCountries ('+params+' )">'
								+ arrayContinent[i] + '</a><br>'
					}

					document.getElementById("demo").innerHTML = out;

				}
			};
			xhttp.open("GET", "/continent", true);
			xhttp.send();
		}

		function loadCountries(continent) {
			var xhttp = new XMLHttpRequest();
			var i=0;
			var out = '';
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var arrayCountries = JSON.stringify(this.responseText);
					out += '<h2>Countries</h2>';
			     for(i=0;i<arrayCountries.length;i++){
			    	 out += '<p>'+ arrayCountries[i] + '</p><br>'
			     }
			     document.getElementById("demo").innerHTML = out;
				}
				
			};
			xhttp.open("GET", "/"+continent+"/nazioni", true);
			xhttp.send();
		}

	</script>

</body>
</html>
