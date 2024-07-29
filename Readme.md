# Fibonacci API

## Descripción

Este es un proyecto de API RESTful desarrollado con Java y Spring Boot. La API permite calcular series de Fibonacci basadas en parámetros proporcionados, como las semillas (X y Y) y la cantidad de números a mostrar. También incluye autenticación básica para proteger los endpoints.

## Características

- **Generación de la Serie de Fibonacci**: Calcula la serie de Fibonacci basándose en las semillas proporcionadas y el número de elementos requeridos.
- **Almacenamiento en Base de Datos**: Guarda las series generadas en una base de datos H2.
- **Autenticación Básica**: Protege los endpoints mediante autenticación básica HTTP.
- **Swagger UI**: Proporciona documentación interactiva de la API a través de Swagger.

## Tecnologías

- **Java 17**
- **Spring Boot 3.x**
- **H2 Database**
- **Spring Security**
- **Swagger**

## Instalación

1. **Clonar el Repositorio**

   Clona el repositorio a tu máquina local:

   ```bash
   git clone https://github.com/ingestebancorrea/fibonacci-backend.git
   cd fibonacci