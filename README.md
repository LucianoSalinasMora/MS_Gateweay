MS_Gateway
La puerta de entrada única del ecosistema Sigue Tu Carrera. Se encarga de centralizar todas las llamadas externas, procesar el ruteo hacia la documentación y redirigir dinámicamente el tráfico eliminando los prefijos de las URL hacia sus respectivos microservicios.

Especificaciones Técnicas
Puerto de Entrada Único: 8000

Versión de Núcleo: Spring Boot 3.4.1 / Spring Cloud Gateway (Reactivo - Netty)

Ventajas de la Arquitectura
Abstracción de Puertos: Los clientes externos y la interfaz de Swagger consumen exclusivamente el puerto 8000.

Rendimiento Asíncrono: Desarrollado sobre Netty no bloqueante para evitar colisiones de hilos con los servidores de base de datos de Laragon.

Mapa de Enrutamiento y Filtros Activos
El Gateway reescribe las rutas eliminando el prefijo del microservicio antes de enviarlo al contenedor destino:

/api/v0/Estudiante/ -> Redirige a Puerto 8001

/api/v0/Malla/ -> Redirige a Puerto 8002

/api/v0/Inscripcion/ -> Redirige a Puerto 8003

/api/v0/Calificaciones/ -> Redirige a Puerto 8004

/api/v0/AvanceCurricular/ -> Redirige a Puerto 8005

/api/v0/Arancel/ -> Redirige a Puerto 8006

/api/v0/Pagos/ -> Redirige a Puerto 8007

/api/v0/Becas/ -> Redirige a Puerto 8008

/api/v0/Notificaciones/ -> Redirige a Puerto 8009

/api/v0/User/ -> Redirige a Puerto 8010 (Filtros de Auth)

Documentación Agregada
Swagger UI: Configurado para agregar la documentación OpenAPI de todos los microservicios del ecosistema en una sola interfaz unificada.
