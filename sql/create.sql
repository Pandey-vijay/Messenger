CREATE DATABASE messenger;

USE messenger;

CREATE TABLE user (	user_id int PRIMARY KEY,
					user_name varchar(20) NOT NULL,
                    password varchar(20) NOT NULL,
                    status varchar(150),
                    last_seen int NOT NULL
                    );
                    
CREATE TABLE message ( 	message_id int PRIMARY KEY,
						sender_id int NOT null,
						recevier_id int NOT NULL,
						message varchar(150) NOT NULL,
						send_time int NOT NULL,
                        rec_time int ,
                        seen_time int,
                        foreign key (sender_id) references user(user_id),
                        foreign key (recevier_id) references user(user_id)
						);