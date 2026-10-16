# API REST de Libros

CRUD de libros con Spring Boot. Los datos se guardan en memoria (sin base de datos).

## Requisitos
- Java 17+
- Maven 3.8+

## Ejecutar
```bash
git clone <URL_DEL_REPOSITORIO>
cd <carpeta>
mvn spring-boot:run
```

## Endpoints

| Método | Endpoint          | Descripción           | Respuestas      |
|--------|-------------------|-----------------------|-----------------|
| POST   | /api/books        | Registrar un libro    | 201, 400        |
| GET    | /api/books        | Obtener todos         | 200             |
| GET    | /api/books/{id}   | Obtener por ID        | 200, 404        |
| PUT    | /api/books/{id}   | Actualizar un libro   | 200, 400, 404   |
| DELETE | /api/books/{id}   | Eliminar un libro     | 204, 404        |

Ejemplo de body (POST/PUT):
```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publicationYear": 2008,
  "category": "Programación",
  "available": true
}
```

## Swagger
Con la aplicación en ejecución:
- UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs
