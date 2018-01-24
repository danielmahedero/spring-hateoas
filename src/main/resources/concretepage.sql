-- phpMyAdmin SQL Dump
-- version 3.5.7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-10-2017 a las 01:53:23
-- Versión del servidor: 5.5.29
-- Versión de PHP: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de datos: `concretepage`
--

CREATE DATABASE concretepage;
USE concretepage;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articles`
--

CREATE TABLE `articles` (
  `article_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `articles`
--

INSERT INTO `articles` (`article_id`, `title`, `category`) VALUES
(1, 'Java Concurrency', 'Java'),
(2, 'Hibernate HQL ', 'Hibernate'),
(3, 'Spring MVC with Hibernate', 'Spring'),
(4, 'New Title', 'News'),
(11, 'New Title', 'News'),
(12, 'New Title', 'News'),
(13, 'New article title', 'New article category');

DROP TABLE dress_category;
CREATE TABLE dress_category (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB;


CREATE TABLE dress (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dress_category_id INT,
  name varchar(255) NOT NULL,
  INDEX par_ind (dress_category_id),
  CONSTRAINT fk_dress_category FOREIGN KEY (dress_category_id)
  REFERENCES dress_category(id)
  ON DELETE CASCADE
  ON UPDATE CASCADE
) ENGINE=INNODB;
