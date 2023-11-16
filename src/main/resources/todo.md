Account
account_id integer primary key auto_increment,
username varchar(255),
password varchar(255)

Rainbows
_id ???? uuid autoincrement
mood double
userID varchar(255)
timeSlept integer
activities varchar(255)
memo varchar(255)
createdAt UTCstringthing
foreign key (posted_by) references Account(account_id)