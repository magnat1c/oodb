CREATE TYPE person AS (
	firstname character varying (255),
	lastname character varying (255),
	phonenumber character varying (12),
	email character varying (255)
);

CREATE TYPE company_person AS (
	company_person person,
	person_number character varying (255)
);


CREATE SEQUENCE company_client_seq;

CREATE TABLE company_client (
	id bigint default nextval('company_client_seq'),
	client person,
	CONSTRAINT ompany_client_pkey PRIMARY KEY (id)
);

INSERT INTO company_client (client) VALUES
	 (ROW('ИВАН','ИВАНОВ','телефон','wbhe@mail.ru'));

INSERT INTO company_client ( client.lastname, client.email, client.firstname) VALUES
	( 'ПОТАПОВА','mdnf@gmail.com','ЖАННА');


SELECT (client).firstname from company_client;