# 🏠 Sistema de Gestión Inmobiliaria

Este proyecto es una aplicación Java diseñada para gestionar operaciones inmobiliarias. Ayuda a los agentes y empresas inmobiliarias a optimizar 
sus procesos y gestionar eficientemente propiedades, clientes, ventas y pagos.

Características Principales:
- **Gestión de Clientes**: Registra y administra la información de los clientes.
- **Gestión de Propiedades**: Añade, actualiza y rastrea los detalles de las propiedades.
- **Gestión de Ventas**: Registra y administra las ventas de propiedades.
- **Seguimiento de Pagos**: Realiza un seguimiento de los pagos realizados por los clientes.
- **Gestión de Vendedores**: Administra la información de los vendedores.

## 🏗️ Estructura del Proyecto

El proyecto sigue el patrón de diseño **Modelo-Vista-Controlador (MVC)**:

- **Modelo (`Modelo`)**: Representa los datos y la lógica de negocio de la aplicación. Incluye clases como `Cliente.java`, `Inmueble.java`, `Compra.java`, `Pago.java` y `Vendedor.java`.
- **Vista (`Vista`)**: Representa la interfaz de usuario (UI) de la aplicación. Incluye formularios Java Swing para interactuar con el usuario, como `GestionClientes.java`, `GestionPropiedad.java` y `Login.java`.
- **Controlador (`Controlador`)**: Actúa como intermediario entre el Modelo y la Vista. Maneja la entrada del usuario, actualiza el Modelo y selecciona la Vista apropiada para mostrar. Ejemplalos incluyen `ClienteControlador.java` e `InmuebleControlador.java`.

El proyecto también utiliza el siguiente patrón **Data Access Object (DAO)**:

- **DAO (`Dao`)**: Proporciona una interfaz abstracta para algún tipo de base de datos u otro mecanismo de persistencia. Incluye clases como `ClienteDAO.java`, `InmuebleDAO.java`, e interfaces como `ICliente.java`, `IInmueble.java`.

### ✨ Patrones de Diseño Utilizados

En este proyecto se implementan varios patrones de diseño para mejorar su estructura y mantenibilidad:

- **Patrón Factory (`PatronFactory`)**: Se utiliza para crear objetos sin exponer la lógica de instanciación al cliente. Ver `ClienteFactory.java`, `InmuebleFactory.java`, etc.
- **Patrón Singleton (`PatronSingleton`)**: Asegura que una clase tenga solo una instancia y proporciona un punto de acceso global a ella. Se utiliza para `DatabaseConnection.java`.
- **Patrón Decorator (`PatronDecorator`)**: Permite añadir comportamiento a un objeto individual, ya sea estática o dinámicamente, sin afectar el comportamiento de otros objetos de la misma clase. Se utiliza para características de propiedades como `InmuebleConCochera.java` (propiedad con cochera) e `InmuebleConTerraza.java` (propiedad con terraza).
- **Patrón Observer (`PatronesObserver`)**: Define una dependencia uno-a-muchos entre objetos para que cuando un objeto cambie de estado, todos sus dependientes sean notificados y actualizados automáticamente. Se utiliza para el sistema de notificación (`SistemaNotificacion.java`).

## 🚀 Cómo Ejecutar el Proyecto

Para ejecutar este proyecto, necesitarás:

- **Java Development Kit (JDK)**: Versión 8 o superior.
- **Apache NetBeans**: IDE recomendado para abrir y ejecutar el proyecto.
- **Base de Datos MySQL**: Es probable que el proyecto requiera una base de datos MySQL. Es posible que necesites configurar la conexión a la base de datos en `PatronSingleton/DatabaseConnection.java`.

**Pasos para ejecutar la aplicación:**

1.  **Clona el repositorio o descarga el código fuente.**
2.  **Abre el proyecto en Apache NetBeans.**
    - Haz clic en `Archivo -> Abrir Proyecto` y selecciona la carpeta del proyecto.
