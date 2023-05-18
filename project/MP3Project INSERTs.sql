-- INSERT LISTs
INSERT INTO listas (description, name, categoty_list_id) VALUES
('Reggeton List of Music', 'Reggeton', 2),
('Rock List of Music', 'Rock', 2), 
('Rap List of Music', 'Rap', 2), 
('Electronic List of Music', 'Electronic', 2), 
('Pop List of Music', 'Pop', 2), 
('Flamenco List of Music', 'Flamenco', 2),
('Your list of Music Favourite', 'Fav', 1); 


-- INSERT SONGS
INSERT INTO song (artist, description, title, url) VALUES 
('Eladio Carrion', 'Reggeton song by Eladio Carrion in 2023', 'Triste Verano', 'SQymtMNE9BU'),
('Eladio Carrion', 'Reggeton song by Eladio Carrion in 2023', 'Coco Chanel', 'j1VVY2sEdC0'),
('Eladio Carrion', 'Reggeton song by Eladio Carrion in 2023', 'Si la calle Llama Remix', '_REASiFeT_g'),
('Eladio Carrion', 'Reggeton song by Eladio Carrion in 2021', 'Hola Cómo Vas', 'PKoBuyUfQSo'),
('Bad Bunny', 'Reggeton song by Bad Bunny in 2021', 'Yonaguni', 'doLMt10ytHY'),
('Bad Bunny', 'Reggeton song by Bad Bunny in 2022', 'Ojitos Lindos', '7GDp7S1HgSk'),
('Bad Bunny', 'Reggeton song by Bad Bunny in 2022', 'Neverita', 'j97HJYmDdQg'),
('Bad Bunny', 'Reggeton song by Bad Bunny in 2018', 'Ni bien ni mal', '4oiZdbwxUuQ'),  
('Feid', 'Reggeton song by Feid in 2022', 'Normal' ,'oD5f55ohsc4'),
('Feid', 'Reggeton song by Feid in 2023', 'Classy 101', 'WFoMObvIQXk'),    
('Feid', 'Reggeton song by Feid in 2022', 'Chorrito pa las animas', 'sTfHzp8WP24'),    
('Feid', 'Reggeton song by Feid in 2021', 'Castigo', 'AOamtC2_r7k'),
('Nirvana', 'Rock song by Nirvana in 1991', 'Smells Like Teen Spirit', 'hTWKbfoikeg'),
('Nirvana', 'Rock song by Nirvana in 1989', 'School', 'aattgr1wFcU'),
('Nirvana', 'Rock song by Nirvana in 1987', 'FLoid The Barber', 'qofd8l27ieY'),
('Nirvana', 'Rock song by Nirvana in 1991', 'Drain You', 'XIFUHzCUHrg'),
('Bon Jovi', 'Rock song by Bon Jovi in 2000', "It's My Life", 'vx2u5uUu3DE'),
('Bon Jovi', 'Rock song by Bon Jovi in 2015', "We don't Run", 'gEdKVz29crs'),
('Bon Jovi', 'Rock song by Bon Jovi in 1986', "Livin'On A Prayer", 'lDK9QqIzhwk'),
('Bon Jovi', 'Rock song by Bon Jovi in 1983', 'This is Out House', 'OT5nJkUTNpc'),
('Evanescence', 'Rock song by Evanescence in 2003', 'Bring Me To Life', '3YxaaGgTQYM'),
('Evanescence', 'Rock song by Evanescence in 2021', 'Better Without You', 'IUCF50ByaaM'),
('Evanescence', 'Rock song by Evanescence in 2021', 'Yeah Right', 'xbfFKJMdDQ8'),
('Evanescence', 'Rock song by Evanescence in 2020', 'Lacrimosa', 'eN4xqSxt5Zk');


-- INSERT Relation(list-song)
INSERT INTO listas_songs (lista_song_id, songs_id) VALUES
(1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8),(1, 9),(1, 10),(1, 11),(1, 12),
(2, 13),(2, 14),(2, 15),(2, 16),(2, 17),(2, 18),(2, 19),(2, 20),(2, 21),(2, 22),(2, 23),(2, 24);