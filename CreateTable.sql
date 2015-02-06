CREATE TABLE `groupmembers` (
  `idgroupmembers` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `groupid` int(11) NOT NULL,
  `groupadmin` tinyint(1) NOT NULL DEFAULT '0',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idgroupmembers`),
  UNIQUE KEY `idgroupmembers_UNIQUE` (`idgroupmembers`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `groups` (
  `idgroups` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idgroups`),
  UNIQUE KEY `idgroups_UNIQUE` (`idgroups`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `keylog` (
  `idkeylog` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `keyid` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `outtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `intime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idkeylog`),
  UNIQUE KEY `idnew_table_UNIQUE` (`idkeylog`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `keys` (
  `idkeys` int(11) NOT NULL AUTO_INCREMENT,
  `keycode` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `groupid` int(11) NOT NULL,
  `permission_required` tinyint(1) NOT NULL DEFAULT '1',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idkeys`),
  UNIQUE KEY `idkeys_UNIQUE` (`idkeys`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `onecard` int(11) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idusers`),
  UNIQUE KEY `idusers_UNIQUE` (`idusers`),
  UNIQUE KEY `onecard_UNIQUE` (`onecard`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
