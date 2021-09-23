/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.13-MariaDB : Database - dealer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dealer` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dealer`;

/*Table structure for table `beli_cash` */

DROP TABLE IF EXISTS `beli_cash`;

CREATE TABLE `beli_cash` (
  `id_beli` bigint(20) NOT NULL AUTO_INCREMENT,
  `no_beli` varchar(20) DEFAULT NULL,
  `no_ktp` varchar(50) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `notelp` varchar(20) DEFAULT NULL,
  `id_motor` bigint(20) DEFAULT NULL,
  `tgl_beli` datetime DEFAULT NULL,
  PRIMARY KEY (`id_beli`),
  KEY `pembelian_ibfk_1` (`id_motor`),
  CONSTRAINT `beli_cash_ibfk_1` FOREIGN KEY (`id_motor`) REFERENCES `motor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `beli_cash` */

insert  into `beli_cash`(`id_beli`,`no_beli`,`no_ktp`,`nama`,`jenis_kelamin`,`alamat`,`notelp`,`id_motor`,`tgl_beli`) values (1,'TX-0001','3223233232','Gofar','Laki-Laki','jl.jalan','091827172',11,'2021-09-18 07:34:01');

/*Table structure for table `beli_credit` */

DROP TABLE IF EXISTS `beli_credit`;

CREATE TABLE `beli_credit` (
  `id_beli` bigint(20) NOT NULL DEFAULT '0',
  `no_beli` varchar(20) DEFAULT NULL,
  `no_ktp` varchar(50) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `notelp` varchar(20) DEFAULT NULL,
  `id_motor` bigint(20) DEFAULT NULL,
  `tgl_beli` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `beli_credit` */

/*Table structure for table `cicilan` */

DROP TABLE IF EXISTS `cicilan`;

CREATE TABLE `cicilan` (
  `id_cicilan` bigint(20) NOT NULL AUTO_INCREMENT,
  `kode_cicilan` varchar(20) DEFAULT NULL,
  `id_beli` bigint(20) DEFAULT NULL,
  `id_paket` bigint(20) DEFAULT NULL,
  `cicilan_ke` bigint(20) DEFAULT NULL,
  `tgl_bayar` datetime DEFAULT NULL,
  PRIMARY KEY (`id_cicilan`),
  KEY `id_beli` (`id_beli`),
  KEY `id_paket` (`id_paket`),
  CONSTRAINT `cicilan_ibfk_1` FOREIGN KEY (`id_beli`) REFERENCES `beli_cash` (`id_beli`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cicilan_ibfk_2` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id_paket`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cicilan` */

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`id`,`username`,`password`) values (1,'admin','admin');

/*Table structure for table `motor` */

DROP TABLE IF EXISTS `motor`;

CREATE TABLE `motor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kode_motor` varchar(255) DEFAULT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `merk` varchar(20) DEFAULT NULL,
  `warna` varchar(20) DEFAULT NULL,
  `stok` bigint(20) DEFAULT NULL,
  `harga` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `motor` */

insert  into `motor`(`id`,`kode_motor`,`nama`,`merk`,`warna`,`stok`,`harga`) values (11,'M0001','KLX','Kawasaki','Hitam HIjau',10,35000000),(12,'M0002','Beat Street','Honda','Coklat Hitam',5,20000000);

/*Table structure for table `paket` */

DROP TABLE IF EXISTS `paket`;

CREATE TABLE `paket` (
  `id_paket` bigint(20) NOT NULL AUTO_INCREMENT,
  `kode_paket` varchar(20) DEFAULT NULL,
  `id_motor` bigint(20) DEFAULT NULL,
  `jumlah_cicilan` bigint(11) DEFAULT NULL,
  `nilai_cicilan` bigint(20) DEFAULT NULL,
  `bunga` bigint(20) DEFAULT NULL,
  `uang_muka` bigint(20) DEFAULT NULL,
  `harga_total` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_paket`),
  KEY `id_motor` (`id_motor`),
  CONSTRAINT `paket_ibfk_1` FOREIGN KEY (`id_motor`) REFERENCES `motor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `paket` */

insert  into `paket`(`id_paket`,`kode_paket`,`id_motor`,`jumlah_cicilan`,`nilai_cicilan`,`bunga`,`uang_muka`,`harga_total`) values (2,'P-0001',11,36,993055,10,7500000,35750000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
