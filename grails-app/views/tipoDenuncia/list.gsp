
<%@ page import="com.sd.TipoDenuncia" %>
<html>
<head>
    <title>List Tipo Denuncias</title>
</head>
<body>
<h1>Tipos de denuncias:</h1>
<g:each in="${tipoDenunciaList}" var="tipoDenunciaInstance">
    Titulo: ${tipoDenunciaInstance.titulo}<br />
    Descripcion: ${tipoDenunciaInstance.descripcion}<br />
</g:each>
<g:link action="create">Create new contact</g:link>
</body>
</html>