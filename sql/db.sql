create database lottery;
use lottery;
create table `lottery_log` (
  `id` bigint(20) not null auto_increment,
  `uid` bigint(20) default null,
  `prize` int(11) default null,
  `prize_name` varchar(200) default null,
  `create_time` datetime default null,
  `ip` varchar(64) default null,
  `status` int(11) default null,
  `update_time` datetime default null,
  primary key (`id`)
) engine=innodb ;

create table `prize` (
  `id` int(11) not null auto_increment,
  `name` varchar(200) default null,
  `probability` int(11) default null comment '概率值',
  `number` int(11) default null comment '奖品数',
  `icon` varchar(200) default null,
  `sort` int(11) default null,
  `create_time` datetime default null,
  `status` int(11) default null,
  `index_no` int(11) default null comment '序号',
  `type` int(11) default null comment '奖品类型:1房卡,2实物,3现金,4未中奖',
  `reward_num` int(11) default null comment '单次中奖奖品数目',
  primary key (`id`)
) engine=innodb;

create table `user` (
  `user_id` bigint(20) not null comment '用户ID',
  `room_card_num` int(11) default null comment '累计消费房卡数',
  `lottery_count` int(11) default null comment '抽奖次数',
  `count` int(11) default null comment '剩余抽奖次数',
  `last_update_time` datetime default null comment '最后验证消费房卡时间',
  `create_time` datetime default null comment '创建时间',
  `usable_room_card_num` int(11) default null comment '剩余可用房卡',
  primary key (`user_id`)
) engine=innodb;
