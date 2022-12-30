<html>
  <link rel="stylesheet" type="text/css" href="./css/style.css"/>
<body>
<h2>Bienvenidos, encuentra tu farmacia</h2>
<a href="http://localhost:8080/VidicDaliborkaFarmacias/listaFarm">Lista de farmacias</a>
<img src="./images/farmacia.png" width="300" height="300"/>
<fieldset>
    <legend>Farmacias cerca de ti</legend>
    <form name="farmaciaForm" method="post" action="vidic_farm"> <br/>
    Nombre de la farmacia: <input type="text" name="farmacia"/> <br/>
    <input type="submit" value="Buscar farmacias cercanas..." />
    </form>
</fieldset>
</body>
</html>
