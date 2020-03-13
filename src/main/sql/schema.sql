#创建数据库
create database db_activiti;

#使用数据库
use db_activiti;

#创建instructor表
create table instructor (
    `instructor_id` bigint not null auto_increment comment '辅导员id',
    `instructor_name` varchar(20) not null comment '辅导员姓名',
    `instructor_account` varchar(100) not null comment '辅导员账号',
    `instructor_password` varchar(100) not null comment '辅导员密码',
    primary key (instructor_id)
)engine = innodb charset = utf8 comment '辅导员表';

#instructor表插入数据
insert into
    instructor(instructor_name, instructor_account, instructor_password)
values
    ('园丁1号', '82d1f3d969b5e5f0f681ac6206729060', '18583bee77b28fb4687fa0615183a234'),
    ('园丁2号', '013d49c80a37d562bd29963c837ed0a8', '18583bee77b28fb4687fa0615183a234');

#创建student表
create table student (
    `student_id` bigint not null auto_increment comment '学生id',
    `student_name` varchar(20) not null comment '学生姓名',
    `student_account` varchar(100) not null comment '学生账号',
    `student_password` varchar(100) not null comment '学生密码',
    `instructor_id` bigint not null comment '辅导员id',
    primary key (student_id),
    foreign key (instructor_id) references instructor(instructor_id)
)engine = innodb charset = utf8 comment '学生表';

#student表插入数据
insert into
    student(student_name, student_account, student_password, instructor_id)
values
    ('花朵1号', '67472508994fb43f9508e213ad7986c2', '18583bee77b28fb4687fa0615183a234', 1),
    ('花朵2号', 'dcde1d17b9d81e65abd2c6d124bf27bb', '18583bee77b28fb4687fa0615183a234', 1),
    ('花朵3号', '56a0e812ee38da893e4e7ced9154fbe6', '18583bee77b28fb4687fa0615183a234', 2),
    ('花朵4号', '0a2812eeef540727aae53fe8be30e9f5', '18583bee77b28fb4687fa0615183a234', 2);