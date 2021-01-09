# grupos-pi-20-21-proyecto i :books:
grupos-pi-20-21-aal created by GitHub Classroom

# Índice :mag:
  - [Introducción](#introducción)
  - [Grupo](#grupo-1)
  - [Montaje del sistema](#montaje-del-sistema)
  - [Pasarela](#pasarela)
  - [MVC](#mvc)
  - [BBDD](#json)
  - [Interfaz](#interfaz)
  - [Links](#links)

## Introducción
![GitHub Logo](/src/Img/logo.png) 

Proyecto elegido: Gestión de Recursos y Presencia. Para ello hemos creado un sistema de fichado de la siguiente forma:

▪ Permite identificación usuarios

  – Introducción de código
  
  – Tarjeta contactless
  
▪ Permite alta/modificación/consulta CRUD de usuarios

▪ Log del sistema


  NODO CENTRAL (PC)
  
  ▪ Desarrollado en JavaFX y JavaEE
  
  ▪ Con interfaz gráfica de ventanas
  
  ▪ Modelo Vista Controlador (MVC)
  
  ▪ Conexión con pasarela puerto serie (USB)
  
  PASARELA (Arduino)
  
  ▪ Desarrollado con Arduino UNO R3
  
  ▪ Lenguaje de programación --> wiring
  
  ▪ Actúa sobre elementos / Lee sensores
  
  ▪ Conexión con el nodo central por puerto de serie (USB)

## Grupo 1

Miembros del grupo:
 * Andrés Jesús BERMÚDEZ MOQUILLAZA
 * Carlos Del CERRO TENORIO
 * Javier SANZ GIL
 * José David TAPIA YEPES


## Montaje del sistema
Utilizaremos el microcontrolador Arduino UNO R3 y le añadiremos los siguientes módulos para realizar el fichado:

* Sensor 1
* Sensor 2
* Sensor 3

## Pasarela
 :computer: Llamada a la librería PanamaHitek_Arduino agregando las sigueintes líneas al archivo POM:

    <dependency>
        <groupId>com.github.PanamaHitek</groupId>
        <artifactId>PanamaHitek_Arduino</artifactId>
        <version>2.7.2</version>
    </dependency>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
 
 ## MVC
 
 ![GitHub interfaz](/src/Img/mvc.PNG)
 
Nuestro patrón de arquitectura de la aplicación sigue el Modelo Vista Controlador. Esto nos garantiza la reutilización y la flexibilidad del proyecto.
 
 ## BBDD
 
Para la conexión con la base de datos utilizaremos JSON a través de XAMPP. Por lo que utilizaremos la tecnología...
 
 ## Interfaz
Introducir imágenes de la interfaz
 
 ## Links

g  :movie_camera:

https://github.com/jsgn7/ProyectoInformatica1/tree/main/src :link:
https://trello.com/b/p5JMLxpj/aal-grupo-1 :link:
   
   :tm: TEAM : José David, Javier, Andrés Jesús y Carlos. Team 1 of UEM Project
   
   :copyright: GPL
