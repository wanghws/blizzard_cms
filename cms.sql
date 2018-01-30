DROP TABLE IF EXISTS `cms_domain`;
CREATE TABLE `cms_domain` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `path` varchar(128) NOT NULL COMMENT '路径',
  `domain` varchar(256) NOT NULL COMMENT '域名',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  KEY `domain` (`domain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='域表';

DROP TABLE IF EXISTS `cms_channel`;
CREATE TABLE `cms_channel` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) NOT NULL COMMENT '父级ID',
  `domain_id` bigint(20) NOT NULL COMMENT '域ID',
  `template_id` bigint(20) NOT NULL COMMENT '模板ID',
  `path` varchar(128) NOT NULL COMMENT '路径',
  `name` varchar(128) NULL COMMENT '名称',
  `html_name` varchar(128) NULL COMMENT 'html名称',
  `display_status` tinyint(1) NOT NULL COMMENT '',
  `page_status` tinyint(1) NOT NULL COMMENT '',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `domain_id` (`domain_id`),
  KEY `template_id` (`template_id`),
  KEY `page_status` (`page_status`),
  KEY `display_status` (`display_status`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='频道表';

DROP TABLE IF EXISTS `cms_fragment`;
CREATE TABLE `cms_fragment` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) NOT NULL COMMENT '父级ID',
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  `domain_id` bigint(20) NOT NULL COMMENT '域ID',
  `title` varchar(128) NULL COMMENT '标题',
  `name` varchar(128) NULL COMMENT '名称',
  `type` tinyint(1) NOT NULL COMMENT '',
  `content` text NOT NULL COMMENT '内容',
  `file_name` varchar(128) NULL COMMENT '文件名称',
  `include_url` varchar(128) NULL COMMENT '',
  `sum_pages` int(20) NOT NULL COMMENT '',
  `page_status` tinyint(1) NOT NULL COMMENT '',
  `file_type` tinyint(1) NOT NULL COMMENT '',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新用户ID',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `category_id` (`category_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='碎片表';

DROP TABLE IF EXISTS `cms_fragment_history`;
CREATE TABLE `cms_fragment_history` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `fragment_id` bigint(20) NOT NULL COMMENT '碎片ID',
  `content` text NOT NULL COMMENT '内容',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `fragment_id` (`fragment_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='碎片历史表';

DROP TABLE IF EXISTS `cms_scheduler`;
CREATE TABLE `cms_scheduler` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(128) NULL COMMENT '名称',
  `title` varchar(128) NULL COMMENT '标题',
  `expression` varchar(128) NULL COMMENT '表达式',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新用户ID',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='计划表';


DROP TABLE IF EXISTS `cms_task`;
CREATE TABLE `cms_task` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `scheduler_id` bigint(20) NOT NULL COMMENT '计划ID',
  `page_id` bigint(20) NOT NULL COMMENT '页面ID',
  `type` tinyint(1) NOT NULL COMMENT '',
  `scheduler_type` tinyint(1) NOT NULL COMMENT '',
  `callback_url` varchar(128) NULL COMMENT '回调URL',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新用户ID',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `scheduler_id` (`scheduler_id`),
  KEY `page_id` (`page_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务表';

DROP TABLE IF EXISTS `cms_template`;
CREATE TABLE `cms_template` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `domain_id` bigint(20) NOT NULL COMMENT '域ID',
  `title` varchar(128) NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `file_name` varchar(128) NULL COMMENT '文件名称',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  `update_user` bigint(20) NOT NULL COMMENT '更新用户ID',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `domain_id` (`domain_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='模板表';

DROP TABLE IF EXISTS `cms_template_history`;
CREATE TABLE `cms_template_history` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `template_id` bigint(20) NOT NULL COMMENT '模板ID',
  `content` text NOT NULL COMMENT '内容',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `template_id` (`template_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='模板历史表';

DROP TABLE IF EXISTS `cms_page`;
CREATE TABLE `cms_page` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) NOT NULL COMMENT '父级ID',
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  `template_id` bigint(20) NOT NULL COMMENT '模板ID',
  `channel_id` bigint(20) NOT NULL COMMENT '频道ID',
  `name` varchar(128) NULL COMMENT '名称',
  `title` varchar(128) NULL COMMENT '标题',
  `key_word` varchar(128) NULL COMMENT '关键字',
  `description` varchar(256) NULL COMMENT '说明',
  `content` text NOT NULL COMMENT '内容',
  `html_name` varchar(128) NULL COMMENT 'html名称',
  `show_url` varchar(128) NULL COMMENT 'url',
  `json_type` tinyint(1) NOT NULL COMMENT '',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `template_id` (`template_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='页面表';

DROP TABLE IF EXISTS `cms_page_fragment`;
CREATE TABLE `cms_page_fragment` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) NOT NULL COMMENT '父ID',
  `page_id` bigint(20) NOT NULL COMMENT '页面ID',
  `fragment_id` bigint(20) NOT NULL COMMENT '碎片ID',
  `status` tinyint(1) NOT NULL COMMENT '状态 0:正常,1:禁用',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `create_user` bigint(20) NOT NULL COMMENT '创建用户ID',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `page_id` (`page_id`),
  KEY `fragment_id` (`fragment_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='页面碎片表';











































