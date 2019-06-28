
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>City</title>
</head>
<body>

	<div align="center">
		<table>
			<thead>
				<tr>
					<td>CITTA</td>
				</tr>
			</thead>
			<tbody>
				<table>
					<thead>
						<tr>
							<td></td>
							<form>
								<td><input name="ord" type="submit" value="${AZ}"
									formaction="/citta/ordina">
								<td><input name="ord" type="submit" value="${POPA}"
									formaction="/citta/ordina"> <input
									name="codNazione" type="hidden" value="${citta[1].codNation}">
							</form>
						</tr>
					</thead>

					<tbody>
						<a href="/citta-load-edit?id=0">Inserisci</a>
						</p>
						<c:forEach items="${citta}" var="c">
							<tr>
								<td>
									<form>
										<input value="Elimina" type="submit"
											formaction="/delete"> <input
											name="cityid" type="hidden" value="${c.id}"> <input
											name="codNazione" type="hidden" value="${c.codNation}">
										<a href="/citta-load-edit?id=${c.id }">MODIFICA
										</a>
									</form>
								</td>

								<td>${c.cityName}</td>
								<td>${c.population}</td>
							</tr>
						</c:forEach>
						<a href="/continent">TORNA INDIETRO</a>

					</tbody>
				</table>
				</div>
</body>
</html>