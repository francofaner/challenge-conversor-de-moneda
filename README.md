# challenge-conversor-de-moneda

Aplicación en Java para conversión de monedas usando API de tasas de cambio.

# Conversor de Monedas - Java

Aplicación de consola desarrollada en **Java** que permite convertir valores entre distintas monedas utilizando una **API de tasas de cambio en tiempo real**.

Este proyecto fue desarrollado como parte del **Challenge Conversor de Monedas del programa ONE (Oracle Next Education) - Alura Latam**.

---

# Descripción

El Conversor de Monedas permite al usuario seleccionar diferentes opciones de conversión desde un **menú interactivo en consola**, ingresar un valor y obtener el resultado convertido utilizando tasas actualizadas obtenidas desde una API externa.

La aplicación utiliza:

* **Java 17**
* **HttpClient (Java API)**
* **ExchangeRate API**
* **Gson para procesar JSON**
* **Scanner para interacción con el usuario**

---

# Tecnologías utilizadas

| Tecnología       | Descripción                     |
| ---------------- | ------------------------------- |
| Java 17          | Lenguaje principal del proyecto |
| Gson             | Biblioteca para parsear JSON    |
| HttpClient       | Cliente HTTP nativo de Java     |
| IntelliJ IDEA    | IDE utilizado                   |
| ExchangeRate API | API externa de tasas de cambio  |
| Postman          | Pruebas de API                  |

---

# API utilizada

Este proyecto utiliza la API:

ExchangeRate API

Endpoint utilizado:

```
https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{BASE}/{TARGET}/{AMOUNT}
```

Ejemplo:

```
https://v6.exchangerate-api.com/v6/MI_API_KEY/pair/USD/ARS/100
```

---

# Estructura del proyecto

```
conversor-monedas
│
├── src
│   └── com.alura.conversor
│       │
│       ├── Principal.java
│       │
│       ├── service
│       │   └── ConsultaMoneda.java
│       │
│       └── model
│           └── ResultadoConversion.java
│
└── README.md
```

---

# Cómo ejecutar el proyecto

### 1. Clonar el repositorio

```
git clone https://github.com/tu-usuario/conversor-monedas-java.git
```

---

### 2. Abrir el proyecto en IntelliJ IDEA

Abrir el proyecto desde:

```
File → Open → Seleccionar carpeta del proyecto
```

---

### 3. Agregar la biblioteca Gson

En IntelliJ:

```
File → Project Structure → Modules → Dependencies → + → Library
```

Buscar:

```
gson
```

Seleccionar la versión **2.10.1 o superior**

---

### 4. Obtener una API KEY

Registrarse en:

https://www.exchangerate-api.com

Luego reemplazar en el código:

```java
String apiKey = "TU_API_KEY_AQUI";
```

---

### 5. Ejecutar el programa

Ejecutar la clase:

```
Principal.java
```

---

# Ejemplo de uso

```
*************************************************
Sea bienvenido/a al Conversor de Moneda

1) Dólar => Peso argentino
2) Peso argentino => Dólar
3) Dólar => Real brasileño
4) Real brasileño => Dólar
5) Dólar => Peso colombiano
6) Peso colombiano => Dólar
7) Salir

Elija una opción válida
*************************************************

Ingrese el valor que desea convertir:

100
```

Resultado:

```
El valor 100 USD corresponde a 108234.56 ARS
```

---

# Funcionalidades

✔ Conversión entre múltiples monedas
✔ Consumo de API externa
✔ Procesamiento de JSON con Gson
✔ Interfaz interactiva en consola
✔ Manejo básico de errores

---

# Monedas soportadas

| Código | Moneda               |
| ------ | -------------------- |
| USD    | Dólar estadounidense |
| ARS    | Peso argentino       |
| BRL    | Real brasileño       |
| COP    | Peso colombiano      |

---

# Autor

**Franco Faner**

Estudiante de programación | Oracle Next Education - Alura Latam

---
