# 🧠 Prueba Técnica - ZARA (Spring Boot + Swagger + Testing)

Este repositorio contiene la solución a la prueba técnica propuesta por ZARA para el puesto de desarrollador backend.  
El proyecto consiste en una API REST construida con **Spring Boot**, que permite consultar el precio final aplicable de un producto, según la **fecha de consulta**, el **identificador del producto** y el **identificador de la marca**.

He seguido una arquitectura limpia, usando buenas prácticas (principios SOLID, separación de capas, inyección de dependencias), incluyendo además:
- **Swagger** para la documentación automática de la API.
- **JUnit 5** y **Mockito** para pruebas unitarias del servicio principal.
- **Tests de integración** con Spring y MockMvc para el controlador REST.
- **Base de datos H2 en memoria** para facilitar pruebas y ejecución inmediata.
- Código limpio, legible y mantenible.

---

## 🔧 Tecnologías utilizadas

- ☕ Java 17  
- 🚀 Spring Boot 3.4.4  
- 🧪 JUnit 5 & Mockito  
- 📘 Swagger / OpenAPI 3  
- 🛢️ H2 Database (memoria)  
- 🛠️ Maven

---

## ▶️ Cómo ejecutar la aplicación

```bash
mvn spring-boot:run
```

> Esto levanta el backend en `http://localhost:8080`.

---

## 🧪 Cómo ejecutar los tests

```bash
mvn clean test
```

Incluye tanto tests unitarios del servicio como tests de integración del controlador.

---

## 📬 Endpoint principal

```http
GET /api/prices?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1
```

📌 Este endpoint devuelve el precio final correspondiente a ese producto en esa fecha, aplicando correctamente la prioridad y rango de fechas.

---

## 🧭 Swagger UI

La documentación de la API está disponible automáticamente en:

```bash
http://localhost:8080/swagger-ui.html
```

---

## 👨‍💻 Desarrollado por Edgar Nuñez

Este proyecto ha sido diseñado con mimo y enfoque profesional para mostrar mis habilidades en desarrollo backend con Java y Spring Boot.  
Estoy disponible para entrevistas técnicas o cualquier feedback constructivo sobre el código. ¡Gracias por la oportunidad!

🔗 GitHub: [github.com/3dgar7eandro](https://github.com/3dgar7eandro)
