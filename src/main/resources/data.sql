SELECT * FROM achievements;

INSERT INTO app_users (
    user_name, email, password, level, xp, profile_image, is_verified, create_at
) VALUES (
             'werty',
             'rtyg@gamil.com',
             '1234567890',
             10,
             10,
             '23456789oigfdfg',
             true,
             NOW()
         );

select * from app_users;

insert into habits ( title, description, frequency, is_active, app_user_id, create_at)
values ('delete from  where ;','qwertyui ;','wwertyuio',true,'d56b80c0-08ca-4313-886f-66a6257091ba',default);

select * from habits;

insert into habits(title, description, frequency, is_active, app_user_id, create_at)values ('1212121','121212','WEEKLY',true,'ac337c4b-6f5d-4fec-84a8-363316069c24',now());

SELECT * FROM habits hs INNER JOIN app_users au ON hs.habit_id = au.app_user_id where habit_id = '3ed1ccc7-1811-4c41-bc18-483329787c24';

SELECT * FROM habits hs INNER JOIN app_users au ON hs.app_user_id = au.app_user_id;

select * from app_users;

SELECT * from app_users where app_user_id = 'ac337c4b-6f5d-4fec-84a8-363316069c24';

SELECT * FROM habits;


INSERT INTO habits (title,description,frequency,is_active,app_user_id,create_at)
VALUES ('Morning Run','Run 3km every morning before work','daily',true,'ac337c4b-6f5d-4fec-84a8-363316069c24',NOW());
