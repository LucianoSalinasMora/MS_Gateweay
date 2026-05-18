# MS_Gateweay
La puerta de entrada única del ecosistema Sigue Tu Carrera. Se encarga de centralizar todas las llamadas externas y redirigirlas dinámicamente a sus respectivos microservicios.

## Especificaciones Técnicas
* **Puerto de Entrada Único:** `8080`
* **Versión de Núcleo:** Spring Boot 3.3.x / Spring Cloud Gateway (Reactivo - Netty)

## Ventajas de la Arquitectura
* **Abstracción de Puertos:** Postman y los clientes externos solo consumen el puerto `8080`.
* **Rendimiento Asíncrono:** Desarrollado sobre Netty no bloqueante para evitar colisiones de hilos con los servidores de base de datos de Laragon.

## Mapa de Enrutamiento Activo
* `/api/v1/estudiantes/**` -> Redirige a Puerto `8001`
* `/api/v1/asignaturas/**` -> Redirige a Puerto `8002`
* `/api/v1/inscripciones/**` -> Redirige a Puerto `8003`
* `/api/v1/Calificacioness/**` -> Redirige a Puerto `8004`
* `/api/v1/avance-curricular/**` -> Redirige a Puerto `8005`
* `/api/v1/tuition/**` -> Redirige a Puerto `8006`
* `/api/v1/pagos/**` -> Redirige a Puerto `8007`
* `/api/v1/becas/**` -> Redirige a Puerto `8008`
* `/api/v1/notificaciones/**` -> Redirige a Puerto `8009`
