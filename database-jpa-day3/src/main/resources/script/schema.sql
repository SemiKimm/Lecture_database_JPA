CREATE TABLE if not exists user_type (
                           user_type_code int AUTO_INCREMENT PRIMARY KEY,
                           user_type_value	varchar(20)	NOT NULL
);

MERGE INTO `user_type` KEY ( `user_type_code` ) VALUES ( 1,'관리자' );
MERGE INTO `user_type` KEY ( `user_type_code` ) VALUES ( 2,'일반' );

CREATE TABLE if not exists `user` (
                      user_no	int	AUTO_INCREMENT PRIMARY KEY,
                      user_id	varchar(20)	NOT NULL,
                      user_password varchar(20) NOT NULL,
                      user_nickname varchar(20) NOT NULL,
                      user_type_code int NOT NULL,
                      FOREIGN KEY (user_type_code) REFERENCES user_type (user_type_code)
);

MERGE INTO `user` KEY ( `user_no` ) VALUES ( 1,'admin1', '1234', '관리자1',1 );

CREATE TABLE if not exists board_type (
                            board_type_code	int	AUTO_INCREMENT PRIMARY KEY,
                            board_code_value varchar(20) NOT NULL
);

MERGE INTO `board_type` KEY ( `board_type_code` ) VALUES ( 1,'일반' );

CREATE TABLE if not exists post (
                      post_no	int	AUTO_INCREMENT PRIMARY KEY,
                      post_title	varchar(255) NOT NULL,
                      post_content	varchar(3000) NOT NULL,
                      write_datetime	datetime NOT NULL,
                      reply_order	int	NOT NULL,
                      modify_datetime	datetime NULL,
                      user_no	int	NOT NULL,
                      board_type_code	int	NOT NULL,
                      parent_post_no	int	NULL,
                      top_post_no	int	NULL,
                      modifier_user_no int NULL,
                      is_delete boolean NOT NULL,
                      FOREIGN KEY (user_no) REFERENCES `user` (user_no),
                      FOREIGN KEY (board_type_code) REFERENCES board_type (board_type_code),
                      FOREIGN KEY (parent_post_no) REFERENCES post (post_no),
                      FOREIGN KEY (top_post_no) REFERENCES post (post_no),
                      FOREIGN KEY (modifier_user_no) REFERENCES `user` (user_no)
);

MERGE INTO `post` KEY ( `post_no` ) VALUES ( 1,'hi', 'hellooooo', now(), 0, null, 1, 1, null, null, null, false);

CREATE TABLE if not exists good (
                      post_no	int	NOT NULL,
                      user_no	int	NOT NULL,
                      PRIMARY KEY (post_no, user_no),
                      FOREIGN KEY (post_no) REFERENCES post (post_no),
                      FOREIGN KEY (user_no) REFERENCES `user` (user_no)
);

CREATE TABLE if not exists `view` (
                      post_no	int	NOT NULL,
                      user_no	int	NOT NULL,
                      PRIMARY KEY (post_no, user_no),
                      FOREIGN KEY (post_no) REFERENCES post (post_no),
                      FOREIGN KEY (user_no) REFERENCES `user` (user_no)
);

CREATE TABLE if not exists comment (
                         comment_no int AUTO_INCREMENT PRIMARY KEY,
                         comment_content varchar(300) NOT NULL,
                         post_no int NOT NULL,
                         user_no int NOT NULL,
                         FOREIGN KEY (post_no) REFERENCES post (post_no),
                         FOREIGN KEY (user_no) REFERENCES `user` (user_no)
);

MERGE INTO `comment` KEY ( `comment_no` ) VALUES (1, 'hi', 1, 1);

CREATE TABLE if not exists file (
                      file_no	int	NOT NULL auto_increment primary key,
                      file_name	varchar(300)	NOT NULL,
                      file_path	varchar(300)	NOT NULL,
                      post_no	int	NOT NULL
);

