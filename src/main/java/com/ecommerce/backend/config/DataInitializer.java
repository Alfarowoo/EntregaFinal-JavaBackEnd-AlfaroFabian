package com.ecommerce.backend.config;

import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.saveAll(Arrays.asList(
                new Product(null, "Smartphone Samsung Galaxy S23", "Potente smartphone con cámara de alta resolución", new BigDecimal("899"), 50, "Celulares", "url_s23"),
                new Product(null, "iPhone 14 Pro", "El último iPhone con chip A16 Bionic", new BigDecimal("1199"), 40, "Celulares", "url_iphone14"),
                new Product(null, "Laptop Lenovo ThinkPad X1", "Laptop empresarial ultraligera", new BigDecimal("1499"), 30, "Laptops", "url_thinkpad"),
                new Product(null, "MacBook Air M2", "Laptop delgada y potente con chip M2", new BigDecimal("1299"), 35, "Laptops", "url_macbook"),
                new Product(null, "Monitor LG UltraWide 34”", "Monitor panorámico para productividad", new BigDecimal("499"), 20, "Monitores", "url_lg_monitor"),
                new Product(null, "Teclado Mecánico HyperX Alloy", "Teclado gamer con switches mecánicos", new BigDecimal("129"), 60, "Periféricos", "url_hyperx"),
                new Product(null, "Mouse Logitech MX Master 3", "Mouse ergonómico para profesionales", new BigDecimal("99"), 70, "Periféricos", "url_mx_master"),
                new Product(null, "Auriculares Sony WH-1000XM5", "Auriculares con cancelación de ruido líder", new BigDecimal("349"), 45, "Audio", "url_sony_xm5"),
                new Product(null, "Tablet iPad Air", "Tablet potente y versátil de Apple", new BigDecimal("599"), 25, "Tablets", "url_ipad_air"),
                new Product(null, "Smartwatch Samsung Galaxy Watch 6", "Reloj inteligente con monitoreo de salud", new BigDecimal("299"), 40, "Wearables", "url_galaxy_watch"),
                new Product(null, "Disco SSD Samsung 1TB", "Almacenamiento rápido y confiable", new BigDecimal("89"), 100, "Almacenamiento", "url_ssd_samsung"),
                new Product(null, "Placa de video NVIDIA RTX 4070", "Tarjeta gráfica para gaming de alto rendimiento", new BigDecimal("699"), 15, "Componentes", "url_rtx4070"),
                new Product(null, "Router TP-Link Archer AX73", "Router Wi-Fi 6 de alta velocidad", new BigDecimal("129"), 30, "Redes", "url_tplink"),
                new Product(null, "Impresora HP DeskJet Plus", "Impresora multifunción para el hogar", new BigDecimal("149"), 20, "Impresoras", "url_hp_printer"),
                new Product(null, "Webcam Logitech C920", "Cámara web Full HD para streaming", new BigDecimal("89"), 50, "Periféricos", "url_c920"),
                new Product(null, "Parlante Bluetooth JBL Charge 5", "Parlante portátil resistente al agua", new BigDecimal("159"), 40, "Audio", "url_jbl"),
                new Product(null, "Micrófono Blue Yeti", "Micrófono USB profesional para grabación", new BigDecimal("129"), 30, "Audio", "url_blue_yeti"),
                new Product(null, "Silla Gamer Razer Iskur", "Silla ergonómica para largas sesiones de juego", new BigDecimal("399"), 10, "Muebles", "url_razer_chair"),
                new Product(null, "Memoria RAM Corsair 16GB DDR4", "Memoria RAM de alto rendimiento", new BigDecimal("59"), 80, "Componentes", "url_corsair_ram"),
                new Product(null, "Cargador portátil Anker PowerCore", "Batería externa de alta capacidad", new BigDecimal("49"), 60, "Accesorios", "url_anker")
            ));
        };
    }
}
