CREATE TABLE `customer` (
`user_id` varchar(30) NOT NULL,
`first_name` varchar(50) NOT NULL,
`last_name` varchar(50) NOT NULL,
`address` varchar(200) NOT NULL,
`contact_number` varchar(15) NOT NULL,
`email_id` varchar(30) NOT NULL,
`profile_picture` longblob NOT NULL,
`password` text NOT NULL,
`account_status` varchar(30) NOT NULL,
`admin_user` int(1) NOT NULL,
primary key(`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `share_group` (
`group_id` varchar(30) NOT NULL,
`group_name` varchar(50) NOT NULL,
`group_Description` varchar(100) NOT NULL,
primary key(`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `share_member` (
`group_id` varchar(30) NOT NULL,
`user_id` varchar(30) NOT NULL,
CONSTRAINT FK_share_member_group FOREIGN KEY (`group_id`) REFERENCES share_group(`group_id`),
CONSTRAINT FK_share_member_user FOREIGN KEY (`user_id`) REFERENCES customer(`user_id`),
primary key(`group_id`, `user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `category` (
`category_id` int(8) NOT NULL,
`category_name` varchar(50) NOT NULL,
primary key(`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `item` (
`item_id` varchar(30) NOT NULL,
`item_name` varchar(50) NOT NULL,
`item_Description` varchar(100) NOT NULL,
primary key(`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `menu` (
`menu_id` varchar(30) NOT NULL,
`user_id` varchar(30) NOT NULL,
`item_id` varchar(30) NOT NULL,
`availability_time` TIMESTAMP  NOT NULL,
`status` varchar(30) NOT NULL,
`ingredients` varchar(100) NOT NULL,
`recipe` varchar(200) NOT NULL,
`price` longblob NOT NULL,
`quantity` int NOT NULL,
`selling_type` varchar(30) NOT NULL,
`category_id` int(1) NOT NULL,
`menu_image` longblob NOT NULL,
primary key(`menu_id`),
CONSTRAINT FK_menu_group FOREIGN KEY (`item_id`) REFERENCES item(`item_id`),
CONSTRAINT FK_menu_user FOREIGN KEY (`user_id`) REFERENCES customer(`user_id`),
CONSTRAINT FK_menu_cat FOREIGN KEY (`category_id`) REFERENCES category(`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `order` (
`order_id` varchar(30) NOT NULL,
`user_id` varchar(30) NOT NULL,
`status` varchar(10) NOT NULL,
`order_date_time` TIMESTAMP NOT NULL,
`rating` varchar(5) NOT NULL,
`comment` varchar(100) NOT NULL,
primary key(`order_id`),
CONSTRAINT FK_order_user FOREIGN KEY (`user_id`) REFERENCES customer(`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `order_details` (
`order_id` varchar(30) NOT NULL,
`menu_id` varchar(30) NOT NULL,
`quantity` int NOT NULL,
`sub_total` TIMESTAMP NOT NULL,
primary key(order_id, menu_id),
CONSTRAINT FK_order_details_id FOREIGN KEY (`order_id`) REFERENCES `order`(`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;



