INSERT INTO users (username, password, enabled)
VALUES ('mangala', 
'm',
true); 

INSERT INTO users (username, password, enabled)
VALUES ('chetan', 
'c',
true);

INSERT INTO authorities (username, authority) 
VALUES ('mangala', 
 'ROLE_admin')
  
  INSERT INTO authorities (username, authority)
VALUES ('chetan', 
 'ROLE_user')