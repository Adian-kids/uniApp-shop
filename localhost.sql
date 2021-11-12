-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2021-11-12 17:06:09
-- 服务器版本： 5.6.49-log
-- PHP 版本： 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `ChinaSoft`
--
CREATE DATABASE IF NOT EXISTS `ChinaSoft` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ChinaSoft`;

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--

CREATE TABLE `goods` (
  `goodId` int(11) NOT NULL,
  `title` varchar(128) NOT NULL,
  `price` varchar(128) NOT NULL,
  `img` varchar(128) NOT NULL,
  `content` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`goodId`, `title`, `price`, `img`, `content`) VALUES
(1, 'Apple iPhone X 256GB 深空灰色 移动联通电信4G手机', '9999', 'http://www.e-wolf.top/usr/uploads/2021/10/2264366338.jpg', '这是手机的一个相信信息'),
(2, 'Apple iPad 平板电脑 2018年新款9.7英寸', '3499', 'http://www.e-wolf.top/usr/uploads/2021/10/438363197.jpg', '这是平板的一个详细信息'),
(3, 'Apple MacBook Pro 13.3英寸笔记本电脑（2017款Core i5处理器/8GB内存/256GB硬盘 MupxT2CH/A）', '12999', 'http://www.e-wolf.top/usr/uploads/2021/10/703168637.jpg', '这是macbook的一个详细信息'),
(4, 'Kindle Paperwhite电纸书阅读器 电子书墨水屏 6英寸wifi 黑色', '1299', 'http://www.e-wolf.top/usr/uploads/2021/10/3280686217.jpg', '这是kindle的一个详细信息'),
(5, '微软（Microsoft）新Surface Pro 二合一平板电脑笔记本 12.3英寸（i5 8G内存 256G存储）', '8888', 'http://www.e-wolf.top/usr/uploads/2021/10/23504471.jpg', '这是surface的一个详细信息'),
(6, 'Apple Watch Series 3智能手表（GPS款 42毫米 深空灰色铝金属表壳 黑色运动型表带 MQL12CH/A）', '3599', 'http://www.e-wolf.top/usr/uploads/2021/10/3368781458.jpg', '这是apple watch的一个详细信息'),
(8, '新款手机', '1999', 'http://www.e-wolf.top/usr/uploads/2021/10/438363197.jpg', '这是最新款的手机哦');

-- --------------------------------------------------------

--
-- 表的结构 `manager`
--

CREATE TABLE `manager` (
  `managerId` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  `passwd` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `manager`
--

INSERT INTO `manager` (`managerId`, `username`, `passwd`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `orders`
--

CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL,
  `userId` int(128) NOT NULL,
  `goodId` int(128) NOT NULL,
  `state` int(11) NOT NULL,
  `express` varchar(128) NOT NULL DEFAULT '暂无单号',
  `recvAddress` varchar(128) NOT NULL,
  `phone` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `orders`
--

INSERT INTO `orders` (`orderId`, `userId`, `goodId`, `state`, `express`, `recvAddress`, `phone`, `name`) VALUES
(1, 2, 2, 1, '123123', '收货地址', '123123123', 'haha'),
(2, 2, 6, 1, 'YT6123678215783', '天津市', '18812334567', '测试名'),
(3, 2, 2, 0, 'null', '阿斯顿', '1998273', '王大锤'),
(4, 2, 4, 1, '432423423', '测试', '123213', '测试'),
(5, 2, 5, 0, 'null', '天上', '12321312', '王大锤'),
(9, 2, 3, 0, 'null', 'asd asd ', '343431', '阿斯顿撒'),
(10, 2, 6, 0, 'null', '哈哈哈哈', '123456', '大锤'),
(11, 11, 2, 1, 'YT6123678215783', '天津市宝坻区', '15543233241', '王大锤'),
(12, 11, 4, 0, '暂无单号', '天津市宝坻区', '18876225677', '王大锤女朋友');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `email` varchar(128) NOT NULL,
  `passwd` varchar(128) NOT NULL,
  `nickname` varchar(128) NOT NULL,
  `phone` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`userId`, `email`, `passwd`, `nickname`, `phone`) VALUES
(2, 'test@test.com', '76A2173BE6393254E72FFA4D6DF1030A', 'HahHa', '12233333333'),
(11, 'admin@admin.com', 'E10ADC3949BA59ABBE56E057F20F883E', 'wangdachui', '17712344321');

--
-- 转储表的索引
--

--
-- 表的索引 `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`goodId`);

--
-- 表的索引 `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`managerId`);

--
-- 表的索引 `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderId`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `goods`
--
ALTER TABLE `goods`
  MODIFY `goodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `manager`
--
ALTER TABLE `manager`
  MODIFY `managerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `orders`
--
ALTER TABLE `orders`
  MODIFY `orderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
