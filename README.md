# Foro Hub  

Foro Hub es una API REST desarrollada en Java utilizando el framework Spring Boot. Permite gestionar tópicos mediante las operaciones básicas de CRUD (Crear, Leer, Actualizar y Eliminar). Implementa autenticación y autorización mediante Spring Security y JWT, además de un manejo robusto de errores para mejorar la experiencia del usuario.

## Tecnologías Utilizadas  
- **Java**: Versión 17 o superior  
- **Spring Boot**: Versión 3 o superior  
- **Maven**: Versión 4 o superior  
- **Spring Security**  
- **JWT (JSON Web Tokens)**  
- **MySQL**: Versión 8 o superior  
- **Flyway**: Para migraciones de base de datos  
- **Lombok**: Para reducir el código repetitivo  
- **IntelliJ IDEA** (opcional, como IDE recomendado)  
- **Insomnia**: Para realizar pruebas de las rutas de la API  

## Dependencias Principales  
El archivo `pom.xml` incluye las siguientes dependencias principales:  
- **Spring Web**: Para la creación de APIs REST  
- **Spring Boot DevTools**: Para recarga automática de cambios en desarrollo  
- **Spring Data JPA**: Para el acceso a la base de datos con Hibernate  
- **Flyway Migration**: Para la evolución de la base de datos  
- **MySQL Driver**: Para conectarse a MySQL  
- **Validation**: Para validar datos de entrada  
- **Spring Security**: Para autenticación y autorización  
- **Lombok**: Para reducir el código repetitivo  

## Funcionalidades de la API  
### Tópicos  
- Crear un nuevo tópico  
- Mostrar todos los tópicos creados  
- Mostrar un tópico específico por ID  
- Actualizar un tópico  
- Eliminar un tópico  

### Seguridad  
- Autenticación con JWT  
- Restricción de acceso a las rutas protegidas mediante Spring Security  

### Manejo de Errores  
- Mensajes claros y específicos en caso de errores  
- Validación para evitar duplicados de títulos o mensajes  
- Mensajes personalizados si un tópico no se encuentra o si se intenta eliminar un tópico inexistente  

## Configuración del Entorno  
### Requisitos Previos  
1. **Java JDK**: Instalar versión 17 o superior  
2. **Maven**: Asegurarse de tener versión 4 o superior instalada  
3. **MySQL**: Instalar versión 8 o superior y crear una base de datos para la aplicación  
4. **IDE**: Se recomienda usar IntelliJ IDEA  



## Estructura del Proyecto  
El proyecto sigue una arquitectura modular y organizada:  

- **`controller`**: Contiene los controladores REST para manejar las solicitudes HTTP  
- **`repository`**: Gestiona el acceso a la base de datos mediante JPA  
- **`domain`**: Incluye las entidades principales y sus DTOs  
  - Paquete `topicos`: Entidad y lógica relacionada con los tópicos  
  - Paquete `usuarios`: Entidad y lógica relacionada con los usuarios  
- **`errores`**: Maneja excepciones personalizadas y errores  
- **`security`**: Configuración de Spring Security y generación de JWT  

## Endpoints Principales  
## Login
1. Iniciar Sesion con el usuario registrado
   - `POST http://localhost:8080/login`  
   ![image](https://github.com/user-attachments/assets/76cf0772-d000-46bc-b0aa-d8b8c3eeaeaa)

### Tópicos  
1. **Crear un nuevo tópico**  
   - `POST http://localhost:8080/topicos`  
![image](https://github.com/user-attachments/assets/bbf2b15f-db58-43c7-8723-bab57469626b)
![image](https://github.com/user-attachments/assets/2dafdef8-211b-45cc-9526-c0eb4a2170b9)


2. **Listar todos los tópicos**  
   - `GET http://localhost:8080/topicos`  
![image](https://github.com/user-attachments/assets/040309df-b4eb-4271-919d-ce77953947c1)

3. **Mostrar un tópico específico por ID**  
   - `GET http://localhost:8080/topicos/{id}`  
![image](https://github.com/user-attachments/assets/b57a708d-c8d5-41ae-8ef7-e7aac814aa7f)

4. **Actualizar un tópico**  
   - `PUT http://localhost:8080/topicos/{id}`  
![image](https://github.com/user-attachments/assets/e45736ca-7123-4fdb-aa3a-ba867d9f4c0b)

5. **Eliminar un tópico**  
   - `DELETE http://localhost:8080/topicos/{id}`  
![image](https://github.com/user-attachments/assets/d9da6b34-0d89-4384-9ef0-73de46194643)

## Pruebas de la API  
Utiliza herramientas como **Insomnia** para probar las rutas. Asegúrate de autenticarte primero para acceder a las rutas protegidas.  
