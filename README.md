# 👥 Sistema de Gestión de Empleados

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![React](https://img.shields.io/badge/React-18-61DAFB)
![Maven](https://img.shields.io/badge/Maven-3.8+-red)

Un sistema completo de gestión de empleados desarrollado con **Spring Boot** (backend) y **React** (frontend), que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos de empleados.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Arquitectura del Proyecto](#-arquitectura-del-proyecto)
- [Prerrequisitos](#-prerrequisitos)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Uso](#-uso)
- [API Endpoints](#-api-endpoints)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Base de Datos](#-base-de-datos)
- [Capturas de Pantalla](#-capturas-de-pantalla)
- [Contribuir](#-contribuir)
- [Licencia](#-licencia)

## ✨ Características

- ✅ **CRUD Completo**: Crear, leer, actualizar y eliminar empleados
- ✅ **API RESTful**: Backend con Spring Boot y endpoints REST
- ✅ **Frontend Moderno**: Interfaz de usuario desarrollada con React
- ✅ **Base de Datos**: Persistencia con MySQL usando JPA/Hibernate
- ✅ **Validación**: Validación de datos tanto en frontend como backend
- ✅ **Arquitectura por Capas**: Separación clara de responsabilidades
- ✅ **CORS Habilitado**: Comunicación fluida entre frontend y backend
- ✅ **Lombok**: Reducción de código boilerplate
- ✅ **Responsive Design**: Interfaz adaptable a diferentes dispositivos

## 🛠 Tecnologías Utilizadas

### Backend
- **Java 21** - Lenguaje de programación
- **Spring Boot 3.5.3** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **Spring Web** - Desarrollo de APIs REST
- **MySQL Connector** - Driver de base de datos
- **Lombok** - Reducción de código boilerplate
- **Maven** - Gestión de dependencias

### Frontend
- **React 18** - Biblioteca de JavaScript para UI
- **Vite** - Herramienta de construcción y desarrollo
- **HTML5 & CSS3** - Estructura y estilos
- **JavaScript ES6+** - Lógica del frontend

### Base de Datos
- **MySQL 8.0** - Sistema de gestión de base de datos

## 🏗 Arquitectura del Proyecto

```
├── Backend (Spring Boot)
│   ├── Controller Layer    → Manejo de peticiones HTTP
│   ├── Service Layer      → Lógica de negocio
│   ├── Repository Layer   → Acceso a datos
│   └── Model Layer        → Entidades JPA
│
├── Frontend (React)
│   ├── Components         → Componentes reutilizables
│   ├── Pages              → Páginas de la aplicación
│   ├── Services           → Servicios para API calls
│   └── Assets             → Recursos estáticos
│
└── Database (MySQL)
    └── gest_empleados     → Base de datos principal
```

## 📋 Prerrequisitos

Antes de comenzar, asegúrate de tener instalado:

- ☑️ **Java 21 o superior**
- ☑️ **Maven 3.8 o superior**
- ☑️ **MySQL 8.0 o superior**
- ☑️ **Node.js 16 o superior** (para el frontend)
- ☑️ **Git** (opcional, para clonar el repositorio)

### Verificar instalaciones:

```bash
java -version
mvn -version
mysql --version
node --version
```

## 🚀 Instalación y Configuración

### 1. Configuración de la Base de Datos

```sql
-- Crear la base de datos (opcional, se crea automáticamente)
CREATE DATABASE IF NOT EXISTS gest_empleados;

-- Crear usuario (opcional)
CREATE USER 'gest_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON gest_empleados.* TO 'gest_user'@'localhost';
FLUSH PRIVILEGES;
```

### 2. Configurar el Backend

1. **Clonar o descargar el proyecto**
2. **Navegar al directorio del proyecto**:
   ```bash
   cd gest-empl
   ```

3. **Configurar la base de datos** en `src/main/resources/application.properties`:
   ```properties
   spring.application.name=gest-empl
   
   # Configuración MySQL
   spring.datasource.url=jdbc:mysql://localhost:3306/gest_empleados?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=root
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Compilar y ejecutar el proyecto**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   O usando el wrapper de Maven:
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

   En Windows:
   ```cmd
   mvnw.cmd clean install
   mvnw.cmd spring-boot:run
   ```

### 3. Verificar el Backend

- El servidor estará corriendo en: `http://localhost:8080`
- Endpoint de prueba: `http://localhost:8080/api/empleados`

## 💻 Uso

### Iniciar la Aplicación

1. **Iniciar MySQL** y asegurarse de que esté corriendo en el puerto 3306
2. **Ejecutar el backend**:
   ```bash
   mvn spring-boot:run
   ```
3. **Abrir el navegador** y navegar a `http://localhost:8080`

### Funcionalidades Disponibles

- 📝 **Crear Empleado**: Agregar nuevos empleados al sistema
- 📋 **Listar Empleados**: Ver todos los empleados registrados
- ✏️ **Editar Empleado**: Modificar información de empleados existentes
- 🗑️ **Eliminar Empleado**: Remover empleados del sistema
- 🔍 **Buscar Empleado**: Encontrar empleados por ID

## 🔗 API Endpoints

### Base URL: `http://localhost:8080/api/empleados`

| Método | Endpoint | Descripción | Cuerpo de la Petición |
|--------|----------|-------------|----------------------|
| `GET` | `/` | Obtener todos los empleados | - |
| `GET` | `/{id}` | Obtener empleado por ID | - |
| `POST` | `/` | Crear nuevo empleado | `{ "nombre": "string", "puesto": "string", "salario": number }` |
| `PUT` | `/{id}` | Actualizar empleado | `{ "nombre": "string", "puesto": "string", "salario": number }` |
| `DELETE` | `/{id}` | Eliminar empleado | - |

### Ejemplos de Uso

#### Crear un nuevo empleado:
```bash
curl -X POST http://localhost:8080/api/empleados \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez",
    "puesto": "Desarrollador Senior",
    "salario": 50000.00
  }'
```

#### Obtener todos los empleados:
```bash
curl -X GET http://localhost:8080/api/empleados
```

#### Actualizar un empleado:
```bash
curl -X PUT http://localhost:8080/api/empleados/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez González",
    "puesto": "Lead Developer",
    "salario": 60000.00
  }'
```

## 📁 Estructura del Proyecto

```
gest-empl/
├── src/
│   ├── main/
│   │   ├── java/com/gest_empl/gest_empl/
│   │   │   ├── GestEmplApplication.java          # Clase principal
│   │   │   ├── controller/
│   │   │   │   ├── EmpleadoController.java       # Controlador REST
│   │   │   │   └── ForwardController.java        # Controlador de rutas
│   │   │   ├── model/
│   │   │   │   └── Empleado.java                 # Entidad JPA
│   │   │   ├── repository/
│   │   │   │   └── EmpleadoRepository.java       # Repositorio JPA
│   │   │   └── service/
│   │   │       ├── IEmpleadoService.java         # Interfaz del servicio
│   │   │       └── EmpleadoService.java          # Implementación del servicio
│   │   └── resources/
│   │       ├── application.properties            # Configuración
│   │       └── static/                           # Archivos estáticos (React build)
│   │           ├── index.html
│   │           ├── alien-svgrepo-com.svg
│   │           └── assets/
│   └── test/
├── target/                                       # Archivos compilados
├── pom.xml                                       # Configuración Maven
├── mvnw                                          # Maven Wrapper (Unix)
├── mvnw.cmd                                      # Maven Wrapper (Windows)
└── README.md                                     # Este archivo
```

## 🗄️ Base de Datos

### Modelo de Datos

**Tabla: empleado**

| Campo | Tipo | Descripción | Restricciones |
|-------|------|-------------|---------------|
| `id_empleado` | INT | Identificador único | PRIMARY KEY, AUTO_INCREMENT |
| `nombre` | VARCHAR(255) | Nombre del empleado | NOT NULL |
| `puesto` | VARCHAR(255) | Puesto de trabajo | NOT NULL |
| `salario` | DOUBLE | Salario del empleado | NOT NULL |

### Script SQL de Creación (Auto-generado por Hibernate)

```sql
CREATE TABLE empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    puesto VARCHAR(255) NOT NULL,
    salario DOUBLE NOT NULL
);
```

## 🎯 Funcionalidades Clave

### Backend (Spring Boot)
- **Arquitectura por Capas**: Controller → Service → Repository → Model
- **Manejo de Errores**: Respuestas HTTP apropiadas
- **CORS Configurado**: Para comunicación con frontend
- **JPA/Hibernate**: ORM para manejo de base de datos
- **Lombok**: Reducción de código boilerplate

### Frontend (React)
- **Componentes Funcionales**: Usando React Hooks
- **Manejo de Estado**: useState y useEffect
- **Comunicación con API**: Fetch API para peticiones HTTP
- **Interfaz Responsive**: Adaptable a diferentes tamaños de pantalla

## 📊 Capturas de Pantalla

### Dashboard Principal
```
┌─────────────────────────────────────────────┐
│  🏢 Sistema de Gestión de Empleados         │
├─────────────────────────────────────────────┤
│  [➕ Agregar Empleado]                      │
│                                             │
│  📋 Lista de Empleados:                     │
│  ┌─────────────────────────────────────────┐ │
│  │ ID | Nombre | Puesto | Salario | Acciones│ │
│  ├─────────────────────────────────────────┤ │
│  │ 1  | Juan   | Dev    | $50000  │ ✏️ 🗑️ │ │
│  │ 2  | Ana    | QA     | $45000  │ ✏️ 🗑️ │ │
│  └─────────────────────────────────────────┘ │
└─────────────────────────────────────────────┘
```

## 🔧 Desarrollo

### Agregar Nuevas Funcionalidades

1. **Backend**: Agregar métodos en el servicio y endpoints en el controlador
2. **Frontend**: Crear nuevos componentes y actualizar el estado
3. **Base de Datos**: Modificar la entidad si es necesario

### Ejecutar en Modo Desarrollo

```bash
# Backend
mvn spring-boot:run

# La aplicación se ejecutará en http://localhost:8080
```

## 🐛 Resolución de Problemas

### Problemas Comunes

1. **Error de conexión a la base de datos**:
   - Verificar que MySQL esté corriendo
   - Confirmar credenciales en `application.properties`

2. **Puerto 8080 ocupado**:
   ```properties
   server.port=8081
   ```

3. **Error de CORS**:
   - Verificar la configuración en `@CrossOrigin`

## 