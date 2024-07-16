# InitiativeApp
Autor: Fernando Regidor Salazar 
An initiative, HP, and condition tracker for D&amp;D 5e

Requisitos de la app:

•Debe constar de al menos tres actividades diferentes: Incorpora el uso de dos actividades, "MainActivity" y "CreateEditActivity", teniendo "MainActivity" implementado un RecyclerView complejo con al menos 5 funcionalidades diferentes.

•Debe poder pasar un extra (parámetro) entre al menos dos actividades, recuperarlo y usarlo en la segunda actividad: Desde la actividad "MainActivity", en la función "navigateToDetail", pasamos el id del elemento como extra mediante el intent, y lo recibimos en la actividad "CreateEditActivity" para operar a la hora de editar un elemento ya creado en la base de datos.

• Debe mostrar al menos un diálogo en respuesta a una acción del usuario: Se muestran diálogos mediante Toast al guardar, editar o borrar un elemento en la base de datos, y otro mostrando los resultados obtenidos de la función rollInitiative al ejecutarla para cada uno de los elementos. También se muestran AlertDialogs mediante la función "setConditionLongClickListener" para desplegar la información de detalle de las condiciones.

• Debe implementar un sistema de sesión, guardando al menos un valor en sesión mediante SharedPreferences: Se almacena en la sesión mediante SharedPreferences mediante la función saveInitiative el valor obtenido de sumar los resultados de la función "rollInitiative" al parámetro initiative de cada uno de los elementos, asociado al ID. Después se obtiene desde la función "loadData" del "MainActivity", a través de la función "getInitiative" para ordenar los elementos del RecyclerView. 


• Debe incluir una tabla en una base de datos (SQLite) para almacenar y gestionar datos relevantes para la aplicación: Tabla generada en la data class "Character", gestionada mediante "CharacterDAO".

• Debe realizar llamadas a un API Rest para obtener datos: Para esta app no fue necesario ni funcional el uso de una API Rest.

• Debe utilizar un RecyclerView para mostrar una lista deelementos, y capturar al menos un evento de clic en cada elemento con una función lambda: En el RecyclerView "recyclerView", ubicado en el layout "activity_main", se muestran los elementos de la tabla "Character", y se capturan eventos de click y longClick para diferentes elementos mediante funciones lambda.

• Mostrar un menú en la AppBar (barra superior): En la actividad principal "MainActivity" se crea el menú con el layout "activity_main_menu", que contiene un botón utilizado para navegar a la vista de creación de elementos en la tabla ("CreateEditActivity").

• Internacionalización (un idioma es suficiente): Los textos no provinientes de la base de datos han sido todos almacenados en strings llamados mediante id.

• Usar ViewBinding en vez de findViewById(resId: Int): Todos los elementos de layout se han buscado mediante ViewBinding, a excepción de los TextView e ImageView del Alert Dialog ubicado en el adaptador "CharacterAdapter", dado que no se puede utilizar binding con dos layouts diferentes.

• Investigar y usar TextField de Material Design: Se ha implementado el uso de TextField en la actividad "CreateEditActivity" para recibir los datos de creación y edición de elementos, funcionando como EditText.
