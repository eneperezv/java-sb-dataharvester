-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2024 a las 05:17:13
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dataharvester`
--
CREATE DATABASE IF NOT EXISTS `dataharvester` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dataharvester`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `scraped_data`
--

CREATE TABLE `scraped_data` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `scraped_at` datetime(6) DEFAULT NULL,
  `scraper_task_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `scraper_task`
--

CREATE TABLE `scraper_task` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `frequency_in_minutes` int(11) NOT NULL,
  `last_executed` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `next_scheduled` datetime(6) DEFAULT NULL,
  `status` enum('COMPLETED','ERROR','PENDING','RUNNING') DEFAULT NULL,
  `target_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `scraped_data`
--
ALTER TABLE `scraped_data`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrl46ejb2e1qorq1oxf4amml86` (`scraper_task_id`);

--
-- Indices de la tabla `scraper_task`
--
ALTER TABLE `scraper_task`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `scraped_data`
--
ALTER TABLE `scraped_data`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `scraper_task`
--
ALTER TABLE `scraper_task`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `scraped_data`
--
ALTER TABLE `scraped_data`
  ADD CONSTRAINT `FKrl46ejb2e1qorq1oxf4amml86` FOREIGN KEY (`scraper_task_id`) REFERENCES `scraper_task` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
