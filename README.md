# weibo

在本地新建数据库``weibo2_0``
建立数据表``t_user``
| t_user | CREATE TABLE `t_user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=100004 DEFAULT CHARSET=utf8 |

建立数据表
``t_file``
create table t_file(fid int(10) not null auto_increment, uid int(10), uname varchar(100), txt varchar(3000), saveTime timestamp not null default now(), url varchar(100), try int, PRIMARY KEY (fid));