3.  **Configura la base de datos.**
    - Asegúrate de que tu servidor MySQL esté en funcionamiento.
    - Es posible que necesites crear una base de datos y tablas. (Busca un archivo `.sql` en el proyecto o revisa `DatabaseConnection.java` para el nombre de la base de datos y las credenciales).
    - Actualiza los detalles de conexión de la base de datos en `src/PatronSingleton/DatabaseConnection.java` si es necesario:
      ```java
      private static final String URL = "jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos"; // Reemplaza nombre_de_tu_base_de_datos
      private static final String USER = "tu_usuario"; // Reemplaza tu_usuario
      private static final String PASSWORD = "tu_contraseña"; // Reemplaza tu_contraseña
      ```
4.  **Limpia y Construye el proyecto.**
    - Haz clic derecho en el proyecto en NetBeans y selecciona `Limpiar y Construir`.
5.  **Ejecuta la aplicación principal.**
    - Localiza el archivo `App/Main.java`.
    - Haz clic derecho en `Main.java` y selecciona `Ejecutar Archivo`.

Esto debería iniciar la aplicación, comenzando con la ventana de inicio de sesión.

## 🧑‍💻 Desarrollado por Aarón Silva Chorres

**Universidad:** Universidad Tecnológica del Perú
**Curso:** Diseño de Patrones
**Año:** 2024

## 📂 Estructura del Código Fuente (`src`)

El código fuente del proyecto está organizado en los siguientes paquetes principales:

- **`App`**: Contiene la clase principal (`Main.java`) que inicia la aplicación.
- **`Controlador`**: Contiene las clases controladoras que manejan la lógica de la aplicación y la interacción entre la Vista y el Modelo.
    - `ClienteControlador.java`
    - `CompraControlador.java`
    - `InmuebleControlador.java`
    - `LoginController.java`
    - `PagoControlador.java`
    - `VendedorControlador.java`
- **`Dao`**: Contiene las clases de Acceso a Datos (Data Access Objects) responsables de interactuar con la base de datos.
    - `ClienteDAO.java`, `ICliente.java` (interfaz)
    - `CompraDAO.java`, `ICompra.java` (interfaz)
    - `InmuebleDAO.java`, `IInmueble.java` (interfaz)
    - `PagoDAO.java`, `IPago.java` (interfaz)
    - `UsuarioDAO.java`
    - `VendedorDAO.java`, `IVendedor.java` (interfaz)
- **`Modelo`**: Contiene las clases que representan las entidades del dominio del problema (los datos).
    - `Cliente.java`
    - `Compra.java`
    - `Inmueble.java`
    - `Pago.java`
    - `Usuario.java`
    - `Vendedor.java`
- **`Vista`**: Contiene las clases que conforman la interfaz gráfica de usuario (GUI), desarrolladas con Java Swing.
    - `GestionClientes.java` & `GestionClientes.form`
    - `GestionCompra.java` & `GestionCompra.form`
    - `GestionPropiedad.java` & `GestionPropiedad.form`
    - `GestionVendedor.java` & `GestionVendedor.form`
    - `HistorialPagos.java` & `HistorialPagos.form`
    - `Login.java` & `Login.form`
    - `Menu.java` & `Menu.form`
- **`PatronDecorator`**: Implementación del patrón Decorator para añadir funcionalidades extras a los inmuebles.
    - `InmuebleBase.java`
    - `InmuebleDecorator.java`
    - `InmuebleConCochera.java`
    - `InmuebleConTerraza.java`
- **`PatronFactory`**: Implementación del patrón Factory para la creación de objetos.
    - `ClienteFactory.java`
    - `CompraFactory.java`
    - `InmuebleFactory.java`
    - `PagoFactory.java`
    - `VendedorFactory.java`
- **`PatronSingleton`**: Implementación del patrón Singleton para la conexión a la base de datos.
    - `DatabaseConnection.java`
- **`PatronesObserver`**: Implementación del patrón Observer para el sistema de notificaciones.
    - `Observer.java` (interfaz)
    - `SistemaNotificacion.java`
- **`Imagenes`**: Contiene las imágenes utilizadas en la interfaz de usuario.

Esta estructura ayuda a mantener el código organizado, modular y facilita su mantenimiento y escalabilidad.
