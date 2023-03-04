<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>IMC</title>
</head>

<body>
<h1>Calculo IMC Ideal</h1>
<br/>
<form name="formularioIMC" action="calcular" method="GET">
    <table>
        <tr>
            <td><label for="height">Sua altura (m):</label></td>
            <td><input type="text" name="altura" id="height"/></td>
        </tr>
        <tr>
            <td><label for="sex">Seu sexo ('M' ou 'F'):</label></td>
            <td><input type="text" name="sexo" id="sex"/></td>
        </tr>
        <tr>
            <th><input type="submit" value="Enviar" name="enviar"/></th>
        </tr>
    </table>

    <h2>Peso Ideal: ${peso}</h2>
</form>
</body>
</html>