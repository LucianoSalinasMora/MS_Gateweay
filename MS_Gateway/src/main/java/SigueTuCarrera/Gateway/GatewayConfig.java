package SigueTuCarrera.Gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        String host = System.getenv("URL_MICROSERVICIOS") != null ? System.getenv("URL_MICROSERVICIOS") : "localhost";

        return builder.routes()
            .route("estudiantes-route", r -> r.path("/api/v1/estudiantes/**")
                .filters(f -> f.rewritePath("/api/v1/estudiantes/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8001"))
                
            .route("malla-route", r -> r.path("/api/v0/asignaturas/**", "/api/v0/carreras/**")
                .filters(f -> f.rewritePath("/api/v0/asignaturas/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8002"))
            
            .route("inscripciones-route", r -> r.path("/api/v1/inscripciones/**", "/api/v0/inscripciones/**")
                .filters(f -> f.rewritePath("/api/v1/inscripciones/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8003"))
            
            .route("calificaciones-route", r -> r.path("/api/v1/Calificacioness/**")
                .filters(f -> f.rewritePath("/api/v1/Calificacioness/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8004"))
            
            .route("avance-route", r -> r.path("/api/v0/avance-curricular/**")
                .filters(f -> f.rewritePath("/api/v0/avance-curricular/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8005"))
            
            .route("arancel-route", r -> r.path("/api/v1/tuition/**")
                .filters(f -> f.rewritePath("/api/v1/tuition/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8006"))
            
            .route("pagos-route", r -> r.path("/api/v0/pagos/**")
                .filters(f -> f.rewritePath("/api/v0/pagos/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8007"))
            
            .route("becas-route", r -> r.path("/api/v0/becas/**")
                .filters(f -> f.rewritePath("/api/v0/becas/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8008"))
            
            .route("notificaciones-route", r -> r.path("/api/v0/notificaciones/**")
                .filters(f -> f.rewritePath("/api/v0/notificaciones/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8009"))

            .route("User-route", r -> r.path("/api/v0/User/**")
                .filters(f -> f.rewritePath("/api/v0/User/(?<remaining>.*)", "/${remaining}"))
                .uri("http://" + host + ":8010"))
            
            .build();
    }
}
