package SigueTuCarrera.Gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("estudiantes-route", r -> r.path("/api/v1/estudiantes/**")
                .uri("http://localhost:8001"))

            .route("malla-route", r -> r.path("/api/v0/asignaturas/**", "/api/v0/carreras/**")
                .uri("http://localhost:8002"))
            
            .route("inscripciones-route", r -> r.path("/api/v1/inscripciones/**", "/api/v0/inscripciones/**")
                .uri("http://localhost:8003"))
            
            .route("calificaciones-route", r -> r.path("/api/v1/Calificacioness/**")
                .uri("http://localhost:8004"))
            
            .route("avance-route", r -> r.path("/api/v0/avance-curricular/**")
                .uri("http://localhost:8005"))
            
            .route("arancel-route", r -> r.path("/api/v1/tuition/**")
                .uri("http://localhost:8006"))
            
            .route("pagos-route", r -> r.path("/api/v0/pagos/**")
                .uri("http://localhost:8007"))
            
            .route("becas-route", r -> r.path("/api/v0/becas/**")
                .uri("http://localhost:8008"))
            
            .route("notificaciones-route", r -> r.path("/api/v0/notificaciones/**")
                .uri("http://localhost:8009"))
            
            .build();
    }
}