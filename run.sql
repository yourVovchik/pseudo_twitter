INSERT INTO public.users (active, birthday, country, date_of_creation, mail, password, sex, username, verification)
VALUES (true, '2000-08-11', 'Россия', '2021-08-24 11:00:18.000000', 'kirill@mail.com',
        '$2a$12$LTn.kiEM4T6k.yNW37OmH.C41NSDO/2LQAUm04L.l0ZbJRgyBB.zm', 0, 'Кирилл', false);

INSERT INTO public.users (active, birthday, country, date_of_creation, mail, password, sex, username, verification)
VALUES (true, '2000-08-31', 'Россия', '2021-08-24 11:01:36.000000', 'vasya@vasya.com',
        '$2a$12$LTn.kiEM4T6k.yNW37OmH.C41NSDO/2LQAUm04L.l0ZbJRgyBB.zm', 0, 'Вася', false);

INSERT INTO public.users (active, birthday, country, date_of_creation, mail, password, sex, username, verification)
VALUES (true, '1995-08-31', 'USA', '2020-08-24 11:02:30.000000', 'jhone@gmail.com',
        '$2a$12$LTn.kiEM4T6k.yNW37OmH.C41NSDO/2LQAUm04L.l0ZbJRgyBB.zm', 0, 'Jhone', false);

INSERT INTO public.users (active, birthday, country, date_of_creation, mail, password, sex, username, verification)
VALUES (true, '1995-08-31', 'Беларусь', '2020-08-24 11:02:30.000000', 'sanya@sanya.com',
        '$2a$12$LTn.kiEM4T6k.yNW37OmH.C41NSDO/2LQAUm04L.l0ZbJRgyBB.zm', 0, 'Саня', false);

INSERT INTO public.users (active, birthday, country, date_of_creation, mail, password, sex, username, verification)
VALUES (true, '1997-08-31', 'Россия', '2020-08-24 11:02:30.000000', 'masha@mail.com',
        '$2a$12$LTn.kiEM4T6k.yNW37OmH.C41NSDO/2LQAUm04L.l0ZbJRgyBB.zm', 1, 'Маша', false);

INSERT INTO public.users (active, birthday, country, date_of_creation, mail, password, sex, username, verification)
VALUES (true, '1999-01-05', 'Беларусь', '2020-08-24 11:02:30.000000', 'user@mail.com',
        '$2a$12$.FpWlXgU5itigmFn7m71a.Dn56bSfeSzaBDRUwZbVgKEIldkRiLE6', 0, 'Дима(User)', false);

INSERT INTO public.users (active, birthday, country, date_of_creation, mail, password, sex, username, verification)
VALUES (true, '1999-01-05', 'Беларусь', '2020-08-24 11:02:30.000000', 'admin@mail.com',
        '$2a$12$.FpWlXgU5itigmFn7m71a.Dn56bSfeSzaBDRUwZbVgKEIldkRiLE6', 0, 'Админ(Admin)', false);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (1, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (2, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (3, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (4, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (5, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (6, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (7, 1);

INSERT INTO public.users_roles (user_id, roles_id)
VALUES (7, 2);

VALUES ('Post', '2021-08-24 11:08:29.000000',
        'Our license applications are pending in many more countries. Hoping to serve Earth soon!', 4, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-24 09:08:20.000000',
        'Прошёл the last of us 2. Самый пожалуй мощный фильм, что мне доводилось смотреть и самая сильная игра в одном флаконе. Планка поднята высоко. Большинство игр теперь просто не зайдёт))',
        1, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Сегодня в трех мировых газетах опубликована колонка Алексея, приуроченная ко дню его отравления год назад. ',
        2, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-24 09:07:22.000000',
        'Вячеслав Володин выдвигается от «Единой России» на сентябрьских выборах в родном Саратове.', 3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-24 11:12:07.000000',
        'Самый высокий американец скончался. Уроженец Украины, актер Игорь Вовковинский, рост которого составлял 235 см, получил особую известность, когда появился на выступлении Обамы в футболке с надписью "Самый большой сторонник Обамы в мире"',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Гражданка Афганистана родила девочку на борту самолета ВВС США. Это произошло во время полета из Кабула на американскую авиабазу Рамштайн в Германии. Ребенок появился на свет в грузовом отсеке машины буквально через несколько минут после приземления',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Сегодня в трех мировых газетах опубликована колонка Алексея, приуроченная ко дню его отравления год назад. ',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Политический кризис в Тунисе. Президент отложил дату возобновления работы парламента "до принятия последующих решений". При этом депутаты лишены на это время неприкосновенности. Председатель парламента назвал происходящее переворотом',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Израиль нанес авиаудары по объектам ХАМАС в ответ на запуск воздушных шаров с зажигательной смесью с территории сектора Газа. Армия обороны Израиля заявила',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Двоих московских активисток, задержанных на акции в поддержку афганских женщин, оставили в ОВД до утра. Накануне на одиночных пикетах у посольства Афганистана в Москве задержали шесть человек',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Впервые женщина стала командиром авианосца в США. Это - 49-летняя капитан Эми Бауэрншмидт. Она начинала пилотом морской авиации и налетала более 3000 часов. А теперь будет командовать кораблем Abraham Lincoln',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Мобильные операторы и провайдеры в России начали блокировать приложение "Навальный". Ранее Роскомнадзор потребовал от Apple и Google удалить это приложение из своих магазинов, заявляя, что оно используется "для пропаганды экстремистских организаций"',
        3, null);

INSERT INTO public.posts (dtype, date, text, user_id, post_id)
VALUES ('Post', '2021-08-23 07:10:31.000000',
        'Четыре христианские организации из Украины и Латвии признаны "нежелательными" в России. Все они входят в состав движения "Новое поколение"',
        3, null);

INSERT INTO public.subscription_follower (follower_id, subscription_id)
VALUES (6, 1);

INSERT INTO public.subscription_follower (follower_id, subscription_id)
VALUES (6, 2);

INSERT INTO public.subscription_follower (follower_id, subscription_id)
VALUES (6, 3);

INSERT INTO public.subscription_follower (follower_id, subscription_id)
VALUES (6, 4);

INSERT INTO public.subscription_follower (follower_id, subscription_id)
VALUES (6, 5);
