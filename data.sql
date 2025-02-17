ALTER DATABASE your_database_name CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
INSERT INTO db.roles (name) VALUES ('ROLE_USER');

INSERT INTO user_vendor (title, description, experience, average_cost, owner_id, service_type)
VALUES ('Almaty Event Masters', 'Ұйымдастыру қызметтері', '10 жыл', 750000.00, 1, 'Presenters'),
       ('Astana Stars', 'Тойлар мен мерекелерге әншілер', '8 жыл', 500000.00, 1, 'Singers'),
       ('Kazakh Dance Crew', 'Қазақ ұлттық және заманауи билер', '6 жыл', 600000.00, 1, 'Dancers'),
       ('Steppe Rhythms', 'Фольклорлық және этно-топ', '5 жыл', 700000.00, 1, 'Group'),
       ('MegaSound Operators', 'Сахна және жарық жабдықтау', '7 жыл', 550000.00, 1, 'Operators'),
       ('Фото-Астана', 'Той және корпоративтік фотосессиялар', '9 жыл', 800000.00, 1, 'Photograph'),
       ('KZ Video Pro', 'Кинематографиялық видеотүсірілім', '7 жыл', 900000.00, 1, 'Mobilograph'),
       ('Nomad Transport', 'VIP көлік қызметтері', '12 жыл', 400000.00, 1, 'Transport'),
       ('Shanyrak Decor', 'Той және мерекелік безендіру', '10 жыл', 1000000.00, 1, 'Decorators'),
       ('BalaFun', 'Балалар аниматорлары', '4 жыл', 350000.00, 1, 'Animators'),
       ('TechNomad', 'Концерттерге техникалық қолдау', '8 жыл', 750000.00, 1, 'Technical_Staff'),
       ('Qorgau Security', 'Жеке күзет қызметтері', '11 жыл', 650000.00, 1, 'Security'),
       ('SoundPro KZ', 'Тікелей дыбыс инженері', '9 жыл', 850000.00, 1, 'Sound_Engineers'),
       ('MedAssist', 'Ірі шараларға медициналық қызмет', '15 жыл', 500000.00, 1, 'Medical_Workers'),
       ('NomadStyle', 'Сән және шаштараз қызметтері', '6 жыл', 600000.00, 1, 'Stylists');



INSERT INTO place (title, city, street, description, owner_id)
VALUES ('Rixos Almaty Ballroom', 'Алматы', 'Сейфуллин даңғылы, 506',
        'Республикалық іс-шаралар өткізуге арналған кең зал', 1),
       ('Astana Grand Hall', 'Астана', 'Қабанбай батыр даңғылы, 45', 'Қала орталығындағы заманауи зал', 1),
       ('Shymkent Palace', 'Шымкент', 'Тәуке хан даңғылы, 120', 'Үлкен тойлар мен конференцияларға арналған зал', 1),
       ('Atyrau Prestige', 'Атырау', 'Сәтпаев көшесі, 30', 'Іскерлік кездесулерге арналған зал', 1),
       ('Kokshetau Elite Venue', 'Көкшетау', 'Абылай хан даңғылы, 80', 'Көкшетаудың ең сәнді іс-шара залы', 1);

-- Insert halls associated with places
INSERT INTO hall (title, description, cost, place_id)
VALUES ('Rixos Main Hall', '600 адамға арналған үлкен зал', 1500000.00, 1),
       ('Astana VIP Lounge', '200 адамға арналған премиум зал', 1000000.00, 2),
       ('Shymkent Golden Hall', 'Тойлар мен концерттер үшін ыңғайлы', 1200000.00, 3),
       ('Atyrau Conference Hall', 'Бизнес-жиналыстарға арналған', 800000.00, 4),
       ('Kokshetau Royal Hall', 'Сәнді интерьері бар элиталық зал', 1300000.00, 5);
