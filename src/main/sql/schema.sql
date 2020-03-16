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
    ('园丁1号', 'ins0000001', '123456'),
    ('园丁2号', 'ins0000002', '123456');

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
    ('花朵1号', 'std0000001', '123456', 1),
    ('花朵2号', 'std0000002', '123456', 1),
    ('花朵3号', 'std0000003', '123456', 2),
    ('花朵4号', 'std0000004', '123456', 2);