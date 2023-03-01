# [BACKUP](../needed_sources/postgres_localhost-2023_03_01_12_34_08-dump.sql)
# [Article PGCRYPTO](https://www.postgresql.fastware.com/blog/further-protect-your-data-with-pgcrypto)
# [Documentation PGCRYPTO](https://www.postgresql.org/docs/current/pgcrypto.html)
# [JSON functions](https://www.postgresql.org/docs/15/functions-json.html)



```roomsql

create database todoapp;

create schema auth;
create schema todo;
create schema category;
create schema utils;

set search_path to auth;

create type authrole as enum ('USER','ADMIN');

create table authuser
(
    id         serial primary key,
    username   varchar unique                      not null
        constraint username_length_valid_check
            check ( length(username) > 4 ),
    password   varchar                             not null,
    role       authrole  default 'USER'            not null,
    created_at timestamp default current_timestamp not null
);

create function auth_register(uname varchar, pswd varchar) returns int
    language plpgsql
as
$$
declare
    newID int;
begin

    insert into auth.authuser (username, password)
    values (uname, pswd)
    returning id into newID;
    return newID;
end
$$;

set search_path to auth;

select auth_register('jlkeesh', '123');
select auth_register('javohir', '123');
create type language as enum ('UZ','RU','EN');
select *
from authuser;
alter table auth.authuser
    add column language auth.language default 'UZ' not null;

set search_path to utils;
create extension pgcrypto;

select crypt('123', gen_salt('bf', 4));

-- $2a$04$tDxKckRaMba9nhb34Wra/e9etqf3ckDW5M20GrhGuVaYohoyLxZym

select '$2a$04$tDxKckRaMba9nhb34Wra/e9etqf3ckDW5M20GrhGuVaYohoyLxZym' =
       crypt('1234', '$2a$04$tDxKckRaMba9nhb34Wra/e9etqf3ckDW5M20GrhGuVaYohoyLxZym');

create function encode_password(raw_password varchar) returns varchar
    language plpgsql as
$$
begin
    return utils.crypt(raw_password, utils.gen_salt('bf', 4));
end
$$;

create function match_password(raw_password varchar, encoded_password varchar) returns boolean
    language plpgsql as
$$
declare
begin
    return encoded_password = utils.crypt(raw_password, encoded_password);
end
$$;


create function auth_login(uname varchar, pswd varchar) returns text
    language plpgsql
as
$$
declare
    t_authuser record;
begin
    select * into t_authuser from auth.authuser where username = lower(uname);
    if not FOUND then
        raise exception 'User not found by username "%"', uname;
    end if;

    return row_to_json(t_authuser)::text;

    return json_build_object(
            'id', t_authuser.id,
            'username', t_authuser.username,
            'password', t_authuser.password,
            'role', t_authuser.role,
            'language', t_authuser.language,
            'created_at', t_authuser.created_at
        )::text;
end
$$;

select auth_login('jlkeesh', '123');


set search_path to category;

create table category
(
    id         serial,
    title      varchar                             not null,
    user_id    int                                 not null,
    created_at timestamp default current_timestamp not null,
    primary key (id),
    foreign key (user_id) references auth.authuser (id) on delete cascade
);

create function create_category(title varchar, sessionuserid int) returns int
    language plpgsql
as
$$
declare
    t_authuser record;
    newID      int;
begin

    select * into t_authuser from auth.authuser a where a.id = sessionuserid;

    if not FOUND then
        raise 'User not found : "%"',sessionuserid;
    end if;

    insert into category.category (title, user_id)
    values (title, sessionuserid)
    returning id into newID;

    return newID;
end
$$;


select *
from category;

select *
from auth.authuser;

select create_category('Not Allowed Category', 6);



create function delete_category(categoryid int, sessionuserid int) returns boolean
    language plpgsql
as
$$
declare
    t_authuser record;
begin

    select * into t_authuser from auth.authuser a where a.id = sessionuserid;

    if not FOUND then
        raise 'User not found : "%"',sessionuserid;
    end if;

    delete from category.category c where c.id = categoryid;

    return true;
end
$$;


create procedure auth.isactive(userid int)
    language plpgsql as
$$
begin
    if not exists(select * from auth.authuser a where a.id = userid) then
        raise 'User not found : "%"',userid;
    end if;
end
$$;

select delete_category(7, 5);
select auth.auth_register('javohir', '123');

select *
from category;

create function auth.hasrole(role varchar, userid int) returns boolean
    language plpgsql
as
$$
declare
    t_authuser record;
begin
    select * into t_authuser from auth.authuser a where a.id = userid;
    if FOUND then
        return t_authuser.role = role;
    else
        return false;
    end if;
end
$$;

set search_path to todo;

create type priority as enum ('LOW','MEDIUM','HIGH','DEFAULT');

create table todo
(
    id          serial,
    title       varchar                                 not null,
    description varchar,
    priority    todo.priority default 'DEFAULT'         not null,
    category_id int,
    created_at  timestamp     default current_timestamp not null,
    due_date    date,
    primary key (id),
    foreign key (category_id) references category.category (id)
);

create function create_todo(dataparam text, userid int) returns int
    language plpgsql
as
$$
declare
    newID      int;
    dataJson   json;
    v_priority todo.priority;
    v_due_date date;
begin
    call auth.isactive(userid);

    -- title,description, priority,category_id, due_date

    if dataparam is null then
        raise exception 'Dataparam invalid';
    end if;


    dataJson := dataparam::json;


    if not exists(select * from category.category c where c.id = (dataJson ->> 'category_id')::int) then
        raise exception 'Category not Found "%"',(dataJson ->> 'category_id');
    end if;

    if dataJson ->> 'priority' is null then
        v_priority := 'DEFAULT';
    else
        v_priority := dataJson ->> 'priority';
    end if;

    if not (dataJson ->> 'due_date' is null) then
        v_due_date = (dataJson ->> 'due_date')::date;
    end if;

    insert into todo.todo (title, description, priority, category_id, due_date)
    values (dataJson ->> 'title',
            dataJson ->> 'description',
            v_priority,
            (dataJson ->> 'category_id')::int,
            v_due_date)
    returning id into newID;
    return newID;
end
$$;



select create_todo('{
  "title": "Read Book about Java Core",
  "category_id":5,
  "description":"Cay.H Volume I,Cay.H Volume II pdf"
}', 5);

-- title,description, priority,category_id, due_date
create type create_todo_dto as
(
    title       varchar,
    description varchar,
    priority    todo.priority,
    category_id int,
    due_date    date
);

select *
from category.category;
select *
from todo;

select coalesce(null, 34);

alter table todo
    add column is_done boolean default false not null;



create function update_todo(dataparam varchar, userid int) returns boolean
    language plpgsql
as
$$
declare
    dataJson json;
    dto      todo.update_todo_dto;
begin
    call auth.isactive(userid);

    if dataparam is null then
        raise exception 'Dataparam invalid';
    end if;

    dataJson := dataparam::json;

    dto.id := dataJson ->> 'id';
--     dto.title := dataJson ->> 'title';
    dto.description := dataJson ->> 'description';
    --     dto.priority := coalesce(dataJson ->> 'priority', 'DEFAULT');
--     dto.due_date := dataJson ->> 'due_date';
--     dto.is_done := dataJson ->> 'is_done';


    update todo.todo
    set title       = dto.title,
        description = dto.description,
        priority    = dto.priority,
        due_date    = dto.due_date,
        is_done     = dto.is_done
    where id = dto.id;


end
$$;


create type update_todo_dto as
(
    id          int,
    title       varchar,
    description varchar,
    priority    todo.priority,
    category_id int,
    due_date    date,
    is_done     boolean
);


select *
from todo;


select update_todo('{
  "title": "Learn AWS",
  "category_id":4,
  "description":"Search From Youtube",
  "due_date":"2023-04-15"
}', 5);

select update_todo('{
  "id" : 8,"is_done":true
}', 5);

select *
from todo;


create function user_todos_by_category(userid int) returns text
    language plpgsql
as
$$
begin
    call auth.isactive(userid);

    return (select json_agg(json_build_object(
            'category_id', category_id,
            'category_name', category_name,
            'user_id', user_id,
            'todos', todos))
            from (select t.category_id,
                         c.title  category_name,
                         c.user_id,
                         json_agg(
                                 json_build_object(
                                         'id', t.id,
                                         'title', t.title,
                                         'description', t.description,
                                         'due_date', t.due_date,
                                         'priority', t.priority,
                                         'is_done', t.is_done,
                                         'created_at', t.created_at
                                     )
                             ) as todos
                  from todo t
                           inner join category.category c on c.id = t.category_id
                  where c.user_id = userid
                  group by t.category_id, c.title, c.user_id) as category_details)::text;
end
$$;


select t.*, c.title
from todo.todo t
         inner join category.category c on t.category_id = c.id
where c.user_id = 5;

select json_agg(json_build_object(
        'category_id', category_id,
        'category_name', category_name,
        'user_id', user_id,
        'todos', todos))
from (select t.category_id,
             c.title  category_name,
             c.user_id,
             json_agg(
                     json_build_object(
                             'id', t.id,
                             'title', t.title,
                             'description', t.description,
                             'due_date', t.due_date,
                             'priority', t.priority,
                             'is_done', t.is_done,
                             'created_at', t.created_at
                         )
                 ) as todos
      from todo t
               inner join category.category c on c.id = t.category_id
      where c.user_id = 5
      group by t.category_id, c.title, c.user_id) as category_details;



select json_build_object(
               'category_id', id,
               'category_title', title)
from category.category;


select user_todos_by_category(5);

select *
from todo;
select *
from category.category;
```